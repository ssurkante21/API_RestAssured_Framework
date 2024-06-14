package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utilities {
	public static RequestSpecification req;
	public  RequestSpecification requestSpecificatio() throws Exception {
		
		  if(req==null) {
		PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
		   req =new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log)) //to logging we need to create fileoutput stram and after adding query parameter we can add to log file
				   .setContentType(ContentType.JSON).build();
		   return req;
	}
		  return req;
	}
	private String getGlobalValue(String key) throws Exception {
		Properties prop =new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Reddy\\eclipse-workspace\\RestfulBroker\\src\\test\\java\\resources\\Global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	public String getJsonPath(Response response,String key) {
		String resp=response.asString();
		JsonPath js=new JsonPath(resp);
		return js.get(key).toString();
		
		
	}
}
