package resources;

import pojo.BookingDates;
import pojo.CreateRecord;
import pojo.LoginCreds;

public class TestBuild {
	
	public LoginCreds LoginCredentials(String username,String Password) {
		
		LoginCreds login=new LoginCreds();
		login.setUsername(username);
		login.setPassword(Password);
		return login;
	}
	
	public CreateRecord Bookingdata(String firstname, String lastname, Integer price, Boolean depositpaid, String checkin, String checkout, String additionalneeds) {
		CreateRecord createRecord=new CreateRecord();
		createRecord.setFirstname(firstname);
		createRecord.setLastname(lastname);
		createRecord.setTotalprice(price);
		createRecord.setDepositpaid(depositpaid);
		createRecord.setAdditionalneeds(additionalneeds);
		BookingDates book=new BookingDates();
		book.setCheckin(checkin);
		book.setCheckout(checkout);
		createRecord.setBookingdates(book);
		return createRecord;
	}

}
