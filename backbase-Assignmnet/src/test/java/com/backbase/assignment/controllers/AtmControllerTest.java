package com.backbase.assignment.controllers;

import com.backbase.bank.domain.model.Address;
import com.backbase.bank.domain.model.ApiResponseObject;
import com.backbase.bank.domain.model.INGAtmLocation;
import com.backbase.bank.services.AtmDomianService;
import com.backbase.controller.AtmApplicationService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by kkalkur
 */
public class AtmControllerTest {


    @InjectMocks
    AtmApplicationService atmApplicationService;

    @Mock
    AtmDomianService atmDomainServicer;

    private List<INGAtmLocation> atmLocationList;


    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        atmLocationList = new ArrayList<>();
        INGAtmLocation atmLocation = new INGAtmLocation();
        Address address = new Address();
        address.setCity("GELDROP");
        address.setHousenumber("1");

        atmLocation.setAddress(address);

        INGAtmLocation atmLocation1 = new INGAtmLocation();
        Address address1 = new Address();
        address1.setHousenumber("2");
        address1.setCity("ROTTERDAM");

        atmLocation1.setAddress(address1);

        atmLocationList.add(atmLocation);
        atmLocationList.add(atmLocation1);
    }

    @Test
    public void testGetATMLocationsfromING() throws Exception {

        when(atmDomainServicer.getAtmLocationsfromING()).thenReturn(atmLocationList);
        ApiResponseObject atmLocationsfromING = atmApplicationService.getATMLocationsfromING();
        assertEquals(atmLocationsfromING.getList().size(),2);

    }

    @Test
    public void testGetATMLocationsfromINGByCity() throws Exception {

        when(atmDomainServicer.getAtmLocationsfromINGByCity(Mockito.anyString())).thenReturn(atmLocationList);
        ApiResponseObject locationsfromINGByCity = atmApplicationService.getATMLocationsfromINGByCity("ANY_CITY");
        assertEquals(locationsfromINGByCity.getList().size(),2);

    }
}