package micronaut.okta.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule

@Controller("/hello")
class HelloController {

    @Get
    @Secured(SecurityRule.IS_AUTHENTICATED)
    def hello(principal) {
        [
                message: "Hello, ${principal.name}!",
                principal: principal.name,
        ]
    }

}
