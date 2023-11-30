package service;

import models.AnswerChallenge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static config.AppConfig.*;

public class SecondService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecondService.class);

    public AnswerChallenge call(boolean isAccepted) {
        LOGGER.info("Method call() SecondService started");
        if (isAccepted) {
            LOGGER.info("Method call() SecondService end with boolean true");
            return new AnswerChallenge(STEP_1_ACCEPTED, "jsp/second.jsp");
        } else {
            LOGGER.info("Method call() SecondService end with boolean false");
            return new AnswerChallenge(STEP_1_NOT_ACCEPTED, "jsp/lose.jsp");
        }
    }
}
