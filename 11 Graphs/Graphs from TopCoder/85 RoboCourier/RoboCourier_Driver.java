// Name:    
// Date:

import java.util.*;
import java.io.*;

public class RoboCourier_Driver
{
   public static void main(String[] args) throws Exception
   {
      System.out.println("RoboCourier");
      System.out.print("Enter rc number: ");
      Scanner sc = new Scanner(System.in);
      String rcnumber = sc.next();
      Scanner file = new Scanner(new File("rc" + rcnumber + ".txt"));
      ArrayList<String> movesArray = new ArrayList<String>();
      while(file.hasNextLine())
         movesArray.add(file.nextLine());
      String[] moves	= new String[movesArray.size()];
      moves = movesArray.toArray(moves);
      RoboCourier rc = new RoboCourier();   //student writes this resource class
      int totalTime = rc.timeToDeliver(moves);
      System.out.println("Returns: " + totalTime);
   }
}

class RoboCourier
{
   public int timeToDeliver(String[] path)
   {	
      /* enter your code here */
   }
}