package service;

import models.AnswerChallenge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static constants.Constants.*;

public class GameFinishService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameChallengeService.class);

    public AnswerChallenge call(boolean isAccepted) {
        LOGGER.info("Method call() GameFinishService started");
        if (isAccepted) {
            LOGGER.info("Method call() GameFinishService end with boolean true");
            return new AnswerChallenge(STEP_2_ACCEPTED, GAME_FINISH);
        } else {
            LOGGER.info("Method call() GameFinishService end with boolean false");
            return new AnswerChallenge(STEP_2_NOT_ACCEPTED, GAME_FAILURE);
        }
    }
}
