package geolocate;

import geolocate.config.HostConfiguration;
import geolocate.entities.PresentLocation;

public class Main {

	public static void main(String[] args) {
	
		
	PresentLocation pl = HostConfiguration.getLocation();
	System.out.println("País: " + pl.getCountryName());
	System.out.println("Cidade: " + pl.getCityName());
	System.out.println("Estado: " + pl.getState());
	System.out.println("Lat: " + pl.getLat());
	System.out.println("Long: " + pl.getLong());
		
	}


}
