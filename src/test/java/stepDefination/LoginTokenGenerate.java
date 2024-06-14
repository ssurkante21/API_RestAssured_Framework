package stepDefination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.ResourcesOfAPI;
import resources.TestBuild;
import resources.Utilities;

public class LoginTokenGenerate extends Utilities {
	public RequestSpecification res;
	ResponseSpecification resspec;
	public Response response;
	public String tokenAccess;
	TestBuild data=new TestBuild();
	@Given("Enter credentials as {string} {string}")
	public void enter_credentials_as(String username, String password) throws Exception {
		res=given().spec(requestSpecificatio())
				  .body(data.LoginCredentials(username, password));
	}

	@When("User calls {string} with post http request")
	public void user_calls_with_http_request(String resource) {
		ResourcesOfAPI apiResource=ResourcesOfAPI.valueOf(resource);	
		 resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();	
		 response = res.when().post(apiResource.getResources());
	}

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(),200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expected) {
		if(key.equalsIgnoreCase("reason"))
		assertEquals(getJsonPath(response,key),expected);
		if(key.equalsIgnoreCase("token")) {
			 tokenAccess=getJsonPath(response,key);
				System.out.println(tokenAccess);	
		}
			System.out.println(tokenAccess);	
			
			
	}
}
