package com.aravinda.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Address Formater implementation class
 *
 * @author Aravinda Weerasekara
 */
public class AddressServicesImpl implements AddressServices {

    /**
     * The privet address to hold full address values
     */
    private String address = null;

    /**
     * The privet street to hold string street values
     */
    private String street = null;

    /**
     * The privet houseNumber to hold string value of the house number
     */
    private String houseNumber = null;

    /**
     * The privet length instance variable to hold block count of the address
     */
    private int length = 0;

    /**
     * The privet length instance variable to hold int block counts
     */
    private int intBlocks = 0;

    /**
     * The String[] splittedAddress to hold splitted addresses as an array
     */
    private String[] splittedAddress;

    /**
     * The String tempHouseNumber to hold a house number value
     */
    private String tempHouseNumber;

    /**
     * the houseNumberArray arrayList keeps values while int checker completing the int block search
     */
    private ArrayList<String> houseNumberArray = new ArrayList<>();

    /**
     * the streetArray arrayList keeps values while check the special characters
     */
    private ArrayList<String> streetArray = new ArrayList<>();

    /**
     * logger for login purpose
     */
    private static final Logger logger = LogManager.getLogger(AddressServicesImpl.class);

    /**
     * <p>input method called by the addressController.addressSubmit method.
     * In this method it will seperate the address into several parts by count of int blocks
     * and count of the address splitted parts. <br>
     * ==========Types of address checker=========<br>
     * - address with a single int bloc and single or multi string blocks <br>
     * - Address without int block but have multiple string blocks (More than or equals to 2 ) which could be have a int block with special character or comma<br>
     * - Address with multiple int blocks and multiple string blocks<br>
     * - Else it should be invalid address type<br>
     * ==========Return values=========<br>
     * if houseNumber == null or street == null or houseNumber.equals("Invalid") or street.equals("Invalid") <br>
     * then return JSON object with invalid address type <br>
     * else return the valid address as a JSON object
     * </p>
     *
     * @param adrs address which will input by the user
     * @return String address
     */
    @Override
    public JSONObject input(String adrs) {
        JSONObject jsonObject = new JSONObject();

        intChecker(adrs);
        // Multi parts address with street and house number e.g.:Winterallee 3,Auf der Vogelwiese 23 b
        if (intBlocks == 1) {
            singleIntBlock(address);
        }
        //Multi parts address with street and house number including a character e.g.:"Blaufeldweg 123B"
        else if (intBlocks == 0 && splittedAddress.length >= 2) {
            for (String chunkOfAddress : streetArray) {
                if (chunkOfAddress.matches("(\\d+)\\w+([a-z,A-Z])")) {
                    houseNumber = chunkOfAddress;
                } else if (chunkOfAddress.matches("([nN]o(.*?)\\d+)") || (chunkOfAddress.matches("([#]\\d+)")) || (chunkOfAddress.matches("([nN]umber(.*?)\\d+)"))) {
                    houseNumber = chunkOfAddress;
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

        if (houseNumber == null || street == null || houseNumber.equals("Invalid") || street.equals("Invalid")) {
            jsonObject.put("given format", "Invalid");
            return jsonObject;
        } else {
            jsonObject.put("street", street.trim());
            jsonObject.put("housenumber", houseNumber.trim());
            return jsonObject;
//            return "{\"street\": \"" + street.trim() + "\", \"housenumber\": \"" + houseNumber.trim() + "\"}";
        }
    }

    /**
     * <p>This method checks the count of int block that have in an address input.
     * Method input() will pass all values to this method at the first stage to identify the int blocks.
     * There is no return value but this method with populate the instance variable to use in other methods.
     * </p>
     *
     * @param adrs address which will input by the user
     */
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

    /**
     * <p>There is only one int block fount in the address. But we need to check how many string blocks are there.
     * This method counts the String parts it can be identified. Else it will call the checkSpecialCharacters() to
     * identify the special characters.
     * </p>
     *
     * @param address address which will input by the user
     */
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

    /**
     * <p>Assume there is only one int block and other string parts need to check whether they are any int concatenate
     * with special character ot alphabetic character.
     * </p>
     *
     */
    private void checkSpecialCharacters() {
        ArrayList<String> houseNumberSpecialSymbols = new ArrayList<>(Arrays.asList("#", "No", "Number"));
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