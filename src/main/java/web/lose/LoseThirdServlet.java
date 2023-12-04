package web.lose;

import models.AnswerChallenge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ThirdService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/losethird")
public class LoseThirdServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoseThirdServlet.class);
    ThirdService thirdService = new ThirdService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Method doPost() LoseThirdServlet started");
        AnswerChallenge answer = thirdService.call(Boolean.parseBoolean(req.getParameter("answer")));

        resp.setStatus(201);
        req.setAttribute("answer", answer.getMessage());
        req.getRequestDispatcher(answer.getPage()).forward(req, resp);
        LOGGER.info("Method doPost() LoseThirdServlet finished");
    }
}
