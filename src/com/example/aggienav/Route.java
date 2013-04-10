package com.example.aggienav;

public class Route {
	private BusStop first; // first Bus Stop in the route
	private BusStop last; // last Bus Stop in the route
	public Route(){
		first = null;
		last = null;
	}
	/*public void addFirst(BusStop _busStop){
		first = _busStop;		
	}*/
	public void add(BusStop _newBusStop){
		if(this.isEmpty()){
			first = _newBusStop;
			last = _newBusStop;
		}else {
			last.setNext(_newBusStop); // old last --> _newBusStop
			last = _newBusStop; // last <-- _newBusStop
		}
		
	}
	public boolean isEmpty(){
		return (first == null);
	}

}
