// Name:   
// Date:
 
import java.util.*;
import java.io.*;

/* For use with Graphs11: State Graphs,
   Heads-Tails-Heads
 */

class HTH_Driver
{
   public static void main(String[] args) throws FileNotFoundException
   {
      System.out.print("Enter the initial state, three H and/or T:  ");
      Scanner in = new Scanner(System.in);
      String initial = in.next().toUpperCase();
      Vertex v = makeGraph(initial);
      System.out.println("The state graph has been made.");
      
      while(true)
      {
         System.out.print("Enter the final state, three H and/or T:  ");
         String finalState = in.next().toUpperCase();;
         if( finalState.equals("-1") )
            break;
         v = findBreadth(v, finalState);
         System.out.println("The shortest path from "+initial+" to "+ finalState+ " is: ");
         System.out.println(initial);
         String s = "";
         while(v.previous != null)
         {
            s = v+"\n"+s;
            v = v.previous;
         }
         System.out.println(s);
      }
   }
   
   public static Vertex makeGraph(String s)
   {
   
   }
   
   public static Vertex findBreadth(Vertex v, String goal)
   {
      
   }
}

class Vertex
{
   private final boolean[] state;
   private List<Vertex> edges = new ArrayList<Vertex>();
   public Vertex previous;
   
}

/************************
 Enter the initial state, three H and/or T:  HTH
 The state graph has been made.
 Enter the final state, three H and/or T:  THT
 The shortest path from HTH to THT is: 
 HTH
 HHH
 HHT
 HTT
 TTT
 THT
 
 Enter the final state, three H and/or T:  HHH
 The shortest path from HTH to HHH is: 
 HTH
 HHH
 
 Enter the final state, three H and/or T:  -1
 

 *************************************/