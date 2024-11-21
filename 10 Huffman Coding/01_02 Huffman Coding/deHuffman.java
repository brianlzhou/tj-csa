// Name:              Date:
import java.util.*;
import java.io.*;
public class deHuffman
{
   public static void main(String[] args) throws IOException
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("\nWhat binary message (middle part)? ");
      String middlePart = keyboard.next();
      Scanner sc = new Scanner(new File("message."+middlePart+".txt")); 
      String binaryCode = sc.next();
      Scanner huffLines = new Scanner(new File("scheme."+middlePart+".txt")); 
      	
      TreeNode root = huffmanTree(huffLines);
      String message = dehuff(binaryCode, root);
      System.out.println(message);
      	
      sc.close();
      huffLines.close();
   }
   public static TreeNode huffmanTree(Scanner huffLines)
   {
      TreeNode root = new TreeNode("");
      TreeNode pointer = root;
      while(huffLines.hasNextLine()) {
         pointer = root;
         String s = huffLines.nextLine();
         String code = s.substring(1);
         String value = s.substring(0,1);
         for(int i = 0; i<code.length()-1; i++) {
            String temp = code.substring(i, i+1);
            if(temp.equals("0")) {
               if(pointer.getLeft() != null)
                  pointer = pointer.getLeft();
               else {
                  pointer.setLeft(new TreeNode(""));
                  pointer = pointer.getLeft();
               }
            }
            else if(temp.equals("1")) {
               if(pointer.getRight() != null)
                  pointer = pointer.getRight();
               else {
                  pointer.setRight(new TreeNode(""));
                  pointer = pointer.getRight();
               }
            }
         }
         String temp = code.substring(code.length()-1);
         if(temp.equals("0"))
            pointer.setLeft(new TreeNode(value));
         else if(temp.equals("1"))
            pointer.setRight(new TreeNode(value));
         
         
         pointer = root;
      }
      return root;
   }
   
   public static String dehuff(String text, TreeNode root)
   {
      TreeNode pointer = root;
      String returner = "";
      for(int i = 0; i< text.length(); i++) {
         String temp = text.substring(i, i+1);
         if(temp.equals("0"))
            pointer = pointer.getLeft();
         else if (temp.equals("1"))
            pointer = pointer.getRight();
                        
         if(!pointer.getValue().equals("")) {
            returner = returner + pointer.getValue();
            pointer = root;
         }
      }
      return returner;
   }
}

 /* TreeNode class for the AP Exams */
class TreeNode
{
   private Object value; 
   private TreeNode left, right;
   
   public TreeNode(Object initValue)
   { 
      value = initValue; 
      left = null; 
      right = null; 
   }
   
   public TreeNode(Object initValue, TreeNode initLeft, TreeNode initRight)
   { 
      value = initValue; 
      left = initLeft; 
      right = initRight; 
   }
   
   public Object getValue()
   { 
      return value; 
   }
   
   public TreeNode getLeft() 
   { 
      return left; 
   }
   
   public TreeNode getRight() 
   { 
      return right; 
   }
   
   public void setValue(Object theNewValue) 
   { 
      value = theNewValue; 
   }
   
   public void setLeft(TreeNode theNewLeft) 
   { 
      left = theNewLeft;
   }
   
   public void setRight(TreeNode theNewRight)
   { 
      right = theNewRight;
   }
}
