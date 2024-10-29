//Updated on 12.14.2020 v2

//Name:   Date:
import java.util.*;
import java.io.*;
import java.lang.*;
public class McRonald
{
   public static final int TIME = 1080;     //18 hrs * 60 min
   public static double CHANCE_OF_CUSTOMER = .2;
   public static int customers = 0;
   public static int totalMinutes = 0;
   public static int longestWaitTime = 0;
   public static int longestQueue = 0;
   public static int serviceWindow = 0;      // to serve the front of the queue
   //public static final int numberOfServiceWindows = 3;  //for McRonald 3
   public static int thisCustomersTime;
   public static PrintWriter outfile = null; // file to display the queue information
      
   public static int timeToOrderAndBeServed()
   {
      return (int)(Math.random() * 6 + 2);
   }
  
   public static void displayTimeAndQueue(Queue<Customer> q, int min)
   { 
      //Billington's
      outfile.println(min + ": " + q);	
      //Jurj's
      //outfile.println("Customer#" + intServiceAreas[i] + 
      //                            " leaves and his total wait time is " + (intMinute - intServiceAreas[i]));                     	
      
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
            
   public static void main(String[] args)
   {     
    //set up file      
      try
      {
         outfile = new PrintWriter(new FileWriter("McRonald 1 Queue 1 ServiceArea.txt"));
      }
      catch(IOException e)
      {
         System.out.println("File not created");
         System.exit(0);
      }
      
      mcRonald(TIME, outfile);   //run the simulation
      
      outfile.close();	
   }
   
   public static void mcRonald(int TIME, PrintWriter of)
   {
      /***************************************
           Write your code for the simulation   
      **********************************/
      Queue<Customer> q = new LinkedList<>();
      int count = 0;
      for(int i = 0; i<= 1080; i++) {
         if(Math.random()*5 <= 1) {
            customers++;
            q.add(new Customer(i, timeToOrderAndBeServed()));
         }
         if(!q.isEmpty()){
            int timeLeft = q.peek().getServed();
            if(timeLeft == 0) {
               Customer removed = q.remove();
               int waitTime = i - removed.getArrival();
               totalMinutes = totalMinutes + waitTime;
               if(waitTime > longestWaitTime) {
                  longestWaitTime = waitTime;
               }
            }
            else{
               //System.out.println(i + ": " + q);
               displayTimeAndQueue(q, i);
               outfile.println("      " + q.peek().getArrival()+" is now being served for " + timeLeft + " minutes.");
            }
         }
         else {
            //System.out.println(i + ": " + q);
            displayTimeAndQueue(q, i);
         }
         int size = q.size();
         if(size > longestQueue) {
            longestQueue = size;
         }
      } 
        
        
              
      /*   report the data to the screen    */  
      System.out.println("1 queue, 1 service window, probability of arrival = "+ CHANCE_OF_CUSTOMER);
      System.out.println("Total customers served = " + getCustomers());
      System.out.println("Average wait time = " + calculateAverage());
      System.out.println("Longest wait time = " + longestWaitTime);
      System.out.println("Longest queue = " + longestQueue);
   }
   
   static class Customer      
   {
      private int arrivedAt;
      private int orderAndBeServed;
      private int timeServed;
      
    /**********************************
       Complete the Customer class with  
       constructor, accessor methods, toString.
    ***********************************/
      public Customer() {
         arrivedAt = 0;
         orderAndBeServed = 0;
         timeServed = 0;
      }
      public Customer(int time, int ordertime) {
         arrivedAt = time;
         orderAndBeServed = ordertime;
         timeServed = 0;
      }
      public int getArrival() {
         return arrivedAt;
      }
      public int getOrderTime() {
         return orderAndBeServed;
      }
      public int getServed() {
         timeServed++;
         return orderAndBeServed-timeServed;
      }
      public String toString() {
         return String.valueOf(this.arrivedAt);
      }
   }
}