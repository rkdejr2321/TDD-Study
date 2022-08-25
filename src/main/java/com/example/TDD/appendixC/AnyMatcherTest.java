package com.example.TDD.appendixC;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class AnyMatcherTest {

    @Test
    void anyMatchTest() {
        GameNumGen genMock = Mockito.mock(GameNumGen.class);
        BDDMockito.given(genMock.generate(ArgumentMatchers.any())).willReturn("456");

        String num = genMock.generate(GameLevel.EASY);
        Assertions.assertEquals("456", num);

        String num2 = genMock.generate(GameLevel.NORMAL);
        Assertions.assertEquals("456", num2);
    }
}
