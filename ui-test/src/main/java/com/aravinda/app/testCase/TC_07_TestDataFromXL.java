package com.aravinda.app.testCase;

import com.aravinda.app.baseScript.BaseDriver;
import com.aravinda.app.baseScript.XLReader;
import com.aravinda.app.context.AddressContext;
import com.aravinda.app.script.FormatAnAddressScript;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_07_TestDataFromXL extends BaseDriver {

    @BeforeMethod
    public void preconditions() {
        new TC_01_AccessAddressFormatterPage().access();

    }

    @Test
    public void formatListOfAddresses() {
        AddressContext context = new AddressContext();
        String[] addressList = new XLReader().getData(1);
        String[] expectedResults = new XLReader().getData(2);
        context.setAddress(addressList);
        context.setResult(expectedResults);
        FormatAnAddressScript script = new FormatAnAddressScript(context);
        script.format();
    }

}
