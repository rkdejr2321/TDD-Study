package com.example.TDD.appendixC;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.mock;

public class VoidMethodStubTest {

    @Test
    void voidMethodWillThrowTest() {
        List<String> mockList = Mockito.mock(List.class);

        BDDMockito.willThrow(UnsupportedOperationException.class)
                .given(mockList)
                .clear();

        Assertions.assertThrows(
                UnsupportedOperationException.class,
                () -> mockList.clear()
        );
    }
}
