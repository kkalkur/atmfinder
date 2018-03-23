package com.backbase.bank.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backbase.bank.domain.model.INGAtmLocation;
import com.backbase.bank.services.AtmDomianService;
import com.backbase.infrastrcture.impl.AtmDataReposiroty;

@Service
public class AtmDomainServiceImpl  implements AtmDomianService {
	 @Autowired
	    private AtmDataReposiroty atmDataPopulator;

	    public List<INGAtmLocation> getAtmLocationsfromING() throws Exception {

	        return atmDataPopulator.getDataFromInG();
	    }

	    public List<INGAtmLocation> getAtmLocationsfromINGByCity(String city) throws Exception {

	        List<INGAtmLocation> locations = new ArrayList<>();
	        List<INGAtmLocation> atmLocationsfromING = getAtmLocationsfromING();
	        for (INGAtmLocation location : atmLocationsfromING) {
	            if (city.equalsIgnoreCase(location.getAddress().getCity())) {
	                locations.add(location);
	            }
	        }
	        return locations;
	    }

}
