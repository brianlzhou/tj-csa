//Name: 
//Date:

interface BSTinterface
{
   public int size();
   public boolean contains(String obj);
   public void add(String obj);
   //public void addBalanced(String obj);
   //public boolean remove(String obj);
   public String min();
   public String max();
   public String toString();
}

/*******************
Represents a binary search tree holding Strings. 
Implements (most of) BSTinterface, above. 
The recursive methods all have a public method calling a private helper method. 
Copy the display() method from TreeLab. 
**********************/
class BST implements BSTinterface
{
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
}
