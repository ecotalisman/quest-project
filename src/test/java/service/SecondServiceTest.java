package service;

import models.AnswerChallenge;
import org.junit.jupiter.api.Test;

import static config.AppConfig.*;
import static org.junit.jupiter.api.Assertions.*;

class SecondServiceTest {
    private SecondService secondService = new SecondService();

    @Test
    public void testCallTrueShouldReturnStartAccepted() {
        boolean input = true;
        AnswerChallenge result = secondService.call(input);

        assertEquals(STEP_1_ACCEPTED, result.getMessage());
        assertEquals("jsp/second.jsp", result.getPage());
    }

    @Test
    public void testCallTrueShouldReturnStartNotAccepted() {
        boolean input = false;
        AnswerChallenge result = secondService.call(input);

        assertEquals(STEP_1_NOT_ACCEPTED, result.getMessage());
        assertEquals("jsp/lose.jsp", result.getPage());
    }
}
