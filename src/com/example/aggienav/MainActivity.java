package com.example.aggienav;

import java.util.LinkedList;
import java.util.Vector;

import com.example.aggienav.R;
import com.example.aggienav.MainActivity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	Button bSubmit;
	String dest1, dest2, dest3, dest4, dest5, dest6;
	String bName1,bName2;

	// Vector<String> dest = new Vector<String>();
	// Vector<EditText> txtBldg;

	EditText txtBldg1, txtBldg2, txtBldg3, txtBldg4, txtBldg5, txtBldg6;

	//EditText testText1;
	
	/***Real Elements*****/
	Vector<Building> bldg = new Vector<Building>(250,100);
	Vector<String> namesEntered = new Vector<String>(6,6);// Vector storing building abbreviations that user has entered
	
	Vector<LinkedList<BusStop>> Routes = new Vector<LinkedList<BusStop>>(8,10);
	
	/*LinkedList<BusStop> Route1 = new LinkedList<BusStop>();
	LinkedList<BusStop> Route2 = new LinkedList<BusStop>();
	LinkedList<BusStop> Route3 = new LinkedList<BusStop>();
	LinkedList<BusStop> Route4 = new LinkedList<BusStop>();
	LinkedList<BusStop> Route5 = new LinkedList<BusStop>();
	LinkedList<BusStop> Route6 = new LinkedList<BusStop>();
	LinkedList<BusStop> Route7 = new LinkedList<BusStop>();
	LinkedList<BusStop> Route8 = new LinkedList<BusStop>();*/
	Route Route1 = new Route();
	Route Route2 = new Route();
	Route Route3 = new Route();
	Route Route4 = new Route();
	Route Route5 = new Route();
	Route Route6 = new Route();
	Route Route7 = new Route();
	Route Route8 = new Route();
	
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

		txtBldg1 = (EditText) findViewById(R.id.boxBldg1);
		txtBldg2 = (EditText) findViewById(R.id.boxBldg2);
		txtBldg3 = (EditText) findViewById(R.id.boxBldg3);
		txtBldg4 = (EditText) findViewById(R.id.boxBldg4);
		txtBldg5 = (EditText) findViewById(R.id.boxBldg5);
		txtBldg6 = (EditText) findViewById(R.id.boxBldg6);
		
		
		
		
		
		
		
		
		/*while(true){
			if(!(txtBldg[i].equal(""))){
				bdEntered.pushback("a");
			}
			break;
		}*/
		
		//Route.add(A); // test
		//Log.i("Route: ", "this is my string");
		
		//Route.add(new BusStop(1000,2000,"Bus Stop B"));
		//mystr = Route.get(1).getName();
		BusStopDatabase BSD= new BusStopDatabase();
		Route tempRoute = new Route();
		
		tempRoute = BSD.collectStops(0);
		Route1 = tempRoute;
		tempRoute = BSD.collectStops(1);
		Route2 = tempRoute;
		tempRoute = BSD.collectStops(2);
		Route3 = tempRoute;
		tempRoute = BSD.collectStops(3);
		Route4 = tempRoute;
		tempRoute = BSD.collectStops(4);
		Route5 = tempRoute;
		tempRoute = BSD.collectStops(5);
		Route6 = tempRoute;
		tempRoute = BSD.collectStops(6);
		Route7 = tempRoute;
		tempRoute = BSD.collectStops(7);
		Route8 = tempRoute;
		
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
				/*
				 * Intent intent = new
				 * Intent(android.content.Intent.ACTION_VIEW,
				 * Uri.parse("http://maps.google.com/maps?" +
				 * "saddr=30.623252,-96.347008&daddr=30.618169,-96.341209"));
				 */

				// get value from EditText View
				/*
				 * dest1 = txtBldg1.getText().toString(); dest2 =
				 * txtBldg2.getText().toString(); dest3 =
				 * txtBldg3.getText().toString(); dest4 =
				 * txtBldg4.getText().toString(); dest5 =
				 * txtBldg5.getText().toString(); dest6 =
				 * txtBldg6.getText().toString();
				 */

				/************
				 * Construct uriString to request direction*********** Does not
				 * work for all Abbrs. eg. BICH
				 *******************/

				

				// while (true) {

				// re-enter bldg names
				
				namesEntered.add(txtBldg1.getText().toString());
				namesEntered.add(txtBldg2.getText().toString());
				namesEntered.add(txtBldg3.getText().toString());
				namesEntered.add(txtBldg4.getText().toString());
				namesEntered.add(txtBldg5.getText().toString());
				namesEntered.add(txtBldg6.getText().toString());
				
				/*bName1 = txtBldg1.getText().toString();
				bName2 = txtBldg2.getText().toString();*/
				
				/**********construst uri string***************/
				
				
				String uri="http://maps.google.com/maps?";
				
				
				for(int i=0; i<=5; i++){
					if(!namesEntered.get(i).equals("")){
						for (int j = 0; j <= bldg.capacity() - 1; j++){
							if (bldg.get(j).getName().equalsIgnoreCase(namesEntered.get(i))){
								if(i==0){
									uri = uri + "saddr=" +  bldg.get(j).getLat() + "," + bldg.get(j).getLon();
									break;
								}
								else if(i==1){
									uri = uri + "&daddr=" +  bldg.get(j).getLat() + "," + bldg.get(j).getLon();
									break;
								}
								else{
									uri = uri + " to: " + bldg.get(j).getLat() + "," + bldg.get(j).getLon();
									break;
								}
							}
						}
					}
					else break;
				}
				
				uri = uri + "&dirflg=w";
				
				/******************between 2 locations**************************/

				/*for (int i = 0; i <= bldg.capacity() - 1; i++) {
					if (dest1 == null || dest2 == null) {
						if (bldg.get(i).getName().equalsIgnoreCase(bName1)) {
							dest1 = bldg.get(i).getLat() + ","
									+ bldg.get(i).getLon();
						}// (bName1 must not != bName2)
						else if (bldg.get(i).getName().equalsIgnoreCase(bName2)) {
							dest2 = bldg.get(i).getLat() + ","
									+ bldg.get(i).getLon();
						}
					} else
						break;
				}*/

				if (!namesEntered.get(0).equals("") && !namesEntered.get(1).equals("")) {
					/**************** get direction form input *******************/
					/*Intent intent = new Intent(
							android.content.Intent.ACTION_VIEW, Uri
									.parse("http://maps.google.com/maps?"
											+ "saddr=" + dest1 + "&daddr="
											+ dest2 + "&dirflg=w"));*/
					
					/*String tempuri = "https://maps.google.com/maps?saddr=Stasney St&daddr=30.607657,-96.344454 to:30.62063,-96.340742 to:30.619046,-96.339186";
					// Stasney -> REC -> Zachry -> HRBB*/ 
					
					Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));

					startActivity(intent);
				} else { // alert(toast a message) & ask user to re enter bldgs
							// name

				}
				/*
				 * if (dest1 != null && dest2 != null) { break; } else {
				 * AlertDialog alert = new
				 * AlertDialog.Builder(MainActivity.this).create();
				 * alert.setTitle("Alert!"); alert.setCancelable(false);
				 * alert.setMessage
				 * ("Building abbr. not found! Please re-enter Building abbr. !"
				 * );
				 * 
				 * alert.setPositiveButton(); alert.setNegativeButton();
				 * //alert.show(); }
				 */

				// }

				// boxBldg1.requestfocus();
				/*
				 * for (int i = 0; i <= bldg.capacity(); i++) { if (dest1 ==
				 * null || dest2 == null) { if
				 * (bldg.get(i).getName().equalsIgnoreCase(bName1)) { dest1 =
				 * bldg.get(i).getLon() + "," + bldg.get(i).getLat(); }//
				 * (bName1 must not != bName2) else if
				 * (bldg.get(i).getName().equalsIgnoreCase(bName2)) { dest2 =
				 * bldg.get(i).getLon() + "," + bldg.get(i).getLat(); } } else
				 * break; }
				 * 
				 * AlertDialog alert = new
				 * AlertDialog.Builder(MainActivity.this).create();
				 * //alert.setTitle("Alert!"); alert.setMessage(
				 * "Building abbr. not found! Please re-enter Building abbr. !"
				 * ); alert.show(); }
				 */
				/*
				 * if (dest1 == null || dest2 == null){ // ask user to re-enter
				 * bldg abbrs call getBldgNames(); getBldgNames(){ clearText
				 * fields wait for user to re-enter BNames and click submit }
				 * 
				 * }
				 */

				/*
				 * if (dest1 == null){ dest1 = bName1 +
				 * ", Texas A%26M University, College Station, Texas 77840"; }
				 * if (dest2 == null){ dest2 = bName2 +
				 * ", Texas A%26M University, College Station, Texas 77840"; }
				 */

				// testText1 = (EditText) findViewById(R.id.TestText1);

				/******** get direction using lon & lat ********/
				/*
				 * Intent intent = new
				 * Intent(android.content.Intent.ACTION_VIEW,
				 * Uri.parse("http://maps.google.com/maps?" + "saddr=" +
				 * bldg.get(0).getLon() +","+bldg.get(0).getLat() + "&daddr=" +
				 * bldg.get(1).getLon() +","+bldg.get(1).getLat() +
				 * "&dirflg=w"));
				 */

				// startActivity(intent);

				/************* get direction with way points ***********/
				/*
				 * String uri = "http://maps.google.com/maps?" + "saddr="+ dest1
				 * +"&daddr="+ dest2 + "%2bto:" + dest3 + "%2bto:" + dest4 +
				 * "%2bto:" + dest5 + "%2bto:" + dest6;
				 */
				
				 /*String uri = "http://maps.google.com/maps?" + "saddr="+ dest1 +"&daddr="+ dest2 + " to:" + dest3 + " to:" + dest4 +
				  " to:" + dest5 + " to:" + dest6;*/
				
				
				 

				/*
				 * String uri =
				 * "https://maps.google.com/maps?saddr=Stasney St&daddr=30.607657,-96.344454 %2b to:30.62063,-96.340742 %2b to:30.619185,-96.342528"
				 * ; Intent intent = new
				 * Intent(android.content.Intent.ACTION_VIEW,Uri.parse(uri));
				 */

				// startActivity(intent);

				// testText1.setText(uri);
			}
		});

	}// end of OnClickListener

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	
}
