package resources;

import pojo.LoginCreds;

public class TestBuild {
	
	public LoginCreds LoginCredentials(String username,String Password) {
		
		LoginCreds login=new LoginCreds();
		login.setUsername(username);
		login.setPassword(Password);
		return login;
	}

}
