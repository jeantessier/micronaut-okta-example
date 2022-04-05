# Micronaut Okta Example

Based on
[this article](https://dzone.com/articles/spring-vs-micronaut-vs-quarkus-which-one-is-the-be)
on integrating Okta with various microservices frameworks, including Micronaut.

To run:

```bash
./gradlew run
```

You can obtain a JWT from Okta using the
[OpenID Connect debugger](https://oidcdebugger.com).  The current config points
to the `dev-2345032` app in Okta.

Once you've extracted the access token from the debugger, you can use it to
access `/hello`.

```bash
export JWT_AUTH_TOKEN=eyJhbGci...5oHfk2fQ
http --auth-type jwt :8080/hello
```
