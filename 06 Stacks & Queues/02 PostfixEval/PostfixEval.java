// Name:
// Date:

import java.util.*;

public class PostfixEval
{
   public static final String operators = "+ - * / % ^ !";
   
   public static void main(String[] args)
   {
      System.out.println("Postfix  -->  Evaluate");
      ArrayList<String> postfixExp = new ArrayList<String>();
      /*  build your list of expressions here  */
       postfixExp.add("3 4 5 * +");
       postfixExp.add("3 4 * 5 +");
       postfixExp.add("10 20 + -6 6 * +");
       postfixExp.add("3 4 + 5 6 + *");
       postfixExp.add("3 4 5 + * 2 - 5 /");
       postfixExp.add("8 1 2 * + 9 3 / -");
       postfixExp.add("2 3 ^");
       postfixExp.add("20 3 %");
       postfixExp.add("21 3 %");
       postfixExp.add("22 3 %");
       postfixExp.add("23 3 %");
       postfixExp.add("5 !");
       postfixExp.add("1 1 1 1 1 + + + + !");
      
   
      
      for( String pf : postfixExp )
      {
         System.out.println(pf + "\t\t" + eval(pf));
      }
   }
   
   public static double eval(String pf)
   {
      Stack<Double> mather = new Stack<>();
      List<String> postfixParts = new ArrayList<String>(Arrays.asList(pf.split(" ")));
      /*  enter your code here  */
      /*
      when number put in stack
      when reach operator pop the two numbers out and do the operation, put result back in
      */
      Iterator<String> it = postfixParts.iterator();
      while(it.hasNext()) {
         String temp = it.next();
         if(isOperator(temp)) {
            if(temp.indexOf("!") != -1) {
               double a = mather.pop();
               double fact = 1;
               for(int i=1;i<=a;i++){    
                  fact=fact*i;    
               }    
               mather.push(fact);
            }
            else {
               double b = mather.pop();
               double a = mather.pop();
               mather.push(eval(a, b, temp));
            }
         }
         else {
            mather.push(Double.valueOf(temp));
         }
      }
      return mather.pop();
   }
   
   public static double eval(double a, double b, String ch)
   {
      switch(ch)
      {
         case "+": 
            return a+b;
         case "-": 
            return a-b;
         case "*": 
            return a*b;
         case "/": 
            return a/b;
         case "%": 
            return a%b;
         case "^": 
            return Math.pow((int) a, (int) b);
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

/**********************************************
Postfix  -->  Evaluate
 3 4 5 * +		23
 3 4 * 5 +		17
 10 20 + -6 6 * +		-6
 3 4 + 5 6 + *		77
 3 4 5 + * 2 - 5 /		5
 8 1 2 * + 9 3 / -		7
 2 3 ^		8
 20 3 %		2
 21 3 %		0
 22 3 %		1
 23 3 %		2
 5 !		120
 1 1 1 1 1 + + + + !		120
 
 
 *************************************/