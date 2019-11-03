package com.aravinda.app.script;

import com.aravinda.app.page.AddressFormatterPage;
import com.aravinda.app.page.FrontPage;
import com.aravinda.app.page.ResultPage;
import org.seleniumx.annotations.Page;
import org.seleniumx.util.DataReader;
import org.seleniumx.util.Script;
import org.testng.Assert;

public class HappyFlowTestCaseWithTestData extends Script {
    @Page(page = {FrontPage.class, AddressFormatterPage.class, ResultPage.class})
    public void script() {
        execute("FrontPage", "clickContinueButton");

        String[] address = DataReader.reads().getData(1, 1);
        String[] result = DataReader.reads().getData(1, 2);
        for (int x = 0; x < address.length; x++) {
            execute("AddressFormatterPage", "setAddress", address[x]);
            execute("AddressFormatterPage", "clickFormatAddressButton");
            Assert.assertEquals(get("ResultPage", "getFormattedAddress"), result[x]);
            execute("ResultPage", "clickSubmitAnotherAddressButton");
        }
    }
}
