package com.example.aggienav;

import android.util.Log;

public class Route { // a Route is a linked list
	private BusStop first; // first Bus Stop in the route
	private BusStop last; // last Bus Stop in the route
	public Route(){
		first = null;
		last = null;
	}
	public void insertFirst(BusStop _newBusStop){
		if(isEmpty()){
			last = _newBusStop;
		}
		_newBusStop.setNext(first);
		first = _newBusStop;
		
	}
	public void insertLast(BusStop _newBusStop){
		if(isEmpty()){
			first = _newBusStop;			
		}else {
			last.setNext(_newBusStop); // old last --> _newBusStop			
		}
		last = _newBusStop; // last <-- _newBusStop
	}
	public BusStop search(String _busStopName){
		
		BusStop currentBStop = first;
		if(!isEmpty()){
			while(currentBStop.getName()!= _busStopName){ // while no match
				if(currentBStop.getNext() == null){ // end of list
					return null;
				}
				else{
					currentBStop = currentBStop.getNext();
				}
			}			
		}else{
			Log.i("Route", " is empty.");
		}
		return currentBStop; // found it
				
		
	}
	public boolean isEmpty(){
		return (first == null);
	}

}
