package stepDefination;

import io.cucumber.java.Before;
import resources.TextContextSetup;

public class Hooks {
	
	TextContextSetup tcs;
	public Hooks(TextContextSetup tcs) {
		this.tcs=tcs;
	}
	
	@Before
	public void beforScenario() throws Exception {
		
		LoginTokenGenerate steps= new LoginTokenGenerate(tcs);
		if(tcs.tokenAccess==null) {
		steps.enter_credentials_as("admin", "password123");
		steps.user_calls_with_http_request("GenerateToken");
		steps.in_response_body_is("token", "");
		}
	}

}
