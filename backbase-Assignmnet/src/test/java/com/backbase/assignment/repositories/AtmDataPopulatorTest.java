package com.backbase.assignment.repositories;

import com.backbase.bank.AtmFinderApplication;
import com.backbase.bank.domain.model.INGAtmLocation;
import com.backbase.infrastrcture.impl.AtmDataReposiroty;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by kkalkur
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AtmFinderApplication.class)
@WebAppConfiguration
public class AtmDataPopulatorTest {

    @Autowired
    AtmDataReposiroty atmDataPopulator;

    @Test
    public void shouldFetchDatafromINGService() throws Exception {

        List<INGAtmLocation> dataFromInG = atmDataPopulator.getDataFromInG();
        // currently we are gettig 1350 records
       assertEquals(dataFromInG.size(), 1350);
    }

}
