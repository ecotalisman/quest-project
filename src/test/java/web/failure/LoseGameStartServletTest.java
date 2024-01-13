package web.failure;

import models.Answer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.GameStartService;

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
    private GameStartService gameStartService;
    @InjectMocks
    private GameStartFailureServlet gameStartFailureServlet;
    @Test
    public void testDoPostWithFalse() throws ServletException, IOException {
        Answer mockAnswer = new Answer("Test false message", GAME_FAILURE_PAGE);

        when(req.getParameter("answer")).thenReturn("false");
        when(gameStartService.call(false)).thenReturn(mockAnswer);
        when(req.getRequestDispatcher(GAME_FAILURE_PAGE)).thenReturn(requestDispatcher);

        gameStartFailureServlet.doPost(req, resp);

        verify(resp).setStatus(200);
        verify(req, times(1)).getParameter("answer");
        verify(req).getRequestDispatcher(GAME_FAILURE_PAGE);
        verify(requestDispatcher).forward(req, resp);
    }
}
