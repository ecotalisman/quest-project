package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {
    @Test
    public void testGetMessageAndGetPage() {
        String expectedMessage = "true";
        String expectedPage = "index.jsp";
        Answer answer = new Answer(expectedMessage, expectedPage);

        assertEquals(expectedMessage, answer.getMessage());
        assertEquals(expectedPage, answer.getPage());
    }

    @Test
    public void testSetMessageAndSetPage() {
        String expectedMessage = "false";
        String expectedPage = "index.jsp";

        Answer answer = new Answer();
        answer.setMessage(expectedMessage);
        answer.setPage(expectedPage);

        assertEquals(expectedMessage, answer.getMessage());
        assertEquals(expectedPage, answer.getPage());
    }
}
