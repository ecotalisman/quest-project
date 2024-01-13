package web;

import models.Answer;
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

import static constants.Constants.*;

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
        Answer mockAnswer = new Answer("Test true message", GAME_FINISH_PAGE);

        when(req.getParameter("answer")).thenReturn("true");
        when(gameFinishService.call(true)).thenReturn(mockAnswer);
        when(req.getRequestDispatcher(GAME_FINISH_PAGE)).thenReturn(requestDispatcher);

        gameFinishServlet.doPost(req, resp);

        verify(resp).setStatus(200);
        verify(req, times(1)).getParameter("answer");
        verify(req).getRequestDispatcher(GAME_FINISH_PAGE);
        verify(requestDispatcher).forward(req, resp);
    }
}
