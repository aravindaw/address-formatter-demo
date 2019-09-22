package com.aravinda.app.testCase;

import com.aravinda.app.baseScript.BaseDriver;
import com.aravinda.app.context.AddressContext;
import com.aravinda.app.script.FormatAnAddressScript;
import com.aravinda.app.script.ResetAddressFieldScript;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_03_ResetAddressField extends BaseDriver {

    @BeforeMethod
    public void preconditions(){
        new TC_01_AccessAddressFormatterPage().access();

    }

    @Test
    public void formatAnAddress(){
        AddressContext context = new AddressContext();
        context.setAddress(new String[]{"Winterallee 3"});
        ResetAddressFieldScript script = new ResetAddressFieldScript(context);
        script.reset();
    }

}
