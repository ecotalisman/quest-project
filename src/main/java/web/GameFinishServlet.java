package web;

import models.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.GameFinishService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/finish")
public class GameFinishServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameFinishServlet.class);
    GameFinishService gameFinishService = new GameFinishService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Method doPost() GameFinishServlet started");
        Answer answer = gameFinishService.call(Boolean.parseBoolean(req.getParameter("answer")));

        resp.setStatus(200);
        req.setAttribute("answer", answer.getMessage());
        req.getRequestDispatcher(answer.getPage()).forward(req, resp);
        LOGGER.info("Method doPost() GameFinishServlet finished");
    }
}
