// Name: 
// Date: 

interface BSTinterface
{
   public int size();
   public boolean contains(String obj);
   public void add(String obj);
   //public void addBalanced(String obj);  //BST_AVL
   public void remove(String obj);    
   //public void removeBalanced(String obj); //extra lab Red_Black
   public String min();
   public String max();
   public String display();
   public String toString();
}

/*******************
BST. Implement the remove() method.
Test it with BST_Remove_Driver.java
**********************/
public class BST implements BSTinterface
{
   /*  copy your BST code here  */
   private TreeNode root;
   private int size;
   public BST()
   {
      root = null;
      size = 0;
   }
   public int size()
   {
      return size;
   }
   public TreeNode getRoot()   //for Grade-It
   {
      return root;
   }
   /***************************************
   @param s -- one string to be inserted
   ****************************************/
   public void add(String s) 
   {
      root = add(root, s);
      size++;
   }
   private TreeNode add(TreeNode t, String s) //recursive helper method
   {      
      /*if(t ==null)
         return new TreeNode(s, null, null);
      TreeNode q = t, p = null;
      while(q!= null) {
         p = q;
         if(s.compareTo((String)p.getValue())<=0)
            q = p.getLeft();
         else {
            q = p.getRight();
         }
      }
      if(s.compareTo((String)p.getValue()) <=0)
         p.setLeft(new TreeNode(s, null, null));
      else
         p.setRight(new TreeNode(s));
      return t;*/
      
      if(t == null)
         return new TreeNode(s, null, null);
      if(s.compareTo((String)t.getValue()) <= 0)
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
   private String display(TreeNode t, int level) //recursive helper method
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
   
   public boolean contains( String obj)
   {
      return contains(root, obj);
   }
   private boolean contains(TreeNode t, String x) //recursive helper method
   {
      if (t ==null)
   	   return false;
      while(t != null) {
         int compare = x.compareTo((String)t.getValue());
         if(compare ==0)
            return true;
   		if(compare<0)	
   			return contains(t.getLeft(), x);
   		if(compare>0)
   			return contains(t.getRight(), x);
   	}
   	return true;
   }
   
   public String min()
   {
      return min(root);
   }
   private String min(TreeNode t)  //use iteration
   {
      if(t==null)
      	return null;
      while(t.getLeft() != null) {
   	   t = t.getLeft();
   	}
   	return t.getValue().toString();
   }
   
   public String max()
   {
      return max(root);
   }
   private String max(TreeNode t)  //recursive helper method
   {
      if(t==null)
      	return null;
      if(t.getRight() != null)
   	   return max( t.getRight());
   	return t.getValue().toString();
   }
   
   public String toString()
   {
      return toString(root);
   }
   private String toString(TreeNode t)  //an in-order traversal.  Use recursion.
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
   public void remove(String target)
   {
      root = remove(root, target);
      size--;
   }
   private TreeNode remove(TreeNode current, String target)
   {
      int comp= target.compareTo(current.getValue().toString());
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
            String max = max(current.getLeft());
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
      /*boolean breaker = true;
      TreeNode parent = current;
      if(contains(current, target)) {
         while(!(current.getLeft()==null && current.getRight()==null) && breaker) {
            parent = current;
            if(target.compareTo(current.getValue().toString()) < 0)
               current = current.getLeft();
            else if(target.compareTo(current.getValue().toString())> 0)
               current = current.getRight();
            else {
               breaker = false;
            }
         }
      }
      // case 1a: target is a leaf but not root
      if(current.getLeft() == null && current.getRight() == null) {
         if(current == root) {// case 1b: target is a leaf and a root WORKS
            root = null;
            return root;
         }
         current = null;
         return root;
      }
      
      // case 2a
      if(current != root && (current.getLeft() == null && !(current.getRight() == null))){
         if(parent.getRight() == current)
            parent.setRight(current.getRight());
         else
            parent.setLeft(current.getRight());
         return root;
      }
      
      // case 2b
      if(current != root && (current.getRight() == null && !(current.getLeft() == null))){
         if(parent.getRight() == current)
            parent.setRight(current.getLeft());
         else
            parent.setLeft(current.getLeft());         
         return root;
      }
      
      // case 2c WORKS
      if(current == root && (current.getLeft() == null && !(current.getRight() == null))){
         root= root.getRight();
         return root;
      }
      
      // case 2d WORKS
      if(current == root && (current.getRight() == null && !(current.getLeft() == null))){
         root = root.getLeft();
         return root;
      }
      
      //etc.
      return root;*/
   }
}