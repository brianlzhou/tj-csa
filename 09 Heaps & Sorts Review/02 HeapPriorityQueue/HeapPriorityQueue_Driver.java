//Driver class to test the student's HeapPriorityQueue.
import java.util.*;

public class HeapPriorityQueue_Driver
{
   public static void main(String[] args)
   {
      //PriorityQueue<Integer> heap  = new PriorityQueue<>();        // java's PQ
      HeapPriorityQueue<Integer> heap = new HeapPriorityQueue();   //your implementation
     
      System.out.println( heap.peek() );                 
      boolean added = heap.add(5);           
      System.out.println( "Peek: " + heap.peek() ); 
      heap.add(1);
      heap.add(3);   
      heap.add(5);   
      heap.add(4);   
      heap.add(2);         
      System.out.println(heap.toString());                    
      // set the debugger here.  Make sure it acts like a min-heap.       
      for(int x=1; x<=6; x++)
         System.out.println( heap.remove() );                             
      System.out.println( heap.isEmpty() );   
       
      //add a lot, then remove half of them 
      for(int x = 0; x < 100; x++)
         heap.add((int)(Math.random() * 50));         
      for(int x = 0; x < 50; x++)
         heap.remove();
      System.out.println(heap.toString()); //is it a heap?
   }
}
/*  sample run
 null
 Peek: 5
 [null, 1, 4, 2, 5, 5, 3]
 1
 2
 3
 4
 5
 5
 true
 [null, 26, 28, 27, 29, 29, 28, 28, 29, 32, 30, 31, 29, 28, 35, 29, 34, 41, 33, 42, 40, 40, 31, 38, 33, 36, 36, 31, 39, 40, 38, 36, 37, 39, 43, 44, 41, 44, 49, 47, 47, 48, 49, 47, 32, 42, 49, 44, 47, 41, 43]
 */