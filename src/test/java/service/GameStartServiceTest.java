package service;

import models.Answer;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;


class GameStartServiceTest {
    private GameStartService gameStartService = new GameStartService();

    @Test
    public void testCallTrueShouldReturnStartAccepted() {
        boolean input = true;
        Answer result = gameStartService.call(input);

        assertEquals(STEP_START_ACCEPTED, result.getMessage());
        assertEquals(GAME_START_PAGE, result.getPage());
    }

    @Test
    public void testCallFalseShouldReturnStartNotAccepted() {
        boolean input = false;
        Answer result = gameStartService.call(input);

        assertEquals(STEP_START_NOT_ACCEPTED, result.getMessage());
        assertEquals(GAME_FAILURE_PAGE, result.getPage());
    }
}
