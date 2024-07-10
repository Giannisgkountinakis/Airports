import java.util.ArrayList;

public class Airport {

	//ATTRIBUTES
	private String name;
	private String codeName;
	private String town;
	private String country;
	
	private ArrayList<Flight> flights = new ArrayList<>();
	
	private ArrayList<String> airline = new ArrayList<>();
	
	
	
	
	//METHODS
	
	//Constructor
	public Airport(String airportName, String codeName, String town, String country) {
		this.name = airportName;
		this.codeName = codeName;
		this.town = town;
		this.country = country;
	}
	

	
	 public boolean isDirectlyConnectedTo(Airport anAirport) 
	 {
		 for (Flight f: CentralRegistry.getFlights())
		 {
			 if (f.getAirportA() == anAirport && f.getAirportB() == this )
			 {
				 return true;
			 }
			 else if (f.getAirportA() == this && f.getAirportB() == anAirport)
			 {
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 
	
	 public boolean isInDirectlyConnectedTo(Airport anAirport)
	 {
		 for (Flight f: CentralRegistry.getFlights())
		 {
			 if (f.getAirportA() != anAirport && f.getAirportB() == this)
			 {
				 for (Flight fl: CentralRegistry.getFlights())
				 {
					 if ((fl.getAirportA() == anAirport && fl.getAirportB() == f.getAirportA()) || (fl.getAirportB() == anAirport && fl.getAirportA() == f.getAirportA()) )
					 {
						 return true;
					 }
				 }
			 }
			 else if (f.getAirportB() != anAirport && f.getAirportA() == this)
			 {
				 for (Flight fl: CentralRegistry.getFlights())
				 {
					 if ((fl.getAirportB() == anAirport && fl.getAirportA() == f.getAirportB()) || (fl.getAirportA() == anAirport && fl.getAirportB() == f.getAirportB()))
					 {
						 return true;
					 }
				 }
			 }
		 }
		 return false;
	 }
	 
	 
	 
	  public ArrayList<Airport> getCommonConnections(Airport anAirport)
	  {
		  ArrayList<Airport> ap = new ArrayList<>();
		  
		  
		  //Epanalamvanetai o kwdikas ths methodou isIndirectlyConnected kai
		  //apla stin thesi tou return anti gia mia boolean metavliti prostithetai
		  //ston pinaka h endiamesi ptisi.
		  
		  
			 for (Flight f: CentralRegistry.getFlights())
			 {
				 if (f.getAirportA() != anAirport && f.getAirportB() == this)
				 {
					 for (Flight fl: CentralRegistry.getFlights())
					 {
						 if (fl.getAirportA() == anAirport && fl.getAirportB() == f.getAirportA())
						 {
							 ap.add(fl.getAirportB());
						 }
						 else if (fl.getAirportB() == anAirport && fl.getAirportA() == f.getAirportA())
						 {
							 ap.add(fl.getAirportA());
						 }
					 }
				 }
				 else if (f.getAirportB() != anAirport && f.getAirportA() == this)
				 {
					 for (Flight fl: CentralRegistry.getFlights())
					 {
						 if (fl.getAirportB() == anAirport && fl.getAirportA() == f.getAirportB())
						 {
							 ap.add(fl.getAirportA());
						 }
						 else if (fl.getAirportA() == anAirport && fl.getAirportB() == f.getAirportB())
						 {
							 ap.add(fl.getAirportB());
						 }
					 }
				 }
			 }
			 return ap;
	  }
	  
	  
	  public void printCompanies()
	  {
		  for (Flight f: CentralRegistry.getFlights())
		  {
			  if ( f.getAirportA() == this || f.getAirportB() == this)
			  {
				  System.out.println(f.getAirline());
			  }
		  }
	  }
	 
	 

	public String getName() {
		return name;
	}



	public String getCodeName() {
		return codeName;
	}



	public String getTown() {
		return town;
	}



	public String getCountry() {
		return country;
	}



	public ArrayList<Flight> getFlights() {
		return flights;
	}



	public ArrayList<String> getAirline() {
		return airline;
	}
	
		
}
