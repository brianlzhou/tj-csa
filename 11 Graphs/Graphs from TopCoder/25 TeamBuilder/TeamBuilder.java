// Name:   
// Date:
 
import java.util.*;
import java.io.*;

public class TeamBuilder
{
   public static void main(String[] args) 
   {
      String[] path = {"010", "000", "110"};	   
      //String[] path = {"0010", "1000", "1100", "1000"};
      //String[] path = {"01000", "00100", "00010", "00001", "10000"};
      //String[] path = {"0110000", "1000100", "0000001", "0010000", "0110000", "1000010", "0001000"};
      
      int[] ret = specialLocations(path);
      System.out.println("{" + ret[0] + ", " + ret[1] + "}");
   }

   public static int[] specialLocations(String[] paths)
   {
      
   }

}