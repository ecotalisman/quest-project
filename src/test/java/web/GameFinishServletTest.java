package web;

import models.AnswerChallenge;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import service.GameFinishService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ExtendWith(MockitoExtension.class)
class GameFinishServletTest extends Mockito {
    @Mock
    private HttpServletRequest req;
    @Mock
    private HttpServletResponse resp;
    @Mock
    private RequestDispatcher requestDispatcher;
    @Mock
    private GameFinishService gameFinishService;
    @InjectMocks
    private GameFinishServlet gameFinishServlet;
    @Test
    public void testDoPostWithTrue() throws ServletException, IOException {
        AnswerChallenge mockAnswer = new AnswerChallenge("Test true message", "jsp/gameFinish.jsp");

        when(req.getParameter("answer")).thenReturn("true");
        when(gameFinishService.call(true)).thenReturn(mockAnswer);
        when(req.getRequestDispatcher("jsp/gameFinish.jsp")).thenReturn(requestDispatcher);

        gameFinishServlet.doPost(req, resp);

        verify(resp).setStatus(200);
        verify(req, times(1)).getParameter("answer");
        verify(req).getRequestDispatcher("jsp/gameFinish.jsp");
        verify(requestDispatcher).forward(req, resp);
    }
}
