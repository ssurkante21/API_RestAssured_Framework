package resources;

public enum ResourcesOfAPI {
	GenerateToken("/auth"),
	CreateBookingAPI("/booking"),
	updateBookingAPI("/booking/:id");
	 private String resourcs;
	
	 ResourcesOfAPI(String resourcs){
	this.resourcs=resourcs;	
	}

	public String getResources() {
		return resourcs;
	}
}
