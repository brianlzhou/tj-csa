// mlbillington 2.27.2020
import java.util.*;

/*******************
Driver class for the BST Remove lab.
The cases correspond to the cases on the handout.
When you finish coding the cases, try the stress test. 
**********************/
public class BST_AVL_StressTest
{
   public static void main(String[] args)
   {
   /*   stress test
      Add 26 letters at random to the AVL tree.
      Is it always balanced? 
      Is it always in BST order?
      */
      BST bst = new BST();
      String[] lettersArray = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"}; 
      List<String> lettersList = new ArrayList(Arrays.asList(lettersArray)); 
      for(int i = 0; i < 26; i++)
      {
         int index = (int)(Math.random() * lettersList.size());
         String letter = lettersList.remove(index);
         bst.addBalanced( letter );
         System.out.println( bst.display() );  //is it balanced?
         System.out.println("In order: " + bst.toString()); //is the BST still in order?
         System.out.println("----------------------------");
      }
   
      /*  extension:  implement removeBalanced()   */
      // lettersList = new ArrayList(Arrays.asList(lettersArray)); 
      // for(int i = 0; i < 26; i++)
      // {
         // int index = (int)(Math.random() * lettersList.size());
         // String letter = lettersList.remove(index);
         // System.out.println("removing " + letter);
         // bst.removeBalanced( letter );
         // System.out.println( bst.display() );  //is it balanced?
         // System.out.println("In order: " + bst.toString());  //is each BST still in order?
         // System.out.println("----------------------------");
      // }
   }
}

/*****************************************************
        ----jGRASP exec: java BST_AVL_StressTest
 I
 
 In order: I 
 ----------------------------
 	R
 I
 
 In order: I R 
 ----------------------------
 	R
 J
 	I
 
 In order: I J R 
 ----------------------------
 	R
 		P
 J
 	I
 
 In order: I J P R 
 ----------------------------
 		T
 	R
 		P
 J
 	I
 
 In order: I J P R T 
 ----------------------------
 		T
 	R
 P
 		O
 	J
 		I
 
 In order: I J O P R T 
 ----------------------------
 		T
 	R
 P
 		O
 			K
 	J
 		I
 
 In order: I J K O P R T 
 ----------------------------
 		Y
 	T
 		R
 P
 		O
 			K
 	J
 		I
 
 In order: I J K O P R T Y 
 ----------------------------
 		Y
 	T
 		R
 P
 		O
 			K
 	J
 		I
 			E
 
 In order: E I J K O P R T Y 
 ----------------------------
 		Y
 			X
 	T
 		R
 P
 		O
 			K
 	J
 		I
 			E
 
 In order: E I J K O P R T X Y 
 ----------------------------
 		Y
 			X
 	T
 			S
 		R
 P
 		O
 			K
 	J
 		I
 			E
 
 In order: E I J K O P R S T X Y 
 ----------------------------
 			Z
 		Y
 			X
 	T
 			S
 		R
 P
 		O
 			K
 	J
 		I
 			E
 
 In order: E I J K O P R S T X Y Z 
 ----------------------------
 			Z
 		Y
 			X
 	T
 			S
 		R
 P
 			O
 		L
 			K
 	J
 		I
 			E
 
 In order: E I J K L O P R S T X Y Z 
 ----------------------------
 			Z
 		Y
 			X
 	T
 			S
 		R
 P
 			O
 				N
 		L
 			K
 	J
 		I
 			E
 
 In order: E I J K L N O P R S T X Y Z 
 ----------------------------
 			Z
 		Y
 			X
 	T
 			S
 		R
 P
 			O
 				N
 		L
 			K
 	J
 			I
 		G
 			E
 
 In order: E G I J K L N O P R S T X Y Z 
 ----------------------------
 			Z
 		Y
 			X
 	T
 			S
 		R
 			Q
 P
 			O
 				N
 		L
 			K
 	J
 			I
 		G
 			E
 
 In order: E G I J K L N O P Q R S T X Y Z 
 ----------------------------
 			Z
 		Y
 			X
 	T
 			S
 		R
 			Q
 P
 			O
 				N
 		L
 			K
 	J
 			I
 		G
 			E
 				C
 
 In order: C E G I J K L N O P Q R S T X Y Z 
 ----------------------------
 			Z
 		Y
 			X
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
 		G
 			E
 				C
 
 In order: C E G I J K L M N O P Q R S T X Y Z 
 ----------------------------
 			Z
 		Y
 			X
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
 		G
 			E
 				C
 
 In order: C E G I J K L M N O P Q R S T U X Y Z 
 ----------------------------
 			Z
 		Y
 			X
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
 		G
 				E
 			C
 				A
 
 In order: A C E G I J K L M N O P Q R S T U X Y Z 
 ----------------------------
 			Z
 		Y
 				X
 			W
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
 		G
 				E
 			C
 				A
 
 In order: A C E G I J K L M N O P Q R S T U W X Y Z 
 ----------------------------
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
 		G
 				E
 			C
 				A
 
 In order: A C E G I J K L M N O P Q R S T U V W X Y Z 
 ----------------------------
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
 			G
 				E
 		C
 				B
 			A
 
 In order: A B C E G I J K L M N O P Q R S T U V W X Y Z 
 ----------------------------
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
 			G
 				E
 					D
 		C
 				B
 			A
 
 In order: A B C D E G I J K L M N O P Q R S T U V W X Y Z 
 ----------------------------
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
 				E
 					D
 		C
 				B
 			A
 
 In order: A B C D E G H I J K L M N O P Q R S T U V W X Y Z 
 ----------------------------
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
 
 In order: A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 
 ----------------------------
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
 
 
  ----jGRASP: operation complete.
      
  ***************************************/
