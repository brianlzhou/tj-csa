// Name:
// Date:
import java.text.DecimalFormat;

public class HeapSort
{
   public static int N;  //9 or 100
	
   public static void main(String[] args)
   {
      /* Part 1: Given a heap, sort it. Do this part first. */
      /*N = 9;  
      double heap[] = {-1,99,80,85,17,30,84,2,16,1};  // size of array = N+1
      
      display(heap);
      sort(heap);
      display(heap);
      System.out.println(isSorted(heap));*/
      
      /* Part 2:  Generate 100 random numbers, make a heap, sort it.  */
      N = 100;
      double[] heap = new double[N + 1];  // size of array = N+1
      heap = createRandom(heap);
      display(heap);
      makeHeap(heap, N);
      display(heap); 
      sort(heap);
      display(heap);
      System.out.println(isSorted(heap));
   }
   
	//******* Part 1 ******************************************
   public static void display(double[] array)
   {
      for(int k = 1; k < array.length; k++)
         System.out.print(array[k] + "    ");
      System.out.println("\n");	
   }
   
   public static void sort(double[] array)
   {
      /* enter your code here */
      for(int i = array.length-1; i>2; i--) {
         swap(array, 1, i);
         heapDown(array, 1, i-1);
      }
      
   
      if(array[1] > array[2])   //just an extra swap, if needed.
         swap(array, 1, 2);
   }
  
   public static void swap(double[] array, int a, int b)
   {
      double temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }
   
   public static void heapDown(double[] array, int k, int lastIndex)
   {
      int left = 2*k;
      int right = 2*k +1;
      

      
      if(left==lastIndex && array[k]<array[lastIndex])
         swap(array, k, lastIndex);
      else if (right > lastIndex) 
         return;
      else {
         int index;
         if(array[left] >= array[right])
            index = 2*k;
         else
            index = 2*k+1;
            
         if(array[k]<array[index]) {
            swap(array, k, index);
            heapDown(array, index, lastIndex);
         }
      }
   }
   
   public static boolean isSorted(double[] arr)
   {
      for(int i = 0; i<arr.length-1; i++) {
         if(arr[i] > arr[i+1])
            return false;
      }
      return true;
   }
   
   //****** Part 2 *******************************************

   //Generate 100 random numbers (between 1 and 100, formatted to 2 decimal places) 
   public static double[] createRandom(double[] array)
   {  
      array[0] = -1;   //because it will become a heap
      DecimalFormat d = new DecimalFormat("0.00");
      for (int i = 1; i < N+1; i++) {
         double temp = Math.random()*100+1;
         array[i] = Double.parseDouble(d.format(temp));
      } 
      return array;
   }
   
   //turn the random array into a heap
   public static void makeHeap(double[] array, int lastIndex)
   {
      for (int i = lastIndex/2; i>0; i--)
         heapDown(array, i, lastIndex);
   }
}

