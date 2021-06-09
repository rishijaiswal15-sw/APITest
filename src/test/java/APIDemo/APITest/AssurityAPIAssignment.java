package APIDemo.APITest;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utilities.ReadPayload;
import static io.restassured.RestAssured.*;

public class AssurityAPIAssignment {

	@Test

	public void getAPIProductDetails()

	{

		RestAssured.baseURI = "https://api.tmsandbox.co.nz";

		String response = given().queryParam("catalogue", "false")

				.when().get("/v1/Categories/6327/Details.json")

				.then().log().all().extract().response().asString();

		JsonPath jsonResponse = new JsonPath(response);

		String expectedName = "Carbon credits";

		String expectedCanRelist = "true";

		String expectedDescription = "2x larger image";

		String actualName = jsonResponse.getString("Name");

		String actualCanRelist = jsonResponse.getString("CanRelist");

		String actualDescription = null;

		String jsonKey = "Promotions";

		actualDescription = ReadPayload.getPromotionDescription(jsonResponse, jsonKey);

		Assert.assertEquals(actualName, expectedName);

		Assert.assertEquals(actualCanRelist, expectedCanRelist);

		Assert.assertEquals(actualDescription, expectedDescription);

	}

}
