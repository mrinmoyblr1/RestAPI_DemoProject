package TestFramework;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import files.ReusableMethods;
public class basics5 {
	@Test
public void getPlaceAPI()
{
		// TODO Auto-generated method stub
		//BaseURL or Host
		RestAssured.baseURI="https://maps.googleapis.com";
		Response res=given().
		       param("location","-33.8670522,151.1957362").
		       param("radius","500").
		       param("key","AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMfss5Y").
		       when().
		       get("/maps/api/place/nearbysearch/json").
		       then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		       body("results[0].name",equalTo("Sydney")).and().
		       body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).
		       and().header("Server","scaffolding on HTTPServer2").
		       extract().response();
		JsonPath x=ReusableMethods.rawToJson(res);
		int count=x.get("results.size()");
		System.out.println(count);
	
		for(int i=0;i<count;i++)
		{
			String ee=x.get("results["+i+"].name");
			System.out.println(ee);
		}
		
		
		
		
		       /*header("dfd","fsdfds").
		       cookie("dsfs","csder").
		       body()*/
		//Status code of the response
		//Content type 
		//Body
		//Header responses
}
}
