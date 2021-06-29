package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Get_Or_Read_All_Product {
	@Test
	public void read_All_Products() {
	//https://techfios.com/api-prod/api/product
	//	/read.php
		Response response = 
			given()
				.baseUri("https://techfios.com/api-prod/api/product")
				.header("Content-Type","application/json;charset=UTF-8")
			.when()
				.get("/read.php")
			.then()
				.extract().response();
		    int statusCode = 
		    response.getStatusCode();
		    System.out.println("statusCode"+statusCode);
		    Assert.assertEquals(statusCode,200);
		   // System.out.println("response_body" + response);
		    String responseBody = response.getBody().prettyPrint();
		   System.out.println("response_body" + responseBody);
				
	}
	

}
