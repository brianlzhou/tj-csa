//resource class to demonstrate sorting with Generics
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
   public Widget(Widget arg)   //copy constructor
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
}
