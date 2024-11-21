// Torbert, in the early 2000's.
// mlbillington 4-3-2019  implemented the BST class.
import java.util.*;

/*******************
Driver class for the BST Remove lab.
The cases correspond to the cases on the handout.
When you finish coding the cases, try the stress test. 
**********************/
public class BST_Remove_StressTest
{
   public static void main(String[] args)
   {
   //Case 1a:     E C S B P W A N R 
   //Case 1b:     N
   //Case 2a:     S N T P O R    
   //Case 2b:     H B R N V J S Z I K  
   //Case 2c:     N F A K G
   //Case 2d:     N S P Q X
   //Case 3a:     D B N A C F S E J H M 
   //Case 3b:     D B N A C F S E J H 
   //Case 3c:     H B N J V
   //on the handout: H D J A G K F E O L T M N S U
   //on the PowerPoint: Florida Oklahoma Colorado Massachusetts Arizona Iowa New_Hampshire Washington West_Virginia Kazakhstan Arkansas
   
   //      Scanner sc = new Scanner(System.in);
   //       System.out.print("Input one of the cases: ");
   //       String line = sc.nextLine();
   //       BST_Teacher bst = new BST_Teacher();
   //       String[] str = line.split(" ");
   //       for(String item : str)
   //          bst.add( item );
   //       System.out.println( bst.display() );
   //       System.out.print("Remove? ");
   //       String target = sc.next();
   //       if( bst.contains( target ) )
   //       {
   //          bst.remove( target );
   //          System.out.println("\n" + target+" removed.");
   //          System.out.println( bst.display() );
   //          System.out.println("Is the tree still a BST?");
   //       }
   //       else
   //          System.out.println("\n" + target+" not found");
   
   /*   stress test
   Add 26 letters at random to the BST, then remove 26 letters at random.
   If it crashes, you have probably missed a case or a guard. 
   If the tree stores the letters of the alphabet, what should bst.toString() show?
   */
      BST_Teacher bst = new BST_Teacher();
      String[] lettersArray = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"}; 
      List<String> lettersList = new ArrayList(Arrays.asList(lettersArray)); 
      for(int i = 0; i < 26; i++)
      {
         int index = (int)(Math.random() * lettersList.size());
         String letter = lettersList.remove(index);
         bst.add( letter );
         System.out.println(bst.toString()); //is the BST still in order?
      }
      System.out.println( bst.display() );
      lettersList = new ArrayList(Arrays.asList(lettersArray)); 
      for(int i = 0; i < 26; i++)
      {
         int index = (int)(Math.random() * lettersList.size());
         String letter = lettersList.remove(index);
         System.out.println("removing " + letter);
         bst.remove( letter );
         System.out.println(bst.toString());  //is each BST still in order?
      }
   }
}
/*****************************************************
     ----jGRASP exec: java BST_Remove_StressTest
 Y 
 Y Z 
 D Y Z 
 D F Y Z 
 D F K Y Z 
 D F K N Y Z 
 D F K N Q Y Z 
 A D F K N Q Y Z 
 A D F K N Q R Y Z 
 A D F K N Q R V Y Z 
 A D F K N P Q R V Y Z 
 A D F K M N P Q R V Y Z 
 A D F K L M N P Q R V Y Z 
 A D F H K L M N P Q R V Y Z 
 A D E F H K L M N P Q R V Y Z 
 A D E F G H K L M N P Q R V Y Z 
 A D E F G H K L M N P Q R U V Y Z 
 A D E F G H K L M N P Q R U V X Y Z 
 A D E F G H I K L M N P Q R U V X Y Z 
 A B D E F G H I K L M N P Q R U V X Y Z 
 A B C D E F G H I K L M N P Q R U V X Y Z 
 A B C D E F G H I K L M N P Q R U V W X Y Z 
 A B C D E F G H I K L M N P Q R T U V W X Y Z 
 A B C D E F G H I J K L M N P Q R T U V W X Y Z 
 A B C D E F G H I J K L M N O P Q R T U V W X Y Z 
 A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 
 	Z
 Y
 								X
 									W
 							V
 								U
 									T
 										S
 						R
 					Q
 						P
 							O
 				N
 					M
 						L
 			K
 						J
 					I
 				H
 					G
 		F
 			E
 	D
 				C
 			B
 		A
 
 removing L
 A B C D E F G H I J K M N O P Q R S T U V W X Y Z 
 removing K
 A B C D E F G H I J M N O P Q R S T U V W X Y Z 
 removing B
 A C D E F G H I J M N O P Q R S T U V W X Y Z 
 removing T
 A C D E F G H I J M N O P Q R S U V W X Y Z 
 removing G
 A C D E F H I J M N O P Q R S U V W X Y Z 
 removing D
 A C E F H I J M N O P Q R S U V W X Y Z 
 removing A
 C E F H I J M N O P Q R S U V W X Y Z 
 removing S
 C E F H I J M N O P Q R U V W X Y Z 
 removing Y
 C E F H I J M N O P Q R U V W X Z 
 removing J
 C E F H I M N O P Q R U V W X Z 
 removing W
 C E F H I M N O P Q R U V X Z 
 removing X
 C E F H I M N O P Q R U V Z 
 removing N
 C E F H I M O P Q R U V Z 
 removing Z
 C E F H I M O P Q R U V 
 removing Q
 C E F H I M O P R U V 
 removing H
 C E F I M O P R U V 
 removing E
 C F I M O P R U V 
 removing I
 C F M O P R U V 
 removing V
 C F M O P R U 
 removing U
 C F M O P R 
 removing O
 C F M P R 
 removing R
 C F M P 
 removing F
 C M P 
 removing M
 C P 
 removing C
 P 
 removing P
 
 
  ----jGRASP: operation complete. 
 
  ----jGRASP: operation complete.
  
  ***************************************/
