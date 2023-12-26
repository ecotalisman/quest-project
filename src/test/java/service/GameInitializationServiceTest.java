package service;

import models.AnswerChallenge;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;


class GameInitializationServiceTest {
    private GameInitializationService gameInitializationService = new GameInitializationService();

    @Test
    public void testCallTrueShouldReturnStartAccepted() {
        boolean input = true;
        AnswerChallenge result = gameInitializationService.call(input);

        assertEquals(STEP_START_ACCEPTED, result.getMessage());
        assertEquals(GAME_START, result.getPage());
    }

    @Test
    public void testCallFalseShouldReturnStartNotAccepted() {
        boolean input = false;
        AnswerChallenge result = gameInitializationService.call(input);

        assertEquals(STEP_START_NOT_ACCEPTED, result.getMessage());
        assertEquals(GAME_FAILURE, result.getPage());
    }
}
