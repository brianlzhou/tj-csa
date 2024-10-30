import java.util.*;
/*******************
Driver for a binary expression tree class.
Input: a postfix string, each token separated by a space.
**********************/
public class BXT_Driver
{
   public static void main(String[] args)
   {
      ArrayList<String> postExp = new ArrayList<String>();
      //postExp.add("A TreeNode is a form of a data structure in AP Computer Science. This is a binary tree, as each node may only have two children. It is written in inorder traversal, which traverses in the order of left, node, right. There is also preorder traversal, which is node left right, and postorder traversal, or left right node. This tree is also full.");
      postExp.add("14 -5 /");
      postExp.add("20.0 3.0 -4.0 + *");
      postExp.add("2 3 + 5 / 4 5 - *");
      postExp.add("2 3 + 5 / 4 5 - *");
      postExp.add("5 3 % 4 5 % +");
      postExp.add("5.6");
              
      for( String postfix : postExp )
      {
         System.out.println("Postfix Exp: "  + postfix);
         BXT tree = new BXT();
         tree.buildTree( postfix );
         System.out.print( tree.display() );
         System.out.print("Infix order:  ");
         System.out.println( tree.inorderTraverse() );
         System.out.print("Prefix order:  ");
         System.out.println( tree.preorderTraverse() );
         System.out.print("Evaluates to " + tree.evaluateTree());
         System.out.println( "\n------------------------");
      }
         
       /*  extension:  prints parentheses */
      // BXT tree2 = new BXT();
      // System.out.println("Extension.  Prints minimal parentheses.");
      // tree2.buildTree("20.0 3.0 -4 + *");   // "20.0 * ( 3.0 + -4 )"
      // System.out.println(tree2.inorderTraverseWithParentheses()); 
      // tree2.buildTree("20.0 3.0 -4 * +");   // "20.0 + 3.0 * -4"
      // System.out.println(tree2.inorderTraverseWithParentheses());   
      // tree2.buildTree("10 5 3 2 1 + * + * 5 +");   // "10 * ( 5 + 3 * ( 2 + 1 ) ) + 5"    //Codepost  
      // System.out.println(tree2.inorderTraverseWithParentheses()); 
   }
}
  
/***************************************

 Postfix Exp: 14 -5 /
 	-5
 /
 	14
 Infix order:  14 / -5 
 Prefix order:  / 14 -5 
 Evaluates to -2.8
 ------------------------
 Postfix Exp: 20.0 3.0 -4.0 + *
 		-4.0
 	+
 		3.0
 *
 	20.0
 Infix order:  20.0 * 3.0 + -4.0 
 Prefix order:  * 20.0 + 3.0 -4.0 
 Evaluates to -20.0
 ------------------------
 Postfix Exp: 2 3 + 5 / 4 5 - *
 		5
 	-
 		4
 *
 		5
 	/
 			3
 		+
 			2
 Infix order:  2 + 3 / 5 * 4 - 5 
 Prefix order:  * / + 2 3 5 - 4 5 
 Evaluates to -1.0
 ------------------------
 Postfix Exp: 2 3 + 5 / 4 5 - *
 		5
 	-
 		4
 *
 		5
 	/
 			3
 		+
 			2
 Infix order:  2 + 3 / 5 * 4 - 5 
 Prefix order:  * / + 2 3 5 - 4 5 
 Evaluates to -1.0
 ------------------------
 Postfix Exp: 5 3 % 4 5 % +
 		5
 	%
 		4
 +
 		3
 	%
 		5
 Infix order:  5 % 3 + 4 % 5 
 Prefix order:  + % 5 3 % 4 5 
 Evaluates to 6.0
 ------------------------
 Postfix Exp: 5.6
 5.6
 Infix order:  5.6 
 Prefix order:  5.6 
 Evaluates to 5.6
 ------------------------
 Extension.  Prints minimal parentheses.
 20.0 * ( 3.0 + -4 ) 
 20.0 + 3.0 * -4 
 10 * ( 5 + 3 * ( 2 + 1 ) ) + 5 
 
  ----jGRASP: operation complete.
     
 *******************************************/