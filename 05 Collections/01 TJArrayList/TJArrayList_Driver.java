import java.util.*;
import java.io.*;
 
public class TJArrayList_Driver
{
   public static void main(String [] args)
   {
      TJArrayList<String> myList = new TJArrayList<>();	
      //ArrayList<String> myList = new ArrayList<>();  //for comparison purposes
      myList.add("Apple");
      myList.add("Banana");
      myList.add("Fig");
      myList.add(2, "Cucumber");
      myList.add(3, "Dates");
      myList.add(0, "Apple");
      System.out.println(myList);
      System.out.println("Size is " + myList.size());
      try
      {
         myList.add(12, "Peach");
      }
      catch(IndexOutOfBoundsException e)
      {
         System.out.println(e);
      }
      System.out.println("Get 2: " + myList.get(2));
      System.out.print("Set at 2: ");
      String previous = myList.set(2, "Cherry");
      System.out.println(previous +" " +myList);
      String obj = myList.remove(2);
      System.out.println("Removed " + obj+ " from " + myList);
      System.out.println("Size is " + myList.size());
      System.out.print("Add too many items: ");
      for(int i = 3; i <= 10; i++)
         myList.add("fruit");
      System.out.println(myList);
      System.out.println("Size is " + myList.size());   	
      System.out.println("Contains \"Breadfruit\"?  " + myList.contains("Breadfruit"));
      System.out.println("Contains \"Banana\"?  " + myList.contains("Banana"));
      System.out.println();
      
   /*  generics are type-safe for any Object.
       Test your code with Widgets.
      */ 
      TJArrayList<Widget> theList = new TJArrayList<>();	
      //ArrayList<Widget> theList = new ArrayList<>();  //for comparison purposes
      theList.add( new Widget(1,2) );
      theList.add( new Widget(4,5) );
      theList.add(2, new Widget(500, 501) );
      theList.add( new Widget(7,8) );
      System.out.println("Size is " + theList.size()); 
      System.out.println(theList);  
   }
}

/************************

 [Apple, Apple, Banana, Cucumber, Dates, Fig]
 Size is 6
 java.lang.IndexOutOfBoundsException: Index: 12, Size: 6
 Get 2: Banana
 Set at 2: Banana [Apple, Apple, Cherry, Cucumber, Dates, Fig]
 Removed Cherry from [Apple, Apple, Cucumber, Dates, Fig]
 Size is 5
 Add too many items: [Apple, Apple, Cucumber, Dates, Fig, fruit, fruit, fruit, fruit, fruit, fruit, fruit, fruit]
 Size is 13
 Contains "Breadfruit"?  false
 Contains "Banana"?  false
 
 Size is 4
 [1 cubits 2 hands, 4 cubits 5 hands, 500 cubits 501 hands, 7 cubits 8 hands]

 
 *********************************************/
