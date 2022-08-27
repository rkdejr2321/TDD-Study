package com.example.TDD.appendixC;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

public class GameTest {

    @Test
    void init() {
        GameNumGen genMock = Mockito.mock(GameNumGen.class);
        Game game = new Game(genMock);
        game.init(GameLevel.EASY);

        BDDMockito.then(genMock).should().generate(GameLevel.EASY);
    }
}
