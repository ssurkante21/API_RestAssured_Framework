package stepDefination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.*;
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
import resources.TextContextSetup;
import resources.Utilities;

public class bookinglist extends Utilities {
	public RequestSpecification res;
	ResponseSpecification resspec;
	public String tokenAccess;
	TestBuild data=new TestBuild();
	TextContextSetup tcs;
	public bookinglist(TextContextSetup tcs) {
		this.tcs=tcs;
	}
	
	@Given("^Booking {string} Payload (.+) (.+) (.+) (.+) (.+) (.+) (.+)$")
	public void create_booking_api_payload(String resource,String firstname, String lastname, Integer price, Boolean depositpaid, String checkin, String checkout, String additionalneeds) throws Exception {
		
		if(resource.equalsIgnoreCase("CreateBookingAPI")) {
		res=given().spec(requestSpecificatio()).header("Authorization",tcs.tokenAccess).body(data.Bookingdata(firstname,  lastname,  price,  depositpaid,  checkin,  checkout,  additionalneeds));
		}
		if(resource.equalsIgnoreCase("updateBookingAPI")) {
			res=given().spec(requestSpecificatio()).header("Authorization",tcs.tokenAccess).pathParam("id", tcs.bookingid).body(data.Bookingdata(firstname,  lastname,  price,  depositpaid,  checkin,  checkout,  additionalneeds));

		}
		
	}

	@When("User calls {string} with http request as {string} method")
	public void user_calls_with_http_request_as_method(String resource, String apimethod) {
		ResourcesOfAPI apiResource=ResourcesOfAPI.valueOf(resource);	
		if(apimethod.equalsIgnoreCase("POST")) {
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();	
		 tcs.bookingresponse = res.when().post(apiResource.getResources());
		}
		if(apimethod.equalsIgnoreCase("PUT")) {
			resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();	
			 tcs.bookingresponse = res.when().put(apiResource.getResources());
			
		}
		
	}

	@Then("^Verify if data created is same as posted (.+) (.+) (.+) (.+) (.+) (.+) (.+)$")
	public void verify_if_data_created_is_same_as_posted(String firstname, String lastname, Integer totalprice, Boolean depositpaid, String checkin, String checkout, String additionalneeds) throws Exception {
		/*tcs.bookingresponse.then().assertThat().body("bookingdates.checkin", equalTo(checkin),
		"bookingdates.checkout", equalTo(checkout),
		"firstname", equalTo(firstname),
		"lastname", equalTo(lastname),
		"additionalneeds", equalTo(additionalneeds),
		"totalprice", equalTo(totalprice),
		"depositpaid", equalTo(depositpaid)			
				);
		
		
		
		*/
		assertEquals(getJsonPath(tcs.bookingresponse,"booking.firstname"),firstname);
	    assertEquals(getJsonPath(tcs.bookingresponse,"booking.lastname"),lastname);
	    assertEquals(getJsonPath(tcs.bookingresponse,"booking.totalprice"),Integer.toString(totalprice));
	    assertEquals(getJsonPath(tcs.bookingresponse,"booking.depositpaid"),String. valueOf(depositpaid));
	    assertEquals(getJsonPath(tcs.bookingresponse,"booking.bookingdates.checkin"),checkin);
	    assertEquals(getJsonPath(tcs.bookingresponse,"booking.bookingdates.checkout"),checkout);
	    assertEquals(getJsonPath(tcs.bookingresponse,"booking.additionalneeds"),additionalneeds);
	    
	}

	@Then("Capture bookingid created")
	public void capture_bookingid_created() throws Exception {
		 tcs.bookingid=getJsonPath(tcs.bookingresponse,"bookingid");
		 System.out.println(tcs.bookingid);
		
	}


	
	
}
