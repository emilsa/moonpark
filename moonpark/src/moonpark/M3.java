package moonpark;

public class M3 extends Takstsone{
	
	public M3(){
		
		//Mandag til l�rdag mellom 08:00 og 16:00 er f�rste time gratis, deretter koster det 2 kroner per p�begynte
		//minutt.
		
		//Mandag til l�rdag utenom disse tidspunktene koster det 3 kroner minuttet.
		
		//S�ndager er parkering gratis.
		
		
	}
	
	public static void main(String[] args) {
		
		Takstsone test3 = new M2();
		test3.setSoneNavn("M3");
		test3.setStartDato("12/10/1992");
		test3.setStartTid("05:01");
		test3.setSluttDato("12/10/1992");
		test3.setSluttTid("07:03");
		
		test3.setTimeTakst(500);
		
		System.out.println(test3.getTimeTakst());
		
		test3.timeCalc();
		test3.hours();
		test3.dayChecker();
		
		
		
		
		
		
		
		
	}

}
