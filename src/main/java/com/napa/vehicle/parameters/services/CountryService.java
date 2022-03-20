package com.napa.vehicle.parameters.services;

import com.napa.vehicle.parameters.models.Country;
import com.napa.vehicle.parameters.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;


    public List<Country> getAll(){
       return countryRepository.findAll();
    }

    public void save(Country country){
        countryRepository.save(country);
    }
}
