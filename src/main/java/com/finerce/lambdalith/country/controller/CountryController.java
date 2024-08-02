package com.finerce.lambdalith.country.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
 
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.finerce.lambdalith.country.model.Country;

import jakarta.annotation.PostConstruct;



@RestController
@EnableWebMvc
@RequestMapping("/countries")
public class CountryController {
	
	List <Country> countryList = new ArrayList<>();
	
    @PostConstruct
    public void initData() {
        countryList.add(Country.builder().capital("Madrid").name("España").region("Europa").population(43000000L).build());
        countryList.add(Country.builder().capital("Paris").name("Francia").region("Europa").population(67000000L).build());
        countryList.add(Country.builder().capital("Berlin").name("Alemania").region("Europa").population(83000000L).build());
    }

    @GetMapping("/searchByCapital")
    public Country searchCountryByCapital(@RequestParam String capital) {		 	
    	return countryList.stream()
                .filter(country -> country.getCapital().equalsIgnoreCase(capital))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/searchByRegion")
    public List<Country> searchCountryByRegion(@RequestParam String region) {
        return countryList.stream()
                .filter(country -> country.getRegion().equalsIgnoreCase(region))
                .collect(Collectors.toList());
    }
    
    @GetMapping("/searchByName")
    public Country searchCountryByName(@RequestParam String name) {
    	return countryList.stream()
                .filter(country -> country.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/saveByName")
    public List<Country> saveCountryByName(@RequestBody Country country) {

    	boolean exists = countryList.stream().anyMatch(existingCountry -> existingCountry.getName().equalsIgnoreCase(country.getName()));

		if (!exists) {
			countryList.add(country);
		}

		return countryList;
    }
}