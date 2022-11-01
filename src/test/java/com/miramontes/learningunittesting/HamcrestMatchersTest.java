package com.miramontes.learningunittesting;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class HamcrestMatchersTest {

    @Test
    public void hamcrestAssertions() {
        List<Integer> numbers = Arrays.asList(4, 8, 15, 16, 23, 42);

        assertThat(numbers, hasSize(6));
        assertThat(numbers, hasItems(4, 15));
        assertThat(numbers, everyItem(greaterThan(2)));
        assertThat(numbers, everyItem(lessThan(100)));
    }

    @Test
    void stringAssertions() {
        assertThat("", is(emptyString()));
        assertThat("ABCDE", containsString("AB"));
        assertThat("XYZ", containsStringIgnoringCase("y"));
        assertThat("ABCDE", startsWith("AB"));
        assertThat("ABCDE", endsWith("DE"));
    }
}
