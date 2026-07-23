package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @RequestMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START - getCountryIndia");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        LOGGER.info("END - getCountryIndia");
        return country;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("START - getAllCountries");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        
        @SuppressWarnings("unchecked")
        List<Country> countryList = context.getBean("countryList", java.util.List.class);
        
        LOGGER.info("END - getAllCountries");
        return countryList;
    }

    @PostMapping("/countries")
    public Country addCountry(@RequestBody @Valid Country country) {
        LOGGER.info("START - addCountry");
        LOGGER.debug("Received Country: {}", country);
        // Ideally we would save this to the DAO here
        LOGGER.info("END - addCountry");
        return country;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("START - getCountry with code: {}", code);
        Country country = countryService.getCountry(code);
        LOGGER.info("END - getCountry");
        return country;
    }
}
