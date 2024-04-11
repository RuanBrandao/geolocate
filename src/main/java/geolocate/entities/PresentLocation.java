package geolocate.entities;



public class PresentLocation {

	private String countryName;
	private String cityName;
	private String state;
	private double lat;
	private double longt;
	
	public PresentLocation() {
		
	}
	
	public PresentLocation(String countryName, String cityName, String state, double lat, double longt) {
		super();
		this.countryName = countryName;
		this.cityName = cityName;
		this.state = state;
		this.lat = lat;
		this.longt = longt;
		
	}
	public String getCountryName() {
		return countryName;
	}
	public String getCityName() {
		return cityName;
	}

	public String getState() {
		return state;
	}
	
	public double getLat() {
		return lat;
	}
	
	public double getLong() {
		return longt;
	}
	@Override
	public String toString() {
		return "Location [countryName=" + countryName + ", cityName=" + cityName + ", postal=" + ", state="
				+ state + "]";
	}
	
	
}
