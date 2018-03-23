package com.backbase.infrastrcture.impl;

import com.backbase.bank.domain.model.INGAtmLocation;
import com.backbase.infrastrcture.AtmRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created kkalkur
 */
@Component
public class AtmDataReposiroty implements AtmRepository  {

    private Logger atmDataPopulatorLogger = LoggerFactory.getLogger(AtmDataReposiroty.class);

    @Autowired
    private RestTemplate restTemplate;

    public List<INGAtmLocation> getDataFromInG() throws Exception {


        String response = restTemplate.getForObject("https://www.ing.nl/api/locator/atms/", String.class);
        String toBeParsed = response.substring(6, response.length());
      
        ObjectMapper objectMapper = new ObjectMapper();
        INGAtmLocation[] ingAtmLocations = objectMapper.readValue(toBeParsed, INGAtmLocation[].class);
      

        return Arrays.asList(ingAtmLocations);
    }

    
}
