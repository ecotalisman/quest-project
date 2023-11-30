package service;

import models.AnswerChallenge;

import static config.AppConfig.*;

public class SecondService {
    public AnswerChallenge call(boolean isAccepted) {
        if (isAccepted) {
            return new AnswerChallenge(STEP_1_ACCEPTED, "jsp/second.jsp");
        } else {
            return new AnswerChallenge(STEP_1_NOT_ACCEPTED, "jsp/lose.jsp");
        }
    }
}
