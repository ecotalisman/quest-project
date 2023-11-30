package service;

import models.AnswerChallenge;

import static config.AppConfig.*;

public class FirstService {
    public AnswerChallenge call(boolean isAccepted) {
        if (isAccepted) {
            return new AnswerChallenge(STEP_START_ACCEPTED, "jsp/first.jsp");
        } else {
            return new AnswerChallenge(STEP_START_NOT_ACCEPTED, "jsp/lose.jsp");
        }
    }
}
