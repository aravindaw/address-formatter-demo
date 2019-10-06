package com.aravinda.app;

/**
 * Address class to create getter and setters of the Address class
 *
 * @author Aravinda Weerasekara
 */
public class Address {

    /**
     * The privet address to set and get address form springboot class
     */
    private String address;

    /**
     * <p>The getter of the privet address instance variable
     * </p>
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * <p>The setter of the privet address instance variable
     * </p>
     * @param address get address value
     */
    public void setAddress(String address) {
        this.address = address;
    }

}