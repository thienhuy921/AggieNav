package com.example.aggienav;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import com.example.aggienav.R;
import com.example.aggienav.MainActivity;

import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.location.Criteria;
import android.location.LocationListener;
import android.widget.TextView;


public class MainActivity extends Activity implements LocationListener {
	
	 private TextView latituteField;
	 private TextView longitudeField;
	 private LocationManager locationManager;
	 private String provider;


	Button bSubmit;
	Button bHelp;
	String dest1, dest2, dest3, dest4, dest5, dest6;
	String bName1,bName2;

	
	EditText txtBldg1, txtBldg2, txtBldg3, txtBldg4, txtBldg5, txtBldg6;

	
	Vector<Building> bldg = new Vector<Building>(250,100);
	Vector<String> namesEntered = new Vector<String>(6,6);// Vector storing building abbreviations that user has entered
	
	/*Vector<LinkedList<BusStop>> Routes = new Vector<LinkedList<BusStop>>(8,10);
	
	LinkedList<BusStop> Route1 = new LinkedList<BusStop>();
	LinkedList<BusStop> Route2 = new LinkedList<BusStop>();
	LinkedList<BusStop> Route3 = new LinkedList<BusStop>();
	LinkedList<BusStop> Route4 = new LinkedList<BusStop>();
	LinkedList<BusStop> Route5 = new LinkedList<BusStop>();
	LinkedList<BusStop> Route6 = new LinkedList<BusStop>();
	LinkedList<BusStop> Route7 = new LinkedList<BusStop>();
	LinkedList<BusStop> Route8 = new LinkedList<BusStop>();*/
	
	Route route1 = new Route();
	Route route2 = new Route();
	Route route3 = new Route();
	Route route4 = new Route();
	Route route5 = new Route();
	Route route6 = new Route();
	Route route7 = new Route();
	Route route8 = new Route();
	
	
	
	/*********Search*************/
	
	/*public static boolean SearchBusStopInRoute(LinkedList<BusStop> _route, BusStop _busStop){
		
		BusStop current = _route.getFirst();
		while(current != null){
			if(current.getName()==_busStop.getName()){
				return true;
			}
			current = current.getNext();
		}
		
		return false;
	}*/
		
	/********/
	
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bSubmit = (Button) findViewById(R.id.bSubmit);
		bHelp = (Button) findViewById(R.id.bHelp);

		txtBldg1 = (EditText) findViewById(R.id.boxBldg1);
		txtBldg2 = (EditText) findViewById(R.id.boxBldg2);
		txtBldg3 = (EditText) findViewById(R.id.boxBldg3);
		txtBldg4 = (EditText) findViewById(R.id.boxBldg4);
		txtBldg5 = (EditText) findViewById(R.id.boxBldg5);
		txtBldg6 = (EditText) findViewById(R.id.boxBldg6);
		
		//================GPS user location========================
		latituteField = (TextView) findViewById(R.id.TextView02);
	    longitudeField = (TextView) findViewById(R.id.TextView04);

	    // Get the location manager
	    locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	    // Define the criteria how to select the locatioin provider -> use
	    // default
	    Criteria criteria = new Criteria();
	    provider = locationManager.getBestProvider(criteria, false);
	    final Location location = locationManager.getLastKnownLocation(provider);

	    // Initialize the location fields
	    if (location != null) {
	      System.out.println("Provider " + provider + " has been selected.");
	      onLocationChanged(location);
	      //latituteField.setVisibility(TextView.INVISIBLE);
	      //longitudeField.setVisibility(TextView.INVISIBLE);
	    } else {
	      //latituteField.setText("Location not available");
	      //longitudeField.setText("Location not available");
	    	Toast toast = Toast.makeText(getApplicationContext(), "User Location Not Available!", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
	    }
		
		//==============================================================
		
		
		
		//Route.add(A); // test
		//Log.i("Route: ", "this is my string");
		
		route1.insertLast(new BusStop(30.619085,-96.339333,"Ross_Spence"));
		route1.insertLast(new BusStop(30.617848,-96.341141,"Ross_Ireland"));
		route1.insertLast(new BusStop(30.617816,-96.343317,"Asbury Water Tower"));
		route1.insertLast(new BusStop(30.612183,-96.348499,"Wehner"));
		route1.insertLast(new BusStop(30.609889,-96.346956,"Kleberg"));
		route1.insertLast(new BusStop(30.605657,-96.347432,"Reed Arena"));
		route1.insertLast(new BusStop(30.60691,-96.34721,"Lot 100a/b"));
		route1.insertLast(new BusStop(30.611922,-96.340671,"Kodus"));
		
		route2.insertLast(new BusStop(30.616458,-96.34366,"Fish Pond"));
		route2.insertLast(new BusStop(30.60933,-96.353764,"Rural Public Health"));
		route2.insertLast(new BusStop(30.597889,-96.395351,"Health Science Center"));
		route2.insertLast(new BusStop(30.60933,-96.353764,"Rural Public Health"));
		
		route3.insertLast(new BusStop(30.614138,-96.341707,"MSC"));
		route3.insertLast(new BusStop(30.617661,-96.341203,"Ross_Ireland")); // khac voi Ross_Ireland o Route 1
		route3.insertLast(new BusStop(30.618926,-96.339379,"Ross_Spence"));
		route3.insertLast(new BusStop(30.619798,-96.338065,"Ross_Bizzell"));
		route3.insertLast(new BusStop(30.620932,-96.338062,"Wisenbaker"));
		route3.insertLast(new BusStop(30.611999,30.611999,"Wehner S"));
		
		route4.insertLast(new BusStop(30.616458,-96.34366,"Fish Pond"));
		route4.insertLast(new BusStop(30.617661,-96.341203,"Ross_Ireland"));
		route4.insertLast(new BusStop(30.618926,-96.339379,"Ross_Spence"));
		route4.insertLast(new BusStop(30.619798,-96.338065,"Ross_Bizzell"));
		route4.insertLast(new BusStop(30.62089,-96.33805,"WERC"));
		route4.insertLast(new BusStop(30.62651,-96.34324,"Hensel_Ball"));
		route4.insertLast(new BusStop(30.62892,-96.34186,"Hensel_WX_Row"));
		route4.insertLast(new BusStop(30.62875,-96.33922,"Hensel_Moore"));
		route4.insertLast(new BusStop(30.62743,-96.34068,"Community Center"));
		route4.insertLast(new BusStop(30.62516,-96.34069,"Moore_Office"));
		route4.insertLast(new BusStop(30.62468,-96.3401,"Moore_Haltom"));
		route4.insertLast(new BusStop(30.62414,-96.33946,"Moore_Front"));
		route4.insertLast(new BusStop(30.62093,-96.33854,"WERC"));
		route4.insertLast(new BusStop(30.619085,-96.339333,"Ross_Spence"));
		route4.insertLast(new BusStop(30.617848,-96.341141,"Ross_Ireland"));
		
		/**************/
		if(route4.contains("WERC")){
			Log.i("Found", "WERC");
		}else Log.i("Not Found", "WERC");
		/*************/
		
		
		
		
		/*Route1.add(new BusStop(30.614992,-96.337684,"Commons"));
		Route1.add(new BusStop(30.619085,-96.339333,"Ross_Spence"));
		Route1.add(new BusStop(30.617848,-96.341141,"Ross_Ireland"));
		Route1.add(new BusStop(30.617816,-96.343317,"Asbury Water Tower"));
		Route1.add(new BusStop(30.612183,-96.348499,"Wehner"));
		Route1.add(new BusStop(30.609889,-96.346956,"Kleberg"));
		Route1.add(new BusStop(30.605657,-96.347432,"Reed Arena"));
		Route1.add(new BusStop(30.60691,-96.34721,"Lot 100a/b"));
		Route1.add(new BusStop(30.611922,-96.340671,"Kodus"));
		
		Route2.add(new BusStop(30.616458,-96.34366,"Fish Pond"));
		Route2.add(new BusStop(30.60933,-96.353764,"Rural Public Health"));
		Route2.add(new BusStop(30.597889,-96.395351,"Health Science Center"));
		Route2.add(new BusStop(30.60933,-96.353764,"Rural Public Health"));
		
		Route3.add(new BusStop(30.614138,-96.341707,"MSC"));
		Route3.add(new BusStop(30.617661,-96.341203,"Ross_Ireland")); // khac voi Ross_Ireland o Route 1
		Route3.add(new BusStop(30.618926,-96.339379,"Ross_Spence"));
		Route3.add(new BusStop(30.619798,-96.338065,"Ross_Bizzell"));
		Route3.add(new BusStop(30.620932,-96.338062,"Wisenbaker"));
		Route3.add(new BusStop(30.611999,30.611999,"Wehner S"));*/
		
		/***** Try search operation!********/
		/*BusStop A = new BusStop(30.611999,30.611999,"Wehner S");
		if(Route3.contains(A)){
			Log.i("Found","BusStop A");
		}else Log.i("Not Found","BusStop A");*/
		
		// return Not found because linkedlist.contains us equals() method -> need to overide equals()
		
		/***********************************/
		
		/*BusStop current = Route3.getFirst();
		while(!current.getName().equalsIgnoreCase("MSC")){
			if(current.getNext()==null){
				Log.i("Not Found","BusStop MSC");
			}else{
				current = current.getNext();	
			}				
		}
		Log.i("Found","MSC");*/
		
		/*Iterator<BusStop> current = Route3.iterator();
		while(!((BusStop) current).getName().equalsIgnoreCase("MSC")){
			if(current.next()==null){
				Log.i("Not Found","BusStop MSC");
			}else{
				current = (Iterator<BusStop>) current.next();	
			}				
		}
		Log.i("Found","MSC");*/
		
				
		bldg.add(new Building(30.61348497,-96.34841648,"ONRP"));
		bldg.add(new Building(30.60479491,-96.35791033,"LYNNTECH BLDG"));
		bldg.add(new Building(30.61607031,-96.34069172,"ACAD"));
		bldg.add(new Building(30.6121855,-96.3345019,"ADAM"));
		bldg.add(new Building(30.61411285,-96.34901729,"AEPM"));
		bldg.add(new Building(30.61348497,-96.34841648,"AESH"));
		bldg.add(new Building(30.60545977,-96.35091513,"AGLS"));
		bldg.add(new Building(30.61582583,-96.3534065,"AGRL"));
		bldg.add(new Building(30.61530877,-96.34366472,"CHPL"));
		bldg.add(new Building(30.59747008,-96.35260326,"ALLN"));
		bldg.add(new Building(30.60092702,-96.34203839,"EQNB"));
		bldg.add(new Building(30.61704113,-96.33714916,"ANIN"));
		bldg.add(new Building(30.5970805,-96.35349709,"BPCC"));
		bldg.add(new Building(30.6136189,-96.34856922,"ANTH"));
		bldg.add(new Building(30.61418069,-96.33533861,"APPE"));
		bldg.add(new Building(30.61911049,-96.33821524,"ARCB"));
		bldg.add(new Building(30.61931361,-96.3379953,"ARCC"));
		bldg.add(new Building(30.61466026,-96.33629507,"ASTO"));
		bldg.add(new Building(30.61687236,-96.35420129,"BEAS"));
		bldg.add(new Building(30.61568276,-96.34753268,"BELL"));
		bldg.add(new Building(30.61563878,-96.34269954,"BEUT"));
		bldg.add(new Building(30.61070784,-96.34921719,"BICH"));
		bldg.add(new Building(30.61494712,-96.35039607,"BCC"));
		bldg.add(new Building(30.615798,-96.33929723,"BSBE"));
		bldg.add(new Building(30.61561449,-96.33964323,"BSBW"));
		bldg.add(new Building(30.61400798,-96.34121012,"BIZL"));
		bldg.add(new Building(30.61955676,-96.34211728,"BLOC"));
		bldg.add(new Building(30.61619735,-96.34165416,"BLTN"));
		bldg.add(new Building(30.60808964,-96.34948378,"SCIC"));
		bldg.add(new Building(30.6140063,-96.33657542,"BRIG"));
		bldg.add(new Building(30.61900217,-96.33880562,"HRBB"));
		bldg.add(new Building(30.60890129,-96.33918817,"BFC"));
		bldg.add(new Building(30.5964228,-96.3532157,"BPLM"));
		bldg.add(new Building(30.61791782,-96.32175682,"BMSB"));
		bldg.add(new Building(30.61483482,-96.33893253,"BTLR"));
		bldg.add(new Building(30.61173795,-96.34342733,"CAIN"));
		bldg.add(new Building(30.61613153,-96.35786837,"CPAT"));
		bldg.add(new Building(30.61321599,-96.34816096,"CMAT"));
		bldg.add(new Building(30.62006598,-96.33964374,"CVLB"));
		bldg.add(new Building(30.60241938,-96.35906265,"CEN"));
		bldg.add(new Building(30.6151608,-96.35151492,"CUSE"));
		bldg.add(new Building(30.61648023,-96.33772186,"CCPG"));
		bldg.add(new Building(30.61812394,-96.34224192,"CUP"));
		bldg.add(new Building(30.61849131,-96.33956398,"CHAN"));
		bldg.add(new Building(30.618949,-96.339476,"CHEM"));
		bldg.add(new Building(30.61980521,-96.33893577,"C E"));
		bldg.add(new Building(30.61445843,-96.34548003,"CLEM"));
		bldg.add(new Building(30.60477959,-96.35549129,"CEL"));
		bldg.add(new Building(30.61463059,-96.34170989,"COKE"));
		bldg.add(new Building(30.61529113,-96.33595545,"COMM"));
		bldg.add(new Building(30.61677918,-96.33687129,"CSC"));
		bldg.add(new Building(30.62032906,-96.33901498,"CONC"));
		bldg.add(new Building(30.61494245,-96.35144789,"INSC"));
		bldg.add(new Building(30.61553884,-96.3464429,"DAVI"));
		bldg.add(new Building(30.6192301,-96.34000422,"DRTY"));
		bldg.add(new Building(30.60656425,-96.3576511,"DLH"));
		bldg.add(new Building(30.6169605,-96.33636025,"CSA"));
		bldg.add(new Building(30.61203883,-96.33544293,"DCAN"));
		bldg.add(new Building(30.61508104,-96.33681847,"CUNN"));
		bldg.add(new Building(30.60560768,-96.35634542,"EBRF"));
		bldg.add(new Building(30.62270814,-96.33915587,"ETB"));
		bldg.add(new Building(30.61451962,-96.35099103,"ERLB"));
		bldg.add(new Building(30.61443239,-96.33449838,"EPPR"));
		bldg.add(new Building(30.61409906,-96.37665454,"EQCT"));
		bldg.add(new Building(30.61661708,-96.33909275,"LIBR"));
		bldg.add(new Building(30.61679251,-96.34177496,"FERM"));
		bldg.add(new Building(30.61529672,-96.33780529,"FLGH"));
		bldg.add(new Building(30.61582881,-96.33700795,"FGGH"));
		bldg.add(new Building(30.61598724,-96.35220694,"FSLB"));
		bldg.add(new Building(30.61341694,-96.33737474,"FOUN"));
		bldg.add(new Building(30.61491634,-96.3453538,"FOWL"));
		bldg.add(new Building(30.61729727,-96.33973621,"FRAN"));
		bldg.add(new Building(30.61973137,-96.3540587,"FOOD"));
		bldg.add(new Building(30.61528153,-96.37613302,"FREE"));
		bldg.add(new Building(30.61138123,-96.34017397,"COLS"));
		bldg.add(new Building(30.61379896,-96.33595632,"GAIN"));
		bldg.add(new Building(30.62214729,-96.35742468,"GSC"));
		bldg.add(new Building(30.60146728,-96.35336263,"GGB"));
		bldg.add(new Building(30.61680977,-96.3339805,"GOLF"));
		bldg.add(new Building(30.61859963,-96.34140182,"GRPH"));
		bldg.add(new Building(30.61586352,-96.34458567,"HAAS"));
		bldg.add(new Building(30.60720629,-96.3374295,"HGLR"));
		bldg.add(new Building(30.61890556,-96.34055664,"HALB"));
		bldg.add(new Building(30.61271885,-96.33673569,"HARL"));
		bldg.add(new Building(30.61683596,-96.34041361,"HECC"));
		bldg.add(new Building(30.61652664,-96.34085885,"EDCT"));
		bldg.add(new Building(30.61424569,-96.34059667,"HART"));
		bldg.add(new Building(30.61667559,-96.34222364,"HEAT"));
		bldg.add(new Building(30.61138212,-96.34809207,"HPCT"));
		bldg.add(new Building(30.61622108,-96.3374473,"HLB"));
		bldg.add(new Building(30.61511771,-96.33868648,"HELD"));
		bldg.add(new Building(30.61475333,-96.34444739,"HEND"));
		bldg.add(new Building(30.61771967,-96.34407634,"HOBB"));
		bldg.add(new Building(30.60091173,-96.34287886,"HRCT"));
		bldg.add(new Building(30.6155315,-96.33742527,"HTGH"));
		bldg.add(new Building(30.60924628,-96.3502717,"HFSB"));
		bldg.add(new Building(30.61824748,-96.34449162,"HOTA"));
		bldg.add(new Building(30.61551262,-96.34517099,"HUGH"));
		bldg.add(new Building(30.62083331,-96.33970969,"HYLB"));
		bldg.add(new Building(30.60346676,-96.35447112,"ODP"));
		bldg.add(new Building(30.61430372,-96.34364543,"ILSB"));
		bldg.add(new Building(30.62085257,-96.34179575,"CHEN"));
		bldg.add(new Building(30.61868195,-96.33645013,"ADMN"));
		bldg.add(new Building(30.61974421,-96.34092826,"ENPH"));
		bldg.add(new Building(30.61948799,-96.33935113,"RICH"));
		bldg.add(new Building(30.61181857,-96.33360726,"LIND"));
		bldg.add(new Building(30.61520577,-96.34559129,"KEAT"));
		bldg.add(new Building(30.61389117,-96.33757375,"KIES"));
		bldg.add(new Building(30.59101571,-96.35793263,"KSWT"));
		bldg.add(new Building(30.61061064,-96.34737724,"KLCT"));
		bldg.add(new Building(30.61220687,-96.33926545,"JJKB"));
		bldg.add(new Building(30.61594758,-96.33551623,"KRUE"));
		bldg.add(new Building(30.61010407,-96.34071774,"KYLE"));
		bldg.add(new Building(30.61515782,-96.35300161,"LARR"));
		bldg.add(new Building(30.61292965,-96.3374127,"LACY"));
		bldg.add(new Building(30.61878195,-96.33761497,"ARCA"));
		bldg.add(new Building(30.61619542,-96.34384767,"LECH"));
		bldg.add(new Building(30.61618157,-96.3423054,"LEGE"));
		bldg.add(new Building(30.61330009,-96.33593616,"LEON"));
		bldg.add(new Building(30.61768032,-96.33797095,"LAAH"));
		bldg.add(new Building(30.62032363,-96.34132578,"CYCL"));
		bldg.add(new Building(30.61563961,-96.34427035,"MCFA"));
		bldg.add(new Building(30.62040758,-96.33961483,"MCNW"));
		bldg.add(new Building(30.61963202,-96.3403578,"MEOB"));
		bldg.add(new Building(30.61198931,-96.35161851,"MEDL"));
		bldg.add(new Building(30.6173503,-96.3384787,"GLAS"));
		bldg.add(new Building(30.61230186,-96.34138793,"MSC"));
		bldg.add(new Building(30.61426149,-96.33935913,"MILS"));
		bldg.add(new Building(30.61689779,-96.34289712,"MILN"));
		bldg.add(new Building(30.62006247,-96.34291418,"MIST"));
		bldg.add(new Building(30.62029099,-96.34243407,"MPHY"));
		bldg.add(new Building(30.60853335,-96.33762412,"KAMU"));
		bldg.add(new Building(30.61563768,-96.34575289,"MOSE"));
		bldg.add(new Building(30.61548205,-96.33515849,"MOSH"));
		bldg.add(new Building(30.61892708,-96.34414406,"MASS"));
		bldg.add(new Building(30.61494554,-96.34052838,"NGLE"));
		bldg.add(new Building(30.60789555,-96.36151961,"NCTM"));
		bldg.add(new Building(30.61798217,-96.344398,"NEEL"));
		bldg.add(new Building(30.59043471,-96.35774119,"WIND"));
		bldg.add(new Building(30.61918432,-96.34347852,"NSPG"));
		bldg.add(new Building(30.61014393,-96.34973502,"NMR"));
		bldg.add(new Building(30.63001593,-96.34296727,"NFFL"));
		bldg.add(new Building(30.61771249,-96.33663459,"O&M"));
		bldg.add(new Building(30.60267078,-96.35569667,"OTRC"));
		bldg.add(new Building(30.60534856,-96.3415389,"OLSN"));
		bldg.add(new Building(30.60212266,-96.34953469,"WCTC"));
		bldg.add(new Building(30.61683288,-96.33805519,"PAV"));
		bldg.add(new Building(30.59955445,-96.34357013,"PRPV"));
		bldg.add(new Building(30.60198112,-96.34676553,"PISC"));
		bldg.add(new Building(30.62172596,-96.3584353,"PGBG"));
		bldg.add(new Building(30.61598289,-96.33857213,"PETR"));
		bldg.add(new Building(30.61885563,-96.35474674,"PPGM"));
		bldg.add(new Building(30.62052678,-96.35518125,"PLNT"));
		bldg.add(new Building(30.5727385,-96.36698662,"OBSV"));
		bldg.add(new Building(30.6150742,-96.35810427,"PHRL"));
		bldg.add(new Building(30.58750303,-96.34997676,"POSC"));
		bldg.add(new Building(30.58743376,-96.35047566,"PSNP"));
		bldg.add(new Building(30.58743376,-96.35047566,"FARM"));
		bldg.add(new Building(30.61015397,-96.33687779,"PRES"));
		bldg.add(new Building(30.6134805,-96.34915428,"AERL"));
		bldg.add(new Building(30.61466817,-96.33973136,"PSYC"));
		bldg.add(new Building(30.61718022,-96.35260051,"PRCH"));
		bldg.add(new Building(30.61066606,-96.33964221,"READ"));
		bldg.add(new Building(30.60585403,-96.34620553,"REED"));
		bldg.add(new Building(30.61832126,-96.34093716,"RDMC"));
		bldg.add(new Building(30.60980184,-96.35586762,"REPR"));
		bldg.add(new Building(30.61121617,-96.3519645,"REYN"));
		bldg.add(new Building(30.60983748,-96.34825481,"MSTC"));
		bldg.add(new Building(30.61501444,-96.33415299,"RUDD"));
		bldg.add(new Building(30.61325246,-96.33994256,"RDER"));
		bldg.add(new Building(30.61207728,-96.33748025,"SCCT"));
		bldg.add(new Building(30.61714069,-96.34374514,"SBSA"));
		bldg.add(new Building(30.61715756,-96.34545953,"SCHU"));
		bldg.add(new Building(30.61850558,-96.33834831,"SCTS"));
		bldg.add(new Building(30.60784968,-96.33832266,"OMAR"));
		bldg.add(new Building(30.62270854,-96.35975209,"STL"));
		bldg.add(new Building(30.61368499,-96.33362261,"SSPG"));
		bldg.add(new Building(30.61425208,-96.3370455,"SPEN"));
		bldg.add(new Building(30.61521299,-96.33926759,"STCH"));
		bldg.add(new Building(30.60874516,-96.33993975,"STED"));
		bldg.add(new Building(30.60713382,-96.34281656,"SREC"));
		bldg.add(new Building(30.61053692,-96.3571343,"TAES"));
		bldg.add(new Building(30.61726395,-96.33605868,"TEAG"));
		bldg.add(new Building(30.63371149,-96.47495641,"ELTC"));
		bldg.add(new Building(30.61054153,-96.35718258,"TIGM"));
		bldg.add(new Building(30.55182652,-96.2436137,"AMSB"));
		bldg.add(new Building(30.61410158,-96.3532997,"VMDL"));
		bldg.add(new Building(30.60605748,-96.35007223,"AGCT"));
		bldg.add(new Building(30.61321844,-96.35622446,"VMTF"));
		bldg.add(new Building(30.61722728,-96.34123179,"THOM"));
		bldg.add(new Building(30.6147873,-96.3589435,"TICK"));
		bldg.add(new Building(30.60211597,-96.35378331,"TTIHQ"));
		bldg.add(new Building(30.61917571,-96.35786173,"TURF"));
		bldg.add(new Building(30.61551807,-96.35853112,"VMB3"));
		bldg.add(new Building(30.61474228,-96.35808369,"VMCA"));
		bldg.add(new Building(30.61441954,-96.35240446,"VIV2"));
		bldg.add(new Building(30.61444219,-96.3559862,"VMSB"));
		bldg.add(new Building(30.61409382,-96.33569275,"UNDE"));
		bldg.add(new Building(30.61204859,-96.3387612,"UCPG"));
		bldg.add(new Building(30.61179467,-96.33639549,"USB"));
		bldg.add(new Building(30.61176127,-96.33635529,"UTAY"));
		bldg.add(new Building(30.61578138,-96.35106341,"UBO"));
		bldg.add(new Building(30.61839348,-96.34318933,"UCO"));
		bldg.add(new Building(30.58881287,-96.35342493,"UEOA"));
		bldg.add(new Building(30.61414642,-96.35444385,"FSSB"));
		bldg.add(new Building(30.6136155,-96.3541649,"VAPA"));
		bldg.add(new Building(30.61254441,-96.35483009,"VLAH"));
		bldg.add(new Building(30.61343016,-96.35209555,"VMS"));
		bldg.add(new Building(30.61293155,-96.35251397,"VMA"));
		bldg.add(new Building(30.61108899,-96.35485293,"VRB"));
		bldg.add(new Building(30.61207699,-96.35362985,"VSAH"));
		bldg.add(new Building(30.61291724,-96.35330798,"VTH"));
		bldg.add(new Building(30.61098998,-96.33700325,"PRVP"));
		bldg.add(new Building(30.61425853,-96.35286429,"VIV3"));
		bldg.add(new Building(30.60943492,-96.35659452,"LFB"));
		bldg.add(new Building(30.61689737,-96.34521117,"WALT"));
		bldg.add(new Building(30.56422517,-96.36975117,"WWTP"));
		bldg.add(new Building(30.61063822,-96.35078748,"WCBA"));
		bldg.add(new Building(30.61484439,-96.33487716,"WELL"));
		bldg.add(new Building(30.61152086,-96.3501875,"WECLF"));
		bldg.add(new Building(30.60842753,-96.34435101,"WCG"));
		bldg.add(new Building(30.61242322,-96.336282,"WHIT"));
		bldg.add(new Building(30.61279256,-96.33578848,"WHTE"));
		bldg.add(new Building(30.60848041,-96.33622836,"CLAC"));
		bldg.add(new Building(30.62070637,-96.33893172,"WERC"));
		bldg.add(new Building(30.56496564,-96.36969046,"TPBB"));
		bldg.add(new Building(30.56543678,-96.37132125,"TPDB"));
		bldg.add(new Building(30.5648825,-96.37035565,"TPPP"));
		bldg.add(new Building(30.56564926,-96.37088137,"TPSP"));
		bldg.add(new Building(30.61511696,-96.34227192,"YMCA"));
		bldg.add(new Building(30.62125784,-96.34020041,"ZACH"));
		
		

		bSubmit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
				// Intent MapIntent = new Intent(MainActivity.this,
				// MapActivity.class);
				// startActivity(MapIntent);
										
				
				getBuildingNames(); // get user inputs				
				
								
				/**********construst uri string for multiple locations (waypoints) ***************/
				
				
				//String UserLat = latituteField.toString();
				double UserLat = location.getLatitude();
				
				//String UserLon = longitudeField.toString();
				double UserLon = location.getLongitude();
				
				int nameCount = 0;
				String uri="http://maps.google.com/maps?";
				uri = uri + "saddr=" + UserLat + "," + UserLon;
				
				
				for(int i=0; i<=5; i++){
					if(!namesEntered.get(i).equals("")){ // if there is some text in text box
						boolean notfound = true;
								
						for (int j = 0; j <= bldg.size() - 1; j++){
							if (bldg.get(j).getName().equalsIgnoreCase(namesEntered.get(i))){
								if(i==0){
									uri = uri + "&daddr=" +  bldg.get(j).getLat() + "," + bldg.get(j).getLon();
									notfound = false;
									nameCount++;
									break;
								}
								/*else if(i==1){
									uri = uri + "&daddr=" +  bldg.get(j).getLat() + "," + bldg.get(j).getLon();
									notfound = false;
									nameCount++;
									break;
								}*/
								else{
									uri = uri + " to: " + bldg.get(j).getLat() + "," + bldg.get(j).getLon();
									notfound = false;
									nameCount++;
									break;
								}
							}							
						}// end of j for loop
						if(notfound){
						//ask user to re-enter names
						Toast toast = Toast.makeText(getApplicationContext(), "Can not find building \""+ namesEntered.get(i) + "\"!", Toast.LENGTH_LONG);
						toast.setGravity(Gravity.CENTER, 0, 0);
						toast.show();
						
						namesEntered.clear();
						nameCount = 0;
						
						if(i==0){
							txtBldg1.requestFocus();														
						}else if(i==1){
							txtBldg2.requestFocus();							
						}else if(i==2){
							txtBldg3.requestFocus();							
						}else if(i==3){
							txtBldg4.requestFocus();							
						}else if(i==4){
							txtBldg5.requestFocus();							
						}else if(i==5){
							txtBldg6.requestFocus();							
						}
						
						
						
						/*******make the app to focus on name that was not found instead of clearing all inputs********/
						break;
						}
					}// end of i for loop
					//else break;
				}
				
				uri = uri + "&dirflg=w";
				
				/*************************************************************************/
				
				/**************** request direction  *******************/
				
				
				
				if (nameCount>0) {					
					launchMap(uri);						
				} 
				
				/******************************************************/

				/****test with user current location***/
				
				/*String uri1="http://maps.google.com/maps?";
								
				LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
				
				Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);  

				if(location == null){
				    Log.i("error:","No Location");
				}
				else{
					uri1 = uri1+"saddr="+location.getLatitude()+","+location.getLongitude()+ "&daddr="+ "texas a&m university college station" + "&dirflg=w";
					
				}
								
				
				Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri1));

				startActivity(intent);*/
				/*******/

			}

			private void launchMap(String uri) { // request direction
				// TODO Auto-generated method stub
				Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));

				startActivity(intent);

			}

			
		}); // end of SetOnClickListener
		
		bHelp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://aggiemap.tamu.edu/?view=directory"));
				
				startActivity(intent);
				
			}
		});

	}// end of onCreate
	
		

	private void getBuildingNames() {
		// TODO Auto-generated method stub
		
		namesEntered.clear();// clear old inputs
		
		namesEntered.add(txtBldg1.getText().toString());
		namesEntered.add(txtBldg2.getText().toString());
		namesEntered.add(txtBldg3.getText().toString());
		namesEntered.add(txtBldg4.getText().toString());
		namesEntered.add(txtBldg5.getText().toString());
		namesEntered.add(txtBldg6.getText().toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	//==================GPS user location
	/* Request updates at startup */
	  @Override
	  protected void onResume() {
	    super.onResume();
	    locationManager.requestLocationUpdates(provider, 400, 1, this);
	  }

	  /* Remove the locationlistener updates when Activity is paused */
	  @Override
	  protected void onPause() {
	    super.onPause();
	    locationManager.removeUpdates(this);
	  }

	  @Override
	  public void onLocationChanged(Location location) {
	    double lat = (double) (location.getLatitude());
	    double lng = (double) (location.getLongitude());
	    latituteField.setText(String.valueOf(lat));
	    longitudeField.setText(String.valueOf(lng));
	  }

	  @Override
	  public void onStatusChanged(String provider, int status, Bundle extras) {
	    // TODO Auto-generated method stub

	  }

	  @Override
	  public void onProviderEnabled(String provider) {
	    Toast.makeText(this, "Enabled new provider " + provider,
	        Toast.LENGTH_SHORT).show();

	  }

	  @Override
	  public void onProviderDisabled(String provider) {
	    Toast.makeText(this, "Disabled provider " + provider,
	        Toast.LENGTH_SHORT).show();
	  }

	//=====================================
	
}
