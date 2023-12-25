package service;

import models.AnswerChallenge;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

class GameFinishServiceTest {
    private GameFinishService gameFinishService = new GameFinishService();

    @Test
    public void testCallTrueShouldReturnStartAccepted() {
        boolean input = true;
        AnswerChallenge result = gameFinishService.call(input);

        assertEquals(STEP_2_ACCEPTED, result.getMessage());
        assertEquals(GAME_FINISH, result.getPage());
    }

    @Test
    public void testCallTrueShouldReturnStartNotAccepted() {
        boolean input = false;
        AnswerChallenge result = gameFinishService.call(input);

        assertEquals(STEP_2_NOT_ACCEPTED, result.getMessage());
        assertEquals(GAME_FAILURE, result.getPage());
    }
}
