package com.aravinda.app.testCase;

import com.aravinda.app.script.HappyFlowTestCase;
import org.seleniumx.annotations.DriverSettings;
import org.seleniumx.annotations.Script;
import org.seleniumx.util.Set;
import org.seleniumx.util.TestCase;

public class BadFlowTestScenario extends TestCase {
    @DriverSettings(
            OS = Set.OS.MAC,
            WINDOW_SIZE = Set.WINDOW_SIZE.FULLSCREEN,
            BROWSER = Set.BROWSER.CHROME,
            BASE_URL = "http://localhost:8080",
            IMPLICIT_WAIT = 10000
    )
    @Script(script = HappyFlowTestCase.class)
    public void testCase() {
        data.put("address", "Sample test data");
        data.put("result", "{\"given format\":\"Invalid\"}");
        testCase(data);
    }
}
