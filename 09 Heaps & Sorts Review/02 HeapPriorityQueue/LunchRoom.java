//Driver class, to use with the student's HeapPriorityQueue.
import java.util.*;
import java.lang.*;

public class LunchRoom
{
   public static void main(String[] args)
   {
      int MINUTES_OPEN = 1080;
      int SERVICE_AREAS = 3;
     // PriorityQueue<Student> heap  = new PriorityQueue<>();     // java's PQ
      HeapPriorityQueue<Student> heap = new HeapPriorityQueue<>(); // your heap implementation
   
     /*--implement the PriorityQueue API in your HeapPriorityQueue so that these all work ----------*/
      System.out.println( heap.peek() );                 //null
      boolean added = heap.add(new Student(1, "2018"));           //add a Freshman
      added = heap.add(new Student(4, "2015"));                   //add a Senior after the Freshman
      System.out.println( heap.peek() );                 //4 2015     
      System.out.println( heap.remove() );               //4 2015
      System.out.println( heap.isEmpty() );              //false
      System.out.println( heap.remove() );               //1 2018
      System.out.println( heap.isEmpty() );              //true
      System.out.println( "------------------");
     /*-----now begin the LunchRoom lab  -----------------------------------------*/
      int[] totalCustomers = new int[4];
      int[] longestWait = new int[4];
      int[] totalWait = new int[4];
      int[] timeServing = new int[SERVICE_AREAS];
      Student[] customers = new Student[SERVICE_AREAS];
      for(int m=0;m<=MINUTES_OPEN || !heap.isEmpty() || customers[0]!=null || customers[1] !=null || customers[2] != null;m++)
      {
         String s = "[";
         boolean b = false;
         for(int i=0;i<SERVICE_AREAS;i++)
         {
            if(customers[i]!=null)
            {
               b=true;
               s+=customers[i] + ", ";
            }
         }
         if(heap.isEmpty() && b)
            s=s.substring(0, s.length()-2) + "]";
         else
            s += heap.toString().substring(1);
         System.out.println(m + ": " + s);
      
         if(Math.random()<0.7 && m<MINUTES_OPEN)  // increase the frequency of arrivals
         {
            double d = Math.random();
            if(d<0.25)
               heap.add(new Freshman(m));
            else if(d<0.5)
               heap.add(new Sophomore(m));
            else if(d<0.75)
               heap.add(new Junior(m));
            else
               heap.add(new Senior(m));
         }
         for(int i=0;i<SERVICE_AREAS;i++)
            if(customers[i]==null && !heap.isEmpty())
               customers[i]=heap.remove();
         for(int i=0;i<SERVICE_AREAS;i++)
            if(customers[i]!=null)
               timeServing[i]++;
         
         for(int i=0;i<SERVICE_AREAS;i++)
            if(customers[i]!=null && timeServing[i]==customers[i].getService())
            {
               timeServing[i] = 0;
               int wait = m - customers[i].getArrival();
               if(customers[i] instanceof Freshman)
               {
                  totalWait[0]+=wait;
                  totalCustomers[0]++;
                  longestWait[0] = Math.max(wait, longestWait[0]);
               }
               if(customers[i] instanceof Sophomore)
               {
                  totalWait[1]+=wait;
                  totalCustomers[1]++;
                  longestWait[1] = Math.max(wait, longestWait[1]);
               }
               if(customers[i] instanceof Junior)
               {
                  totalWait[2]+=wait;
                  totalCustomers[2]++;
                  longestWait[2] = Math.max(wait, longestWait[2]);
               }
               if(customers[i] instanceof Senior)
               {
                  totalWait[3]+=wait;
                  totalCustomers[3]++;
                  longestWait[3] = Math.max(wait, longestWait[3]);
               }
               if(!heap.isEmpty())
                  customers[i]=heap.remove();
               else
                  customers[i]=null;
            }
      }
      System.out.println("Customer\tTotal Served\tLongest Wait\tAverage Wait");
      for(int i=3;i>=0;i--)
      {
         double averageWait = (double) totalWait[i]/totalCustomers[i];
         if(i==3)
            System.out.print("Senior\t\t");
         if(i==2)
            System.out.print("Junior\t\t");
         if(i==1)
            System.out.print("Sophomore\t");
         if(i==0)
            System.out.print("Freshman\t");
         System.out.println(totalCustomers[i] + "\t\t" + longestWait[i] + "\t\t" + averageWait);
      }
   }
}
class Student implements Comparable<Student>
{
   private String myGradYear;
   private int arrivalTime;
   private int serviceTime;
   public Student(int arrTime, String year)
   {
      arrivalTime=arrTime;
      serviceTime = (int) (Math.random() * 6 + 2);
      myGradYear = year;
   }

   public int compareTo(Student obj)
   {
      return Integer.parseInt(myGradYear) - Integer.parseInt(obj.myGradYear);
   }
   public int getService()
   {
      return serviceTime;
   }
   public int getArrival()
   {
      return arrivalTime;
   }
   public String toString()
   {
      return arrivalTime + " " + myGradYear;
   }
}
class Senior extends Student
{
   public Senior(int arrTime)
   {
      super(arrTime, "2015");
   }
}
class Junior extends Student
{
   public Junior(int arrTime)
   {
      super(arrTime, "2016");
   }
}
class Sophomore extends Student
{
   public Sophomore(int arrTime)
   {
      super(arrTime, "2017");
   }
}
class Freshman extends Student
{
   public Freshman(int arrTime)
   {
      super(arrTime, "2018");
   }
}