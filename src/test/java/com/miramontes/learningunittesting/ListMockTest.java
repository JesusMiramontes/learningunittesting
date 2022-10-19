package com.miramontes.learningunittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
}
