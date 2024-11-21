import java.util.*;
import java.io.*;

/*******************
Driver class for a generic BST. 
**********************/
public class BST_Generic_Driver
{
   public static int N = 10;
   public static void main(String[] args)
   {
      BST_Generic<Integer> treeOfIntegers = new BST_Generic<Integer>();
      treeOfIntegers.add(5);
      treeOfIntegers.add(2);
      treeOfIntegers.add(10);
      System.out.println(treeOfIntegers.display());
      System.out.println(treeOfIntegers.toString());
      System.out.println("Size: " + treeOfIntegers.size());
      System.out.println("Min: " + treeOfIntegers.min());
      System.out.println("Max: " + treeOfIntegers.max());
      int a = treeOfIntegers.remove(10);
      int b = treeOfIntegers.remove(2);
      int c = treeOfIntegers.remove(5);
      System.out.println("Sum = "+ (a+b+c));
      System.out.println();
    /*
      Put some Widget objects into your BST.  Display the tree. 
      Print it using toString().   Are the objects in BST order?
   	*/
      BST_Generic<Widget> treeOfWidgets = new BST_Generic<Widget>();
      treeOfWidgets.add( new Widget( 3, 5 ));
      treeOfWidgets.add( new Widget( 4, 0 ));
      treeOfWidgets.add( new Widget( 4, 6 ));
      treeOfWidgets.add( new Widget( 2, 0 ));
      treeOfWidgets.add( new Widget( 3, 3 ));
      System.out.println(treeOfWidgets.display());
      System.out.println(treeOfWidgets.toString());
      System.out.println("Size: " + treeOfWidgets.size());
      System.out.println("Min: " + treeOfWidgets.min());
      System.out.println("Mas: " + treeOfWidgets.max());
      
      /*
      Prompt the user to enter cubits and hands.  If the tree contains that 
   	Widget, remove it, of course restoring the BST order. Display the new tree 
   	and its size. If the tree does not contain that Widget, print "Not found".
      */         
      Scanner kb = new Scanner( System.in );
      do{
         System.out.print("Remove which Widget?  ");
         int stop = kb.nextInt();
         if(stop == -1)
            System.exit(0);
         Widget toRemove = new Widget( stop, kb.nextInt() );
         if( treeOfWidgets.contains( toRemove ) )
         {
            treeOfWidgets.remove( toRemove );
            System.out.println(treeOfWidgets.display());
            System.out.println(treeOfWidgets.toString());
            System.out.println("Size: " + treeOfWidgets.size());
         }
         else
            System.out.println( "Not found.");
      }while( treeOfWidgets.size() != 0 );
      
      /*
     Stress test. Put N random Widgets in an ArrayList. Make a copy of the 
     ArrayList.  Add the Widgets, at random, to your generic BST.
     Remove the Widgets, at random, from your generic BST.  Is the
     BST in order at every step?
     */
   //    BST_Generic<Widget> treeOfWidgets = new BST_Generic<Widget>();  
   //       ArrayList<Widget> listOfWidgets = new ArrayList<>();
   //       ArrayList<Widget> widgetsToRemove = new ArrayList<>();
   //       for( int x = 0; x < N; x++ )
   //       {
   //          int cubits = (int)(Math.random() * 10);
   //          int hands = (int)(Math.random() * 10);
   //          listOfWidgets.add(new Widget( cubits, hands ));
   //          widgetsToRemove.add(new Widget( cubits, hands ));
   //       }
   //       for( int x = 0; x < N; x++ )
   //       {
   //          int index = (int)(Math.random() * listOfWidgets.size());
   //          Widget randomWidget = listOfWidgets.remove(index);
   //          treeOfWidgets.add( randomWidget);
   //       }
   //       System.out.println( treeOfWidgets.display() );
   //       System.out.println("In order? " + checkInOrder( treeOfWidgets ));
   //       System.out.println();
   //       
   //       for( int x = 0; x < N-1; x++ )
   //       {
   //          int index = (int)(Math.random() * widgetsToRemove.size());
   //          Widget randomWidget = widgetsToRemove.remove(index);
   //          System.out.println(">>> Now removing " + randomWidget +"\n");
   //          treeOfWidgets.remove( randomWidget);
   //          System.out.println( treeOfWidgets.display() );
   //       
   //          System.out.println("In order? " + checkInOrder( treeOfWidgets ));
   //          System.out.println();
   //       }      
   //    }
   
   /* how can you get the computer to test if the objects are "in order"?  */
   //    public static boolean checkInOrder(BST_Generic<Widget> bst)
   //    {
   //
   //    }
   }
}
