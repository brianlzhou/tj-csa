// Brian Zhou

import javax.swing.JFrame;
import java.text.DecimalFormat;
import java.io.*;
import java.util.*;

public class DisplaySampleYard {
   // create all the variables needed
 	private static DecimalFormat d = new DecimalFormat("#.00");
   private static Yard[] yards;
   private static int num; 
   private static int count = 0;
	private static double runningCost = 0;

	public void fillSampleYard(String fileName) throws Exception {
		// create the variables for the text reader
      String lastName, firstName, driveway;
      int lawnSize, gardenSize, treeCount;

      // create the text reader and see how many yards there will be
      Scanner textReader = new Scanner(new File(fileName));
		num = textReader.nextInt(); // log the # of yards
      textReader.nextLine(); // move to next line as the next line is a line reader with an int before
		yards = new Yard[num]; // create array with n
      
      // read the variables in order and assign them to a new yard in the array
      for (int i = 0; i < num; i++) {
         lastName = textReader.nextLine();
         firstName = textReader.nextLine();
         lawnSize = textReader.nextInt();
			treeCount = textReader.nextInt();
			gardenSize = textReader.nextInt();
         textReader.nextLine(); // same as before, additional nextLine before the nextLine since it's int before line
			driveway = textReader.nextLine();
         if (lawnSize > 20000) {
            yards[i] = new CustomerLargeYard(firstName, lastName, lawnSize, treeCount, gardenSize, driveway);
         }
         else if (lawnSize > 10000) {
            yards[i] = new CustomerMediumYard(firstName, lastName, lawnSize, treeCount, gardenSize, driveway);
         }
         else {
            yards[i] = new CustomerSmallYard(firstName, lastName, lawnSize, treeCount, gardenSize, driveway);
         }
      }
      textReader.close();
      
      // sort the array
      insertionSort();
      
      // create frame and compoments
      JFrame frame = new JFrame("Sample CS ReadinessTest");
      frame.setSize(400,305);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(new PanelSampleYard());
		frame.setVisible(true); 
   }
   
   // sorters, either works
   private static void bubbleSort() {
      int n = yards.length;
      for (int i = 0; i < n-1; i++) {
         for (int j = 0; j < n-i-1; j++) {
             if (yards[j].compareTo(yards[j+1]) > 0)
             {
                 // swap arr[j+1] and arr[j]
                 Yard temp = yards[j];
                 yards[j] = yards[j+1];
                 yards[j+1] = temp;
             }
         }
      }
   }     
   private static void insertionSort()
   {
       int i, j;
       Yard key;
       for (i = 1; i < yards.length; ++i)
       {
           key = yards[i];
           j = i - 1;
    
           while (j >= 0 && yards[j].compareTo(key) > 0)
           {
               yards[j + 1] = yards[j];
               j = j - 1;
           }
           yards[j + 1] = key;
       }
   }
       
   // switch what is being displayed
   public static void switcher() {
		PanelSampleYard.lastNameField.setText(yards[count].getLastName());
		PanelSampleYard.firstNameField.setText(yards[count].getFirstName());
		PanelSampleYard.lawnSizeField.setText("" + yards[count].getSize());
		PanelSampleYard.treesField.setText("" + yards[count].getNumberTrees());
      PanelSampleYard.gardenSizeField.setText("" + yards[count].getGardenSize());
		PanelSampleYard.drivewayField.setText(yards[count].getDoubleDriveway());
		
      PanelSampleYard.totalCostField.setText("$" + d.format(yards[count].getCost()));
		runningCost = runningCost + yards[count].getCost();
 		PanelSampleYard.runningCostField.setText("$" + d.format(Math.round(runningCost * 100) / 100.0));
		count++;

		if (count >= num)
			PanelSampleYard.next.setEnabled(false);
	}

}
