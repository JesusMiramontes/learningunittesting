package com.miramontes.learningunittesting.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
    private static final String expected =
            "{\"id\":1,\"name\":\"Foo\",\"price\":10,\"quantity\":100}";

    // This test is meant to fail.
    @Test
    public void jsonAssert_strict_fail() throws JSONException {
        String actual = "{\"id\":1,\"name\":\"Foo\",\"price\":        10}";

        // If we set the strict as true, the test will fail because it didn't find all the expected
        // attributes.
        // It won't fail because of the extra spaces tho.
        JSONAssert.assertEquals(expected, actual, true);
    }

    @Test
    public void jsonAssert_notStrict() throws JSONException {
        String actual =
                "{\"id\":1,\"name\":\"Foo\",\"price\":10,\"quantity\":100,\"not_expected_field\":\"bar\"}";

        // If we set strict ass false, it will allow to receive extra field, but if one of the
        // expected is missing, it will fail.
        JSONAssert.assertEquals(expected, actual, false);
    }

    @Test
    public void jsonAssert_without_backslashes() throws JSONException {
        // You can leave the json without scape characters only if they don't have spaces in
        // between.
        String actual = "{id:1,name:Foo,price:10,quantity:100}";
        JSONAssert.assertEquals(expected, actual, true);
    }
}
