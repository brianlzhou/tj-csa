//mlbillington@fcps.edu, May 2012, June 2014
// Graphs 2,  uses AdjMat

import java.util.*;
import java.io.*;
public class FloydDriver
{
   public static void main( String[] args)throws FileNotFoundException
   {
      Scanner kb = new Scanner(System.in);
      System.out.print("Floyd's Algorithm! Enter file of names: "); 
   											             //cities
      String fileNames = kb.next()+".txt";
      Scanner sc = new Scanner(new File(fileNames));
      int size = sc.nextInt();
      AdjMat g = new AdjMat(size);
      g.readNames(fileNames);
      System.out.print("Enter file of the matrix: ");//citymatrixweighted
      String fileGrid = kb.next()+".txt";
      g.readGrid(fileGrid);
      System.out.println("\nAdjacency Matrix");
      System.out.println( g.toString() ); 
      System.out.println("\nNumber of Edges: " + g.edgeCount());
      g.allPairsWeighted();    //call Floyd's
      System.out.println();
      g.displayVertices();
      System.out.println("Cost Matrix");
      System.out.println( g.toString() ); 
      System.out.println("\nNumber of Edges: " + g.edgeCount());
      while(true)
      {
         System.out.print("\nWhat is the cost?  Enter start city (-1 to exit): ");
         String from = kb.next();
         if(from.equals("-1"))
            break;
         System.out.print("                Enter end city: "); 
         String to = kb.next();  
         System.out.println( g.getCost(from, to) );
      }
   }
}
/*******************************      
Floyd's Algorithm! Enter file of names: cities
Enter file of the matrix: citymatrixweighted

Adjacency Matrix
 0  9999  9999  9999  9999  9999  9999  8 
 9999  0  9999  5  9999  9999  9999  9999 
 9999  9999  0  9999  9999  5  9999  3 
 9999  9999  9999  0  9999  10  9999  3 
 2  9999  9999  9999  0  9999  9999  9999 
 9999  4  9999  10  9999  0  9999  9999 
 9999  9999  9999  9999  9999  2  0  9999 
 8  9999  9999  9999  3  9999  9999  0 

Number of Edges: 12

0-Pendleton
1-Pensacola
2-Peoria
3-Phoenix
4-Pierre
5-Pittsburgh
6-Princeton
7-Pueblo

Cost Matrix
 0  9999  9999  9999  11  9999  9999  8 
 13  0  9999  5  11  15  9999  8 
 8  9  0  14  6  5  9999  3 
 8  14  9999  0  6  10  9999  3 
 2  9999  9999  9999  0  9999  9999  10 
 17  4  9999  9  15  0  9999  12 
 19  6  9999  11  17  2  0  14 
 5  9999  9999  9999  3  9999  9999  0 

Number of Edges: 33

What is the cost?  Enter start city (-1 to exit): Pittsburgh
                Enter end city: Phoenix
9

What is the cost?  Enter start city (-1 to exit): Pendleton
                Enter end city: Phoenix
9999

What is the cost?  Enter start city (-1 to exit): -1

*************************************************************/     
