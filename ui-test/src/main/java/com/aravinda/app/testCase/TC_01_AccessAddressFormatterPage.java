package com.aravinda.app.testCase;

import com.aravinda.app.baseScript.BaseDriver;
import com.aravinda.app.context.AddressContext;
import com.aravinda.app.script.AccessAddressFormatterPageScript;
import org.testng.annotations.Test;

public class TC_01_AccessAddressFormatterPage extends BaseDriver {

    @Test
    public void access(){
        AddressContext context = new AddressContext();
        AccessAddressFormatterPageScript formatterPage = new AccessAddressFormatterPageScript(context);
        formatterPage.access();
    }

}
