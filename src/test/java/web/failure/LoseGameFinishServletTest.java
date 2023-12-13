package web.failure;

import models.AnswerChallenge;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.GameFinishService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoseGameFinishServletTest {
    @Mock
    private HttpServletRequest req;
    @Mock
    private HttpServletResponse resp;
    @Mock
    private RequestDispatcher requestDispatcher;
    @Mock
    private GameFinishService gameFinishService;
    @InjectMocks
    private GameFinishFailureServlet gameFinishFailureServlet;

    @Test
    public void testDoPostWithFalse() throws ServletException, IOException {
        AnswerChallenge mockAnswer = new AnswerChallenge("Test false message", "jsp/gameFailure.jsp");

        when(req.getParameter("answer")).thenReturn("false");
        when(gameFinishService.call(false)).thenReturn(mockAnswer);
        when(req.getRequestDispatcher("jsp/gameFailure.jsp")).thenReturn(requestDispatcher);

        gameFinishFailureServlet.doPost(req, resp);

        verify(resp).setStatus(201);
        verify(req, times(1)).getParameter("answer");
        verify(req).getRequestDispatcher("jsp/gameFailure.jsp");
        verify(requestDispatcher).forward(req, resp);
    }
}
