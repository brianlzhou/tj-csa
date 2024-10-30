// Name: 
// Date:  
/*  Represents a binary expression tree.
 *  The BXT builds itself from postorder expressions. It can
 *  evaluate and print itself.  Also prints inorder and postorder strings. 
 */
 
import java.util.*;

public class BXT
{
   public static final String operators = "+ - * / % ^ !";
   private TreeNode root;   
   
   public BXT()
   {
      root = null;
   }
   public TreeNode getRoot()   //for Codepost
   {
      return this.root;
   }
    
   public void buildTree(String str)
   {
      Stack<TreeNode> t = new Stack<>();
      List<String> b = new ArrayList<String>(Arrays.asList(str.split(" ")));
      Iterator<String> it = b.iterator();
      int count = 0;
      while(it.hasNext()) {
         String temp = it.next();
         if(isOperator(temp)) {
            //if(count == 2) {
               TreeNode ae = t.pop();
               TreeNode be = t.pop();
               t.push(new TreeNode(temp, be, ae));
               count = 0;
            //}
            /*if(count == 1) {
               t.push(new TreeNode(temp, t.pop(), t.pop()));
               count = 0;
            }*/
         }
         else {
            if(temp.contains("."))
               t.push(new TreeNode(Double.valueOf(temp)));
            else{
               t.push(new TreeNode(Integer.valueOf(temp)));
            }
            //count++;
         }
      }
      if(!t.isEmpty())
         root = t.pop();
   }
   
   public double evaluateTree()
   {
      return evaluateNode(root);
   }
   
   private double evaluateNode(TreeNode t)  //recursive
   {
      if(t==null) {
         return 0;
      }
      if(t.getLeft()==null && t.getRight() ==null) {
         return Double.valueOf(t.getValue().toString());
      }
      
      double left = evaluateNode(t.getLeft());
      double right = evaluateNode(t.getRight());
      
      switch (t.getValue().toString()) {
         case "+": return left+right;
         case "-": return left-right;
         case "*": return left*right;
         case "/": return left/right;
         case "%": return left%right;
         //case "^": return left^right;
      }
      
      return 9999999;
   }
   
   private double computeTerm(String s, double a, double b)
   {
      switch(s)
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
   
   private boolean isOperator(String s)
   {
      if(operators.indexOf(s) != -1) {
         return true;
      }
      return false;
   }
   
   public String display()
   {
      return display(root, 0);
   }
   
   private String display(TreeNode t, int level)
   {
      String toRet = "";
      if(t == null)
         return "";
      toRet += display(t.getRight(), level + 1); //recurse right
      for(int k = 0; k < level; k++)
         toRet += "\t";
      toRet += t.getValue() + "\n";
      toRet += display(t.getLeft(), level + 1); //recurse left
      return toRet;
   }
    
   public String inorderTraverse()
   {
      return inorderTraverse(root);
   }
   
   private  String inorderTraverse(TreeNode t)
   {
      String toReturn = "";
      if(t == null)
         return "";
      toReturn += inorderTraverse(t.getLeft());    //recurse left
      toReturn += t.getValue() + " ";	            //process root
      toReturn += inorderTraverse(t.getRight());   //recurse right
      return toReturn;
   }
   
   public String preorderTraverse()
   {
      return preorderTraverse(root);
   }
   
   private String preorderTraverse(TreeNode t)
   {
      String toReturn = "";
      if(t == null)
         return "";
      toReturn += t.getValue() + " ";              //process root
      toReturn += preorderTraverse(t.getLeft());   //recurse left
      toReturn += preorderTraverse(t.getRight());  //recurse right
      return toReturn;
   }
   
  /* extension */
   // public String inorderTraverseWithParentheses()
   // {
      // return inorderTraverseWithParentheses(root);
   // }
//    
   // private String inorderTraverseWithParentheses(TreeNode t)
   // {
      // return "";
   // }
}