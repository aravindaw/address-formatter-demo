package com.aravinda.app;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Address Formatter implementation class
 *
 * @author Aravinda Weerasekara
 */
public class AddressServicesImpl implements AddressServices {

    private List<String> addressWordList = new ArrayList<>();
    private List<String> intBlocks = new ArrayList<>();
    private List<String> intBlockWithSpecialWord = new ArrayList<>();
    private List<String> specialWord = new ArrayList<>();

    @Override
    public JSONObject input(String address) {
        JSONObject jsonObject = new JSONObject();
        if (address == null) {
            jsonObject.put("given format", "Invalid");
            return jsonObject;
        } else if (address.replace(",", "").split(" ").length <= 1) {
            jsonObject.put("given format", "Invalid");
            return jsonObject;
        } else if (intChecker() == new int[]{0, 0, 0,}) {
            jsonObject.put("given format", "Invalid");
            return jsonObject;
        }

        addressWordList.addAll(Arrays.asList(address.replace(",", "").split(" ")));
        intChecker();

        Object[] addressObject = getStreetName(address);

        String streetName = addressObject[0].toString().trim();
        String houseNumber = addressObject[1].toString().trim();

        if (streetName.equals("invalid") | houseNumber.equals("invalid")) {
            jsonObject.put("given format", "Invalid");
            return jsonObject;
        } else {
            jsonObject.put("street", streetName.trim().trim());
            jsonObject.put("housenumber", houseNumber.trim().trim());
            System.out.println(jsonObject.toJSONString());
            return jsonObject;
        }
    }

    private int[] intChecker() {
        for (String word : addressWordList) {
            if (word.matches("\\d+")) {
                intBlocks.add(word);
            } else if (word.matches("(([Nn](o|o.)|([Nn]umber.)|(#))\\d+)|(\\d+[a-zA-Z])")) {
                intBlockWithSpecialWord.add(word);
            } else if (word.matches("[Nn](o|o)|([Nn]umber)|(#)")) {
                specialWord.add(word);
            }
        }
        return new int[]{intBlocks.size(), intBlockWithSpecialWord.size(), specialWord.size()};
    }

    private Object[] getStreetName(String address) {
        address = address.replace(",", " ");
        String streetName;
        String houseNumber;
        Object[] result;
        if (intBlocks.size() == 1 && intBlockWithSpecialWord.size() == 0 && specialWord.size() == 0) {
            String[] splittedAddress;
            String houseLetter = checkLettersAfterInt(intBlocks.get(0));
            if (!houseLetter.equals("")) {
                splittedAddress = address.split(intBlocks.get(0) + " " + houseLetter);
            } else {
                splittedAddress = address.split(intBlocks.get(0));
            }
            try {
                streetName = splittedAddress[1].trim();
            } catch (Exception e) {
                streetName = splittedAddress[0].trim();
            }
            houseNumber = intBlocks.get(0) + " " + houseLetter;
        } else if (intBlocks.size() >= 1 && intBlockWithSpecialWord.size() == 0 && specialWord.size() == 1 && addressWordList.size() >= 3) {
            int indexOfSpecialWord = addressWordList.indexOf(specialWord.get(0));
            if (indexOfSpecialWord == 0) {
                String[] splittedAddress = address.split(addressWordList.get(1));
                streetName = splittedAddress[1].trim();
            } else {
                String[] splittedAddress = address.split(specialWord.get(0));
                streetName = splittedAddress[0].trim();
            }
            houseNumber = specialWord.get(0) + " " + addressWordList.get(indexOfSpecialWord + 1);
        } else if (intBlocks.size() == 0 && intBlockWithSpecialWord.size() == 1 && specialWord.size() == 0 && addressWordList.size() >= 2) {
            int indexOfIntBlockWithSpecialWord = addressWordList.indexOf(intBlockWithSpecialWord.get(0));
            String[] splittedAddress = address.split(addressWordList.get(indexOfIntBlockWithSpecialWord));
            if (indexOfIntBlockWithSpecialWord == 0) {
                streetName = splittedAddress[1].trim();
            } else {
                streetName = splittedAddress[0].trim();
            }
            houseNumber = intBlockWithSpecialWord.get(0);
        } else {
            streetName = "invalid";
            houseNumber = "invalid";
        }
        result = new String[]{streetName, houseNumber};
        return result;
    }

    public String checkLettersAfterInt(String intBlock) {
        String houseLetter = "";
        try {
            if (addressWordList.get(addressWordList.indexOf(intBlock) + 1).matches("[a-zA-Z]")) {
                houseLetter = addressWordList.get(addressWordList.indexOf(intBlock) + 1);
            }
        } catch (Exception ignored) {

        }
        return houseLetter;
    }
}