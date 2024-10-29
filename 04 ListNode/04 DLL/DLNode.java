//////////////////////////////////////
//Keith Ainsworth, 11/13/2006
class DLNode 
{
   private Object value;
   private DLNode prev;
   private DLNode next;
   public DLNode(Object arg, DLNode p, DLNode n)
   {
      value=arg;
      prev=p;
      next=n;
   }
   public DLNode()
   {
      value=null;
      next=this;
      prev=this;
   }
   public void setValue(Object arg)
   {
      value=arg;
   }
   public void setNext(DLNode arg)
   {
      next=arg;
   }
   public void setPrev(DLNode arg)
   {
      prev=arg;
   }
   public DLNode getNext()
   {
      return next;
   }
   public DLNode getPrev()
   {
      return prev;
   }
   public Object getValue()
   {
      return value;
   }
}
