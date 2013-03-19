package com.example.aggienav;

import com.google.android.maps.GeoPoint;

// Bus Stop is a node in a linked list which represents a Bus route.
public class BusStop {
	private String name;
	//private GeoPoint loc;
	private double lat;
	private double lon;
	private BusStop nextStop;
	
	public BusStop(){ // Constructor
		name = "";
		//loc = null;
		lon = 0;
		lat = 0;
		nextStop = null;
	}
	public BusStop(double Lat, double Lon,String Name){
		name = Name;
		//loc = new GeoPoint(Lon, Lat);
		lon = Lon;
		lat = Lat;
		nextStop = null;		
	}
	public BusStop(double Lat, double Lon,String Name, BusStop NextStop){
		name = Name;
		//loc = new GeoPoint(Lon, Lat);
		lon = Lon;
		lat = Lat;
		nextStop = NextStop;		
	}
}
