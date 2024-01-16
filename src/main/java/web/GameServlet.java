package web;

import models.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameServlet.class);
    GameService gameService = new GameService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");

        if (userName != null && !userName.trim().isEmpty()) {
            HttpSession session = req.getSession();
            session.setAttribute("userName", userName);
            LOGGER.info("User name set in session: " + userName);
        } else {
            LOGGER.warn("User name parameter was null or empty");
        }

        LOGGER.info("Method doPost() GameServlet started");
        Answer answer = gameService.call(Boolean.parseBoolean(req.getParameter("answer")));

        resp.setStatus(200);
        req.setAttribute("answer", answer.getMessage());
        req.getRequestDispatcher(answer.getPage()).forward(req, resp);
        LOGGER.info("Method doPost() GameServlet finished");
    }
}
