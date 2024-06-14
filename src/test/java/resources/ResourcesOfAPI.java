package resources;

public enum ResourcesOfAPI {
	GenerateToken("/auth");
	 
	 private String resourcs;
	
	 ResourcesOfAPI(String resourcs){
	this.resourcs=resourcs;	
	}

	public String getResources() {
		return resourcs;
	}
}
