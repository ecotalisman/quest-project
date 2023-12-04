package web.lose;

import models.AnswerChallenge;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.FirstService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoseFirstServletTest {
    @Mock
    private HttpServletRequest req;
    @Mock
    private HttpServletResponse resp;
    @Mock
    private RequestDispatcher requestDispatcher;
    @Mock
    private FirstService firstService;
    @InjectMocks
    private LoseFirstServlet loseFirstServlet;
    @Test
    public void testDoPostWithFalse() throws ServletException, IOException {
        AnswerChallenge mockAnswer = new AnswerChallenge("Test false message", "jsp/lose.jsp");

        when(req.getParameter("answer")).thenReturn("false");
        when(firstService.call(false)).thenReturn(mockAnswer);
        when(req.getRequestDispatcher("jsp/lose.jsp")).thenReturn(requestDispatcher);

        loseFirstServlet.doPost(req, resp);

        verify(resp).setStatus(201);
        verify(req, times(1)).getParameter("answer");
        verify(req).getRequestDispatcher("jsp/lose.jsp");
        verify(requestDispatcher).forward(req, resp);
    }
}
