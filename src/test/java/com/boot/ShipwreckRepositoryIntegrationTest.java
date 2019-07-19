package com.boot;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
public class ShipwreckRepositoryIntegrationTest {

    @Autowired
    ShipwreckRepository shipwreckRepository;


    @Test
    public void testFindAll(){
        List<Shipwreck> wrecks = shipwreckRepository.findAll();

        assertThat(wrecks.size(), is(greaterThanOrEqualTo(0)));
    }
}
