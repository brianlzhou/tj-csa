// Brian Zhou
public class CustomerLargeYard implements Yard { 
   //create all our variables
   private double cost;
   private String lastName, firstName;
   private int lawnSize, gardenSize, treeCount;
   private boolean driveway;
   
   //constructor 
   public CustomerLargeYard(String lastName, String firstName, int lawnSize, int treeCount, int gardenSize, String driveway) {
      this.lastName = lastName;
      this.firstName = firstName;
      this.lawnSize = lawnSize;
      this.treeCount = treeCount;
      this.gardenSize = gardenSize;
      if (driveway.equalsIgnoreCase("yes")) {
         this.driveway = true;
      }
      else {this.driveway = false;}
      // cost calculation time! this checks if there is no garden, and then if there is a driveway, and then if it is an odd # of trees to calculate cost
      if (gardenSize != 0) {
         if (this.driveway) {
            if (this.treeCount % 2 == 1) {
               cost = (this.lawnSize - this.gardenSize) * 0.003 * 1.02 + 10; // Y garden, Y driveway, Y odd trees
            }
            else {
               cost = (this.lawnSize - this.gardenSize) * 0.003 * 0.97 + 10; // Y garden, Y driveway, N odd trees
            }
         }
         else {
            if (this.treeCount % 2 == 1) {
               cost = (this.lawnSize - this.gardenSize) * 0.003 * 1.05 + 10; // Y garden, N driveway, Y odd trees
            }
            else {
               cost = (this.lawnSize - this.gardenSize) * 0.003 + 10; // Y garden, N driveway, N odd trees
            }
         }
      }
      else {
         if (this.driveway) {
            if (this.treeCount % 2 == 1) {
               cost = this.lawnSize * 0.003 * 1.02; // N garden, Y driveway, Y odd trees
            }
            else {
               cost = this.lawnSize * 0.003 * 0.97; // N garden, Y driveway, N odd trees
            }
         }
         else {
            if (this.treeCount % 2 == 1) {
               cost = this.lawnSize * 0.003 * 1.05; // N garden, N driveway, Y odd trees 
            }
            else {
               cost = this.lawnSize * 0.003; // N garden, N driveway, N odd trees
            }
         }
      }
   }
   public double getCost() {
      return cost;
   } 
   public String getFirstName() {
      return firstName;
   }
   public String getLastName() {
      return lastName;
   }
   public int compareTo(Yard y) {
      return this.lastName.compareTo(y.getLastName());
   }
   public int getNumberTrees() {
      return treeCount; 
   }
   public int getGardenSize() {
      return gardenSize;
   } 
   public String getDoubleDriveway() {
      if(driveway) {
         return "Yes";
      }
      else {return "No";}
   }
   public String toString() {
      return firstName + " " + lastName;
   }
   public int getSize() {
      return lawnSize;
   }
}

