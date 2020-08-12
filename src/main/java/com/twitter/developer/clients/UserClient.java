package com.twitter.developer.clients;

import com.twitter.developer.util.EnvReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    public Response updateMyStaus(Object status) {
        return given()
                    .baseUri(EnvReader.getBaseUri())
                    .basePath(EnvReader.getBasePath())
                    .auth().oauth(EnvReader.getApiKey(),
                            EnvReader.getApiSecretKey(),
                            EnvReader.getAccessToken(),
                            EnvReader.getAccessSecretToken())
                    .queryParam("status", status )
                    .contentType(ContentType.JSON)
                    .log().all()
                    .post("/statuses/update.json");

    }
}
