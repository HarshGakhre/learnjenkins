package harsh

import jwtFilter.JwtTokenGenerator
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder

import javax.naming.AuthenticationException

class LoginController {

    AuthenticationManager authenticationManager
    JwtTokenGenerator jwtTokenGenerator

    def login() {
        def jsonData = request.JSON
        String username = jsonData.username
        String password = jsonData.password
        try {
            def authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            )
            SecurityContextHolder.getContext().setAuthentication(authentication)

                jwtTokenGenerator.onAuthenticationSuccess(request, response, authentication)

            render(status: 200,)
        } catch (AuthenticationException e) {
            render(status: 401, text: "invalid username or password")
        }
    }
}

