package TestFramework;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class basics4 {
	@Test
	public void postData() throws IOException
	{
		String postData=GenerateStringFromResource("/Users/Mrinmoy/eclipse-workspace/DemoProject/src/postData.xml");
		RestAssured.baseURI="http://216.10.245.166";
		Response res=given().
		queryParam("key","qaclick123").
		body(postData).
		when().
		post("/maps/api/place/add/xml").
		then().assertThat().statusCode(200).and().contentType(ContentType.XML).
		extract().response();
		XmlPath x=ReusableMethods.rawToXML(res);
		System.out.println("The XML contains is: "+x);
		//System.out.println("Response  ="+str1);		
		//XmlPath x=new XmlPath(str1);
		//System.out.println();
		String str44=x.get("response.status");
		String str45=x.get("response.place_id");
				
				
				
		
		System.out.println("THE STATUS IS: "+str44+"   "+"THE PLACE_ID IS:"+str45);
	//	.and().
	//	body("status",equalTo("OK"));
	}
	public static String GenerateStringFromResource(String path) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(path)));
	}
}
