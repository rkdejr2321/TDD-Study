package com.example.TDD.appendixC;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class GameGenMockTest {

    @Test
    void mockTest() {
        //모의 객체  생성
        GameNumGen genMock = Mockito.mock(GameNumGen.class);

        //스텁 설정
        BDDMockito.given(genMock.generate(GameLevel.EASY)).willReturn("123");
        BDDMockito.given(genMock.generate(null)).willThrow(new IllegalArgumentException());

        //스텁 설정에 매칭되는 메서드 실행 =
        String num = genMock.generate(GameLevel.EASY);

        //검증
        Assertions.assertEquals("123", num);
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> genMock.generate(null));
    }
}
