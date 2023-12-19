package service;

import models.AnswerChallenge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static constants.Constants.*;

public class GameInitializationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameInitializationService.class);

    public AnswerChallenge call(boolean isAccepted) {
        LOGGER.info("Method call() GameInitializationService started");
        if (isAccepted) {
            LOGGER.info("Method call() GameInitializationService end with boolean true");
            return new AnswerChallenge(STEP_START_ACCEPTED, "jsp/gameStart.jsp");
        } else {
            LOGGER.info("Method call() GameInitializationService end with boolean false");
            return new AnswerChallenge(STEP_START_NOT_ACCEPTED, "jsp/gameFailure.jsp");
        }
    }
}
