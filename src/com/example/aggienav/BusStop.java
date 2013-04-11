package com.example.aggienav;

import com.google.android.maps.GeoPoint;
import java.util.Date;

// Bus Stop is a node in a linked list which represents a Bus route.
public class BusStop {
	private String name;
	//private GeoPoint loc;
	private double lat;
	private double lon;
	private BusStop nextBusStop;
	private int timeToNext; //time to next stop in seconds
	
	public BusStop(){ // Constructor
		name = "";
		//loc = null;
		lon = 0;
		lat = 0;
		nextBusStop = null;
		timeToNext = 0;
	}
	public BusStop(double Lat, double Lon,String Name){ // Constructor
		name = Name;
		//loc = new GeoPoint(Lon, Lat);
		lon = Lon;
		lat = Lat;
		nextBusStop = null;
		timeToNext = 0;
	}
	public BusStop(double Lat, double Lon,String Name, BusStop _nextBusStop){ // Constructor
		name = Name;
		//loc = new GeoPoint(Lon, Lat);
		lon = Lon;
		lat = Lat;
		nextBusStop = _nextBusStop;
		timeToNext = 0;
	}
	public BusStop(double Lat, double Lon,String Name, int _timeToNext){ // Constructor
		name = Name;
		//loc = new GeoPoint(Lon, Lat);
		lon = Lon;
		lat = Lat;
		nextBusStop = null;
		timeToNext = _timeToNext;
	}
	public BusStop(double Lat, double Lon,String Name, BusStop _nextBusStop, int _timeToNext){ // Constructor
		name = Name;
		//loc = new GeoPoint(Lon, Lat);
		lon = Lon;
		lat = Lat;
		nextBusStop = _nextBusStop;
		timeToNext = _timeToNext;
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
	public int getTimeToNext(){
		return timeToNext;
	}
	public void setNext(BusStop _busStop){
		nextBusStop = _busStop;
	}
	
	public void display(){
		System.out.println("Bus Stop name: "+ name +" lat:"+ lat +" lon:"+ lon );
	}
	
	public boolean equals(BusStop _other){
		if((this.lat == _other.getLat())
			&& (this.lon == _other.getLon())
			&& (this.name.equals(_other.getName()))
			&& (this.timeToNext == _other.getTimeToNext()))
		{
			if(this.nextBusStop != null
				&& this.nextBusStop.equals(_other.getNext()))
			{
				return true;
			}
		}
		return false;
	}
	
}
