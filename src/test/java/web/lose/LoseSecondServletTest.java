package web.lose;

import models.AnswerChallenge;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.SecondService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoseSecondServletTest {
    @Mock
    private HttpServletRequest req;
    @Mock
    private HttpServletResponse resp;
    @Mock
    private RequestDispatcher requestDispatcher;
    @Mock
    private SecondService secondService;
    @InjectMocks
    private LoseSecondServlet loseSecondServlet;

    @Test
    public void testDoPostWithFalse() throws ServletException, IOException {
        AnswerChallenge mockAnswer = new AnswerChallenge("Test false message", "jsp/lose.jsp");

        when(req.getParameter("answer")).thenReturn("false");
        when(secondService.call(false)).thenReturn(mockAnswer);
        when(req.getRequestDispatcher("jsp/lose.jsp")).thenReturn(requestDispatcher);

        loseSecondServlet.doPost(req, resp);

        verify(resp).setStatus(201);
        verify(req, times(1)).getParameter("answer");
        verify(req).getRequestDispatcher("jsp/lose.jsp");
        verify(requestDispatcher).forward(req, resp);
    }
}
