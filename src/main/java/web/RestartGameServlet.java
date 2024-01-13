package web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.failure.GameFailureServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/restart")
public class RestartGameServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameFailureServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Method doGet() RestartGameServlet started");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
        LOGGER.info("Method doGet() RestartGameServlet finished");
    }
}
