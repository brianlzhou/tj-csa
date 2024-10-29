//  mlbillington@fcps.edu  11-2-2008. 
//	 demonstrates some of the List and LinkedList interfaces: 
//	 	size(), add(i, o), remove(i);  addFirst(o), addLast(o);  toString().
//  the list is zero-indexed.
//  Uses DLL
import java.util.LinkedList; 
public class DLL_Driver
{
   public static void main(String args[]) 
   {
      DLL list = new DLL();	
      //LinkedList<Object> list = new LinkedList();  //for comparison purposes
      list.addLast("Avocado");
      list.addLast("Banana");
      list.addLast("Cucumber");
      list.add("Durian");
      list.add("Eggplant");
      
      System.out.println("The list is " + list);
      System.out.println("Size: " + list.size());
      Object obj = list.remove(2);
      System.out.println("Remove index 2: "+ obj);
      System.out.println("The list is " + list);
      System.out.println("Size: " + list.size());
   
      list.add(2,"Carrot");
      System.out.println("Add Carrot at index 2:   " + list);
      list.add(0,"Apple");
      System.out.println("Add Apple at index 0:   " + list);
      
      System.out.println("Get values at index 0 and First: " + list.get(0)+" and " + list.getFirst());
      System.out.println("No change in list: " +list);
         
      list.removeFirst();
      System.out.println( "Remove the First:  " + list); 
       
      list.addFirst("Artichoke");
      System.out.println("Add First:  " + list);
      System.out.println("Size: " + list.size());
     
      System.out.println("Get Last: " + list.getLast());
      System.out.println(list);  
    
      System.out.println("Remove Last: " + list.removeLast());
      System.out.println(list);  
     
      Object oldValue = list.set(3, "Cherry");
      System.out.println("Set new value at index 3:  " + list);
      System.out.println("Old value was: " + oldValue);
    
      list.set(0, "Apricot");
      System.out.println("Set new value at index 0:  " + list);
      try
      {
         list.add(16,"Kiwi");       //test out-of-bounds
        // list.remove(100);         //test out-of-bounds
        // list.get(-1);            //test out-of-bounds
        // list.set(16,"Kiwi");     //test out-of-bounds
      }
      catch(IndexOutOfBoundsException e)
      {
         System.out.println(e);
      }
   }
}
  /********************************************
 The list is [Avocado, Banana, Cucumber, Durian, Eggplant]
 Size: 5
 Remove index 2: Cucumber
 The list is [Avocado, Banana, Durian, Eggplant]
 Size: 4
 Add Carrot at index 2:   [Avocado, Banana, Carrot, Durian, Eggplant]
 Add Apple at index 0:   [Apple, Avocado, Banana, Carrot, Durian, Eggplant]
 Get values at index 0 and First: Apple and Apple
 No change in list: [Apple, Avocado, Banana, Carrot, Durian, Eggplant]
 Remove the First:  [Avocado, Banana, Carrot, Durian, Eggplant]
 Add First:  [Artichoke, Avocado, Banana, Carrot, Durian, Eggplant]
 Size: 6
 Get Last: Eggplant
 [Artichoke, Avocado, Banana, Carrot, Durian, Eggplant]
 Remove Last: Eggplant
 [Artichoke, Avocado, Banana, Carrot, Durian]
 Set new value at index 3:  [Artichoke, Avocado, Banana, Cherry, Durian]
 Old value was: Carrot
 Set new value at index 0:  [Apricot, Avocado, Banana, Cherry, Durian]
 java.lang.IndexOutOfBoundsException: Index: 16, Size: 5
 
 
 ***********************************************/
