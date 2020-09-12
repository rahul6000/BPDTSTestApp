import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;


public class GetCallForApp {


    @Test
    public void getUserID() {
        String id = "id"; // defined id as string parameter
        Object obj = 1000; // defined obj as object/value parameter, Object value can be changes to get the result
        String idUrl = "http://bpdts-test-app-v2.herokuapp.com/user/{id}"; //storing request url in string.

        int Scode = given().pathParam(id, obj). // storing Status code in Scode
                when().
                get(idUrl).getStatusCode();
        System.out.println("Status code is " + Scode);

        given().pathParam(id, obj). // sending request
                when().
                get(idUrl).
                then().
                assertThat().statusCode(Scode). // Status Code validation
                log().all(); // Printing body and header in console
        System.out.println("The time taken to fetch the response " + given().pathParam(id, obj).
                when().get(idUrl)
                .timeIn(TimeUnit.MILLISECONDS) + " milliseconds"); // displaying response time.

    }

    @Test
    public void getCity() {
        String city = "city"; // defined city as string parameter
        Object obj = "London"; // defined obj as object/value parameter, Object value can be changes to get the result
        String cityUrl = "http://bpdts-test-app-v2.herokuapp.com/city/{city}/users";

        int Scode = given().pathParam(city, obj).  // storing Status code in Scode
                when().
                get(cityUrl).getStatusCode();
        System.out.println("Status code is " + Scode);

        given().pathParam(city, obj). // sending request
                when().
                get(cityUrl).
                then().
                assertThat().statusCode(Scode).// Status Code validation
                log().all();// Printing body and header in console
        System.out.println("The time taken to fetch the response " + given().pathParam(city, obj).
                when().get(cityUrl)
                .timeIn(TimeUnit.MILLISECONDS) + " milliseconds"); // displaying response time.

    }

    @Test
    public void getInstruction() {

        String instUrl = "http://bpdts-test-app-v2.herokuapp.com/instructions"; //Storing request Url
        int Scode = given().
                when().
                get(instUrl).getStatusCode();// storing Status code in Scode
        System.out.println("Status code is " + Scode);
        given().
                when().
                get(instUrl). // request sent
                then().
                assertThat().statusCode(Scode). //validation
                log().all();// Printing response in console

    }

    @Test
    public void getUsers() {

        String usersUrl = "http://bpdts-test-app-v2.herokuapp.com/users";
        int Scode = given().
                when().
                get(usersUrl).getStatusCode();// storing Status code in Scode

        System.out.println("Status code is " + Scode);
        given().
                when().
                get(usersUrl). // request sent
                then().
                assertThat().statusCode(Scode). //validation
                log().all(); //// Printing response in console

    }
}
