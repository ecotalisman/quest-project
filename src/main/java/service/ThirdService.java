package service;

import models.AnswerChallenge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static config.AppConfig.*;

public class ThirdService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecondService.class);

    public AnswerChallenge call(boolean isAccepted) {
        LOGGER.info("Method call() ThirdService started");
        if (isAccepted) {
            LOGGER.info("Method call() ThirdService end with boolean true");
            return new AnswerChallenge(STEP_2_ACCEPTED, "jsp/finish.jsp");
        } else {
            LOGGER.info("Method call() ThirdService end with boolean false");
            return new AnswerChallenge(STEP_2_NOT_ACCEPTED, "jsp/lose.jsp");
        }
    }
}
