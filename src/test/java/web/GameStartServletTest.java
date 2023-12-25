package web;

import models.AnswerChallenge;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import service.GameInitializationService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constants.Constants.*;

@ExtendWith(MockitoExtension.class)
class GameStartServletTest extends Mockito {
    @Mock
    private HttpServletRequest req;
    @Mock
    private HttpServletResponse resp;
    @Mock
    private RequestDispatcher requestDispatcher;
    @Mock
    private GameInitializationService gameInitializationService;
    @InjectMocks
    private GameStartServlet gameStartServlet;
    @Test
    public void testDoPostWithTrue() throws ServletException, IOException {
        AnswerChallenge mockAnswer = new AnswerChallenge("Test true message", GAME_START);

        when(req.getParameter("answer")).thenReturn("true");
        when(gameInitializationService.call(true)).thenReturn(mockAnswer);
        when(req.getRequestDispatcher(GAME_START)).thenReturn(requestDispatcher);

        gameStartServlet.doPost(req, resp);

        verify(resp).setStatus(200);
        verify(req, times(1)).getParameter("answer");
        verify(req).getRequestDispatcher(GAME_START);
        verify(requestDispatcher).forward(req, resp);
    }
}
