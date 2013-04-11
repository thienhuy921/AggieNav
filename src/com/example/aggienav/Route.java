package com.example.aggienav;

public class Route {
	private BusStop first; // first Bus Stop in the route
	private BusStop last; // last Bus Stop in the route
	private int stopCount;
	public Route(){
		first = null;
		last = null;
		stopCount = 0;
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
		last.setNext(first);
		++stopCount;
		
	}
	public BusStop getFirst(){
		return first;
	}
	public BusStop getLast(){
		return last;
	}
	public boolean isEmpty(){
		return (first == null);
	}
	public int numStops(){
		return stopCount;
	}

}
