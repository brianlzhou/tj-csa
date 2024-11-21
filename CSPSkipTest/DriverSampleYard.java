// Brian Zhou
import java.util.*;
import java.io.*;

public class DriverSampleYard {
   public static void main(String[] args) throws Exception {
      // create scanner
      Scanner scanner = new Scanner(System.in);
      
      // ask user for .txt file
      System.out.println("Please enter a file ending in .txt: ");
      
      // reads input and checks for existence
      String fileName = scanner.nextLine();
      if (new File(fileName).exists()) {
         if (fileName.substring(fileName.length() - 4).equals(".txt")) {
            // confirmed that file exists, now try to print it
            try {
               System.out.println("Valid file!");
               new DisplaySampleYard().fillSampleYard(fileName);
            } catch (Exception e) {
               System.out.println("File incompatible, please enter a text file which is compatible");
               System.out.println("To be a compatible file, the file should have data values seperated by line");
               System.out.println("The file should begin with a number of how many customer yards there are, followed by the yard information in the order of last name, first name, lawn size, number of trees, garden size, garden size, and driveway status.");
            }
         }
         else {
            System.out.println("This file does not end in .txt. Please make sure the file is a text file and ends in .txt when it is entered.");
         }
      }
      else {
         System.out.println("This file does not exist. Please move the file into the folder with the code or use the full path.");
      }
   }
}