package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    public Country getCountry(String code) throws CountryNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        
        @SuppressWarnings("unchecked")
        List<Country> countryList = context.getBean("countryList", java.util.List.class);

        // Case-insensitive matching logic
        for (Country country : countryList) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }

        throw new CountryNotFoundException("Country not found");
    }
}
