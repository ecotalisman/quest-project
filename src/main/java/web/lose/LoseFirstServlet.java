package web.lose;

import models.AnswerChallenge;
import service.FirstService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/losefirst")
public class LoseFirstServlet extends HttpServlet {
    FirstService firstService = new FirstService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AnswerChallenge answer = firstService.call(Boolean.parseBoolean(req.getParameter("answer")));

        resp.setStatus(201);
        req.setAttribute("answer", answer.getMessage());
        req.getRequestDispatcher(answer.getPage()).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);
    }
}