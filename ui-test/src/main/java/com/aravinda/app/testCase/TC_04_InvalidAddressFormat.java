package com.aravinda.app.testCase;

import com.aravinda.app.baseScript.BaseDriver;
import com.aravinda.app.context.AddressContext;
import com.aravinda.app.script.FormatAnAddressScript;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_04_InvalidAddressFormat extends BaseDriver {

    @BeforeMethod
    public void preconditions() {
        new TC_01_AccessAddressFormatterPage().access();

    }

    @Test
    public void formatAnAddress() {
        AddressContext context = new AddressContext();
        String[] addressList = {
                "Test Address",
                "Sample invalid address 45 46",
                "InvalidAddress"

        };
        String[] expectedResults = {
                "{\"given format\":\"Invalid\"}",
                "{\"given format\":\"Invalid\"}",
                "{\"given format\":\"Invalid\"}"
        };
        context.setAddress(addressList);
        context.setResult(expectedResults);
        FormatAnAddressScript script = new FormatAnAddressScript(context);
        script.format();
    }

}
