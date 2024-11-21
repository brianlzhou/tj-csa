// Name: 
// Date: 

interface BSTinterface
{
   public int size();
   public boolean contains(String obj);
   public void add(String obj);   //does not balance
   public void addBalanced(String obj);
   public void remove(String obj);
   public String min();
   public String max();
   public String display();
   public String toString();
}

public class BST implements BSTinterface
{
   /*  copy your BST code  here  */
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
      
   }




   /*  start the addBalanced methods */
   private int calcBalance(TreeNode t) //height to right minus 
   {                                    //height to left
      return height(t.getRight()) - height(t.getLeft());
   }

   public static int height(TreeNode t)
   {
      int count = 0;
      if(t == null)
         return -99999999;
      count = Math.max(height(t.getLeft()), height(t.getRight()))+1;     
      return count;
   }

   public void addBalanced(String value)  
   {
      add(value);
      root = balanceTree(root);   // for an AVL tree. Put in the arguments you want.
   }
   private void balanceTree(TreeNode t)  //recursive.  Whatever makes sense.
   {
      if(t.getLeft() != null)
         balanceTree(t.getLeft());
      if(t.getRight() != null)
         balanceTree(t.getRight());
      int balance = calcBalance(t);
      if(balance>1) {  
         //double left: right heavy then left heavy
         if(calcBalance(t.getRight()) < 0) {
            TreeNode temp = rotateLeft(t.getRight());
            t.getRight().setValue(temp.getValue());
            t.getRight().setRight(temp.getRight());
            t.getRight().setLeft(temp.getLeft());
            /*TreeNode temp = t.getRight();
            String s = temp.getValue().toString();
            t.setRight(temp.getLeft());
            t.setLeft(null);
            t.getRight().setRight(new TreeNode(s));*/
            
            TreeNode temptwo = rotateRight(t);
            t.setValue(temptwo.getValue());
            t.setRight(temptwo.getRight());
            t.setLeft(temptwo.getLeft());
         }
         else {
            TreeNode temp = rotateRight(t);
            t.setValue(temp.getValue());
            t.setRight(temp.getRight());
            t.setLeft(temp.getLeft());
         }
      }
      if(balance<-1 && balance > -99999) {
         if(calcBalance(t.getLeft()) > 0) {
            TreeNode temp = rotateRight(t.getLeft());
            t.getLeft().setValue(temp.getValue());
            t.getLeft().setRight(temp.getRight());
            t.getLeft().setLeft(temp.getLeft());
            
            /*TreeNode temp = t.getLeft();
            TreeNode s = new TreeNode(temp.getValue().toString(), t.getLeft(), null);
            t.setLeft(temp.getRight());
            t.setRight(null);
            t.getLeft().setLeft(s);*/
            
            TreeNode temptwo = rotateLeft(t);
            t.setValue(temptwo.getValue());
            t.setRight(temptwo.getRight());
            t.setLeft(temptwo.getLeft());
         }
         else {
            TreeNode temp = rotateLeft(t);
            t.setValue(temp.getValue());
            t.setRight(temp.getRight());
            t.setLeft(temp.getLeft());       
         }
      }
   }
   
   private TreeNode rotateLeft(TreeNode t) {
      TreeNode l = t.getLeft();
      TreeNode n = new TreeNode(t.getValue(), l.getRight(), t.getRight());
      return new TreeNode (l.getValue(), l.getLeft(), n);
   }
   
   private TreeNode rotateRight(TreeNode t) {
      TreeNode r = t.getRight();
      TreeNode n = new TreeNode(t.getValue(), t.getLeft(), r.getLeft());
      return new TreeNode (r.getValue(), n, r.getRight());
   }
   // 4 rotation methods
   
   
}