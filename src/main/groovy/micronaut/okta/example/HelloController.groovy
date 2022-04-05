package micronaut.okta.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import org.slf4j.LoggerFactory

import java.security.Principal

@Controller("/hello")
class HelloController {

    static final LOGGER = LoggerFactory.getLogger(this)

    @Get
    @Secured(SecurityRule.IS_AUTHENTICATED)
    def hello(Principal principal) {
        LOGGER.info("principal: ${principal} (${principal.getClass().name})")
        [
                message: "Hello, ${principal.attributes.given_name}!" as String,
                principal: principal.name,
                principalJson: principal.toJson(),
        ]
    }

}
