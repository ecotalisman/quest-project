package web.failure;

import models.AnswerChallenge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.GameInitializationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/startfailure")
public class GameStartFailureServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameStartFailureServlet.class);
    GameInitializationService gameInitializationService = new GameInitializationService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Method doPost() GameStartFailureServlet started");
        AnswerChallenge answer = gameInitializationService.call(Boolean.parseBoolean(req.getParameter("answer")));

        resp.setStatus(200);
        req.setAttribute("answer", answer.getMessage());
        req.getRequestDispatcher(answer.getPage()).forward(req, resp);
        LOGGER.info("Method doPost() GameStartFailureServlet finished");
    }
}
