package com.aravinda.app.testCase;

import com.aravinda.app.script.HappyFlowTestCaseWithTestData;
import org.seleniumx.annotations.Data;
import org.seleniumx.annotations.DriverSettings;
import org.seleniumx.annotations.Script;
import org.seleniumx.util.Set;
import org.seleniumx.util.TestCase;

public class HappyFlowTestScenarioWithTestData extends TestCase {
    @DriverSettings(
            OS = Set.OS.MAC,
            WINDOW_SIZE = Set.WINDOW_SIZE.DEFAULT,
            BROWSER = Set.BROWSER.CHROME,
            BASE_URL = "http://localhost:8080/address-formatter-0.0.1-SNAPSHOT",
            IMPLICIT_WAIT = 10000
    )
    @Data(path = "/Users/aravindaweerasekara/projects/address-formatter-demo/ui-test/src/main/resources/Testdata.xlsx")
    @Script(script = HappyFlowTestCaseWithTestData.class)
    public void testCase() {
        run();
    }
}
