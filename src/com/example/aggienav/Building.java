package com.example.aggienav;

//import com.google.android.maps.GeoPoint;

public class Building {
	public String abbr; // building abbr
	public String name;
	//private GeoPoint loc;	
	private double lat;
	private double lon;	
	private BusStop nearestBusStop; // nearest bus stop
	public Building(){ // Constructor
		abbr ="";
		//loc = null;
		lon = 0;
		lat = 0;
		nearestBusStop = null;
	}
	
	public Building(double Lat, double Lon, String Abbr){ // Constructor
		abbr = Abbr;
		//loc = new GeoPoint(Lon, Lat);
		lon = Lon;
		lat = Lat;
		nearestBusStop = null;
	}
	
	public Building(double Lat, double Lon, String Abbr, BusStop BusStop){ // Constructor
		abbr = Abbr;
		//loc = new GeoPoint(Lon, Lat);
		lon = Lon;
		lat = Lat;
		nearestBusStop = BusStop;
	}
	
	public double getLon(){
		return lon;
	}
	
	public double getLat(){
		return lat;
	}
	
	public String getName(){
		return abbr;	
	}
}
