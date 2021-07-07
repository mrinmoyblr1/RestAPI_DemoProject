package TestFramework;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import files.payLoad;
import files.resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class basics3 {
	Properties prop=new Properties();
	@BeforeTest
	public void getData() throws IOException
	{
		FileInputStream fis=new FileInputStream("/Users/Mrinmoy/eclipse-workspace/DemoProject/src/files/env.properties");
		prop.load(fis);
	}
	@Test
	public void AddandDelete()
	{
		//Task 1: Grab the response
		RestAssured.baseURI=prop.getProperty("HOST");
		Response res=given().
		body(payLoad.getPostData()).
		when().
		post(resources.placePostData()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status",equalTo("OK")).
		extract().response();
		// Task 2: Grab the place_ID from the response
		String responseString=res.asString();
		System.out.println(responseString);
		JsonPath js=new JsonPath(responseString);
		String placeID=js.get("place_id");
		System.out.println("Place ID is : "+placeID);
		//Place the place ID in the Delete Request
		String b2="{     \"place_id\":\""+placeID+"\"   }";		
		given().
		queryParam("key",prop.getProperty("KEY")).
		body(b2).
		when().
		post("/maps/api/place/delete/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status",equalTo("OK"));
	}
}
