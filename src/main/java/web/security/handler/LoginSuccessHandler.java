package web.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        if(authentication.getAuthorities()
                .stream()
                .anyMatch(r->r.getAuthority().equals("ROLE_ADMIN"))){
            httpServletResponse.sendRedirect("/admin/users");
        } else{
            httpServletResponse.sendRedirect("/user/userPage");
        }
    }
}