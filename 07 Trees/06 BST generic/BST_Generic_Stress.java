// mlbillington 4-10-2019  

import java.util.*;
import java.io.*;

/*******************
Driver class for a generic BST. 
**********************/
public class BST_Generic_Stress
{
   public static int N = 10;
   public static void main(String[] args)
   {
    /*
      Put some Widget objects into your BST.  Display the tree. 
      Print it using toString().   Are the objects in BST order?
   	*/
     //  BST_Generic_Teacher<Widget> treeOfWidgets = new BST_Generic_Teacher<Widget>();
   //       treeOfWidgets.add( new Widget( 3, 5 ));
   //       treeOfWidgets.add( new Widget( 4, 0 ));
   //       treeOfWidgets.add( new Widget( 4, 6 ));
   //       treeOfWidgets.add( new Widget( 2, 0 ));
   //       treeOfWidgets.add( new Widget( 3, 3 ));
   //       System.out.println(treeOfWidgets.display());
   //       System.out.println(treeOfWidgets.toString());
   //       System.out.println("Size: " + treeOfWidgets.size());
   //       System.out.println("Min: " + treeOfWidgets.min());
   //       System.out.println("Max: " + treeOfWidgets.max());
   //          
   //          /*
   //          Prompt the user to enter cubits and hands.  If the tree contains that 
   //       	Widget, remove it, of course restoring the BST order. Display the new tree 
   //       	and its size. If the tree does not contain that Widget, print "Not found".*/ 
   //                  
   //       Scanner kb = new Scanner( System.in );
   //       do{
   //          System.out.print("Remove which Widget?  ");
   //          int stop = kb.nextInt();
   //          if(stop == -1)
   //             System.exit(0);
   //          Widget toRemove = new Widget( stop, kb.nextInt() );
   //          if( treeOfWidgets.contains( toRemove ) )
   //          {
   //             treeOfWidgets.remove( toRemove );
   //             System.out.println(treeOfWidgets.display());
   //             System.out.println(treeOfWidgets.toString());
   //             System.out.println("Size: " + treeOfWidgets.size());
   //          }
   //          else
   //             System.out.println( "Not found.");
   //       }while( treeOfWidgets.size() != 0 );
      
   /*
     Stress test.  Put N random Widgets in an ArrayList. Make a copy of the 
     ArrayList.  Add the Widgets, at random, to your generic BST.
     Remove the Widgets, at random, from your generic BST.  Is the
     BST in order at every step?
     */
   
      BST_Generic_Teacher<Widget> treeOfWidgets = new BST_Generic_Teacher<Widget>();  
      ArrayList<Widget> listOfWidgets = new ArrayList<>();
      ArrayList<Widget> widgetsToRemove = new ArrayList<>();
      for( int x = 0; x < N; x++ )
      {
         int cubits = (int)(Math.random() * 10);
         int hands = (int)(Math.random() * 10);
         listOfWidgets.add(new Widget( cubits, hands ));
         widgetsToRemove.add(new Widget( cubits, hands ));
      }
      for( int x = 0; x < N; x++ )
      {
         int index = (int)(Math.random() * listOfWidgets.size());
         Widget randomWidget = listOfWidgets.remove(index);
         treeOfWidgets.add( randomWidget);
      }
      System.out.println( treeOfWidgets.display() );
      System.out.println("In order? " + checkInOrder( treeOfWidgets ));
      System.out.println();
      
      for( int x = 0; x < N-1; x++ )
      {
         int index = (int)(Math.random() * widgetsToRemove.size());
         Widget randomWidget = widgetsToRemove.remove(index);
         System.out.println(">>> Now removing " + randomWidget +"\n");
         treeOfWidgets.remove( randomWidget);
         System.out.println( treeOfWidgets.display() );
      
         System.out.println("In order? " + checkInOrder( treeOfWidgets ));
         System.out.println();
      }      
   }
   
    /* how can you get the computer to test if the objects are "in order"?  */
   public static boolean checkInOrder(BST_Generic_Teacher<Widget> bst)
   {
      ArrayList<Widget> list = bst.toList();
      for( int x = 0; x < list.size()-1; x++)
         if(list.get(x).compareTo(list.get(x+1)) > 0 )
            return false;
      return true;
   }
}
