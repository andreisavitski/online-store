package by.pvt.onlinestore.core.filter;

import by.pvt.onlinestore.core.dto.user.UserResponseDTO;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession httpSession = httpServletRequest.getSession(false);
        if (httpSession == null) {
            httpServletRequest.setAttribute("errorMessage", "Pass authorization");
            httpServletRequest.getRequestDispatcher("/jsp/error.jsp").forward(httpServletRequest, servletResponse);
        } else if (httpSession.getAttribute("userAuthorize") == null) {
            httpServletRequest.setAttribute("errorMessage", "Pass authorization");
            httpServletRequest.getRequestDispatcher("/jsp/error.jsp").forward(httpServletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
