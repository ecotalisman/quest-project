package web;

import models.AnswerChallenge;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import service.GameChallengeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ExtendWith(MockitoExtension.class)
class GameChallengeServletTest extends Mockito {
    @Mock
    private HttpServletRequest req;
    @Mock
    private HttpServletResponse resp;
    @Mock
    private RequestDispatcher requestDispatcher;
    @Mock
    private GameChallengeService gameChallengeService;
    @InjectMocks
    private GameChallengeServlet gameChallengeServlet;
    @Test
    public void testDoPostWithTrue() throws ServletException, IOException {
        AnswerChallenge mockAnswer = new AnswerChallenge("Test true message", "jsp/gameChallenge.jsp");

        when(req.getParameter("answer")).thenReturn("true");
        when(gameChallengeService.call(true)).thenReturn(mockAnswer);
        when(req.getRequestDispatcher("jsp/gameChallenge.jsp")).thenReturn(requestDispatcher);

        gameChallengeServlet.doPost(req, resp);

        verify(resp).setStatus(201);
        verify(req, times(1)).getParameter("answer");
        verify(req).getRequestDispatcher("jsp/gameChallenge.jsp");
        verify(requestDispatcher).forward(req, resp);
    }
}
