package service;

import models.Answer;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {
    private GameService gameService = new GameService();

    @Test
    public void testCallTrueShouldReturnStartAccepted() {
        boolean input = true;
        Answer result = gameService.call(input);

        assertEquals(STEP_1_ACCEPTED, result.getMessage());
        assertEquals(GAME_CHALLENGE_PAGE, result.getPage());
    }

    @Test
    public void testCallTrueShouldReturnStartNotAccepted() {
        boolean input = false;
        Answer result = gameService.call(input);

        assertEquals(STEP_1_NOT_ACCEPTED, result.getMessage());
        assertEquals(GAME_FAILURE_PAGE, result.getPage());
    }
}
