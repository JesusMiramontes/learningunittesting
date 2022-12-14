package com.miramontes.learningunittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

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

    @Test
    public void argumentCapturing() {
        // SUT
        listMock.add("SomeString");

        // Including Argument Captor
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(listMock).add(captor.capture());

        // Assertion
        assertEquals("SomeString", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {
        // SUT
        listMock.add("object 1");
        listMock.add("object 2");

        // Including Argument Captor
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(listMock, times(2)).add(captor.capture());

        // Retrieving captured arguments.
        List<String> capturedArguments = captor.getAllValues();

        assertTrue(capturedArguments.contains("object 1"));
        assertTrue(capturedArguments.contains("object 2"));
    }

    @Test
    public void mocking() {
        // Mocking doesn't retain the original class behavior. Only behaves as we specify.
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println("arrayListMock.size() = " + arrayListMock.size()); // Will return 0;
        arrayListMock.add("foo");
        arrayListMock.add("bar");
        System.out.println("arrayListMock.size() = " + arrayListMock.size()); // Still returns 0;
        when(arrayListMock.size()).thenReturn(10);
        System.out.println("arrayListMock.size() = " + arrayListMock.size()); // Will return 10;
    }

    @Test
    public void spying() {
        // Spying will behave as the class is designed to, but we can still override behavior.
        ArrayList arrayListSpy = spy(ArrayList.class);
        System.out.println("arrayListSpy.size() = " + arrayListSpy.size()); // Will return 0;
        arrayListSpy.add("foo");
        arrayListSpy.add("bar");
        System.out.println("arrayListSpy.size() = " + arrayListSpy.size()); // Still returns 2;
        when(arrayListSpy.size()).thenReturn(10);
        System.out.println("arrayListSpy.size() = " + arrayListSpy.size()); // Will return 10;
    }
}
