package com.aravinda.app.script;

import com.aravinda.app.baseScript.BaseDriver;
import com.aravinda.app.context.AddressContext;
import com.aravinda.app.page.AddressFormatterPage;
import com.aravinda.app.page.ResultPage;
import org.testng.Assert;

public class FormatAnAddressScript extends BaseDriver {

    private AddressContext context;

    public FormatAnAddressScript(AddressContext context) {
        this.context = context;
    }

    public void format() {
        int addressCount = 0;
        for (String address : context.getAddress()) {
            AddressFormatterPage inputPage = new AddressFormatterPage();
            inputPage.verifyPageLoaded();
            inputPage.verifyPageUrl();
            inputPage.setAddress(address);
            inputPage.clickFormatAddressButton();
            ResultPage resultPage = new ResultPage();
            resultPage.verifyPageLoaded();
            resultPage.verifyPageUrl();
            Assert.assertEquals(resultPage.getGivenAddress(), address);
            Assert.assertEquals(resultPage.getFormattedAddress(), context.getResult()[addressCount]);
            addressCount++;
            resultPage.clickSubmitAnotherAddressButton();
        }
    }
}
