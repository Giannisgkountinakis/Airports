import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class AirportPage extends JFrame{

	private JPanel panel = new JPanel();
	
	private JTextField name = new JTextField();
	private JTextField codeName = new JTextField();
	private JTextField town = new JTextField();
	private JTextField country = new JTextField();
	private JTextField cityName = new JTextField("Enter city");
	
	private JButton findFlightsButton = new JButton("Find Flights");
	private JButton backToSearchButton = new JButton("Back to Search Screen");

	private JList airlinesList = new JList();
	
	private JTextArea directFlightsArea = new JTextArea();
	private JTextArea inDirectFlightsArea = new JTextArea();
	
	private Airport airportName;
	private Airport nameOfCity;
	

	public AirportPage(Airport airport)
	{
		name.setText(airport.getName());
		name.setEditable(false);
		codeName.setText(airport.getCodeName());
		codeName.setEditable(false);
		town.setText(airport.getTown());
		town.setEditable(false);
		country.setText(airport.getCountry());
		country.setEditable(false);
		
		DefaultListModel model = new DefaultListModel();
		
		for (Flight flight: CentralRegistry.getFlights())
		{
			if (airport == flight.getAirportA())
			{
				airportName = airport;
				model.addElement(flight.getAirline());
			}
		}
		
		airlinesList.setModel(model);
		
		
		ButtonListener findFlightsListener = new ButtonListener();
		findFlightsButton.addActionListener(findFlightsListener);
		
		ButtonListener searchListener = new ButtonListener();
		backToSearchButton.addActionListener(searchListener);
		
		//JTextFields
		panel.add(name);
		panel.add(codeName);
		panel.add(town);
		panel.add(country);
		
		//JList
		panel.add(airlinesList);
		
		//JTextField
		panel.add(cityName);
		
		//JButton
		panel.add(findFlightsButton);
		
		//JTextArea
		panel.add(directFlightsArea);
		panel.add(inDirectFlightsArea);
		
		//JButton
		panel.add(backToSearchButton);
		

		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(400, 400);
		this.setTitle("Airport Page");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			

			if (e.getSource() == findFlightsButton)
			{	
				int index = 0;
				int count = 0;
			
				if (cityName.getText().equals(airportName.getTown()))
				{
					//!!To parakatw emfanizei kanonika to minima pou evala otan dinontai idies poleis,ektos
					//omws apo otan dinw gia idies poleis to Munich,den kserw giati symvainei omws!!
					JOptionPane.showMessageDialog(panel, "Arrival and departure city cannot be the same!");
				}
				else
				{
					directFlightsArea.append("DIRECT FLIGHTS DETAILS \n");
					inDirectFlightsArea.append("INDIRECT FLIGHTS through... \n");
				
					for (Airport airport: CentralRegistry.getAirports())
					{
						nameOfCity = airport;
						if (airport.getTown().equals(cityName.getText()))
						{
							nameOfCity = airport;
						
							ArrayList<Flight> flights = CentralRegistry.getDirectFlightsDetails(airportName,nameOfCity);
						
							for (Flight flight: flights)
							{
								index++;
								directFlightsArea.append("[" + index + "]" + flight.toString() + "\n");
							}
						}
					}
					if (index == 0)
					{
						directFlightsArea.append("No direct flights");
					}
					
					int index1 = 0 ;
					for (Airport airport: CentralRegistry.getAirports())
					{
						nameOfCity = airport;
						if (airport.getTown().equals(cityName.getText()))
						{
							nameOfCity = airport;
							ArrayList<Airport> airports = CentralRegistry.getInDirectFlightsDetails(airportName, nameOfCity);
							for(Airport a:  airports)
							{
								if (!(a.getTown().equals(cityName.getText())))
								{
									index1++;
									//model3.addElement(a.getTown() + "," + a.getCodeName() + " airport");
									inDirectFlightsArea.append("[" + index1 + "]" + a.getTown() + "," + a.getCodeName() + " airport" + "\n");
									count++;
								}
							}
						}
					}
					if (count==0)
					{
						inDirectFlightsArea.append("No indirect flights ");
					}
				}
			}
			else if (e.getSource() == backToSearchButton)
			{
				dispose();
				FindAirport findAirport = new FindAirport();
				findAirport.setVisible(true);
			}
		}
	}
}
