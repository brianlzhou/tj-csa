//Torbert, e-mail: mr@torbert.com, website: www.mr.torbert.com
//version 7.22.2003
//mlbillington@fcps.edu  version 10/14/05, 10/09/2006, 4/25/2007

/*************************************** 
Modify the Widget class so that it hashes on its
values, not on its address.   Be sure that compareTo(),
equals(Object) and hashCode() agree with each other.
****************************************/
public class Widget implements Comparable<Widget>
{
  // fields
   private int myCubits, myHands;
   
  // constructors
   public Widget()
   {
      myCubits = myHands = 0;
   }
   public Widget(int x)
   {
      myCubits = x;
      myHands = 0;
   }
   public Widget(int x, int y)
   {
      myCubits = x;
      myHands = y;
   }
   public Widget(Widget arg)
   {
      myCubits = arg.getCubits();
      myHands = arg.getHands();
   }
   
   	//accessors and modifiers
   public int getCubits()
   {
      return myCubits;
   }
   public int getHands()
   {
      return myHands;
   }
   public void setCubits(int x)
   {
      myCubits = x;
   }
   public void setHands(int x)
   {
      myHands = x;
   }
   
   	//other methods
   public int compareTo(Widget other)
   {
        // Widget w = (Widget)arg;       no need to cast
      if(myCubits < other.getCubits())
         return -1;
      if(myCubits > other.myCubits)
         return 1;
      if(myHands < other.myHands)    //"private" is at the class level
         return -1;
      if(myHands > other.getHands())
         return 1;
      return 0;
   }
   public boolean equals(Widget other)    //not equals(Object arg)
   {
      return compareTo(other) == 0;
   }
   public String toString()
   {
      return myCubits + " cubits " + myHands + " hands";
   }   
         
    /* 2 new methods for this lab */
   public boolean equals(Object arg)
   {
      return equals((Widget)arg );
   }
   public int hashCode()
   {
      return toString().hashCode();
   }   
}