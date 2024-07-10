import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindAirport extends JFrame{

	private JPanel panel = new JPanel();
	private JTextField airportNameField = new JTextField("Enter City");
	private JButton findButton = new JButton("Find");
	
	public FindAirport()
	{
		panel.add(airportNameField);
		panel.add(findButton);
		
		this.setContentPane(panel);
		
		ButtonListener findflightListener = new ButtonListener();
		findButton.addActionListener(findflightListener);
		
		this.setVisible(true);
		this.setSize(400, 400);
		this.setTitle("Find Airport");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	class ButtonListener implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String givenName = airportNameField.getText();
			String townName = "";
			int count = 0;

			for (Airport airport: CentralRegistry.getAirports())
			{
				townName = airport.getTown();
				
				if (townName.equals(givenName))
				{
					count++;
					new AirportPage(airport);
				}
			}
			if (count == 0)
			{
				JOptionPane.showMessageDialog(panel, givenName + " does not have an airport");
			}
		}
		
	}
}
