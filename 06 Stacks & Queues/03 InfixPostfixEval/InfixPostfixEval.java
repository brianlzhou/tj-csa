// Name:
// Date:
//uses PostfixEval

import java.util.*;
public class InfixPostfixEval
{
   public static final String LEFT  = "([{<";
   public static final String RIGHT = ")]}>";
   public static final String operators = "+ - * / % ^ !";
   
   public static void main(String[] args)
   {
      System.out.println("Infix  \t-->\tPostfix\t\t-->\tEvaluate");
      /*build your list of Infix expressions here  */
      List<String> infixExp = new ArrayList<>();
      infixExp.add("5 - 1 - 1");
      infixExp.add("5 - 1 + 1");
      infixExp.add("12 / 6 / 2");
      infixExp.add("3 + 4 * 5");
      infixExp.add("3 * 4 + 5");
      infixExp.add("1.3 + 2.7 + -6 * 6");
      infixExp.add("( 33 + -43 ) * ( -55 + 65 )");
      infixExp.add("8 + 1 * 2 - 9 / 3");
      infixExp.add("3 * ( 4 * 5 + 6 )");
      infixExp.add("3 + ( 4 - 5 - 6 * 2 )");
      infixExp.add("2 + 7 % 3");
      infixExp.add("( 2 + 7 ) % 3");    
      //codepost tests
      infixExp.add("New cases");
      infixExp.add("8 + 1 * 2 - 9 / 3");
      infixExp.add("5 + [ 2 - ( 1 + 3 ) + 4 % 3 ]");
      infixExp.add("4 - 3 + 2 + 5 * 2 / 3 % 2");   
         
         
         
         
      for( String infix : infixExp )
      {
         String pf = infixToPostfix(infix);  //get the conversion to work first
         System.out.println(infix + "\t\t\t" + pf );  
      }
   }
   
   public static String infixToPostfix(String infix)
   {
      List<String> nums = new ArrayList<String>(Arrays.asList(infix.split(" ")));
      /* enter your code here  */
      Iterator<String> it = nums.iterator();
      Stack<String> ops = new Stack<>();
      String returner = "";
      boolean first = true;
      boolean paren = false;
      boolean brack = false;
      while(it.hasNext()) {
         String temp = it.next();
         if(temp.equals("(")) {
            ops.push("(");
            paren = true;
         }
         else if(temp.equals(")")) {
            while(!ops.peek().equals("(")) {
               returner = returner + " " + ops.pop();
            }
            ops.pop();
            paren = false;
         }
         else if(temp.equals("[")) {
            ops.push("[");
            brack = true;
         }
         else if(temp.equals("]")) {
            while(!ops.peek().equals("[")) {
               returner = returner + " " + ops.pop();
            }
            ops.pop();
            brack = false;
         }

         else if(isOperator(temp)) {
            
            if(ops.empty()) {
               ops.push(temp);
            }          
            else if(isHigherOrEqual(ops.peek(), temp)) {
               while(!ops.empty() && isHigherOrEqual(ops.peek(), temp)) {
                  returner = returner + " " + ops.pop();
               }
               ops.push(temp);
               
            }
            else {
               ops.push(temp);
            }

         }
         else {
            if(first) {
               returner = returner + temp;
               first = false;
            }
            else{returner = returner + " " + temp;}
         }
      }
      while(!ops.empty()) {
         returner = returner + " " + ops.pop();
      }
      return returner;
   }
   
   //enter your precedence method below
   public static boolean isHigherOrEqual(String top, String next) {
      int num = precedence(top);
      int numtwo = precedence(next);
      if(num-numtwo >= 0) {
         return true;
      }
      return false;
   }
   public static boolean isEqual(String top, String next) {
      int num = precedence(top);
      int numtwo = precedence(next);
      if(num-numtwo == 0) {
         return true;
      }
      return false;
   }
   
   public static int precedence(String op) 
   {
      switch(op)
      {
         case "+": 
            return 1;
         case "-": 
            return 1;
         case "*": 
            return 2;
         case "/": 
            return 2;
         case "%": 
            return 2;
         case "^": 
            return 3;
         default:
      }
      return -100000000;
   }
   
   public static boolean isOperator(String op)
   {
      if(operators.indexOf(op) != -1) {
         return true;
      }
      return false;
   }
   
}


/********************************************

Infix  	-->	Postfix		-->	Evaluate
 5 - 1 - 1			5 1 - 1 -			3.0
 5 - 1 + 1			5 1 - 1 +			5.0
 12 / 6 / 2			12 6 / 2 /			1.0
 3 + 4 * 5			3 4 5 * +			23.0
 3 * 4 + 5			3 4 * 5 +			17.0
 1.3 + 2.7 + -6 * 6			1.3 2.7 + -6 6 * +			-32.0
 ( 33 + -43 ) * ( -55 + 65 )			33 -43 + -55 65 + *			-100.0
 8 + 1 * 2 - 9 / 3			8 1 2 * + 9 3 / -			7.0
 3 * ( 4 * 5 + 6 )			3 4 5 * 6 + *			78.0
 3 + ( 4 - 5 - 6 * 2 )			3 4 5 - 6 2 * - +			-10.0
 2 + 7 % 3			2 7 3 % +			3.0
 ( 2 + 7 ) % 3			2 7 + 3 %			0.0
      
***********************************************/
