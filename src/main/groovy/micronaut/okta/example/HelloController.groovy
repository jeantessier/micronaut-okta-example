package micronaut.okta.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule

import java.security.Principal

@Controller("/hello")
class HelloController {

    @Get
    @Secured(SecurityRule.IS_AUTHENTICATED)
    def hello(Principal principal) {
        [
                message: "Hello, ${principal.name}!" as String,
                principal: principal.name,
        ]
    }

}
