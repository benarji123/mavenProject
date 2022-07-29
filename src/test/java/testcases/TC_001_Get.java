package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;


import static org.hamcrest.Matchers.*;public class TC_001_Get {
@Test
void test_001() {
//	Response response =get("https://reqres.in/api/users/2");
//	System.out.println(response.getBody());
//	System.out.println(response.getStatusCode());
//	System.out.println(response.getContentType());
//	System.out.println(response.getTime());
//	Assert.assertEquals("application/json; charset=utf-8", response.getContentType());
    given()
    .when()
       .get("https://reqres.in/api/users/2")
     .then()
        .statusCode(200)
      //  .statusLine(DEFAULT_BODY_ROOT_PATH)
        .body("data.id", equalTo(2))
       .header("Content-Type","application/json; charset=utf-8")
        .log().all();
	
}
}
