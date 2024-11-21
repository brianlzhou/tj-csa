//Brian Zhou

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PanelSampleYard extends JPanel {
   // create labels
   private static final JLabel lastNameLabel = new JLabel("Last Name:", SwingConstants.LEFT);
	private static final JLabel firstNameLabel = new JLabel("First Name:", SwingConstants.LEFT);
	private static final JLabel lawnSizeLabel = new JLabel("Lawn Size:", SwingConstants.LEFT);
	private static final JLabel treesLabel = new JLabel("Number Of Trees:", SwingConstants.LEFT);
   private static final JLabel gardenSizeLabel = new JLabel("Garden Size:", SwingConstants.LEFT);
	private static final JLabel drivewayLabel = new JLabel("Double Driveway:", SwingConstants.LEFT);
	private static final JLabel totalCost = new JLabel("Total Cost:", SwingConstants.LEFT);
	private static final JLabel runningCostLabel = new JLabel("Running Cost:", SwingConstants.LEFT);

	// create fields
	public static JTextField lastNameField = new JTextField("");
	public static JTextField firstNameField = new JTextField("");
	public static JTextField lawnSizeField = new JTextField("");
	public static JTextField treesField = new JTextField("");
   public static JTextField gardenSizeField = new JTextField("");
	public static JTextField drivewayField = new JTextField("");
	public static JTextField totalCostField = new JTextField("");
	public static JTextField runningCostField = new JTextField("");

	// create buttons 
	public static JButton next;
	private static JButton quit;

	public PanelSampleYard() {
		// create title panel
		JPanel paneltitle = new JPanel();
		JLabel labeltitle = new JLabel("Green and Grow Mowing Company");
		labeltitle.setHorizontalAlignment(SwingConstants.CENTER);
		labeltitle.setFont(new Font("Arial", Font.BOLD, 20));
		paneltitle.add(labeltitle);
      
      // create panel with info
 		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(8, 2)); 

		Font font = new Font("Arial", Font.BOLD, 16);

		panel.add(lastNameLabel);
		lastNameLabel.setFont(font);
		lastNameField.setHorizontalAlignment(SwingConstants.RIGHT);
		lastNameField.setFont(font);
      lastNameField.setBackground(Color.WHITE);
		lastNameField.setEditable(false);
		panel.add(lastNameField);

		panel.add(firstNameLabel);
		firstNameLabel.setFont(font);
		firstNameField.setHorizontalAlignment(SwingConstants.RIGHT);
		firstNameField.setFont(font);
      firstNameField.setBackground(Color.WHITE);
		firstNameField.setEditable(false);
		panel.add(firstNameField);

		panel.add(lawnSizeLabel);
		lawnSizeLabel.setFont(font);
		lawnSizeField.setHorizontalAlignment(SwingConstants.RIGHT);
		lawnSizeField.setFont(font);
      lawnSizeField.setBackground(Color.WHITE);
		lawnSizeField.setEditable(false);
		panel.add(lawnSizeField);

		panel.add(treesLabel);
		treesLabel.setFont(font);
		treesField.setHorizontalAlignment(SwingConstants.RIGHT);
		treesField.setFont(font);
      treesField.setBackground(Color.WHITE);
		treesField.setEditable(false);
		panel.add(treesField);

      panel.add(gardenSizeLabel);
		gardenSizeLabel.setFont(font);
		gardenSizeField.setHorizontalAlignment(SwingConstants.RIGHT);
		gardenSizeField.setFont(font);
      gardenSizeField.setBackground(Color.WHITE);
		gardenSizeField.setEditable(false);
		panel.add(gardenSizeField);

		panel.add(drivewayLabel);
		drivewayLabel.setFont(font);
		drivewayField.setHorizontalAlignment(SwingConstants.RIGHT);
		drivewayField.setFont(font);
      drivewayField.setBackground(Color.WHITE);
		drivewayField.setEditable(false);
		panel.add(drivewayField);

		panel.add(totalCost);
		totalCost.setFont(font);
		totalCostField.setHorizontalAlignment(SwingConstants.RIGHT);
		totalCostField.setFont(font);
      totalCostField.setBackground(Color.WHITE);
		totalCostField.setEditable(false);
		panel.add(totalCostField);

		panel.add(runningCostLabel);
		runningCostLabel.setFont(font);
		runningCostField.setHorizontalAlignment(SwingConstants.RIGHT);
		runningCostField.setFont(font);
      runningCostField.setBackground(Color.WHITE);
		runningCostField.setEditable(false);
		panel.add(runningCostField);

		// create buttonsubpanel and listeners
		JPanel buttonpanel = new JPanel();
		next = new JButton("Next");
		quit = new JButton("Quit");
		buttonpanel.add(next);
		buttonpanel.add(quit);

		next.addActionListener(new ActionListener() 
         {
   			public void actionPerformed(ActionEvent e) {
   				DisplaySampleYard.switcher();
   			}
   		}
      );

		quit.addActionListener(new ActionListener() 
         {
			   public void actionPerformed(ActionEvent e) {
				   System.exit(0);
			   }
		   }
      );

		// create layout
		setLayout(new BorderLayout());
		add(labeltitle, BorderLayout.NORTH); 
		add(panel, BorderLayout.CENTER);
		add(buttonpanel, BorderLayout.SOUTH);
	}
}
