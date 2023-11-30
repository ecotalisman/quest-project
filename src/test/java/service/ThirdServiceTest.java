package service;

import models.AnswerChallenge;
import org.junit.jupiter.api.Test;

import static config.AppConfig.*;
import static org.junit.jupiter.api.Assertions.*;

class ThirdServiceTest {
    private ThirdService thirdService = new ThirdService();

    @Test
    public void testCallTrueShouldReturnStartAccepted() {
        boolean input = true;
        AnswerChallenge result = thirdService.call(input);

        assertEquals(STEP_2_ACCEPTED, result.getMessage());
        assertEquals("jsp/finish.jsp", result.getPage());
    }

    @Test
    public void testCallTrueShouldReturnStartNotAccepted() {
        boolean input = false;
        AnswerChallenge result = thirdService.call(input);

        assertEquals(STEP_2_NOT_ACCEPTED, result.getMessage());
        assertEquals("jsp/lose.jsp", result.getPage());
    }
}
