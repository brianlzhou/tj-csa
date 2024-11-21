//mlbillington@fcps.edu, May 2014
//graph manipulation, lesson #0

import java.util.*;
import java.io.*;
public class AdjMat_0_Driver
{
   public static void main(String[] args)throws FileNotFoundException
   {
      Scanner kb = new Scanner(System.in);
      System.out.print("Enter size of adjacency matrix: "); 
      int size = kb.nextInt();
      AdjMat g = new AdjMat(size);
      System.out.println("Adjacency Matrix");
      System.out.println(g.toString());
      System.out.println("Add edges, source<space>target<enter>.  Enter -1 to stop.");
      while(true)
      {
         int source = kb.nextInt();
         if( source == -1 ) 
            break;
         int target = kb.nextInt();
         if( !g.isEdge(source, target) )
            g.addEdge(source, target);
         System.out.println(g.toString());
      }
      System.out.println(g.toString());
      System.out.print("Remove an edge? Y/N");
      if( kb.next().equalsIgnoreCase("Y"))
      {  
         while(true)
         {
            System.out.print("Remove which edge?  ");
            int source = kb.nextInt();
            if( source == -1 ) 
               break;
            int target = kb.nextInt();
            if( g.isEdge(source, target) )
               g.removeEdge( source, target );
            else 
               System.out.println("That's not an edge");
            System.out.println(g.toString());
         }
      }
   			
      System.out.println("Number of edges: " + g.edgeCount());
      System.out.println("The neighbors of each vertex: ");
      for(int i=0; i<size; i++)
      {
         System.out.println(i + ": " +g.getNeighbors(i));
      }
   }
}
/******************   sample run
 Enter size of adjacency matrix: 4
 Adjacency Matrix
  0  0  0  0 
  0  0  0  0 
  0  0  0  0 
  0  0  0  0 
 Add edges, source<space>target<enter>.  Enter -1 to end.
 1 3
  0  0  0  0 
  0  0  0  1 
  0  0  0  0 
  0  0  0  0 
 0 2
  0  0  1  0 
  0  0  0  1 
  0  0  0  0 
  0  0  0  0 
 2 2
  0  0  1  0 
  0  0  0  1 
  0  0  1  0 
  0  0  0  0 
 -1
  0  0  1  0 
  0  0  0  1 
  0  0  1  0 
  0  0  0  0 
 Remove an edge? Y/N y
 Remove which edge?  0 2
  0  0  0  0 
  0  0  0  1 
  0  0  1  0 
  0  0  0  0 
 Remove which edge?  0 0
 That's not an edge
  0  0  0  0 
  0  0  0  1 
  0  0  1  0 
  0  0  0  0 
 Remove which edge?  -1
 Number of edges: 2
 The neighbors of each vertex: 
 0: []
 1: [3]
 2: [2]
 3: []
 ************************************/