package com.aravinda.app.testCase;

import com.aravinda.app.script.HappyFlowTestCase;
import org.seleniumx.annotations.DriverSettings;
import org.seleniumx.annotations.Script;
import org.seleniumx.util.Set;
import org.seleniumx.util.TestCase;

public class HappyFlowTestScenario extends TestCase {
    @DriverSettings(
            OS = Set.OS.MAC,
            WINDOW_SIZE = Set.WINDOW_SIZE.DEFAULT,
            BROWSER = Set.BROWSER.CHROME,
            BASE_URL = "http://localhost:8080/address-formatter-0.0.1-SNAPSHOT",
            IMPLICIT_WAIT = 10000
    )
    @Script(script = HappyFlowTestCase.class)
    public void testCase() {
        data.put("address", "test address 04");
        data.put("result","{\"housenumber\":\"04\",\"street\":\"test address\"}");
        run(data);
    }
}
