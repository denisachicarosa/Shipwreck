package com.boot;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.PathVariable;


import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class ShipwreckControllerWebIntegrationTest {

//    @Value(%{shipwrecks.path})
//    private String shipwreckPath;


    @Test
    public void testListAll() throws IOException {
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:9090/api/v1/shipwrecks", String.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJson = objectMapper.readTree(response.getBody());

        assertThat( responseJson.isMissingNode(), is(false));
        assertThat(responseJson.toString(), equalTo("[]"));

    }
}
