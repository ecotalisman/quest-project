package service;

import models.AnswerChallenge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static config.AppConfig.*;

public class FirstService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FirstService.class);

    public AnswerChallenge call(boolean isAccepted) {
        LOGGER.info("Method call() FirstService started");
        if (isAccepted) {
            LOGGER.info("Method call() FirstService end with boolean true");
            return new AnswerChallenge(STEP_START_ACCEPTED, "jsp/first.jsp");
        } else {
            LOGGER.info("Method call() FirstService end with boolean false");
            return new AnswerChallenge(STEP_START_NOT_ACCEPTED, "jsp/lose.jsp");
        }
    }
}
