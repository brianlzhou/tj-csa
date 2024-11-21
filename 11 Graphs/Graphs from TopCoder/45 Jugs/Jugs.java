// Name:   
// Date:
 
import java.util.*;
import java.io.*;

public class Jugs
{
   public static void main(String[] args) throws Exception
   {
      solve(3, 5, 4);  //replace this line
   }
	
   public static void solve(int a, int b, int n)
   {
      //Build a graph of the possible Jug pair states, 
      //given a as the capacity of the first jug, b as the capacity of the second jug, 
      Jug startJug = createGraph(a, b); 
      
      //Given n as the desired measurement of liquid,
      //print the solution to the given Jug problem using breadth-first search
      findReachableBreadth(startJug, a, b, n); 
   }
	
	//Breadth-first search from EdgeList
   public static void findReachableBreadth(Jug v, int ac, int bc, int n)
   {
     
   }
   
   public static Jug createGraph(int a, int b)
   {
   	/* Use a HashMap mapping a string representing the state of the jugs
   	   (e.g. "1 2") to its analagous Jug object (e.g. Jug(1, 2)) */
      HashMap<String, Jug> map = new HashMap<String, Jug>();
   
      /*It's easier if you first add every possible Jug combination to the map, ignoring whether the Jug can be reached.
         Use nested for-loops. */
   
      
   
   	/* For each Jug object in the map, add an edge to every other Jug that can be reached from the present state.
   		In other words, add an edge for the filling of either jug, the emptying of either jug, or the pouring of
   		one jug into the other. */  
         
         
         
      return map.get("0 0"); //Return starting point of the graph (empty jugs)
   }
}

/* The Jug object is a representation of the state of the pair of jugs.
 * Jug is a slight modification of the Vertex class from EdgeList.
 */
class Jug 
{
   private final int a, b; //a is the volume of the liquid in the first jug, b is the second jug
   private HashSet<Jug> edges = new HashSet<Jug>(); //Adjacency List


}
