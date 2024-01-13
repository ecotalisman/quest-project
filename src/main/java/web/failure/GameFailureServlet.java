package web.failure;

import models.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/game-failure")
public class GameFailureServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameFailureServlet.class);
    GameService gameService = new GameService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Method doPost() GameFailureServlet started");
        Answer answer = gameService.call(Boolean.parseBoolean(req.getParameter("answer")));

        resp.setStatus(200);
        req.setAttribute("answer", answer.getMessage());
        req.getRequestDispatcher(answer.getPage()).forward(req, resp);
        LOGGER.info("Method doPost() GameFailureServlet finished");
    }
}
