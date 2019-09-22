package com.aravinda.app.script;

import com.aravinda.app.baseScript.BaseDriver;
import com.aravinda.app.context.AddressContext;
import com.aravinda.app.page.AddressFormatterPage;
import com.aravinda.app.page.FrontPage;
import org.testng.Assert;

public class AccessAddressFormatterPageScript extends BaseDriver {

    public AccessAddressFormatterPageScript(AddressContext context) {
    }

    public void access() {
        FrontPage frontPage = new FrontPage();
        frontPage.verifyPageLoaded();
        frontPage.verifyPageUrl();
        frontPage.clickContinueButton();
        AddressFormatterPage inputPage = new AddressFormatterPage();
        Assert.assertTrue(inputPage.addressFormatterButtonVisible());
    }
}
