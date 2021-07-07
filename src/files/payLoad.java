package files;
public class payLoad {
	public static String getPostData()
	{
		String b="{\n" + 
				"		    \"location\":{\n" + 
				"		        \"lat\" : -38.383494,\n" + 
				"		        \"lng\" : 33.427362\n" + 
				"		    },\n" + 
				"		    \"accuracy\":50,\n" + 
				"		    \"name\":\"Frontline house\",\n" + 
				"		    \"phone_number\":\"(+91) 983 893 3937\",\n" + 
				"		    \"address\" : \"29, side layout, cohen 09\",\n" + 
				"		    \"types\": [\"shoe park\",\"shop\"],\n" + 
				"		    \"website\" : \"http://google.com\",\n" + 
				"		    \"language\" : \"French-IN\"\n" + 
				"		}";
		return b;
	}
	public static String addBook(String aisle, String isbn)
	{
		String payLoad="{\r\n\"name\":\"Learn Appium Automation with Java\",\r\n\"isbn\":\""+isbn+"\",\r\n\"aisle\":\""+aisle+"\",\r\n\"author\":\"John foe\"\r\n}";
		return payLoad;
	}
	public static String deleteBook(String id1)
	{
		System.out.println("The vales of the id is:"+id1);
		String payLoad1="{\\\"ID\\\" : \\\""+id1+"\\\"} ";
		return payLoad1;
	}
}
