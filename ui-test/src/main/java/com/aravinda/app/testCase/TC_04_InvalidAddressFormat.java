package com.aravinda.app.testCase;

import com.aravinda.app.baseScript.BaseDriver;
import com.aravinda.app.context.AddressContext;
import com.aravinda.app.script.FormatAnAddressScript;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_04_InvalidAddressFormat extends BaseDriver {

    @BeforeMethod
    public void preconditions(){
        new TC_01_AccessAddressFormatterPage().access();

    }

    @Test
    public void formatAnAddress(){
        AddressContext context = new AddressContext();
        context.setAddress(new String[]{"InvalidAddress"});
        context.setResult(new String[]{"{\"given format\":\"Invalid\"}"});
        FormatAnAddressScript script = new FormatAnAddressScript(context);
        script.format();
    }

}
