package com.backbase.infrastrcture;

import com.backbase.bank.domain.model.INGAtmLocation;

import java.util.List;
/*
 *  Created by  kkalkur
 * 
 */

public interface AtmRepository {

 
    public List<INGAtmLocation> getDataFromInG() throws Exception ;


    
}
