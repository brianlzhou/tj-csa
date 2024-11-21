//lesson:  Graphs4: DFS_BFS
//uses AdjList

import java.util.*;
import java.io.*;
 
public class DFS_BFS_Driver
{  
   public static void main(String[] args)throws FileNotFoundException
   {
      //should already be working from Lab03
      System.out.println("Edge List Representation! ");
      AdjList g = new AdjList(); 
      g.addVertex("R");     
      g.addVertex("B");
      g.addVertex("C");
      g.addVertex("D");
      
      g.addEdge("R", "C"); 
      g.addEdge("B", "R");
      g.addEdge("C", "C");
      g.addEdge("C", "D");
      g.addEdge("D", "C");
      g.addEdge("D", "R");
      System.out.println(g.toString());      //let's look at it first
   
      //test the DFS-BFS methods  	
      System.out.println("Depth First Search");
      Scanner kb = new Scanner(System.in);
      while(true)
      {
         System.out.print("\tEnter source: ");
         String from = kb.next();
         if(from.equals("-1"))
            break;
         System.out.println( "\t\t\t\t" + g.depthFirstSearch(from) );
      }
            
      System.out.println("\nBreadth First Search");
      while(true)
      {
         System.out.print("\tEnter source: ");
         String from = kb.next();
         if(from.equals("-1"))
            break;
         System.out.println( "\t\t\t\t" + g.breadthFirstSearch(from) );
      }
      
      //Set the debugger in AdjList to see the difference:
      System.out.println("\nSet the debugger in AdjList to see the difference:");  
      System.out.println( "D" + " ---> " + g.depthFirstSearch("D") );
      System.out.println( "D" + " ---> " + g.breadthFirstSearch("D") );  
      
        
     /*  Extensions  */    
      // System.out.println("\nExtension:  Depth First Search (Recursive)");
      // for (String name : g.getVertexMap().keySet() )
         // System.out.println ( name + " ---> " + g.depthFirstRecur(name) );
       
      //System.out.println("\nExtension:  Breadth First Search (Recursive)");
      //for (String name : g.getVertexMap().keySet() )
         //System.out.println ( name + " ---> " + g.breadthFirstRecur(name) );
   }   
}
/**********************************
  
Edge List Representation! 
B [R]
C [C D]
D [R C]
R [C]

Depth First Search
	Enter source: B
				[R [C], C [C D], D [R C]]
	Enter source: C
				[D [R C], C [C D], R [C]]
	Enter source: D
				[C [C D], D [R C], R [C]]
	Enter source: R
				[C [C D], D [R C], R [C]]
	Enter source: -1

Breadth First Search
	Enter source: B
				[R [C], C [C D], D [R C]]
	Enter source: C
				[C [C D], D [R C], R [C]]
	Enter source: D
				[R [C], C [C D], D [R C]]
	Enter source: R
				[C [C D], D [R C], R [C]]
	Enter source: -1

Set the debugger in AdjList to see the difference:
D ---> [C [C D], D [R C], R [C]]
D ---> [R [C], C [C D], D [R C]]

Extension:  Depth First Search (Recursive)
B ---> [R [C], C [C D], D [R C]]
C ---> [D [R C], C [C D], R [C]]
D ---> [C [C D], D [R C], R [C]]
R ---> [C [C D], D [R C], R [C]]
 
******************************/