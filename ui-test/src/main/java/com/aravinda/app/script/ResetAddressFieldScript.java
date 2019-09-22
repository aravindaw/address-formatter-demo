package com.aravinda.app.script;

import com.aravinda.app.baseScript.BaseDriver;
import com.aravinda.app.context.AddressContext;
import com.aravinda.app.page.AddressFormatterPage;
import org.testng.Assert;

public class ResetAddressFieldScript extends BaseDriver {

    private AddressContext context;

    public ResetAddressFieldScript(AddressContext context) {
        this.context = context;
    }

    public void reset() {
        AddressFormatterPage inputPage = new AddressFormatterPage();
        inputPage.verifyPageLoaded();
        inputPage.verifyPageUrl();
        inputPage.setAddress(context.getAddress()[0]);
        Assert.assertEquals(inputPage.getAddressFieldValue(),context.getAddress()[0]);
        inputPage.clickResetButton();
        Assert.assertEquals("", inputPage.getAddressFieldValue());
    }
}
