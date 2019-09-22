package com.aravinda.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class AddressServicesImpl implements AddressServices {

    private String address = null;
    private String street = null;
    private String houseNumber = null;


    private int length = 0;
    private int intBlocks = 0;
    private String[] splittedAddress;
    private String tempHouseNumber;
    private ArrayList<String> houseNumberArray = new ArrayList<String>();
    private ArrayList<String> streetArray = new ArrayList<String>();
    private ArrayList<String> houseNumberSpecialSymbols = new ArrayList<String>(Arrays.asList("#", "No", "Number"));
    private JSONObject jsonObject = new JSONObject();
    private static final Logger logger = LogManager.getLogger(AddressServicesImpl.class);

    @Override
    public JSONObject input(String adrs) {

        intChecker(adrs);
        //Multi parts address with street and house number e.g.:Winterallee 3,Auf der Vogelwiese 23 b
        if (intBlocks == 1) {
            singleIntBlock(address);
        }
        //Multi parts address with street and house number including a character e.g.:"Blaufeldweg 123B"
        else if (intBlocks == 0 && splittedAddress.length >= 2) {
            for (String x : streetArray) {
                if (x.matches("([0-9])\\w+([a-z,A-Z])")) {
                    houseNumber = x;
                } else if (x.matches("([nN]o[0-9])") || (x.matches("([#][0-9])")) || (x.matches("([nN]umber[0-9])"))) {
                    houseNumber = x;
                }
            }
            if (houseNumber != null) {
                String[] part = address.split(houseNumber);
                if (houseNumber.equals(splittedAddress[0])) {
                    street = part[1];
                } else {
                    street = part[0];
                }
            }
            //Multi parts address with street and multiple int blocks, house number start with Number/No/#/e.g.:Calle 39 No 1540
        } else if (intBlocks > 1 && splittedAddress.length >= 3) {
            checkSpecialCharacters();
        } else {
            houseNumber = "Invalid";
            street = "Invalid";
        }

        if (houseNumber == null || street == null || houseNumber == "Invalid" || street == "Invalid") {
            jsonObject.put("given format", "Invalid");
            return jsonObject;
        } else {
            jsonObject.put("street", street.trim());
            jsonObject.put("housenumber", houseNumber.trim());
            return jsonObject;
//            return "{\"street\": \"" + street.trim() + "\", \"housenumber\": \"" + houseNumber.trim() + "\"}";
        }
    }

    private void intChecker(String adrs) {
        address = adrs.replace(",", "").trim();
        splittedAddress = address.split(" ");
        length = splittedAddress.length;
        for (String x : splittedAddress) {
            try {
                Integer.parseInt(x);
                houseNumberArray.add(x);
                tempHouseNumber = x;
                intBlocks = houseNumberArray.size();
            } catch (NumberFormatException e) {
                streetArray.add(x);
            }
        }
    }

    private void singleIntBlock(String address) {
        houseNumber = houseNumberArray.get(0);
        street = streetArray.get(0);
        if ((splittedAddress[0].equals(tempHouseNumber)) && streetArray.size() > 1) {
            String[] part = address.split(tempHouseNumber);
            houseNumber = tempHouseNumber;
            street = part[1];
        } else if ((splittedAddress[length - 2].equals(tempHouseNumber)) && streetArray.size() > 1) {
            houseNumber = houseNumberArray.get(0) + " " + splittedAddress[length - 1];
            String[] part = address.split(tempHouseNumber);
            street = part[0];
        } else if ((splittedAddress[length - 1].equals(tempHouseNumber)) && streetArray.size() > 1) {
            String[] part = address.split(tempHouseNumber);
            houseNumber = tempHouseNumber.replace(",", "").trim();
            street = part[0];
        } else {
            checkSpecialCharacters();
        }
    }

    private void checkSpecialCharacters() {
        for (String specialSymbol : houseNumberSpecialSymbols) {
            if (streetArray.contains(specialSymbol) && splittedAddress[length - 2].equals(specialSymbol)) {
                String[] part = address.split(specialSymbol);
                street = part[0];
                houseNumber = specialSymbol + part[1];
            } else if (streetArray.contains(specialSymbol) && splittedAddress[0].equals(specialSymbol)) {
                String[] part = address.split(splittedAddress[1]);
                houseNumber = part[0] + splittedAddress[1];
                street = part[1];
            } else {
                logger.info("Checking special symbols..");
            }
        }
    }
}