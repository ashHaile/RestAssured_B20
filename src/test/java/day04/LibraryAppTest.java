package day04;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class LibraryAppTest {
    private static String myToken;

    @BeforeAll
    public static void setUp(){
        baseURI = "http://library1.cybertekschool.com";
        basePath = "/rest/v1" ;
        // myToken = SomeUtility.getToken()
    }

    @AfterAll
    public static void tearDown(){
        reset();
    }

    @DisplayName("Testing POST /login Endpoint")
    @Test
    public void testLogin(){
        /*
        Librarian1  email	librarian69@library
        Librarian1  password		KNPXrm3S
         */
         myToken =
                given()
                        .log().all()
                        .contentType( ContentType.URLENC  )
                        .formParam("email", "librarian69@library")
                        .formParam("password","KNPXrm3S").
                when()
                        .post("/login").
                then()
                        .log().all()
                        .assertThat()
                        .statusCode( is(200))
                        .contentType(ContentType.JSON)
                        .body("token", is( not( emptyString() ) )  )
                        .extract()
                        .jsonPath()
                        .getString("token")
                ;
        System.out.println("myToken = \n" + myToken);
        // How to extract some data out of response object
        // after doing validation in then section
        // without breaking the chain -->> use extract() method that return
    }
    @DisplayName("Testing POST /login Endpoint")
    @Test
    public void testzDashboard_stats(){
        given()
                .header("x-library-token","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjp7ImlkIjoiMjA5MCIsImZ1bGxfbmFtZSI6IlRlc3QgTGlicmFyaWFuIDY5IiwiZW1haWwiOiJsaWJyYXJpYW42OUBsaWJyYXJ5IiwidXNlcl9ncm91cF9pZCI6IjIifSwiaWF0IjoxNjA3ODA5MzQ5LCJleHAiOjE2MTA0MDEzNDl9.iNrBSPUqIMFFGWcgVsOY0bzRin9BcmA7c8tVeddxiSI").
        when()
                .get("/dashboard_stats").
        then()
                .log().all()
                .assertThat()
                .statusCode(is(200))
                .contentType("application/json; charset=utf-8");
        System.out.println("myToken = \n" + myToken);



    }
    // create a utility class LibraryUtility
    // create a static method



}