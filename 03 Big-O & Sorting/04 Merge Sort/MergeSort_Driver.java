// Name:
// Date:

import java.util.*;
import java.io.*;

public class MergeSort_Driver
{
   public static void main(String[] args) throws Exception
   {
      //Part 1, for doubles
      double[] array = {3,1,4,1,5,9,2,6};    // small example array from the MergeSort handout
      MergeSort.sort(array);
   
      print(array);
      if( isAscending(array) )
         System.out.println("In order!");
      else
         System.out.println("oops!");
         
      //Part 2, for Comparables
      int size = 100;
      Scanner sc = new Scanner(new File("declaration.txt"));
      Comparable[] arrayStr = new String[size];
      for(int k = 0; k < arrayStr.length; k++)
         arrayStr[k] = sc.next();	
   
      MergeSort.sort(arrayStr);
      print(arrayStr);
      System.out.println();
      if( isAscending(arrayStr) )
         System.out.println("In order!");
      else
         System.out.println("Out of order  :-( ");
   }

   
   public static void print(double[] a)   
   {                             
      for(double number : a)    
         System.out.print(number+" ");
      System.out.println();
   }
  
   public static boolean isAscending(double[] a)
   {
      for(int i = 1; i < a.length; i++) {
         if(a[i] < a[i-1])
            return false;
      }
      return true;
   }
  
   public static void print(Object[] peach)
   {
   
   }
   
   @SuppressWarnings("unchecked")
   public static boolean isAscending(Comparable[] a)
   {
      for(int i = 1; i < a.length; i++) {
         if(a[i].compareTo(a[i-1]) < 0)
            return false;
      }
      return true;

   }
}
/////////////////////////////////////////////
// 15 Oct 07
// MergeSort Code Handout
// from Lambert & Osborne, p. 482 - 485

class MergeSort
{
   private static final int CUTOFF = 10; // for small lists, recursion isn't worth it
  
   public static void sort(double[] array)
   { 
      double[] copyBuffer = new double[array.length];
      mergeSortHelper(array, copyBuffer, 0, array.length - 1);
   }
   
   /*  array			array that is being sorted
       copyBuffer		temp space needed during the merge process
       low, high		bounds of subarray
       middle			midpoint of subarray   
   */
   private static void mergeSortHelper(double[] array, double[] copyBuffer, int low, int high)
   {  
      // if ( high - low  < CUTOFF )                  //switch to selection sort  when
         // SelectionLowHigh.sort(array, low, high);        //the list gets small enough 
      // else
      int n = array.length;
      if (n < 2) {
         return;
      }
      int mid = n/2;
      double[] left = new double[mid];
      double[] right = new double[n-mid];
      
      for (int i = 0; i < mid; i++) {
         left[i] = array[i];
      }
      for (int i = mid; i < n; i++) {
         right[i-mid] = array[i];
      }
      mergeSortHelper(left, left, mid, mid);
      mergeSortHelper(right, right, n-mid, n-mid);
      
      merge(array, left, right, mid, n-mid);
   }
   
   /* array				array that is being sorted
      copyBuffer		temp space needed during the merge process
      low				beginning of first sorted subarray
      middle			end of first sorted subarray
      middle + 1		beginning of second sorted subarray
      high				end of second sorted subarray   
   */
   public static void merge(double[] array, double[] left, double[] right, int l, int r
   /*double[] array, double[] copyBuffer, int low, int middle, int high*/)
   {
      int i=0;
      int j=0;
      int k=0;
      while (i < l && j < r) {
         if (left[i] < right[j]) {
            array[k++] = left[i++];
         }
         else {
            array[k++] = right[j++];
         }
      }
      while (i < l) {
         array[k++] = left[i++];
      }
      while (j < r) {
         array[k++] = right[j++];
      }
   }	
      
   @SuppressWarnings("unchecked")//this removes the warning for Comparable
   public static void sort(Comparable[] array)
   { 
      Comparable[] copyBuffer = new Comparable[array.length];
      mergeSortHelper(array, copyBuffer, 0, array.length - 1);
   }

   /* array				array that is being sorted
      copyBuffer		temp space needed during the merge process
      low, high		bounds of subarray
      middle			midpoint of subarray  */
   @SuppressWarnings("unchecked")
   private static void mergeSortHelper(Comparable[] array, Comparable[] copyBuffer, int low, int high)
   {
      int n = array.length;
      if (n < 2) {
         return;
      }
      int mid = n/2;
      Comparable[] left = new Comparable[mid];
      Comparable[] right = new Comparable[n-mid];
      
      for (int i = 0; i < mid; i++) {
         left[i] = array[i];
      }
      for (int i = mid; i < n; i++) {
         right[i-mid] = array[i];
      }
      mergeSortHelper(left, left, mid, mid);
      mergeSortHelper(right, right, n-mid, n-mid);
      
      merge(array, left, right, mid, n-mid);
   }
   
   /* array				array that is being sorted
      copyBuffer		temp space needed during the merge process
      low				beginning of first sorted subarray
      middle			end of first sorted subarray
      middle + 1		beginning of second sorted subarray
      high				end of second sorted subarray   */
   @SuppressWarnings("unchecked")
   public static void merge(Comparable[] array, Comparable[] left, Comparable[] right, int l, int r)
   {
     int i=0;
      int j=0;
      int k=0;
      while (i < l && j < r) {
         if (left[i].compareTo(right[j]) < 0) {
            array[k++] = left[i++];
         }
         else {
            array[k++] = right[j++];
         }
      }
      while (i < l) {
         array[k++] = left[i++];
      }
      while (j < r) {
         array[k++] = right[j++];
      }

   }    	
}

/***************************************************
This is the extension.  You will have to uncomment Lines 89-90 above.
***************************************************/

class SelectionLowHigh
{
   public static void sort(double[] array, int low, int high)
   {  
   
   }
   private static int findMax(double[] array, int low, int upper)
   {
      return 0;
   }
   private static void swap(double[] array, int a, int b)
   {
   
   } 
}
