// Name:
// Date:

import java.util.*;
import java.io.*;

public class AreaFill {
   public static void main(String[] args) {
      char[][] grid = null;
      String filename = null;
      Scanner sc = new Scanner(System.in);
      while (true) // what does this do?
      {
         System.out.print("Fill the Area of (-1 to exit): ");
         filename = sc.next();
         if (filename.equals("-1")) {
            sc.close();
            System.out.println("Good-bye");
            // System.exit(0);
            return;
         }
         grid = read(filename);
         String theGrid = display(grid);
         System.out.println(theGrid);
         System.out.print("1-Fill or 2-Fill-and-Count: ");
         int choice = sc.nextInt();
         switch (choice) {
            case 1: {
               System.out.print("\nEnter ROW COL to fill from: ");
               int row = sc.nextInt();
               int col = sc.nextInt();
               fill(grid, row, col, grid[row][col]);
               System.out.println(display(grid));
               break;
            }
            case 2: {
               System.out.print("\nEnter ROW COL to fill from: ");
               int row = sc.nextInt();
               int col = sc.nextInt();
               int count = fillAndCount(grid, row, col, grid[row][col]);
               System.out.println(display(grid));
               System.out.println("count = " + count);
               System.out.println();
               break;
            }
            default:
               System.out.print("\nTry again! ");
         }
      }
   }

   /**
    * Reads the contents of the file into a matrix. Uses try-catch.
    * 
    * @param filename The string representing the filename.
    * @returns A 2D array of chars.
    */
   public static char[][] read(String filename) {
      Scanner infile = null;
      try {
         infile = new Scanner(new File(filename));
      } catch (Exception e) {
         System.out.println("File not found");
         return null;
      }
      /* enter your code here */
      int columns = infile.nextInt();
      int rows = infile.nextInt();
      char[][] newarray = new char[columns][rows];
      infile.nextLine();
      for (int i = 0; i < columns; i++) {
         String theLine = infile.nextLine();
         for (int j = 0; j < rows; j++) {
            newarray[i][j] = theLine.charAt(j);
         }
      }
      infile.close();
      return newarray;
   }

   /**
    * @param g A 2-D array of chars.
    * @returns A string representing the 2D array.
    */
   public static String display(char[][] g) {
      int col = g.length;
      int row = g[0].length;
      String returner = "";
      for (int i = 0; i < col; i++) {
         for (int j = 0; j < row; j++) {
            returner += g[i][j];
         }
         returner += "\n";
      }
      return returner;
   }

   /**
    * Fills part of the matrix with a different character.
    * 
    * @param g  A 2D char array.
    * @param r  An int representing the row of the cell to be filled.
    * @param c  An int representing the column of the cell to be filled.
    * @param ch The char which is being replaced.
    */
   public static void fill(char[][] g, int r, int c, char ch) {
      g[r][c] = '*';
      
      if(r>0) {
         if(g[r-1][c] == ch) {
            fill(g,r-1,c,ch);
         }
      }
      if(r<g.length-1) {
         if(g[r+1][c] == ch) {
            fill(g,r+1,c,ch);
         }
      }
      if(c>0) {
         if(g[r][c-1] == ch) {
            fill(g,r,c-1,ch);
         }
      }
      if(c<g[0].length-1) {
         if(g[r][c+1] == ch) {
            fill(g,r,c+1,ch);
         }
      }
   }

   /**
    * Fills part of the matrix with a different character. Counts as you go. Does
    * not use a static variable.
    * 
    * @param g  A 2D char array.
    * @param r  An int representing the row of the cell to be filled.
    * @param c  An int representing the column of the cell to be filled.
    * @param ch The char which is being replaced.
    * @return An int representing the number of characters that were replaced.
    */
   public static int fillAndCount(char[][] g, int r, int c, char ch) {
      int count = 1;
      g[r][c] = '*';
      
      if(r>0) {
         if(g[r-1][c] == ch) {
            count += fillAndCount(g,r-1,c,ch);
         }
      }
      if(r<g.length-1) {
         if(g[r+1][c] == ch) {
            count += fillAndCount(g,r+1,c,ch);
         }
      }
      if(c>0) {
         if(g[r][c-1] == ch) {
            count += fillAndCount(g,r,c-1,ch);
         }
      }
      if(c<g[0].length-1) {
         if(g[r][c+1] == ch) {
            count += fillAndCount(g,r,c+1,ch);
         }
      }

      return count; // never reached
   }
}