package com.aravinda.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddressController {
    @GetMapping("/address")
    public String addressForm(Model model) {
        model.addAttribute("address", new Address());
        return "address";
    }

    @PostMapping("/address")
    public String addressSubmit(@ModelAttribute Address address, ModelMap mp) {
        mp.addAttribute("givenAddress", address.getAddress());
        mp.addAttribute("address", new AddressServicesImpl().input(address.getAddress()));
        return "result";
    }

}