package pojo;

public class CreateRecord {
private String firstname;
private String lastname;
private int totalprice;
private boolean depositpaid;
private String additionalneeds;
private BookingDates BookingDates;
public BookingDates getBookingDates() {
	return BookingDates;
}
public void setBookingDates(BookingDates bookingDates) {
	BookingDates = bookingDates;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public int getTotalprice() {
	return totalprice;
}
public void setTotalprice(int totalprice) {
	this.totalprice = totalprice;
}
public boolean isDepositpaid() {
	return depositpaid;
}
public void setDepositpaid(boolean depositpaid) {
	this.depositpaid = depositpaid;
}
public String getAdditionalneeds() {
	return additionalneeds;
}
public void setAdditionalneeds(String additionalneeds) {
	this.additionalneeds = additionalneeds;
}


}
