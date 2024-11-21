// mlbillington@fcps.edu on 6.12.2014, May 2022
// ejurj@fcps.edu  May 2022

//teacher's driver for Graph 6, using AdjListWeighted   
// hard-coded A-B-C-D   	
import java.util.*;
import java.io.*;

public class Dijkstra_6_Driver 
{
   public static void main(String[] args) throws FileNotFoundException 
   {   
      /********** test the individual classes **********/ 
      System.out.println("Testing wVertex");
      wVertex a = new wVertex("alpha");
      wVertex b = new wVertex("beta");
      a.addAdjacent(b, 5);
      b.addAdjacent(a, 3);
      System.out.println("get the names:\n  " + a.getName() + "\n  " + b.getName() );
      System.out.println("get the list of Neighbors: \n  " + a.getNeighbors() +"\n  " + b.getNeighbors());
    
      System.out.println("\nTesting Neighbor");
      Neighbor n1 = new Neighbor(a, 100);
      Neighbor n2 = new Neighbor(a, 101);
      System.out.println("Neighbor's toString(): " + n1.toString());
      System.out.println("Neighbor's toString(): " + n2.toString());
      System.out.println("Neighbors are equal if the names are the same: " + n1.compareTo(n2));
   
      System.out.println("\nTesting PQelement");
      PQelement e1 = new PQelement(a, 10);
      PQelement e2 = new PQelement(b, 11);
      System.out.println("PQelement's toString(): " + e1.toString());
      System.out.println("PQelement's toString(): " + e2.toString());
      System.out.println("Comparing two PQelements returns the difference in distance: " + e1.compareTo(e2));
      System.out.println("toString() shows the name, the name and distance to the neighbor(s), and the list of PQelements: \n  " + a.toString() +"\n  " + b.toString());
      
      System.out.println("\nTesting wVertex's PQelements");
      wVertex g = new wVertex("gamma");
      wVertex d = new wVertex("delta");
      System.out.println("Adding gamma and delta to alpha's list of PQelement");
      a.setDistanceToVertex( g, 20 );
      a.setDistanceToVertex( d, 21 );
      System.out.println("Get alpha's list of reachables: " + a.getAlDistanceToVertex());
      System.out.println("Get the PQelement which is wVertex g: " + a.getPQelement( g ));
      System.out.println("Get the PQelement which is wVertex d: " + a.getPQelement( d ));
      
   /********** test the AdjListWeighted graph **********/
      AdjListWeighted graph = new AdjListWeighted();
      System.out.println("\nHard-coding vertices and neighbors with weights.");
      graph.addVertex("A");
      graph.addVertex("B");
      graph.addVertex("C");
      graph.addVertex("D"); 
      graph.addEdge("A","B", 9); 
      graph.addEdge("A","C", 3); 
      graph.addEdge("C","B", 5); 
      graph.addEdge("C","D", 2);
      graph.addEdge("D","B", 1); 
      
      /********** testing the graph **********/
      System.out.println("Get the vertex by name \"A\": " + graph.getVertex("A")); 
      System.out.println("Get the vertices: " + graph.getVertices()); 
      System.out.println("Get the map: " + graph.getVertexMap()); 
      System.out.println("The whole graph:\n" + graph.toString());  
         
      /**********  Start Dijkstra's ************/   	
      System.out.println("Dijkstra's Algorithm!");
      Scanner key = new Scanner(System.in);
      System.out.print("Enter source: " );
      String source = key.next(); 
      if(source.equals("-1")) 
         System.exit(1);
      wVertex vSource = graph.getVertex(source);
      graph.minimumWeightPath(source);   //runs Dijkstra's Algorithm
      System.out.println("\nAfter processing, the entire graph is:\n" + graph); 
      System.out.println("State of the source vertex: " + graph.getVertex(source).getName());
      System.out.println( graph.getVertex(source).toString() );
      System.out.println();
      //insert breakpoint. Look at graph. 
      
      System.out.println("The source "+ vSource.getName() + " knows the distance to each target:");
      for (PQelement pq : vSource.getAlDistanceToVertex()) //prints all the distances from the source
         System.out.println("Distance to " + pq.getVertex().getName() + ": " + vSource.getDistanceToVertex(pq.getVertex()));
   }
}

/***********************************

 Testing wVertex
 get the names:
   alpha
   beta
 get the list of Neighbors: 
   [beta 5.0]
   [alpha 3.0]
 
 Testing Neighbor
 Neighbor's toString(): alpha 100.0
 Neighbor's toString(): alpha 101.0
 Neighbors are equal if the names are the same: 0
 
 Testing PQelement
 PQelement's toString(): alpha 10.0
 PQelement's toString(): beta 11.0
 Comparing two PQelements returns the difference in distance: -1
 toString() shows the name, the name and distance to the neighbor(s), and the list of PQelements: 
   alpha [beta 5.0] List: []
   beta [alpha 3.0] List: []
 
 Testing wVertex's PQelements
 Adding gamma and delta to alpha's list of PQelement
 Get alpha's list of reachables: [gamma 20.0, delta 21.0]
 Get the PQelement which is wVertex g: gamma 20.0
 Get the PQelement which is wVertex d: delta 21.0
 
 Hard-coding vertices and neighbors with weights.
 Get the vertex by name "A": A [B 9.0, C 3.0] List: []
 Get the vertices: [A [B 9.0, C 3.0] List: [], B [] List: [], C [B 5.0, D 2.0] List: [], D [B 1.0] List: []]
 Get the map: {A=A [B 9.0, C 3.0] List: [], B=B [] List: [], C=C [B 5.0, D 2.0] List: [], D=D [B 1.0] List: []}
 The whole graph:
 A [B 9.0, C 3.0] List: []
 B [] List: []
 C [B 5.0, D 2.0] List: []
 D [B 1.0] List: []
 
 Dijkstra's Algorithm!
 Enter source: A
 
 After processing, the entire graph is:
 A [B 9.0, C 3.0] List: [A 0.0, B 6.0, C 3.0, D 5.0]
 B [] List: []
 C [B 5.0, D 2.0] List: []
 D [B 1.0] List: []
 
 State of the source vertex: A
 A [B 9.0, C 3.0] List: [A 0.0, B 6.0, C 3.0, D 5.0]
 
 The source A knows the distance to each target:
 Distance to A: 0.0
 Distance to B: 6.0
 Distance to C: 3.0
 Distance to D: 5.0
 
 
 **********************************************/