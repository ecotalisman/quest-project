package web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class SessionFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionFilter.class);
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("Method doFilter() SessionFilter started");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String path = httpRequest.getServletPath();

        if ("/restart".equals(path) || "/finish".equals(path)) {
            LOGGER.info(String.format("Found path to finish game with %s", path));
            HttpSession session = httpRequest.getSession();
            Integer gameCounter = (Integer) session.getAttribute("gameCounter");
            if (gameCounter == null) {
                gameCounter = 1;
            } else {
                gameCounter++;
            }
            LOGGER.info(String.format("Game count times: %d", gameCounter));
            session.setAttribute("gameCounter", gameCounter);
        }

        if (httpRequest.getSession().getAttribute("userName") == null) {
            LOGGER.info("No name found in session, setting default name: Travel Hobbit");
            httpRequest.getSession().setAttribute("userName", "Travel Hobbit");
        } else {
            LOGGER.info(String.format("Setting name in session: %s", httpRequest.getSession().getAttribute("userName")));
        }
        chain.doFilter(request, response);
        LOGGER.info("Method doFilter() SessionFilter finished");
    }
}
