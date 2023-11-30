package service;

import models.AnswerChallenge;

import static config.AppConfig.*;

public class ThirdService {
    public AnswerChallenge call(boolean isAccepted) {
        if (isAccepted) {
            return new AnswerChallenge(STEP_2_ACCEPTED, "jsp/finish.jsp");
        } else {
            return new AnswerChallenge(STEP_2_NOT_ACCEPTED, "jsp/lose.jsp");
        }
    }
}
