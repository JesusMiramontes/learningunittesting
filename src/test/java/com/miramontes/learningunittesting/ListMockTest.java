package com.miramontes.learningunittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ListMockTest {
    List listMock = mock(List.class);

    @Test
    public void sizeBasic() {
        when(listMock.size()).thenReturn(1);
        assertEquals(1, listMock.size());
    }

    @Test
    public void returnDifferentValues() {
        // At first call to method it will return 10, second time will return 20.
        when(listMock.size()).thenReturn(10).thenReturn(20);

        // Validate.
        assertEquals(10, listMock.size());
        assertEquals(20, listMock.size());
    }

    @Test
    public void returnWithParameters() {
        // When the param is 0 return Zero. When the param is 1 return 1.
        when(listMock.get(0)).thenReturn("Zero");
        when(listMock.get(1)).thenReturn("One");

        // Validate.
        assertEquals("Zero", listMock.get(0));
        assertEquals("One", listMock.get(1));
    }

    @Test
    public void returnWithArgumentMatchers() {
        when(listMock.get(anyInt())).thenReturn("anyInt");
        assertEquals("anyInt", listMock.get(1));
        assertEquals("anyInt", listMock.get(100));
        assertEquals("anyInt", listMock.get(anyInt()));
    }

    @Test
    public void verificationBasics() {
        listMock.get(0);
        listMock.get(0);
        listMock.get(1);
        listMock.get(2);

        // Verify method get with param '2' is called.
        verify(listMock).get(2);

        // Verify method get with param '0' is called exactly two times.
        verify(listMock, times(2)).get(0);

        // Verify method get with any int as param gets called at least one time.
        verify(listMock, atLeastOnce()).get(anyInt());

        // Verify method get gets called maximum 4 times.
        verify(listMock, atMost(4)).get(anyInt());

        // Verify method get with param 100 never gets called.
        verify(listMock, never()).get(100);
    }
}
