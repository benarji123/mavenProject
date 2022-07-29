package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.EncryptedDocumentException;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;
import utils.ExcelUtils;
import utils.UtilsMethods;
public class TC_2_Put {
	  HashMap map=new HashMap();
	@BeforeClass
	void setData() {
		
		  map.put("name","Alekh11");
		  map.put("job", "Qa");
		  
		
	}
	@Test(dataProvider = "datapro")
	void post(String firstname,String lastname) {
		JSONObject j=new JSONObject();
		j.put(lastname, lastname);
	
		System.out.println(j);
		given()
		
		.contentType("application/json")
	
		  .body(j.toJSONString())
		  
		.when()
		  .post("https://reqres.in/api/users")
		.then()
		  .statusCode(201)
		  .body("name", equalTo("Alekh11"))
		  
		  .log().all();
		  
		  
	}
	//@Test
	void  put() {
		JSONObject j=new JSONObject(map);
		
		System.out.println(j);
		given()
		
		.contentType("application/json")
	
		  .body(j.toJSONString())
		  
		.when()
		  .put("https://reqres.in/api/users/2")
		.then()
		  .statusCode(200)
		  .body("name", equalTo("Alekh11"))
		  
		  .log().all();
		  
	}
	@Test
	void delete() {
		given()
		.when()
		  .delete("https://reqres.in/api/users/2")
		.then()
		  .statusCode(204)
		  .log().all();
		
		
	} 
	@DataProvider(name="datapro")
	public Object[][] dataProvider() throws EncryptedDocumentException, IOException {
		String path="C:\\Users\\Dell\\Desktop\\alekh.xlsx";
		ExcelUtils u =new ExcelUtils(path);
		int row=u.getRowCount("Sheet1");
		int cl=u.getColumnCount("Sheet1");
		Object[][]obj=new Object [row][cl]; 
		for(int i=1;i<=row;i++) {
	      for(int j=0;j<cl;j++) {
	    	  obj [i-1][j]=u.getCellData("Sheet1", i, j);
	      }


			
					}
		return obj;
	}

}
