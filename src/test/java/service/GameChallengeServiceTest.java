package service;

import models.AnswerChallenge;
import org.junit.jupiter.api.Test;

import static config.AppConfig.*;
import static org.junit.jupiter.api.Assertions.*;

class GameChallengeServiceTest {
    private GameChallengeService gameChallengeService = new GameChallengeService();

    @Test
    public void testCallTrueShouldReturnStartAccepted() {
        boolean input = true;
        AnswerChallenge result = gameChallengeService.call(input);

        assertEquals(STEP_1_ACCEPTED, result.getMessage());
        assertEquals("jsp/gameChallenge.jsp", result.getPage());
    }

    @Test
    public void testCallTrueShouldReturnStartNotAccepted() {
        boolean input = false;
        AnswerChallenge result = gameChallengeService.call(input);

        assertEquals(STEP_1_NOT_ACCEPTED, result.getMessage());
        assertEquals("jsp/gameFailure.jsp", result.getPage());
    }
}
