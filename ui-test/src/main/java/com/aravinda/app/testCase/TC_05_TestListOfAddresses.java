package com.aravinda.app.testCase;

import com.aravinda.app.baseScript.BaseDriver;
import com.aravinda.app.context.AddressContext;
import com.aravinda.app.script.FormatAnAddressScript;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_05_TestListOfAddresses extends BaseDriver {

    @BeforeMethod
    public void preconditions() {
        new TC_01_AccessAddressFormatterPage().access();

    }

    @Test
    public void formatListOfAddresses() {
        AddressContext context = new AddressContext();
        String[] addressList = {
                "Winterallee 3",
                "Musterstrasse 45",
                "Blaufeldweg 123B",
                "Am Bächle 23",
                "Auf der Vogelwiese 23 b",
                "4, rue de la revolution",
                "200 Broadway Av",
                "Calle Aduana, 29",
                "Calle 39 No 1540"
        };
        String[] expectedResults = {
                "{\"housenumber\":\"3\",\"street\":\"Winterallee\"}",
                "{\"housenumber\":\"45\",\"street\":\"Musterstrasse\"}",
                "{\"housenumber\":\"123B\",\"street\":\"Blaufeldweg\"}",
                "{\"housenumber\":\"23\",\"street\":\"Am Bächle\"}",
                "{\"housenumber\":\"23 b\",\"street\":\"Auf der Vogelwiese\"}",
                "{\"housenumber\":\"4\",\"street\":\"rue de la revolution\"}",
                "{\"housenumber\":\"200\",\"street\":\"Broadway Av\"}",
                "{\"housenumber\":\"29\",\"street\":\"Calle Aduana\"}",
                "{\"housenumber\":\"No 1540\",\"street\":\"Calle 39\"}"
        };
        context.setAddress(addressList);
        context.setResult(expectedResults);
        FormatAnAddressScript script = new FormatAnAddressScript(context);
        script.format();
    }

}
