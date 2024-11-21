import java.util.*;

/*******************
Driver class for the BST Removelab.
The cases correspond to the cases on the handout.
When you finish coding the cases, try the stress test. 
**********************/
public class BST_Remove_Driver
{
   public static void main(String[] args)
   {
      //Case 1a:     E C S B P W A N R 
      //Case 1b:     N
      //Case 2a:     S N T P O R    
      //Case 2b:     H B R N V J S Z I K  
      //Case 2c:     N F A K G
      //Case 2d:     N S P Q X
      //Case 3.a:    D B N A C F S E J H M 
      //Case 3.b:    D B N A C F S E J H 
      //on the handout: H D J A G K F E O L T M N S U
      //on the PowerPoint: Florida Oklahoma Colorado Massachusetts Arizona Iowa New_Hampshire Washington West_Virginia Kazakhstan Arkansas
     
      Scanner sc = new Scanner(System.in);
      System.out.print("Input one of the cases: ");
      String line = sc.nextLine();
      BST bst = new BST();
      String[] str = line.split(" ");
      for(String item : str)
         bst.add( item );
      System.out.println( bst.display() );
      System.out.print("Remove? ");
      String target = sc.next();
      if( bst.contains( target ) )
      {
         bst.remove( target );
         System.out.println("\n" + target+" removed.");
         System.out.println( bst.display() );
         System.out.println("Is the tree still a BST?");
      }
      else
         System.out.println("\n" + target+" not found");
   
   /*   stress test
   Add 26 letters at random to the BST, then remove 26 letters at random.
   If it crashes, you have probably missed a case or a guard. 
   If the tree stores the letters of the alphabet, what should bst.toString() show?
   */
      // BST bst = new BST();
      // String[] lettersArray = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"}; 
      // List<String> lettersList = new ArrayList(Arrays.asList(lettersArray)); 
      // for(int i = 0; i < 26; i++)
      // {
         // int index = (int)(Math.random() * lettersList.size());
         // String letter = lettersList.remove(index);
         // bst.add( letter );
         // System.out.println(bst.toString()); //is the BST still in order?
      // }
      // System.out.println( bst.display() );
      // lettersList = new ArrayList(Arrays.asList(lettersArray)); 
      // for(int i = 0; i < 26; i++)
      // {
         // int index = (int)(Math.random() * lettersList.size());
         // String letter = lettersList.remove(index);
         // bst.remove( letter );
         // System.out.println(bst.toString());  //is each BST still in order?
      // }
   }
}
