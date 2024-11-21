import java.util.*;
public class MapPractice
{
   public static void main(String[] args)
   {
      Map<String, String>  h = new HashMap<String, String>();
      h.put("Othello", "green");
      h.put("MacBeth", "XXX");
      h.put("MacBeth", "red");  //what happens if two keys are the same?
      h.put("Hamlet", "blue"); 
      if(!h.containsKey("Lear"))
         h.put("Lear", "black");
      System.out.println( h.containsKey("Othello") );		
      System.out.println( h.keySet() );         //print the __________
      
      Iterator<String> it = h.keySet().iterator(); //using an iterator 
      while(it.hasNext())
         System.out.print( h.get(it.next()) );  //print the __________ 
      System.out.println();
          
      Map<String, String> t = new TreeMap<String, String>(h); //from HashMap to TreeMap
      for( String str : t.keySet() )            //must use a for-each
         System.out.print( t.get( str ) );      //print the __________ 
      System.out.println();
      System.out.println(t);                //print any Collection—wow!
   }
}

/******************
 
 true
 [Othello, Lear, MacBeth, Hamlet]
 greenblackredblue
 blueblackredgreen
 
 ************************/