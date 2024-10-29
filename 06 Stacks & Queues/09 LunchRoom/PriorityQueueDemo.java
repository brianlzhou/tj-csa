import java.util.*;
public class PriorityQueueDemo
{
   public static void main(String [] args)
   {
      PriorityQueue<String> pq = new PriorityQueue<String>();
      //MyPriorityQueue pq = new MyPriorityQueue();
      pq.add("c");
      pq.add("b");
      pq.add("a");
      pq.add("d");
      pq.add("b");
      pq.add("a");
      pq.add("d");
      pq.add("b");
      pq.add("a");     
      while( !pq.isEmpty() )
         System.out.print( pq.remove() + " ");
   }
}