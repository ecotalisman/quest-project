package service;

import models.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static constants.Constants.*;

public class GameService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameService.class);

    public Answer call(boolean isAccepted) {
        LOGGER.info("Method call() GameService started");
        if (isAccepted) {
            LOGGER.info("Method call() GameService end with boolean true");
            return new Answer(STEP_1_ACCEPTED, GAME_CHALLENGE_PAGE);
        } else {
            LOGGER.info("Method call() GameService end with boolean false");
            return new Answer(STEP_1_NOT_ACCEPTED, GAME_FAILURE_PAGE);
        }
    }
}
