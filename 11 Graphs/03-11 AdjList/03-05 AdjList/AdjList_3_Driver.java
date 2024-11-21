   //lesson:  Graphs3: AdjList
//uses AdjList

import java.util.*;
import java.io.*;
 
public class AdjList_3_Driver
{  
   public static void main(String[] args)throws FileNotFoundException
   {
      System.out.println("Edge List Representation! ");
      System.out.println("Test the Vertex class");
      System.out.println("Add some vertices and adjacencies.");
      Vertex a = new Vertex("alpha");
      Vertex b = new Vertex("beta");
      a.addAdjacent(b);
      b.addAdjacent(a);
      b.addAdjacent(b);
      System.out.println("get the names:\n  " + a.getName() + "\n  " + b.getName() );
      System.out.println("get the set of adjacencies: \n  " + a.getAdjacencies() +"\n  " + b.getAdjacencies());
      System.out.println("toString() shows the names plus the name of the neighbor(s): \n  " + a.toString() +"\n  " + b.toString());
     
      System.out.println("\nTest the AdjList class");
      AdjList g = new AdjList();
      System.out.println("Adding some vertices and edges.");
      g.addVertex("A");    
      g.addVertex("B"); 
      g.addVertex("C");
      g.addVertex("D");                  
      g.addVertex("R");
      g.addEdge("A", "C"); 
      g.addEdge("B", "A");  // <-- warning! Do not add a new Vertex("A").  You must get
                           // the old Vertex B and addAdjacent() the old Vertex A.
      g.addEdge("C", "C");
      g.addEdge("C", "D");
      g.addEdge("C", "R");
      g.addEdge("D", "C");
      g.addEdge("D", "A");
      System.out.println("set of vertices in the graph:  " + g.getVertices());
      System.out.println("map string to vertex:  " + g.getVertexMap());  
      System.out.println("get a vertex by name \"B\":  " + g.getVertex("B").toString());  
      System.out.println("\ntoString the whole graph:\n"+g.toString()); 
   }
}

/***************************
 Edge List Representation! 
 Test the Vertex class
 Add some vertices and adjacencies.
 get the names:
   alpha
   beta
 get the set of adjacencies: 
   [beta [alpha beta]]
   [alpha [beta], beta [alpha beta]]
 toString() shows the names plus the name of the neighbor(s): 
   alpha [beta]
   beta [alpha beta]
 
 Test the AdjList class
 Adding some vertices and edges.
 set of vertices in the graph:  [A [C], B [A], R [], C [R C D], D [A C]]
 map string to vertex:  {A=A [C], B=B [A], C=C [R C D], D=D [A C], R=R []}
 get a vertex by name "B":  B [A]
 
 toString the whole graph:
 A [C]
 B [A]
 C [R C D]
 D [A C]
 R []
 
**********************************/