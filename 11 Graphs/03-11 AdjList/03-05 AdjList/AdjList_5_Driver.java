   //lesson:  Graphs5: EdgeListCities
//uses AdjList

import java.util.*;
import java.io.*;
 
public class AdjList_5_Driver
{  
   public static void main(String[] args)throws FileNotFoundException
   {
      System.out.println("Edge List with Cities! ");
      Scanner kb = new Scanner(System.in);
      System.out.print("Enter file of cities: ");  //cities  //threeCities
      String fileOfCities = kb.next()+".txt";
      
      System.out.print("Enter file of edges: ");  
   									                  //cityEdges   //threeCitiesEdges
      String fileOfEdges = kb.next()+".txt";
      AdjList g = new AdjList();
      g.readData(fileOfCities, fileOfEdges);
     
      System.out.println("\nThe cities with their edges:");
      System.out.println(g.toString());  //print the graph
   	
      System.out.println("Number of vertices: " + g.vertexCount());
      System.out.println("Number of edges: " + g.edgeCount());
      
      System.out.print("\nIs this graph strongly connected? " + g.isStronglyConnected() + "\n" );
      
      while(true)
      {
         System.out.print("\nCan you get there from here?  \n\tStart at (-1 to exit): ");
         String from = kb.next();
         if(from.equals("-1"))
            break;
         System.out.print("\tEnd at: "); 
         String to = kb.next();  
         System.out.println( "\t\t" + g.isReachable(from, to) );  //step into isReachable()
      }
   }  
}
/**********************************

Edge List with Cities! 
Enter file of cities: cities
Enter file of edges: cityEdges

The cities with their edges:
Pendleton [Pueblo]
Pensacola [Phoenix]
Peoria [Pueblo Pittsburgh]
Phoenix [Pueblo Pittsburgh]
Pierre [Pendleton]
Pittsburgh [Pensacola Phoenix]
Princeton [Princeton Pittsburgh]
Pueblo [Pendleton Pierre]

Number of vertices: 8
Number of edges: 13

Is this graph connected? false

Can you get there from here?  
	Start at (-1 to exit): Pittsburgh
	End at: Pueblo
		true

Can you get there from here?  
	Start at (-1 to exit): Pueblo
	End at: Pittsburgh
		false

Can you get there from here?  
	Start at (-1 to exit): -1
 
****************************/