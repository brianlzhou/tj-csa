// Name:
// Date:

import java.util.*;

public class ParenMatch
{
   public static final String LEFT  = "([{<";
   public static final String RIGHT = ")]}>";
   
   public static void main(String[] args)
   {
      System.out.println("Parentheses Match");
      ArrayList<String> parenExp = new ArrayList<String>();
      /* enter test cases here */
      parenExp.add("5 + 7");
      parenExp.add("( 15 + -7 )");
      parenExp.add(") 5 + 7 ( ");
      parenExp.add("( ( 5.0 - 7.3 ) * 3.5 )");
      parenExp.add("< { 5 + 7 } * 3 > ");
      parenExp.add("[ ( 5 + 7 ) * ]  3 ");
      parenExp.add("( 5 + 7 ) * 3");
      parenExp.add("5 + ( 7 * 3 )");
      parenExp.add("( ( 5 + 7 ) * 3 ");
      parenExp.add("[ ( 5 + 7 ] * 3 ) ");
      parenExp.add("[ ( 5 + 7 ) * 3 ] )");
      parenExp.add("( [ ( 5 + 7 ) * 3 ] ");
      parenExp.add("( ( ( ) $ ) )");
      parenExp.add("( ) [ ] ");

         
      for( String s : parenExp )
      {
         boolean good = checkParen(s);
         if(good)
            System.out.println(s + "\t good!");
         else
            System.out.println(s + "\t BAD");
      }
   }
     
   //returns the index of the left parentheses or -1 if it is not there
   public static int isLeftParen(String p)
   {
      return LEFT.indexOf(p);
   }
  
   //returns the index of the right parentheses or -1 if it is not there
   public static int isRightParen(String p)
   {
      return RIGHT.indexOf(p);
   }
   
   public static boolean checkParen(String exp)
   {
      /* enter your code here */
      //if nothing return true
      //if right paren return false
      Stack<Integer> paren = new Stack<>();
      Scanner scan = new Scanner(exp);
      while(scan.hasNext()){
         String token = scan.next();
         if(isLeftParen(token) != -1) {
            paren.push(isLeftParen(token));
         }
         else if(isRightParen(token) != -1) {
            if(paren.empty()) {
               // right paren without left paren
               return false;
            }
            else {
               if(paren.pop() != isRightParen(token)) {
                  return false;
               }
            }
         }
      }
      if(paren.empty()) {
         return true;
      }
      else {
         return false;
      }
      /*
      if left, add to stack
      next token
      if right, check stack -> if not empty stack, pop and compare
      if matching, keep going, if not return false   
      
      return true;  //so it compiles    */
   }
}

/*****************************************

Parentheses Match
5 + 7		 good!
( 15 + -7 )		 good!
) 5 + 7 (		 BAD
( ( 5.0 - 7.3 ) * 3.5 )		 good!
< { 5 + 7 } * 3 >		 good!
[ ( 5 + 7 ) * ] 3		 good!
( 5 + 7 ) * 3		 good!
5 + ( 7 * 3 )		 good!
( ( 5 + 7 ) * 3		 BAD
[ ( 5 + 7 ] * 3 )		 BAD
[ ( 5 + 7 ) * 3 ] )		 BAD
( [ ( 5 + 7 ) * 3 ]		 BAD
( ( ( ) $ ) )		 good!
( ) [ ]		 good!
 
 *******************************************/
