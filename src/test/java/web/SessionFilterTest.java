package web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SessionFilterTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    private FilterChain chain;
    @Mock
    private HttpSession session;
    @InjectMocks
    private SessionFilter sessionFilter;

    @ParameterizedTest
    @ValueSource(strings = {"/restart", "/finish"})
    public void TestDoFilterInitializeSessionAttributes(String path) throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("gameCounter")).thenReturn(null);
        when(session.getAttribute("name")).thenReturn(null);
        when(request.getServletPath()).thenReturn(path);

        sessionFilter.doFilter(request, response, chain);

        verify(session).setAttribute("gameCounter", 1);
        verify(session).setAttribute(eq("name"), anyString());
        verify(chain).doFilter(request, response);
    }

    @Test
    public void TestDoFilterWhenGameCounterExists() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("gameCounter")).thenReturn(2);
        when(session.getAttribute("name")).thenReturn("ExistingNickname");
        when(request.getServletPath()).thenReturn("/restart");

        sessionFilter.doFilter(request, response, chain);

        verify(session).setAttribute("gameCounter", 3);
        verify(session, never()).setAttribute(eq("name"), anyString());
        verify(chain).doFilter(request, response);
    }

    @Test
    public void TestDoFilterForOtherPaths() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(request.getServletPath()).thenReturn("/otherPath");
        when(session.getAttribute("name")).thenReturn("ExistingNickname");

        sessionFilter.doFilter(request, response, chain);

        verify(session, never()).setAttribute(eq("gameCounter"), anyInt());
        verify(session, never()).setAttribute(eq("name"), anyString());
        verify(chain).doFilter(request, response);
    }
}
