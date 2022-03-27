package com.project.vehicle.parameters.controllers;

import com.project.vehicle.parameters.models.Country;
import com.project.vehicle.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/parameters/countries")
    public String getAll(Model model , String keyword){

        List<Country>countries;
       countries=keyword==null? countryService.findAll():countryService.findByKeyword(keyword);
        model.addAttribute("countries",countries);
        return "parameters/countryList";
    }

    ///get country by id
    @GetMapping("/parameters/country/{id}")
    @ResponseBody
    public Country getCountry(@PathVariable Integer id){
        return countryService.getById(id);
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
        return "redirect:/parameters/countries";
    }

    @RequestMapping(value = "/countries/delete/{id}" ,method = {RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        countryService.delete(id);
        return "redirect:/parameters/countries";
    }
}
