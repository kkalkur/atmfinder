package com.backbase.assignment.services;

import com.backbase.bank.domain.model.Address;
import com.backbase.bank.domain.model.INGAtmLocation;
import com.backbase.bank.services.AtmDomianService;
import com.backbase.bank.services.impl.AtmDomainServiceImpl;
import com.backbase.infrastrcture.impl.AtmDataReposiroty;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by  kkalkur
 */
public class AtmLocatorTest {

    @InjectMocks
    AtmDomainServiceImpl atmLocator;

    @Mock
    AtmDataReposiroty atmDataPopulator;

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
        address1.setHousenumber("17");
        address1.setCity("Arnhem");

        atmLocation1.setAddress(address1);

        atmLocationList.add(atmLocation);
        atmLocationList.add(atmLocation1);
    }

    @Test
    public void testGetAtmLocationsfromING() throws Exception {

        when(atmDataPopulator.getDataFromInG()).thenReturn(atmLocationList);
        List<INGAtmLocation> atmLocations = atmLocator.getAtmLocationsfromING();
        assertEquals(atmLocations.size(), 2);

    }

    @Test
    public void testGetAtmLocationsfromINGByCity() throws Exception {

        when(atmDataPopulator.getDataFromInG()).thenReturn(atmLocationList);
        List<INGAtmLocation> atmLocationsfromINGByCity = atmLocator.getAtmLocationsfromINGByCity("GELDROP");
        assertEquals(atmLocationsfromINGByCity.size(), 1);
    }
}