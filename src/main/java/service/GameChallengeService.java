package service;

import models.AnswerChallenge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static constants.Constants.*;

public class GameChallengeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameChallengeService.class);

    public AnswerChallenge call(boolean isAccepted) {
        LOGGER.info("Method call() GameChallengeService started");
        if (isAccepted) {
            LOGGER.info("Method call() GameChallengeService end with boolean true");
            return new AnswerChallenge(STEP_1_ACCEPTED, "jsp/gameChallenge.jsp");
        } else {
            LOGGER.info("Method call() GameChallengeService end with boolean false");
            return new AnswerChallenge(STEP_1_NOT_ACCEPTED, "jsp/gameFailure.jsp");
        }
    }
}
