package com.backbase.controller;

import com.backbase.bank.domain.model.ApiResponseObject;
import com.backbase.bank.domain.model.INGAtmLocation;
import com.backbase.bank.services.AtmDomianService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kkalkur
 */
@RestController
public class AtmApplicationService {

    @Autowired
    private AtmDomianService atmLocator;

    @RequestMapping(value = "/ATMlocations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    ApiResponseObject getATMLocationsfromING() throws Exception {
        ApiResponseObject<INGAtmLocation> responseObject= new ApiResponseObject<>();
        responseObject.setList(atmLocator.getAtmLocationsfromING());
        return responseObject;
    }

    @RequestMapping(value = "/ATMlocations/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    ApiResponseObject getATMLocationsfromINGByCity(@RequestParam(name="city", required=false) String city) throws Exception {
        ApiResponseObject<INGAtmLocation> responseObject= new ApiResponseObject<>();
        responseObject.setList(atmLocator.getAtmLocationsfromINGByCity(city));
        return responseObject;
    }


}
