package com.aravinda.app;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;


public class InvalidAddressTypeTests {
    private JSONObject formattedAddress = new JSONObject();
    private static final Logger logger = Logger.getLogger(InvalidAddressTypeTests.class);

    @Test
    public void invalidAddressType1() {
        String address = "Test Address";
        formattedAddress.put("given format", "Invalid");
        JSONObject result = new AddressServicesImpl().input(address);
        Assert.assertEquals(formattedAddress, result);
        logger.info("Expected result  : " + formattedAddress.toJSONString());
        logger.info("Actual result    : " + result.toJSONString());
    }

    @Test
    public void invalidAddressType2() {
        String address = "Sample invalid address 45 46";
        formattedAddress.put("given format", "Invalid");
        JSONObject result = new AddressServicesImpl().input(address);
        Assert.assertEquals(formattedAddress, result);
        logger.info("Expected result  : " + formattedAddress.toJSONString());
        logger.info("Actual result    : " + result.toJSONString());
    }

    @Test
    public void invalidAddressType3() {
        String address = "InvalidAddress";
        formattedAddress.put("given format", "Invalid");
        JSONObject result = new AddressServicesImpl().input(address);
        Assert.assertEquals(formattedAddress, result);
        logger.info("Expected result  : " + formattedAddress.toJSONString());
        logger.info("Actual result    : " + result.toJSONString());
    }

}