package service;

import models.AnswerChallenge;
import org.junit.jupiter.api.Test;

import static config.AppConfig.*;
import static org.junit.jupiter.api.Assertions.*;


class FirstServiceTest {
    private FirstService firstService = new FirstService();

    @Test
    public void testCallTrueShouldReturnStartAccepted() {
        boolean input = true;
        AnswerChallenge result = firstService.call(input);

        assertEquals(STEP_START_ACCEPTED, result.getMessage());
        assertEquals("jsp/first.jsp", result.getPage());
    }

    @Test
    public void testCallFalseShouldReturnStartNotAccepted() {
        boolean input = false;
        AnswerChallenge result = firstService.call(input);

        assertEquals(STEP_START_NOT_ACCEPTED, result.getMessage());
        assertEquals("jsp/lose.jsp", result.getPage());
    }
}
