
public class Flight {


	//ATTRIBUTES
	private Airport AirportA;
	private Airport AirportB;
	private int duration;
	private String airline;

	
	//METHODS
	
	//Constructors
	public Flight(Airport start, Airport end, int duration, String airline) {
		this.AirportA = start;
		this.AirportB = end;
		this.duration = duration;
		this.airline = airline;
	}
	
	
	public String toString()
	{
		return ("Flight operated by " + airline + ", duration " + duration + " minutes");
	}
	
	
	//Getters
	public Airport getAirportA() {
		return AirportA;
	}


	public Airport getAirportB() {
		return AirportB;
	}

	
	public int getDuration() {
		return duration;
	}

	
	public String getAirline() {
		return airline;
	}
	
}
