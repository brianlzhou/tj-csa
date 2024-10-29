//name:    date:
import java.lang.Math.*;
import java.text.DecimalFormat;
public class SmartCard 
{
   public final static DecimalFormat df = new DecimalFormat("$0.00");
   public final static double MIN_FARE = 0.5;
   /* enter the private fields */
   private double balance;
   private Station initialStation;
   private boolean boarded;
   
   /* the one-arg constructor  */
   public SmartCard(double initBalance)
   {
      balance = initBalance;
      initialStation = null;
      boarded = false;
   }

   //these three getter methods only return your private data
   //they do not make any changes to your data
   public boolean getIsBoarded() 
   { 
     return boarded;
   }
   
   public double getBalance()
   {
      return balance;   
   }
   
   public String getFormattedBalance() 
   {
      return df.format(balance);
   }
         
   public Station getBoardedAt()
   {
      return initialStation;
   }
   
   // actual methods
   public void addMoney(double d) {
      balance += d;
   }
   
   public void board(Station s) {
      if(boarded) {
         System.out.println("Error: already boarded?!");
         return;
      }
      else if (balance < 0.50) {
         System.out.println("Insufficient funds to board. Please add more money.");
         return;
      }
      else {
         boarded = true;
         initialStation = s;
         return;
      }
   }
   
   public double cost(Station s) {
      int zoneDiff = Math.abs(s.getZone() - initialStation.getZone());
      return 0.50 + 0.75 * zoneDiff;
   }
   
   public void exit(Station s) {
      if (!boarded) {
         System.out.println("Error: Did not board?!");
         return;
      }
      else if (cost(s) > balance) {
         System.out.println("Insufficient funds to exit. Please add more money.");
         return;
      }
      else {
         balance = balance - cost(s);
         boarded = false;
         System.out.println("From " + initialStation.getName() + " to " + s.getName() + " costs " + df.format(cost(s)) + ". SmartCard has " + getFormattedBalance() + ".");
         initialStation = null;
         return;
      }
   }
}
   
// ***********  start a new class.  The new class does NOT have public or private.  ***/
class Station
{
   // create fields
   private String name;
   private int zone;
   
   // constructors
   public Station() {
      name = "No name entered";
      zone = -1;
   }
   public Station(String name, int zone) {
      this.name = name;
      this.zone = zone;
   }
   
   // return priv data
   public String getName() {
      return name;
   }
   
   public int getZone() {
      return zone;
   }
}

