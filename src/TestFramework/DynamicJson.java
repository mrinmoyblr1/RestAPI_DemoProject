package TestFramework;
import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import files.ReusableMethods;
import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class DynamicJson {
	
	String id;
	@Test(dataProvider="BooksData")	
	public void addBook(String isbn, String aisle) throws IOException
	{
		//String aisle="BKM7";
		//String isbn="117";
		RestAssured.baseURI="http://216.10.245.166";
		Response resp=given().
		header("Content-Type","application/json").
		body(payLoad.addBook(aisle,isbn)).
		when().
		post("/Library/Addbook.php").
		then().assertThat().statusCode(200).extract().response();		
		JsonPath js=ReusableMethods.rawToJson(resp);
		id=js.get("ID");
		System.out.println(id);
	}
	
	@Test
	public void deleteBook() throws IOException
	{
		String aa=id;
		RestAssured.baseURI="http://216.10.245.166";
	//	System.out.println("The ID is-----  "+id);
		
	//	System.out.println(payLoad.deleteBook(id));
		
		Response res=given().
		header("Content-Type","application/json").
		body(payLoad.deleteBook(aa)).
		//body("{ \r\n\"ID\" : \"BCR3113\" \r\n} \r\n").
		
		
		
		when().
		post("/Library/DeleteBook.php").
		then().assertThat().statusCode(200).extract().response();		
		
		//JsonPath js=ReusableMethods.rawToJson(res);
		//String msg=js.get("msg");
		//System.out.println(msg);
		
		
		
		
	}
	
	
	

	
	
	
	
	@DataProvider(name="BooksData")
	public Object[][] getData()
	{
		return new Object[][] {{"BKM1","Test1"},{"BKM2","Test2"},{"BKM3","Test3"}};
		
	}
	
	
}
