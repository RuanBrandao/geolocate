package geolocate.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;


import geolocate.entities.PresentLocation;



public class HostConfiguration {
	//Esta classe é responsável por recuperar a localização geográfica do dispositivo que executa a aplicação.
	
	
	
	//utiliza o banco de dados geolite2 para buscar a localização com o endereço ip fornecido
	public static PresentLocation getLocation() {
		
		
		try {
			 String path = "src/main/resources/GeoLite2-City.mmdb";

	            File database = new File(path);
			
			
	
			InetAddress addr = InetAddress.getByName(getIPAddress()); //converte o endereço IP string em um 
																	  //InetAddress que é a representação de um endereço IP
			
			DatabaseReader dbReader = new DatabaseReader.Builder(database).build();//instancia de DatabaseReader para trabalhar com o database
			
			CityResponse response = dbReader.city(addr);//Buscamos com base no endereço ip a localização
			 	String countryName = response.getCountry().getName();//Nome do país
			    String cityName = response.getCity().getName();//nome da cidade
			    String state = response.getLeastSpecificSubdivision().getName();//nome do estado
			    Double lat = response.getLocation().getLatitude();
			    Double longt = response.getLocation().getLongitude();
			    PresentLocation location = new PresentLocation(countryName, cityName, state, lat, longt);// instancia de um PresentLocation que representa a localização
			    return location;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (GeoIp2Exception e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	//esse metodo retorna o ip atraves de uma conexão confiável com a Internet, nesse caso checkip.amazonaws.com
	private static String getIPAddress() throws Exception {
		URL whatismyip = new URL("https://checkip.amazonaws.com");
		
		BufferedReader in = null;//Leitor de fluxo de dados com buffer
		try {
			in = new BufferedReader(new InputStreamReader(
					whatismyip.openStream()));//openStream retorna o conteudo da url informada, e a primeira linha é 
												//referente ao ip externo da maquina
			String ip = in.readLine();
			return ip;
		} finally {
			if (in != null) {
				try {
					in.close();
				}catch(IOException ioe) {
					ioe.printStackTrace();
				}
				
			}
		}
	}
	
	
}
	            
