package com.napa.vehicle.parameters.controllers;

import com.napa.vehicle.parameters.models.Country;
import com.napa.vehicle.parameters.models.State;
import com.napa.vehicle.parameters.services.CountryService;
import com.napa.vehicle.parameters.services.StateService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class StateController {

    @Autowired private StateService stateService;
    @Autowired private CountryService countryService;

    public Model addModelAttribute(Model model){
        model.addAttribute("states",stateService.findAll());
        model.addAttribute("countries",countryService.findAll());
        return model;
    }

    @GetMapping("/states")
    public String findAll(Model model){
       addModelAttribute(model);
        return "parameters/states";
    }

    @GetMapping("/parameters/stateAdd")
    public String stateAdd(Model model) {
        addModelAttribute(model);
        return "parameters/stateAdd";
    }

    @GetMapping("/stateEdit/{id}")
    public String editState(@PathVariable Integer id,Model model) {
        State state=stateService.getById(id);
        model.addAttribute("state",state);
        return "/parameters/stateEdit";
    }


    @GetMapping("/parameters/stateDetails/{id}")
    public String stateDetails(@PathVariable Integer id,Model model) {
        addModelAttribute(model);
        model.addAttribute("state",stateService.getById(id));
        return "/parameters/stateDetails";
    }

    @PostMapping("/states")
    public String save(State state){
        stateService.save(state);
        return "redirect:/states";
    }

    @RequestMapping(value = "/states/delete/{id}" ,method = {RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        stateService.delete(id);
        return "redirect:/states";
    }
}
