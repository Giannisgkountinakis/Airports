import java.util.ArrayList;

public class CentralRegistry {

	//ATTRIBUTES
	
	private static ArrayList<Flight> flights = new ArrayList<>();
	private static ArrayList<Airport> airports = new ArrayList<>();
	
	
	
	//METHODS 
	
	public static void addAirport(Airport anAirport)
	{
		airports.add(anAirport);
	}
	
	
	public static void addFlight(Flight aFlight)
	{
		flights.add(aFlight);
	}
	

	//Methodos h opoia epistrefei ton Arraylist "flights" prokeimenoy na xrisimopoihthei
	//stis methodous ths klashs airport.
	public static ArrayList<Flight> getFlights()
	{
		return flights;
	}
	
	public static ArrayList<Airport> getAirports()
	{
		return airports;
	}
	
	public static Airport getAirport(String cityName)
	{
		for (Airport airport: airports)
		{
			if (airport.getTown() == cityName)
			{
				return airport;
			}
		}
		return null;
	}
	
	//Prokeimenou na proxoreisw thn askhsh ekana tin methodo me diko mou tropo
	public static ArrayList<Flight> getDirectFlightsDetails(Airport a, Airport b)
	{
		ArrayList<Flight> f = new ArrayList<>();
		
		for (Flight flight: flights)
		{
			if (a.isDirectlyConnectedTo(b))
			{
				if ((flight.getAirportA() == a && flight.getAirportB() == b ) || (flight.getAirportA() == a && flight.getAirportB() == b))
				{
					f.add(flight);
				}
			}
		}
		return f;
	}
	
	
	
	public static ArrayList<Airport> getInDirectFlightsDetails(Airport a, Airport b)
	{

		ArrayList<Airport> answer = a.getCommonConnections(b);
		
		return answer;
	}
}
