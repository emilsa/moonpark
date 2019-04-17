package moonpark;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

public class M2 extends Takstsone{
	
	public M2() {
		
		
		
	}
	
	
	public void setTimeTakst(int timeTakst) {
    	super.setTimeTakst(timeTakst);
	}
	
	
	//weekend checker
	@PUT @Path("/score/ties")@Produces("text/plain")
	public void dayChecker(){
				
		if(dayOfDate().equals("lørdag") || dayOfDate().equals("søndag")){
			setTimeTakst(200);
			//System.out.println(dayOfDate());
			//System.out.println("helg");
		}
		else{
			setTimeTakst(100);
			//System.out.println("ikke helg");
			
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		Takstsone test2 = new M2();
		test2.setSoneNavn("M2");
		test2.setStartDato("11/10/1992");
		test2.setStartTid("05:01");
		test2.setSluttDato("12/10/1992");
		test2.setSluttTid("07:03");
		test2.dayChecker();
		//test2.setTimeTakst(1);
		
		System.out.println(test2.getTimeTakst());
		
		test2.timeCalc();
		test2.hours();
		
		
	}
	


}
