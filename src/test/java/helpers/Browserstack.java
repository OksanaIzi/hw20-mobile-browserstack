package helpers;

import java.net.MalformedURLException;
import java.net.URL;

import static config.Project.browserStackConfig;
import static io.restassured.RestAssured.given;


public class Browserstack {


    public static URL getBrowserstackUrl() {
        try {
            return new URL(String.format(browserStackConfig.url(),
                    browserStackConfig.getBaseUser(), browserStackConfig.getBasePassword()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic("oksanaizibekova_ytcmHa", "r1z1qmnRRxysJUSSMUxk")
                .when()
                .get(browserStackConfig.sessionsUrl() + sessionId +".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response()
                .path("automation_session.video_url");
    }
}