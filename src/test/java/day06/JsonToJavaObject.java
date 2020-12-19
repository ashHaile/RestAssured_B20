package day06;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import io.restassured.http.ContentType;
import pojo.Spartan;
import pojo.SpartanRead;
import utility.ConfigurationReader;
import utility.SpartanUtil;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class JsonToJavaObject {
    @BeforeAll
    public static void setUp() {
        //RestAssured.filters().add(new AllureRestAssured() ) ;
        baseURI = ConfigurationReader.getProperty("spartan.base_url");
        basePath = "/api";
    }

    @AfterAll
    public static void tearDown() {
        reset();
    }

    @DisplayName("Get 1 Data with Save Response Json As Java Object")
    @Test
    public void getOneSpartanAndSaveResponseJsonAsMap() {
              Response response =  given()
                                            .auth().basic("admin", "admin")
                                            .log().all()
                                            .pathParam("id", 5).
                                    when()
                                            .get("/spartans/{id}").prettyPeek()
                                     ;
              // get a jsonPath object
        JsonPath jp = response.jsonPath();
        Map<String, Object>  responseMap = jp.getMap("");
        System.out.println("responseMap = " + responseMap);
        
        
        // I need to read it as SpartanRead 
        
        SpartanRead sp = jp.getObject("",SpartanRead.class);
        System.out.println("sp = " + sp);




        /**
         * {
         *     "id": 5,
         *     "name": "Sayeem",
         *     "gender": "Male",
         *     "phone": 1231231230
         * }
         * jsonPath to get whole json object is just empty string
         *
         * assume this is a car object
         * {
         *     "make":"Honda"
         *     "color" : "white"
         *     "engine" : {
         *                   "type" : "v8"
         *                   "horsepower" : 350
         *                }
         * }
         * jsonPath for horse power -->> engine.horsepower
         * jsonPath for engine itself -->> engine
         * jsonPath for entire car JsonObject -->> ""
         *
         *
         */


    }
    @DisplayName("Get All Data and Save Response JsonArray As Java Object")
    @Test
    public void getOneSpartanAndSaveResponseJsonAsJavaObject(){

    }

}
