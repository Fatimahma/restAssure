package testCases;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Put_Or_Update_A_Product {
	@Test
	public void Create_A_Product() {
	
		String path = "src/main/java/data/updatePayload_1931.json";
		Response response = 
			given()
				.log().all()
				.baseUri("https://techfios.com/api-prod/api/product")
				.header("Content-Type","application/json")
				.body(new File(path))
			.when()
				.put("/update.php")
			.then()
				.log().all()
				.extract().response();
		response.getBody().prettyPrint();
		
		/*
		 * int statusCode = response.getStatusCode(); long rt =
		 * response.getTimeIn(TimeUnit.MILLISECONDS); System.out.println("response time"
		 * + rt); if (rt<=2000) { System.out.println("response time within range");
		 * }else { System.out.println("out of range"); }
		 * System.out.println("statusCode"+statusCode);
		 * Assert.assertEquals(statusCode,201); String responseBody =
		 *response.getBody().prettyPrint(); 
		 *System.out.println("response_body" +
		 * responseBody); JsonPath jp = new JsonPath(responseBody); String
		 * successMessage = jp.getString("message"); System.out.println("message" +
		 * successMessage); Assert.assertEquals(successMessage, "Product was created.");
		 */
	}
	

}
