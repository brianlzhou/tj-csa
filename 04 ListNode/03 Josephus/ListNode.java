//the College Board's standard ListNode class
    public class ListNode
   {
      private Object value;
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