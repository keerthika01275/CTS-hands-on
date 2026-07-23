package com.cognizant.springlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
        
        displayDate();
        displayCountry();
        displayCountries();
    }

    public static void displayDate() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        try {
            Date date = format.parse("31/12/2018");
            LOGGER.debug("Parsed Date: {}", date);
            // System.out.println("Never use sout, but keeping as per prompt instructions: " + date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("END");
    }

    public static void displayCountry() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        
        // Demonstrating Prototype Scope (Hands-on 5)
        // You will see "Inside Country Constructor" triggered twice in the logs!
        LOGGER.debug("Fetching first instance of 'country' bean...");
        Country country = context.getBean("country", Country.class);
        
        LOGGER.debug("Fetching second instance of 'country' bean...");
        Country anotherCountry = context.getBean("country", Country.class);
        
        LOGGER.debug("Country 1: {}", country.toString());
        LOGGER.debug("Country 2: {}", anotherCountry.toString());
        
        LOGGER.info("END");
    }

    public static void displayCountries() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        
        // Suppressing unchecked cast warnings for java.util.List.class
        @SuppressWarnings("unchecked")
        List<Country> countryList = context.getBean("countryList", java.util.List.class);
        
        LOGGER.debug("List of countries: {}", countryList);
        LOGGER.info("END");
    }
}
