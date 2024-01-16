package service;

import models.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static constants.Constants.*;

public class GameFinishService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameService.class);

    public Answer call(boolean isAccepted) {
        LOGGER.info("Method call() GameFinishService started");
        if (isAccepted) {
            LOGGER.info("Method call() GameFinishService end with boolean true");
            return new Answer(STEP_2_ACCEPTED, GAME_FINISH_PAGE);
        } else {
            LOGGER.info("Method call() GameFinishService end with boolean false");
            return new Answer(STEP_2_NOT_ACCEPTED, GAME_FAILURE_PAGE);
        }
    }
}
