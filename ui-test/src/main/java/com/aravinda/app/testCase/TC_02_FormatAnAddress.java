package com.aravinda.app.testCase;

import com.aravinda.app.baseScript.BaseDriver;
import com.aravinda.app.context.AddressContext;
import com.aravinda.app.script.FormatAnAddressScript;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_02_FormatAnAddress extends BaseDriver {

    @BeforeMethod
    public void preconditions() {
        new TC_01_AccessAddressFormatterPage().access();

    }

    @Test
    public void formatAnAddress() {
        AddressContext context = new AddressContext();
        context.setAddress(new String[]{"Winterallee 3"});
        context.setResult(new String[]{"{\"housenumber\":\"3\",\"street\":\"Winterallee\"}"});
        FormatAnAddressScript script = new FormatAnAddressScript(context);
        script.format();
    }

}
