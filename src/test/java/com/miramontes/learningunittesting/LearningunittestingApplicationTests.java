package com.miramontes.learningunittesting;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LearningunittestingApplicationTests {

    @Autowired private TestRestTemplate testRestTemplate;

    @Test
    void allItemsPresentFromDb() throws JSONException {
        String response = this.testRestTemplate.getForObject("/all-items-from-db", String.class);
        JSONAssert.assertEquals("[{id:10001}, {id:10002}, {id:10003}]", response, false);
    }
}
