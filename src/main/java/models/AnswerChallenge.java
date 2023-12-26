package models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnswerChallenge {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnswerChallenge.class);
    private String message;
    private String page;

    public AnswerChallenge() {
    }

    public AnswerChallenge(String message, String page) {
        this.message = message;
        this.page = page;
    }

    public String getMessage() {
        LOGGER.info("Start method getMessage()");
        return message;
    }

    public void setMessage(String message) {
        LOGGER.info("Start method setMessage()");
        this.message = message;
    }

    public String getPage() {
        LOGGER.info("Start method getPage()");
        return page;
    }

    public void setPage(String page) {
        LOGGER.info("Start method setPage()");
        this.page = page;
    }
}
