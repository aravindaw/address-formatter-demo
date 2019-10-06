package com.aravinda.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * AddressController - Springboot controller class
 *
 * @author Aravinda Weerasekara
 */
@Controller
public class AddressController {

    /**
     * <p>addressForm GET http method
     * </p>
     * @param model SpringFramework model attribute
     * @return String address
     */
    @GetMapping("/address")
    public String addressForm(Model model) {
        model.addAttribute("address", new Address());
        return "address";
    }

    /**
     * <p>addressForm POST http method
     * </p>
     * @param address SpringFramework web bind
     * @param mp SpringFramework ModelMap
     * @return String String result
     */
    @PostMapping("/address")
    public String addressSubmit(@ModelAttribute Address address, ModelMap mp) {
        mp.addAttribute("givenAddress", address.getAddress());
        mp.addAttribute("address", new AddressServicesImpl().input(address.getAddress()));
        return "result";
    }

}