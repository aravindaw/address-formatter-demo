package com.aravinda.app.script;

import com.aravinda.app.page.AddressFormatterPage;
import com.aravinda.app.page.FrontPage;
import com.aravinda.app.page.ResultPage;
import org.seleniumx.annotations.Page;
import org.seleniumx.util.Script;
import org.testng.Assert;

public class HappyFlowTestCase extends Script {
    @Page(page = {FrontPage.class, AddressFormatterPage.class, ResultPage.class})
    public void script() {
        execute("FrontPage", "clickContinueButton");
        execute("AddressFormatterPage", "setAddress", data.get("address"));
        execute("AddressFormatterPage", "clickFormatAddressButton");
        Assert.assertEquals(get("ResultPage", "getFormattedAddress"), data.get("result"));
        execute("ResultPage", "clickSubmitAnotherAddressButton");
    }
}
