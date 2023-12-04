package web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestartGameServletTest {
    @Mock
    private HttpServletRequest req;
    @Mock
    private HttpServletResponse resp;
    @Mock
    private RequestDispatcher requestDispatcher;

    @InjectMocks
    RestartGameServlet restartGameServlet;

    @Test
    public void doGetTest() throws ServletException, IOException {
        when(req.getRequestDispatcher("index.jsp")).thenReturn(requestDispatcher);

        restartGameServlet.doGet(req, resp);

        verify(req).getRequestDispatcher("index.jsp");
        verify(requestDispatcher).forward(req, resp);
    }
}
