package com.backbase.bank.services;

import com.backbase.bank.domain.model.INGAtmLocation;
import com.backbase.infrastrcture.impl.AtmDataReposiroty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kkalkur
 */

public interface AtmDomianService {

    

    public List<INGAtmLocation> getAtmLocationsfromING() throws Exception ;

      

    public List<INGAtmLocation> getAtmLocationsfromINGByCity(String city) throws Exception ;

        
}
