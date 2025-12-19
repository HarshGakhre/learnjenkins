package spring

import harsh.UserPasswordEncoderListener
import jwtFilter.JwtTokenGenerator
import jwtFilter.JwtTokenValidationFilter

beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    jwtTokenGenerator(JwtTokenGenerator)
    jwtTokenValidationFilter(JwtTokenValidationFilter)
}
