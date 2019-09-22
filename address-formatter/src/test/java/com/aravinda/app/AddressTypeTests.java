package com.aravinda.app;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;


public class AddressTypeTests {
    private JSONObject formattedAddress = new JSONObject();
    private static final Logger logger = Logger.getLogger(AddressTypeTests.class);

    @Test
    public void addressType1() {
        String address = "Winterallee 3";
        formattedAddress.put("street", "Winterallee");
        formattedAddress.put("housenumber", "3");
        JSONObject result = new AddressServicesImpl().input(address);
        Assert.assertEquals(formattedAddress, result);
        logger.info("Expected result  : " + formattedAddress.toJSONString());
        logger.info("Actual result    : " + result.toJSONString());
    }

    @Test
    public void addressType2() {
        String address = "Musterstrasse 45";
        formattedAddress.put("street", "Musterstrasse");
        formattedAddress.put("housenumber", "45");
        JSONObject result = new AddressServicesImpl().input(address);
        Assert.assertEquals(formattedAddress, result);
        logger.info("Expected result  : " + formattedAddress.toJSONString());
        logger.info("Actual result    : " + result.toJSONString());
    }

    @Test
    public void addressType3() {
        String address = "Blaufeldweg 123B";
        formattedAddress.put("street", "Blaufeldweg");
        formattedAddress.put("housenumber", "123B");
        JSONObject result = new AddressServicesImpl().input(address);
        Assert.assertEquals(formattedAddress, result);
        logger.info("Expected result  : " + formattedAddress.toJSONString());
        logger.info("Actual result    : " + result.toJSONString());
    }

    @Test
    public void addressType4() {
        String address = "Am Bächle 23";
        formattedAddress.put("street", "Am Bächle");
        formattedAddress.put("housenumber", "23");
        JSONObject result = new AddressServicesImpl().input(address);
        Assert.assertEquals(formattedAddress, result);
        logger.info("Expected result  : " + formattedAddress.toJSONString());
        logger.info("Actual result    : " + result.toJSONString());
    }

    @Test
    public void addressType5() {
        String address = "Auf der Vogelwiese 23 b";
        formattedAddress.put("street", "Auf der Vogelwiese");
        formattedAddress.put("housenumber", "23 b");
        JSONObject result = new AddressServicesImpl().input(address);
        Assert.assertEquals(formattedAddress, result);
        logger.info("Expected result  : " + formattedAddress.toJSONString());
        logger.info("Actual result    : " + result.toJSONString());
    }

    @Test
    public void addressType6() {
        String address = "4, rue de la revolution";
        formattedAddress.put("street", "rue de la revolution");
        formattedAddress.put("housenumber", "4");
        JSONObject result = new AddressServicesImpl().input(address);
        Assert.assertEquals(formattedAddress, result);
        logger.info("Expected result  : " + formattedAddress.toJSONString());
        logger.info("Actual result    : " + result.toJSONString());
    }

    @Test
    public void addressType7() {
        String address = "200 Broadway Av";
        formattedAddress.put("street", "Broadway Av");
        formattedAddress.put("housenumber", "200");
        JSONObject result = new AddressServicesImpl().input(address);
        Assert.assertEquals(formattedAddress, result);
        logger.info("Expected result  : " + formattedAddress.toJSONString());
        logger.info("Actual result    : " + result.toJSONString());
    }

    @Test
    public void addressType8() {
        String address = "Calle Aduana, 29";
        formattedAddress.put("street", "Calle Aduana");
        formattedAddress.put("housenumber", "29");
        JSONObject result = new AddressServicesImpl().input(address);
        Assert.assertEquals(formattedAddress, result);
        logger.info("Expected result  : " + formattedAddress.toJSONString());
        logger.info("Actual result    : " + result.toJSONString());
    }

    @Test
    public void addressType9() {
        String address = "Calle 39 No 1540";
        formattedAddress.put("street", "Calle 39");
        formattedAddress.put("housenumber", "No 1540");
        JSONObject result = new AddressServicesImpl().input(address);
        Assert.assertEquals(formattedAddress, result);
        logger.info("Expected result  : " + formattedAddress.toJSONString());
        logger.info("Actual result    : " + result.toJSONString());
    }

    @Test
    public void addressType10() {
        String address = "Number 8, somapah av";
        formattedAddress.put("street", "somapah av");
        formattedAddress.put("housenumber", "Number 8");
        JSONObject result = new AddressServicesImpl().input(address);
        Assert.assertEquals(formattedAddress, result);
        logger.info("Expected result  : " + formattedAddress.toJSONString());
        logger.info("Actual result    : " + result.toJSONString());
    }

    @Test
    public void addressType11() {
        String address = "#8, somapah av";
        formattedAddress.put("street", "somapah av");
        formattedAddress.put("housenumber", "#8");
        JSONObject result = new AddressServicesImpl().input(address);
        Assert.assertEquals(formattedAddress, result);
        logger.info("Expected result  : " + formattedAddress.toJSONString());
        logger.info("Actual result    : " + result.toJSONString());
    }

    @Test
    public void addressType12() {
        String address = "# 8, somapah av";
        formattedAddress.put("street", "somapah av");
        formattedAddress.put("housenumber", "# 8");
        JSONObject result = new AddressServicesImpl().input(address);
        Assert.assertEquals(formattedAddress, result);
        logger.info("Expected result  : " + formattedAddress.toJSONString());
        logger.info("Actual result    : " + result.toJSONString());
    }

}
