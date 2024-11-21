// Name:   
// Date:   
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
public class deHuffmanPix
{
   public static void main(String[] args) throws IOException
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("\nWhat binary picture file (middle part) ? ");
      String middlePart = keyboard.next();
      Scanner sc = new Scanner(new File("pix."+middlePart+".txt")); 
      String binaryCode = sc.next();
      Scanner huffScheme = new Scanner(new File("schemePix."+middlePart+".txt")); 
      int width = huffScheme.nextInt();   //  read the size of the image
      int height = huffScheme.nextInt();    
      
      TreeNode root = huffmanTree(huffScheme);
      BufferedImage bufImg = dehuff(binaryCode, root, height, width);
   	
      JFrame f = new JFrame("HuffmanPix");
      f.setSize(500,500);    // width, height
      f.setLocation(100,50);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setContentPane(new DisplayPix(bufImg));
      f.setVisible(true);
      
      sc.close();
      huffScheme.close();
      keyboard.nextLine();  //press 'enter'
      keyboard.nextLine(); 
      System.exit(0);
   }
   
   public static TreeNode huffmanTree(Scanner huffScheme)
   {
       /*  your code goes here */
   }
   
   public static BufferedImage dehuff(String text, TreeNode root, int height, int width)
   {
      BufferedImage bufImg = new BufferedImage( width, height, BufferedImage.TYPE_INT_RGB);
      /*  your code goes here */
  
  
  
      return bufImg;
   }
}
   

 /* normal AP-style TreeNode class  */
class TreeNode
{
   private Object value; 
   private TreeNode left, right;
   public TreeNode(Object initValue)
   { 
      value = initValue; 
      left = null; 
      right = null; 
   }  
   public TreeNode(Object initValue, TreeNode initLeft, TreeNode initRight)
   { 
      value = initValue; 
      left = initLeft; 
      right = initRight; 
   } 
   public Object getValue()
   { 
      return value; 
   }  
   public TreeNode getLeft() 
   { 
      return left; 
   }  
   public TreeNode getRight() 
   { 
      return right; 
   }
   public void setValue(Object theNewValue) 
   { 
      value = theNewValue; 
   }
   
   public void setLeft(TreeNode theNewLeft) 
   { 
      left = theNewLeft;
   }
   
   public void setRight(TreeNode theNewRight)
   { 
      right = theNewRight;
   }
}

  /*
  * Minimum code necessary to show a BufferedImage.   
  * 
  */ 
class DisplayPix extends JPanel
{
   private BufferedImage img;
   private Graphics g;

   public DisplayPix(BufferedImage bufImg, ImageIcon i)   //for Huffman Coding
   {
      int w = bufImg.getWidth();
      int h = bufImg.getHeight();
      img = bufImg;
      g = bufImg.getGraphics();
      g.drawImage( i.getImage() , 0 , 0 , w , h, null );
   }
   public DisplayPix(BufferedImage bufImg)              //for deHuffman
   {
      img = bufImg;
   }
   public void paintComponent(Graphics g)
   {
      g.drawImage( img , 0 , 0 , getWidth() , getHeight() , null );
   }
}