package web.failure;

import models.Answer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.GameService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constants.Constants.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoseGameServletTest {
    @Mock
    private HttpServletRequest req;
    @Mock
    private HttpServletResponse resp;
    @Mock
    private RequestDispatcher requestDispatcher;
    @Mock
    private GameService gameService;
    @InjectMocks
    private GameFailureServlet gameFailureServlet;

    @Test
    public void testDoPostWithFalse() throws ServletException, IOException {
        Answer mockAnswer = new Answer("Test false message", GAME_FAILURE_PAGE);

        when(req.getParameter("answer")).thenReturn("false");
        when(gameService.call(false)).thenReturn(mockAnswer);
        when(req.getRequestDispatcher(GAME_FAILURE_PAGE)).thenReturn(requestDispatcher);

        gameFailureServlet.doPost(req, resp);

        verify(resp).setStatus(200);
        verify(req, times(1)).getParameter("answer");
        verify(req).getRequestDispatcher(GAME_FAILURE_PAGE);
        verify(requestDispatcher).forward(req, resp);
    }
}
