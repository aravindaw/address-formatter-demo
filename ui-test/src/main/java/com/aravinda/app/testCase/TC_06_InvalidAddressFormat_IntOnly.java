package com.aravinda.app.testCase;

import com.aravinda.app.baseScript.BaseDriver;
import com.aravinda.app.context.AddressContext;
import com.aravinda.app.script.FormatAnAddressScript;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_06_InvalidAddressFormat_IntOnly extends BaseDriver {

    @BeforeMethod
    public void preconditions() {
        new TC_01_AccessAddressFormatterPage().access();

    }

    @Test
    public void formatAnAddress() {
        AddressContext context = new AddressContext();
        String[] addressList = {
                "12345"
        };
        String[] expectedResults = {
                "{\"given format\":\"Invalid\"}"
        };
        context.setAddress(addressList);
        context.setResult(expectedResults);
        FormatAnAddressScript script = new FormatAnAddressScript(context);
        script.format();
    }

}
