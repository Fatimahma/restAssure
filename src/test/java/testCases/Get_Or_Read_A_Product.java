package testCases;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_Or_Read_A_Product {
	@Test
	public void read_All_Products() {
	//https://techfios.com/api-prod/api/product/read_one.php?id=65
	//	/read.php
		Response response = 
			given()
				.baseUri("https://techfios.com/api-prod/api/product")
				.header("Content-Type","application/json;charset=UTF-8")
				.queryParam("id","67")
			.when()
				.get("/read_one.php")
			.then()
				.extract().response();
		    int statusCode = 
		    response.getStatusCode();
		    long rt = response.getTimeIn(TimeUnit.MILLISECONDS);
		    System.out.println("response time" + rt);
		    if (rt<=2000) {
		    	System.out.println("response time within range");
		    }else {
		    	System.out.println("out of range");
		    }
		    System.out.println("statusCode"+statusCode);
		    Assert.assertEquals(statusCode,200);
		    String responseBody = response.getBody().prettyPrint();
		   System.out.println("response_body" + responseBody);
		   JsonPath jp = new JsonPath(responseBody);
		   String productName = jp.getString("name");
		   System.out.println("product name" + productName);
		   Assert.assertEquals(productName, "CellPhone");
		   
	}
	

}
