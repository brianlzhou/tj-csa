// Name:      
// Date:
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;
public class HuffmanPix
{
   public static int WIDTH = 5;   // 500 x 500 is too big
   public static int HEIGHT = 5;

   public static void main(String[] args) throws IOException
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Encoding using Huffman codes");
      System.out.print("\nWhat image (including extension)? ");
      String pixName = keyboard.nextLine();
      ImageIcon i = new ImageIcon(pixName);
      BufferedImage bufImg = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
   
      JFrame f = new JFrame("HuffmanPix");
      f.setSize(500,500);    // width, height
      f.setLocation(100,50);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setContentPane(new DisplayPix(bufImg, i));
      f.setVisible(true);
   
      System.out.print("\nEnter middle part of filename:  ");
      String middlePart = keyboard.nextLine();
   
      huffmanize( bufImg, middlePart );
      
      System.exit(0);
   }

   
   public static void huffmanize(BufferedImage bufImg, String middlePart) throws IOException
   {
      /*   your Huffman code goes  here  */
      
      
      
      
      
      
      
         				
      String binaryFileName = "pix." + middlePart + ".txt";
      PrintWriter outfile = new PrintWriter(new FileWriter(binaryFileName));
      outfile.print(code);
      System.out.println("Pix done");
            			
      Map<String, String> huffmanScheme = new HashMap<String,String>();
      String schemeFile = "schemePix."+ middlePart + ".txt";
      PrintWriter outfile2 = new PrintWriter(new FileWriter(schemeFile));
      outfile2.println(""+ WIDTH +" " + HEIGHT);    //outputs the width x height
      outfile2.println( /*the scheme */ );
      System.out.println("Scheme done");
      
      outfile.close(); 
      outfile2.close();  
   }
   
   /*  several Huffman methods go here  */
   
   
}


  /*
  * This node stores two values.  
  * The compareTo method must ensure that the lowest frequency has the highest priority.
  */   
class HuffmanNode implements Comparable<HuffmanNode>
{

}
  /*
  * Minimum code necessary to display a BufferedImage.    
  */ 
class DisplayPix extends JPanel
{
   private BufferedImage img;
   private Graphics g;
   public DisplayPix(BufferedImage bufImg, ImageIcon i)   //for Huffman
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