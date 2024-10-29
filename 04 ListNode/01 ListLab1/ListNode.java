//Thomas Bettge, TJHSST, 10-20-2006
public class ListNode
{
   private Object value;   //technically, ListNodes store Objects, not primitives
   private ListNode next;
   public ListNode(Object v, ListNode n)
   {
      value=v;
      next=n;
   }
   public Object getValue()
   {
      return value;
   }
   public ListNode getNext()
   {
      return next;
   }
   public void setValue(Object newv)
   {
      value=newv;
   }
   public void setNext(ListNode newn)
   {
      next=newn;
   }
   
}