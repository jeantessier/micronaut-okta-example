# Micronaut Okta Example

Based on
[this article](https://dzone.com/articles/spring-vs-micronaut-vs-quarkus-which-one-is-the-be)
on integrating Okta with various microservices frameworks, including Micronaut.

To run:

    $ ./gradlew run

You can get an access token with:

    $ curl \
        -X POST \
        http://localhost:8080/login \
        --header 'Content-type: application/json' \
        --data '{"username": "sherlock", "password": "password"}'
    {"accessToken":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzaGVybG9jayIsIm5iZiI6MTUzMTg2NDQ4OSwicm9sZXMiOltdLCJpc3MiOiJjb21wbGV0ZSIsImV4cCI6MTUzMTg2ODA4OSwiaWF0IjoxNTMxODY0NDg5fQ.XOQmDS53CYDlUbr_JvrnsWub8fA6XOO3vKcfczQY6Bw","refreshToken":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzaGVybG9jayIsIm5iZiI6MTUzMTg2NDQ5MCwicm9sZXMiOltdLCJpc3MiOiJjb21wbGV0ZSIsImlhdCI6MTUzMTg2NDQ5MH0.ugo0yTZbG1gGI6xH3DsXuWB3uHWS6yuKzSMbrqIYris","username":"sherlock","expires_in":3600,"token_type":"Bearer"}

Or:

    $ http :8080/login username=sherlock password=password

Once you've extracted the access token from the returned JSON, you can use it to
access `/`.

    $ curl \
        http://localhost:8080/ \
        --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzaGVybG9jayIsIm5iZiI6MTUzMTg2NDk3Niwicm9sZXMiOltdLCJpc3MiOiJjb2IsImV4cCI6MTUzMTg2ODU3NiwiaWF0IjoxNTMxODY0OTc2fQ.3R8D0rrZZn98etinczklBgmYsxKuCyqtCep5oHfk2fQ'
    sherlock

Or:

    $ http \
        --auth-type jwt \
        --auth  eyJhbGci...5oHfk2fQ \
        :8080

Or:

    $ export JWT_AUTH_TOKEN=eyJhbGci...5oHfk2fQ
    $ http --auth-type jwt :8080

The access token is a JWT with a payload similar to:

    {
        "sub": "sherlock",
        "nbf": 1531864511,
        "roles": [],
        "iss": "complete",
        "exp": 1531868111,
        "iat": 1531864511
    }
