// Name: 
// Date: 

import java.util.*;

interface Fibber
{
   public abstract int fib(int n);
}

public class Fib
{
   public static final int FIBsubN = 40;
   public static void main(String[] args)
   {
      System.out.println("******************************");
      Fib1 f1= new Fib1();
      System.out.println("Fib1, Recursive, no storing");
      calculate(f1, FIBsubN);
      System.out.println("Fib1 again with the same Fib1 object");
      calculate(f1, FIBsubN);
      System.out.println("Fib1 with a new Fib1 object");
      calculate(new Fib1(), FIBsubN);
      
      System.out.println("******************************");
      Fib2 f2 = new Fib2(FIBsubN + 1);
      System.out.println("Fib2, Iterative, stored in an array");
      calculate(f2, FIBsubN);
      System.out.println("Fib2 again with the same Fib2 object");
      calculate(f2, FIBsubN);      
      System.out.println("Fib2 with a new Fib2 object");
      calculate(new Fib2(FIBsubN + 1), FIBsubN);
      
      System.out.println("******************************");
      Fib3 f3 = new Fib3();
      System.out.println("Fib3, Recursive, stored in a static arrayList");
      calculate(f3, FIBsubN);
      System.out.println("Fib3 again with the same Fib3 object");
      calculate(f3, FIBsubN);
      System.out.println("Fib3 with a new Fib3 object");
      calculate(new Fib3(), FIBsubN);
      
      System.out.println("******************************");
      Fib4 f4 = new Fib4();
      System.out.println("Fib4, Recursive, stored in a static hashMap");
      calculate(f4, FIBsubN);
      System.out.println("Fib4 again with the same Fib4 object");
      calculate(f4, FIBsubN);
      System.out.println("Fib4 with a new Fib4 object");
      calculate(new Fib4(), FIBsubN);	
   }
      
   public static void calculate(Fibber fibber, int n)
   {
      long start = System.nanoTime();
      int f = fibber.fib(n);
      long finish = System.nanoTime();
      long time = finish - start;
      
      System.out.print("fib(" + n + ") = " + f);
      System.out.println(" (" + time + "nanoseconds)");		
      System.out.println();		
   }
}
    
class Fib1 implements Fibber
{
   public Fib1()    //default constructor
   {
   }
   public int fib(int n)
   {
      if(n<=2)
      	return 1;
      return fib(n-1) + fib(n-2);
   }
}
   
class Fib2 implements Fibber
{
   private int[] array;       //not static--it gets duplicated in each object 
   private int lastIndex;     //lastIndex calculated
   
   public Fib2(int n)
   {
      array = new int[n];
      array[1] = 1;      //first fibonacci number goes into index 1 (index 0 has a dummy value)
      array[2] = 1;
      lastIndex = 2; 
   }
  //precondition: n can't be bigger than the value used when creating the object
  // since the array is not static, you need to be clever with this code
   public int fib(int n)
   {
      for(int i = lastIndex+1; i<=n; i++) 
      	array[i] = array[i-1] + array[i-2];
      if(n>lastIndex)
         lastIndex = n;
      return array[n];
   }
   public int[] getArray()   //nice to have
   {
      return array;
   }
   
   public int getLastIndex()  //nice to have
   {
      return lastIndex;
   }
}
   
class Fib3 implements Fibber
{
   private static ArrayList<Integer> myFibList = new ArrayList<Integer>();  //what does static do?
   public Fib3()
   {
      if(myFibList.size() ==0) {
         myFibList.add(0, 0);
         myFibList.add(1, 1);
         myFibList.add(2, 1);
      }
   }
   public int fib(int n)
   {
      for(int i = myFibList.size(); i<=n; i++) 
      	myFibList.add(i, myFibList.get(i-1) + myFibList.get(i-2));
      return myFibList.get(n);
   }
   public static ArrayList<Integer> getArrayList()  //nice to have
   {
      return myFibList;
   }
}

class Fib4 implements Fibber
{
   private static Map<Integer, Integer> myFibMap;  
   public Fib4()
   {  //if the Map is null, . . .
      if (myFibMap ==null) {
         myFibMap = new HashMap<Integer, Integer>();
         myFibMap.put(1, 1);
         myFibMap.put(2, 1);
      }
   }
   public int fib(int n)
   {
      if(myFibMap.containsKey(n))
         return myFibMap.get(n);
      myFibMap.put(n, fib(n-1) + fib(n-2));
      return myFibMap.get(n);
   }
   public static Map<Integer, Integer> getMap()  //nice to have
   {
      return myFibMap;
   }
}
	
/**********************************************

******************************
 Fib1, Recursive, no storing
 fib(40) = 102334155 (288406761 nanoseconds)
 
 Fib1 again with the same Fib1 object
 fib(40) = 102334155 (257368643 nanoseconds)
 
 Fib1 with a new Fib1 object
 fib(40) = 102334155 (258617859 nanoseconds)
 
 ******************************
 Fib2, Iterative, stored in an array, stores lastIndex
 fib(40) = 102334155 (5401 nanoseconds)
 
 Fib2 again with the same Fib2 object
 fib(40) = 102334155 (1080 nanoseconds)
 
 Fib2 with a new Fib2 object
 fib(40) = 102334155 (3240 nanoseconds)
 
 ******************************
 Fib3, Recursive, stored in a static arrayList
 fib(40) = 102334155 (99376 nanoseconds)
 
 Fib3 again with the same Fib3 object
 fib(40) = 102334155 (3780 nanoseconds)
 
 Fib3 with a new Fib3 object
 fib(40) = 102334155 (3780 nanoseconds)
 
 ******************************
 Fib4, Recursive, stored in a static hashMap
 fib(40) = 102334155 (210093 nanoseconds)
 
 Fib4 again with the same Fib4 object
 fib(40) = 102334155 (5401 nanoseconds)
 
 Fib4 with a new Fib4 object
 fib(40) = 102334155 (5400 nanoseconds) ***********************************************/