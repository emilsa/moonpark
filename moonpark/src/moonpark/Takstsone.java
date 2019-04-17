package moonpark;

import java.sql.Date;
import java.time.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.ws.rs.*;


import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

@Path("/")
public class Takstsone {
	
	private static String soneNavn;
	private int timeTakst;
	private boolean helg = false;
	private static String startTid;
	private static String sluttTid;
	private static String startDato;
	private static String sluttDato;
	private Date formatStartDato;
	private Date formatSluttDato;
	private double parkertTid;
	private double betalingSum;
	
	static Scanner userInput = new Scanner(System.in);

	

	
	//Constructor
	public Takstsone(/*String soneNavn, String startTid, String sluttTid,String startDato, String sluttDato*/){
		
		
		
		
		//http://localhost:8080/moonpark/takst?sonenavn=Testsone&starttid=15:25&slutttid=17:28&startdato=16/04&sluttdato=16/05
		/*soneNavn = "Test";
		startTid = "12:22";
		sluttTid = "13:24";
		startDato = "12/12/12";
		sluttDato = "13/12/12";
		timeTakst = 10;*/
		
		
		
		//$ curl -X PUT "http://localhost:8080/restful-java/score?wins=1&losses=2&ties=3"
		
		//PUT(update/changing state) putter/endrer verdier inn, POST(create) kjører en metode.
		
		//To summarize, use @PathParam for retrieval based on id. User @QueryParam for filter or if you have any fixed list of options that user can pass.
		//Path parameters for grouping data, query parameters for filtering.
		
		
		
		
		/*System.out.println("Skriv inn hvilken sone du parkerer i:");
		if(userInput.hasNextLine()){
			this.setSoneNavn(userInput.nextLine());
			//System.out.println(getSoneNavn());
			
		}
			
		System.out.println("Skriv inn tidspunktet du parkerer fra: (dd/MM/yyyy HH:mm)");
		if(userInput.hasNextLine()){
			this.setStartDato(userInput.next());
			this.setStartTid(userInput.next());
			//System.out.println(getStartDato());
			//System.out.println(getStartTid());
			
		}
		
		System.out.println("Skriv inn tidspunktet du parkerer til: (dd/MM/yyyy HH:mm)");
		if(userInput.hasNextLine()){
			this.setSluttDato(userInput.next());
			this.setSluttTid(userInput.next());
			//System.out.println(getSluttDato());
			//System.out.println(getSluttTid());
			
		}*/
		
	}
	
	@GET
	@Path("/takst")
	@Produces("application/json")
	public String visTakst(){
		//String pattern = "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\":\"%s\"}";
		String pattern = "{ \"Sonenavn\":\"%s\", \"Starttid\":\"%s\", \"Slutttid\":\"%s\", \"Startdato\":\"%s\", \"Sluttdato\":\"%s\"}";
		return String.format(pattern, soneNavn, startTid, sluttTid, startDato, sluttDato);
		
	}
	
	//Gjør en get med nødvendige input paramter: http://www.mysite.com/mypage.html?var1=value1&var2=value2&var3=value3

	//http://localhost:8080/moonpark/takst?sonenavn=Testsone&starttid=15:25&slutttid=17:28&startdato=16/04&sluttdato=16/05
	@PUT
	@Path("/takst")
	@Produces("application/json")
	public String updateTakst(@QueryParam("sonenavn") String soneNavn,
			@QueryParam("starttid") String startTid,
			@QueryParam("slutttid") String sluttTid,
			@QueryParam("startdato") String startDato,
			@QueryParam("sluttdato") String sluttDato
			){
		Takstsone.soneNavn = soneNavn;
		Takstsone.startTid = startTid;
		Takstsone.sluttTid = sluttTid;
		Takstsone.startDato = startDato;
		Takstsone.sluttDato = sluttDato;
		//Takstsone.soneNavn= soneNavn;
		//Input parametere: soneNavn, startTid, sluttTid, startDato, sluttDato (alt annet skal regnes ut av metoder og kalles.)
		String pattern = "{ \"Update: Sonenavn\":\"%s\", \"Starttid\":\"%s\", \"Slutttid\":\"%s\", \"Startdato\":\"%s\", \"Sluttdato\":\"%s\"}";
		return String.format(pattern, soneNavn, startTid, sluttTid, startDato, sluttDato);
		
	}
	
	
	@GET @Path("/sonenavn")@Produces("text/plain")
	public String getSoneNavn() {
		return soneNavn;
	}
	
	public void setSoneNavn(String soneNavn) {
		this.soneNavn = soneNavn;
	}

	@GET @Path("/takst/timetakst")@Produces("text/plain")
	public int getTimeTakst() {
		return timeTakst;
	}

	public void setTimeTakst(int timeTakst) {
		this.timeTakst = timeTakst;
	}


	public boolean isHelg() {
		return helg;
	}

	public void setHelg(boolean helg) {
		this.helg = helg;
	}
	
	@GET @Path("/starttid")@Produces("text/plain")
	public String getStartTid() {
		return startTid;
	}

	public void setStartTid(String startTid) {
		this.startTid = startTid;
	}

	@GET @Path("/slutttid")@Produces("text/plain")
	public String getSluttTid() {
		return sluttTid;
	}

	public void setSluttTid(String sluttTid) {
		this.sluttTid = sluttTid;
	}

	@GET @Path("/startdato")@Produces("text/plain")
	public String getStartDato() {
		return startDato;
	}

	public void setStartDato(String startDato) {
		this.startDato = startDato;
	}

	@GET @Path("/sluttdato")@Produces("text/plain")
	public String getSluttDato() {
		return sluttDato;
	}

	public void setSluttDato(String sluttDato) {
		this.sluttDato = sluttDato;
	}

	@GET @Path("/parkerttid")@Produces("text/plain")
	public double getParkertTid() {
		return parkertTid;
	}

	public void setParkertTid(double parkertTid) {
		this.parkertTid = parkertTid;
	}

	@GET @Path("/betalingsum")@Produces("text/plain")
	public double getBetalingSum() {
		return betalingSum;
	}

	public void setBetalingSum(double betalingSum) {
		this.betalingSum = betalingSum;
	}

	
	
	
	public LocalDate startDatoFormat(){
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate startDatoForm = LocalDate.parse(this.startDato, formatter);
		
	    //System.out.println(startDatoF);
	    return startDatoForm;
	}
	
	public LocalDate sluttDatoFormat(){
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate sluttDatoForm = LocalDate.parse(this.sluttDato, formatter);
		
	    //System.out.println(sluttDatoF);
	    return sluttDatoForm;
	}
	
	
	@PUT @Path("/day")@Produces("text/plain")
	public String dayOfDate() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE");

		String formattedDate = formatter.format(this.startDatoFormat());
		//System.out.println(formattedDate);
		
		return formattedDate;
		
	}
	
	//weekend checker
	@PUT @Path("/score/ties")@Produces("text/plain")
	public void dayChecker(){
				
		if(dayOfDate().equals("lørdag") || dayOfDate().equals("søndag")){
			//System.out.println(dayOfDate());
			//System.out.println("helg");
			
		}
	}
	
	
	
	public void timeCalc(){
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		
		LocalDateTime start = LocalDateTime.parse(this.startDato + " " + this.getStartTid(), formatter);
	    LocalDateTime end = LocalDateTime.parse(this.sluttDato + " " + this.getSluttTid(), formatter);
	    
	    Duration duration = Duration.between(start, end);

	    long hours = duration.toHours();
	    long mins = duration.minusHours(hours).toMinutes();
	    
	    long parkerteTimer = duration.toHours();
	    long parkerteMin = duration.minusHours(hours).toMinutes();
	    
	    
	    double temp = this.parkertTid = (double) duration.toMinutes() /60;
	    //System.out.println(temp);
	    setParkertTid(temp);
	    //this.parkertTid = (double) duration.toMinutes() /60;
	    
	    //System.out.println("timer og minutter = " + (this.parkertTid));
	    
	}
	


	@POST @Path("/hours")@Produces("text/plain")
	public void hours(){
		setBetalingSum(Math.ceil(this.getParkertTid())* this.getTimeTakst());
		
		//System.out.println("Timer å betale for " +Math.ceil(this.getParkertTid()));
		
		//System.out.println("Å betale " + getBetalingSum());
		
		
	    System.out.println("Parkering i " + this.getSoneNavn() + " koster: " + getBetalingSum() + "kr");
	    
	}
	
	
	 
	
	public static void main(String[] args) {
		
		Takstsone test = new Takstsone();
		test.setSoneNavn("Test");
		test.setTimeTakst(100);
		test.setStartDato("12/10/1992");
		test.setStartTid("05:01");
		test.setSluttDato("12/10/1992");
		test.setSluttTid("07:03");
		test.timeCalc();
		test.hours();
		test.dayOfDate();
		
		test.dayChecker();
		
		System.out.println("Du parkerer i sone " + test.soneNavn + " fra kl. " + test.startTid + " til kl. " + test.sluttTid + " og må betale " + test.getBetalingSum() +"kr");
		
		
		
	}
}
