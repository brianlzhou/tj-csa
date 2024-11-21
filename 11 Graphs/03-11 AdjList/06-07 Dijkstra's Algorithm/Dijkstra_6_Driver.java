//driver for Graph 6, using AdjListWeighted   
import java.util.*;
import java.io.*;
public class Dijkstra_6_Driver
{
   public static void main(String[] args) throws FileNotFoundException 
   {
   /* Graphs 6 Dijkstra:  hard-coded A-B-C-D   	*/
   
      AdjListWeighted graph = new AdjListWeighted();
      graph.addVertex("A");
      graph.addVertex("B");
      graph.addVertex("C");
      graph.addVertex("D"); 
      graph.addEdge("A","B", 9); 
      graph.addEdge("A","C", 3); 
      graph.addEdge("C","B", 5); 
      graph.addEdge("C","D", 2);
      graph.addEdge("D","B", 1);    	
      Scanner key = new Scanner(System.in);
      while(true)
      {
         System.out.print("Enter source: " );
         String source = key.next(); 
         if(source.equals("-1")) 
            break;
         wVertex vSource = graph.getVertex(source);
         graph.minimumWeightPath(source);   //runs Dijkstra's Algorithm
         System.out.println( "data structure at source: " + graph.getVertex(source).toString() );
      //insert breakpoint. Look at graph.
         for (PQelement pq : vSource.getAlDistanceToVertex()) //prints all the distances from the source
         {
            System.out.println("Distance to " + pq.getVertex().getName() + ": " + vSource.getDistanceToVertex(pq.getVertex()));
         }
         System.out.println("\n\nThe entire graph is:\n" + graph);    
      
      }
   }
}

/***********************************

Enter source: A
data structure at source: A [B 9.0, C 3.0] Distances: [A 0.0, B 6.0, C 3.0, D 5.0]
Distance to A: 0.0
Distance to B: 6.0
Distance to C: 3.0
Distance to D: 5.0


The entire graph is:
A [B 9.0, C 3.0] Distances: [A 0.0, B 6.0, C 3.0, D 5.0]
B [] Distances: []
C [B 5.0, D 2.0] Distances: []
D [B 1.0] Distances: []

Enter source: B
data structure at source: B [] Distances: [A Infinity, B 0.0, C Infinity, D Infinity]
Distance to A: Infinity
Distance to B: 0.0
Distance to C: Infinity
Distance to D: Infinity


The entire graph is:
A [B 9.0, C 3.0] Distances: [A 0.0, B 6.0, C 3.0, D 5.0]
B [] Distances: [A Infinity, B 0.0, C Infinity, D Infinity]
C [B 5.0, D 2.0] Distances: []
D [B 1.0] Distances: []

Enter source: -1   
 ******************************/