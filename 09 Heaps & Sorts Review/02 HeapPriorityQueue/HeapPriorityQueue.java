 //Name:   
 //Date:
 
import java.util.*;

/* implement the API for java.util.PriorityQueue
 *     a min-heap of objects in an ArrayList<E> in a resource class
 * test this class with HeapPriorityQueue_Driver.java.
 * test this class with LunchRoom.java.
 * add(E) and remove()  must work in O(log n) time
 */
public class HeapPriorityQueue<E extends Comparable<E>> 
{
   private ArrayList<E> myHeap;
   
   public HeapPriorityQueue()
   {
      myHeap = new ArrayList<E>();
      myHeap.add(null);
   }
   
   public ArrayList<E> getHeap()   //for Codepost
   {
      return myHeap;
   }
   
   public int lastIndex()
   {
      return myHeap.size()-1;
   }
   
   public boolean isEmpty()
   {
      return myHeap.size()==1;
   }
   
   public boolean add(E obj)
   {
      myHeap.add(obj);
      heapUp(lastIndex());
      return true;
   }
   
   public E remove()
   {
      swap(1, lastIndex());
      E temp = myHeap.get(lastIndex());
      myHeap.remove(lastIndex());
      heapDown(1, lastIndex()-1);
      return temp;
   }
   
   public E peek()
   {
      if (this.isEmpty())
         return null;
      else
         return myHeap.get(1);
   }
   
   //  it's a min-heap of objects in an ArrayList<E> in a resource class
   public void heapUp(int k)
   {
      int root = k/2;
      if(root < 1)
         return;
      else if(myHeap.get(root).compareTo(myHeap.get(k))> 0) {
         swap(root, k);
         heapUp(root);
      }
   }
   
   private void swap(int a, int b)
   {
      int temp = a;
      a = b;
      b = temp;
   }
   
  //  it's a min-heap of objects in an ArrayList<E> in a resource class
   public void heapDown(int k, int lastIndex)
   {
      int left = 2*k;
      int right = 2*k +1;
      
      if(left>lastIndex)
         return;
      else if(left==lastIndex)
         if(myHeap.get(k).compareTo(myHeap.get(left))>0)
            swap(left, k);
      //else if (right > lastIndex) 
      //   return;
      else {
         int index;
         if(myHeap.get(left).compareTo(myHeap.get(right)) < 0)
            index = 2*k;
         else
            index = 2*k+1;
            
         if(myHeap.get(k).compareTo(myHeap.get(index)) > 0) {
            swap(k, index);
            heapDown(index, lastIndex);
         }
      }
   }
   
   public String toString()
   {
      return myHeap.toString();
   }  
}
