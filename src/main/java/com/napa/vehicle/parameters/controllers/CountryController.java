package com.napa.vehicle.parameters.controllers;

import com.napa.vehicle.parameters.models.Country;
import com.napa.vehicle.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public String getAll(Model model){
        List<Country>countries= countryService.getAll();
        model.addAttribute("countries",countries);
        return "parameters/countryList";
    }

    @GetMapping("/countryAdd")
    public String countryAdd() {
        return "parameters/countryAdd";
    }

    @GetMapping("/countryEdit/{id}")
    public String editCountry(@PathVariable Integer id,Model model) {
        Country country=countryService.getById(id);
        model.addAttribute("country",country);
        return "/parameters/countryEdit";
    }


    @GetMapping("/countryDetails/{id}")
    public String countryDetails(@PathVariable Integer id,Model model) {
        Country country=countryService.getById(id);
        model.addAttribute("country",country);
        return "/parameters/countryDetails";
    }

    @PostMapping("/countries")
    public String save(Country country){
        countryService.save(country);
        return "redirect:/countries";
    }

    @RequestMapping(value = "/countries/delete/{id}" ,method = {RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        countryService.delete(id);
        return "redirect:/countries";
    }
}
