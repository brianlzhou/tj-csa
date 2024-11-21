// driver for Graph 7 using AdjListWeighted
//    read from data files  
//    prints cities, distances, and paths     
import java.util.*;
import java.io.*;
public class Dijkstra_7_Driver
{
   public static void main(String[] args) throws FileNotFoundException 
   {
      System.out.println("Dijkstra's Algorithm with cities!");
      Scanner key = new Scanner(System.in);
      System.out.print("Enter file of cities: ");  //cities  
      String fileOfCities = key.next()+".txt";
      System.out.print("Enter file of edges: ");  //cityEdgesWeighted						                  
      String fileOfEdges = key.next()+".txt";
      
      AdjListWeighted g = new AdjListWeighted();
      g.readData(fileOfCities, fileOfEdges);
      System.out.print("Enter source: " );
      String source = key.next();
      wVertex vSource = g.getVertex(source); 
      g.minimumWeightPath(source);  //runs Dijkstra's Algorithm
      System.out.println("\nThe entire graph is:\n" + g); 
      System.out.println("Data structure of the source vertex: " + g.getVertex(source).getName());
      System.out.println( g.getVertex(source).toString() );
     //insert breakpoint. Look at graph.
      System.out.println();
      
      for (wVertex v : g.getVertices()) //prints the distances and path from source
      {
         System.out.println("Distance from source to " + v.getName() + ": " + vSource.getDistanceToVertex(v));
         List<String> path = g.getShortestPathTo(vSource, v);
         System.out.println("     path: " + path);
      }   
   }
}
/**************************************************
 Dijkstra's Algorithm with cities!
 Enter file of cities: cities
 Enter file of edges: cityEdgesWeighted
 Enter source: Peoria
 
 The entire graph is:
 Pendleton [Pueblo 8.0] List: []
 Pensacola [Phoenix 5.0] List: []
 Peoria [Pueblo 3.0, Pittsburgh 5.0] List: [Pensacola 9.0 Previous: Pittsburgh, Pendleton 8.0 Previous: Pierre, Pierre 6.0 Previous: Pueblo, Princeton Infinity Previous: null, Pueblo 3.0 Previous: Peoria, Peoria 0.0 Previous: null, Phoenix 14.0 Previous: Pensacola, Pittsburgh 5.0 Previous: Peoria]
 Phoenix [Pueblo 3.0, Pittsburgh 10.0] List: []
 Pierre [Pendleton 2.0] List: []
 Pittsburgh [Pensacola 4.0, Phoenix 10.0] List: []
 Princeton [Princeton 5.0, Pittsburgh 2.0] List: []
 Pueblo [Pendleton 8.0, Pierre 3.0] List: []
 
 Data structure of the source vertex: Peoria
 Peoria [Pueblo 3.0, Pittsburgh 5.0] List: [Pensacola 9.0 Previous: Pittsburgh, Pendleton 8.0 Previous: Pierre, Pierre 6.0 Previous: Pueblo, Princeton Infinity Previous: null, Pueblo 3.0 Previous: Peoria, Peoria 0.0 Previous: null, Phoenix 14.0 Previous: Pensacola, Pittsburgh 5.0 Previous: Peoria]
 
 Distance from source to Pensacola: 9.0
      path: [Peoria, Pittsburgh, Pensacola]
 Distance from source to Pendleton: 8.0
      path: [Peoria, Pueblo, Pierre, Pendleton]
 Distance from source to Pierre: 6.0
      path: [Peoria, Pueblo, Pierre]
 Distance from source to Princeton: Infinity
      path: [Princeton]
 Distance from source to Pueblo: 3.0
      path: [Peoria, Pueblo]
 Distance from source to Peoria: 0.0
      path: [Peoria]
 Distance from source to Phoenix: 14.0
      path: [Peoria, Pittsburgh, Pensacola, Phoenix]
 Distance from source to Pittsburgh: 5.0
      path: [Peoria, Pittsburgh]
 
   
********************************************/