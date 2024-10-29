//Name:   Date:

import java.util.*;
import java.io.*;
public class McRonaldVIP
{
   public static final int TIME = 1080;  //18 hrs * 60 min
   public static double CHANCE_OF_CUSTOMER = .2;
   public static double CHANCE_OF_VIP = .02;
   public static int customers = 0;
   public static int totalMinutes = 0;
   public static int longestWaitTime = 0;
   public static int longestQueue = 0;
   public static int serviceWindow = 0;      // to serve the front of the queue
   public static int thisCustomersTime;
   public static int vipTime = 0;
   public static int vips = 0;
   public static PrintWriter outfile = null; // file to display the queue information
      
   public static int timeToOrderAndBeServed()
   {
      return (int)(Math.random() * 6 + 2);
   }
  
   public static void displayTimeAndQueue(String vip, int min, Queue<Customer> q)
   { 
      outfile.println(vip + " " + min + ": " + q);			
   }
   public static int getCustomers()
   {
      return customers;
   }
   public static double calculateAverage()
   {
      return (int)(1.0 * totalMinutes/customers * 10)/10.0;
   }
   public static int getLongestWaitTime()
   {
      return longestWaitTime;
   }
   public static int getLongestQueue()
   {
      return longestQueue;
   }
   public static double calculateAverageVIP()
   {
      return (int)(1.0 * vipTime / vips * 10) / 10.0;
   }


        
   public static void main(String[] args)
   {     
    //set up file     
      try
      {
         outfile = new PrintWriter(new FileWriter("McRonaldVIP 2 Queues 1 ServiceArea.txt"));
      }
      catch(IOException e)
      {
         System.out.println("File not created");
         System.exit(0);
      }
   
      mcRonaldVIP(TIME, outfile);  //call the simulation
       
      outfile.close();
   }
   
   public static void mcRonaldVIP(int TIME, PrintWriter outfile)   //2 queues, 1 service area
   {
      // write code for the simulation
      
      
      
      
      //empty the queue at the end of the day-- no VIPS!
               
               
               
               
      /*   display all cumulative variables  */
      System.out.println("1 queue plus VIP queue, 1 service window");
      System.out.println("probability of arrival = "+ CHANCE_OF_CUSTOMER);
      System.out.println("probability of VIP = "+ CHANCE_OF_VIP);
      System.out.println("Total customers served = " + customers);
      System.out.println("Total VIPs served = " + vips);
      System.out.println("Average wait time = " + calculateAverage());
      System.out.println("Average VIP wait time = " + calculateAverageVIP());
      System.out.println("Longest wait time = " + getLongestWaitTime());
      System.out.println("Longest queue = " + getLongestQueue());	
   }
   
   static class Customer      
   {
   
   }
}