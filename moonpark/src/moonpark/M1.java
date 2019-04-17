package moonpark;

import java.sql.Time;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


public class M1 extends Takstsone{
	
	private int timeTakst;


	public M1() {

		
		
	}
	
/*	public void setTimeTakst(String soneNavn){
		setTimeTakst(100);
		
		
	}*/
	
    @Override
	public void setTimeTakst(int timeTakst) {
    	super.setTimeTakst(60);
	}

	
	
	public static void main(String[] args) {
		
		Takstsone test1 = new M1();
		test1.setSoneNavn("M1");
		test1.setStartDato("10/10/1992");
		test1.setStartTid("05:01");
		test1.setSluttDato("12/10/1992");
		test1.setSluttTid("07:03");
		
		test1.setTimeTakst(1);
		System.out.println(test1.getTimeTakst());
		test1.timeCalc();
		test1.hours();
		
		test1.dayOfDate();
		test1.dayChecker();
		

	}
	
	
	
}
