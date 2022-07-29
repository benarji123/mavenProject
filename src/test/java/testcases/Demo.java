package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Scenario;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;

public class Demo {
@Test
void demo() {
	when()
	  .get("https://reqres.in/api/users?page=2")
	 .then()
	    .statusCode(200)
	    .log().all();
	 
}
@Test
void testSingleContent() {
	when()
	  .get("https://reqres.in/api/users?page=2")
	 .then()
	    .statusCode(200);
	   // .log().all();
	    //.body()
	 
}

	
}
