package service;

import models.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static constants.Constants.*;

public class GameStartService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameStartService.class);

    public Answer call(boolean isAccepted) {
        LOGGER.info("Method call() GameStartService started");
        if (isAccepted) {
            LOGGER.info("Method call() GameStartService end with boolean true");
            return new Answer(STEP_START_ACCEPTED, GAME_START_PAGE);
        } else {
            LOGGER.info("Method call() GameStartService end with boolean false");
            return new Answer(STEP_START_NOT_ACCEPTED, GAME_FAILURE_PAGE);
        }
    }
}
