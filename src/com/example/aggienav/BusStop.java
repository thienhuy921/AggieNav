package com.example.aggienav;

import com.google.android.maps.GeoPoint;

// Bus Stop is a node in a linked list which represents a Bus route.
public class BusStop {
	private String name;
	//private GeoPoint loc;
	private double lat;
	private double lon;
	private BusStop nextBusStop;
	
	public BusStop(){ // Constructor
		name = "";
		//loc = null;
		lon = 0;
		lat = 0;
		nextBusStop = null;
	}
	public BusStop(double Lat, double Lon,String Name){ // Constructor
		name = Name;
		//loc = new GeoPoint(Lon, Lat);
		lon = Lon;
		lat = Lat;
		nextBusStop = null;		
	}
	public BusStop(double Lat, double Lon,String Name, BusStop _nextBusStop){ // Constructor
		name = Name;
		//loc = new GeoPoint(Lon, Lat);
		lon = Lon;
		lat = Lat;
		nextBusStop = _nextBusStop;		
	}
	public double getLon(){
		return lon;
	}
	public double getLat(){
		return lat;
	}
	public String getName(){
		return name;
	}
	public BusStop getNext(){
		return nextBusStop;
	}
	public void setNext(BusStop _busStop){
		nextBusStop = _busStop;
	}
	
	public void display(){
		System.out.println("Bus Stop name: "+ name +" lat:"+ lat +" lon:"+ lon );
	}
	
}
