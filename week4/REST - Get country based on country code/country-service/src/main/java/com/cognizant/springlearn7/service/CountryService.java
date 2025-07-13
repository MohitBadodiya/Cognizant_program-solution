package com.cognizant.springlearn7.service;

import com.cognizant.springlearn7.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private ApplicationContext context;

    public Country getCountry(String code) {
        List<Country> countries = (List<Country>) context.getBean("countryList");
        for (Country country : countries) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }
        throw new RuntimeException("Country not found");
    }
}
