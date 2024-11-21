// Name:
// Date: 
import java.util.*;

interface BSTinterface<E>
{
   public int size();
   public boolean contains(E element);
   public E add(E element);
   //public E addBalanced(E element);
   public E remove(E element);
   public E min();
   public E max();
   public String display();
   public String toString();
   public List<E> toList();  //returns an in-order list of E
}

/*******************
  Copy your BST code.  Implement generics.
**********************/
public class BST_Generic<E extends Comparable<E>> implements BSTinterface<E>
{
/*  copy your BST code  here  */
   private TreeNode<E> root;
   private int size;
   public BST_Generic()
   {
      root = null;
      size = 0;
   }
   public int size()
   {
      return size;
   }
   public TreeNode<E> getRoot()   //for Grade-It
   {
      return root;
   }
   /***************************************
   @param s -- one string to be inserted
   ****************************************/
   public E add(E s) 
   {
      root = add(root, s);
      size++;
      return s;
   }
   public TreeNode<E> add(TreeNode<E> t, E s) //recursive helper method
   {      
      if(t == null)
         return new TreeNode<E>(s, null, null);
      if(s.compareTo(t.getValue()) <= 0)
         t.setLeft(add(t.getLeft(), s));
      else {
         t.setRight(add(t.getRight(), s));
      }
      return t;
   }
   
   public String display()
   {
      return display(root, 0); 
   }
   private String display(TreeNode<E> t, int level) //recursive helper method
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
   
   public boolean contains( E obj)
   {
      return contains(root, obj);
   }
   private boolean contains(TreeNode<E> t, E x) //recursive helper method
   {
      if (t ==null)
   	   return false;
      while(t != null) {
         int compare = x.compareTo(t.getValue());
         if(compare ==0)
            return true;
   		if(compare<0)	
   			return contains(t.getLeft(), x);
   		if(compare>0)
   			return contains(t.getRight(), x);
   	}
   	return true;
   }
   
   public E min()
   {
      return min(root);
   }
   private E min(TreeNode<E> t)  //use iteration
   {
      if(t==null)
      	return null;
      while(t.getLeft() != null) {
   	   t = t.getLeft();
   	}
   	return t.getValue();
   }
   
   public E max()
   {
      return max(root);
   }
   private E max(TreeNode<E> t)  //recursive helper method
   {
      if(t==null)
      	return null;
      if(t.getRight() != null)
   	   return max( t.getRight());
   	return t.getValue();
   }
   
   public String toString()
   {
      return toString(root);
   }
   private String toString(TreeNode<E> t)  //an in-order traversal.  Use recursion.
   {
      String toReturn = "";
      if(t == null)
         return "";
      toReturn += toString(t.getLeft());    //recurse left
      toReturn += t.getValue() + " ";	            //process root
      toReturn += toString(t.getRight());   //recurse right
      return toReturn;
   }

   /*  precondition:  target must be in the tree.
                      implies that tree cannot be null.
   */
   public E remove(E target)
   {
      root = remove(root, target);
      size--;
      return target;
   }
   private TreeNode<E> remove(TreeNode<E> current, E target)
   {
      int comp= target.compareTo(current.getValue());
      if(comp ==0) {
         // case 1: target is a leaf
         if(current.getLeft() == null && current.getRight() == null) {
            return null;
         }
         
         // case 2a: one child to the right
         else if(current.getLeft() == null) {
            return current.getRight();
         }
         
         //case 2b: one child to the left
         else if(current.getRight() == null) {
            return current.getLeft();
         }
         
         //case 3: two children
         else {
            E max = max(current.getLeft());
            current.setValue(max);
            current.setLeft(remove(current.getLeft(), max));
         }
      }
      
      else if (comp < 0) {
         current.setLeft(remove(current.getLeft(), target));
      }
      else {
         current.setRight(remove(current.getRight(), target));
      }
      
      return current;
      
   }
   
   public List<E> toList()  //an in-order traversal.  Use recursion.
   {
      List<E> l = new LinkedList<>();
      return toList(root, l);
   }
   
   public List<E> toList(TreeNode<E> t, List<E> l )  //an in-order traversal.  Use recursion.
   {
      if(t == null)
         return l;
      l = toList(t.getLeft(), l);    //recurse left
      l.add(t.getValue());	            //process root
      l = toList(t.getRight(), l);   //recurse right
      return l;
   }
   
   /*public List<E> toList()
   {
      TreeNode<E> lister = new TreeNode<E> (root.getValue(), root.getLeft(), root.getRight());
      toList(lister);
      List<E> l = new LinkedList<E>();
      do {
         l.add(lister.getValue());
      } while(lister.getRight() != null);
      return l;
   }
   
   public void toList(TreeNode<E> e) 
   {
      /*List<E> l = new LinkedList<>();
      if(t == null)
         return "";
      toReturn += inorderTraverse(t.getLeft());    //recurse left
      toReturn += l.add(.getValue()) + " ";	            //process root
      toReturn += inorderTraverse(t.getRight());   //recurse right
      return toReturn;//
      if (e == null)
         return;
      
      if (e.getLeft() == null && e.getRight() == null)
         return;
       
      if (e.getLeft() != null) {
         toList(e.getLeft());
       
         E temp = e.getRight().getValue();
         e.getRight().setValue(e.getLeft().getValue());
         e.setLeft(null);
       
         TreeNode<E> current = e.getRight();
         while (current.getRight() != null)
         {
            current = current.getRight();
         }
        
            current.setRight(new TreeNode<E>(temp));
         }
      
         toList(e.getRight());
      }*/
    
      
   /*public List<E> toList(TreeNode<E> t) {
      List<E> l = new LinkedList<>();
      if(t == null)
         return "";
      l.add(toLeft(t.getLeft());    //recurse left
      toReturn += l.add(.getValue()) + " ";	            //process root
      toReturn += inorderTraverse(t.getRight());   //recurse right
      return toReturn;
   }*/
}

/*******************
  Copy your TreeNode code.  Implement generics.
**********************/
class TreeNode<E> 
{
   private E value; 
   private TreeNode<E> left, right;
   
   public TreeNode(E initValue)
   { 
      value = initValue; 
      left = null; 
      right = null; 
   }
   
   public TreeNode(E initValue, TreeNode<E> initLeft, TreeNode<E> initRight)
   { 
      value = initValue; 
      left = initLeft; 
      right = initRight; 
   }
   
   public E getValue()
   { 
      return value; 
   }
   
   public TreeNode<E> getLeft() 
   { 
      return left; 
   }
   
   public TreeNode<E> getRight() 
   { 
      return right; 
   }
   
   public void setValue(E theNewValue) 
   { 
      value = theNewValue; 
   }
   
   public void setLeft(TreeNode<E> theNewLeft) 
   { 
      left = theNewLeft;
   }
   
   public void setRight(TreeNode<E> theNewRight)
   { 
      right = theNewRight;
   }

}