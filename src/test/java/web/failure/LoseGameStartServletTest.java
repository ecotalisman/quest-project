package web.failure;

import models.AnswerChallenge;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.GameInitializationService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constants.Constants.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoseGameStartServletTest {
    @Mock
    private HttpServletRequest req;
    @Mock
    private HttpServletResponse resp;
    @Mock
    private RequestDispatcher requestDispatcher;
    @Mock
    private GameInitializationService gameInitializationService;
    @InjectMocks
    private GameStartFailureServlet gameStartFailureServlet;
    @Test
    public void testDoPostWithFalse() throws ServletException, IOException {
        AnswerChallenge mockAnswer = new AnswerChallenge("Test false message", GAME_FAILURE);

        when(req.getParameter("answer")).thenReturn("false");
        when(gameInitializationService.call(false)).thenReturn(mockAnswer);
        when(req.getRequestDispatcher(GAME_FAILURE)).thenReturn(requestDispatcher);

        gameStartFailureServlet.doPost(req, resp);

        verify(resp).setStatus(200);
        verify(req, times(1)).getParameter("answer");
        verify(req).getRequestDispatcher(GAME_FAILURE);
        verify(requestDispatcher).forward(req, resp);
    }
}
