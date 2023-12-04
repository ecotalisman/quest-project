package web;

import models.AnswerChallenge;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import service.ThirdService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ExtendWith(MockitoExtension.class)
class ThirdServletTest extends Mockito {
    @Mock
    private HttpServletRequest req;
    @Mock
    private HttpServletResponse resp;
    @Mock
    private RequestDispatcher requestDispatcher;
    @Mock
    private ThirdService thirdService;
    @InjectMocks
    private ThirdServlet thirdServlet;
    @Test
    public void testDoPostWithTrue() throws ServletException, IOException {
        AnswerChallenge mockAnswer = new AnswerChallenge("Test true message", "jsp/finish.jsp");

        when(req.getParameter("answer")).thenReturn("true");
        when(thirdService.call(true)).thenReturn(mockAnswer);
        when(req.getRequestDispatcher("jsp/finish.jsp")).thenReturn(requestDispatcher);

        thirdServlet.doPost(req, resp);

        verify(resp).setStatus(201);
        verify(req, times(1)).getParameter("answer");
        verify(req).getRequestDispatcher("jsp/finish.jsp");
        verify(requestDispatcher).forward(req, resp);
    }
}
