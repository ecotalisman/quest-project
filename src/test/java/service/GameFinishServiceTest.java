package service;

import models.Answer;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

class GameFinishServiceTest {
    private GameFinishService gameFinishService = new GameFinishService();

    @Test
    public void testCallTrueShouldReturnStartAccepted() {
        boolean input = true;
        Answer result = gameFinishService.call(input);

        assertEquals(STEP_2_ACCEPTED, result.getMessage());
        assertEquals(GAME_FINISH_PAGE, result.getPage());
    }

    @Test
    public void testCallTrueShouldReturnStartNotAccepted() {
        boolean input = false;
        Answer result = gameFinishService.call(input);

        assertEquals(STEP_2_NOT_ACCEPTED, result.getMessage());
        assertEquals(GAME_FAILURE_PAGE, result.getPage());
    }
}
