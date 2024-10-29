// Name:
// Date:

import java.util.*;
import java.io.*;
import java.io.File;

public class MazeGrandMaster
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the maze's filename (no .txt): ");
      Maze m = new Maze(sc.next() + ".txt"); //append the .txt
      // Maze m = new Maze();    
      m.display();      
      System.out.println("Options: ");
      System.out.println("1: Mark all paths.");
      System.out.println("1: Find the shortest path\n\tIf no path exists, say so.");
      System.out.println("2: Mark only the shortest correct path and display the count of STEPs.\n\tIf no path exists, say so.");
      System.out.print("Please make a selection: ");
      m.solve(sc.nextInt());
   } 
}

class Maze
{
   //Constants
   private final char WALL = 'W';
   private final char DOT = '.';
   private final char START = 'S';
   private final char EXIT = 'E';
   private final char STEP = '*';
   //Instance Fields
   private char[][] maze;
   private int startRow, startCol;
  
   //constructors
	
	/* 
	 * EXTENSION 
	 * This no a arg constructor that generates a random maze
	 */
   public Maze()
   {
   
   }
	
	/* 
	 * Copy Constructor  
	 */
   public Maze(char[][] m)  
   {
      maze = m;
      for(int r = 0; r < maze.length; r++)
      {
         for(int c = 0; c < maze[0].length; c++)
         { 
            if(maze[r][c] == START)      //identify start
            {
               startRow = r;
               startCol = c;
            }
         }
      }
   } 
	
	/* 
	 * Use a try-catch block
	 * Use next(), not nextLine()  
	 */
   public Maze(String filename)    
   {
      Scanner infile = null;
      try {
         infile = new Scanner(new File(filename));
      } catch (Exception e) {
         System.out.println("File not found");
         System.exit(0);
      }
      /* enter your code here */
      int rows = infile.nextInt();
      int columns = infile.nextInt();
      this.maze = new char[rows][columns];
      for (int i = 0; i < rows; i++) {
         this.maze[i]=infile.next().toCharArray();
      }
      infile.close();
      for(int r = 0; r < maze.length; r++)
      {
         for(int c = 0; c < maze[0].length; c++)
         { 
            if(maze[r][c] == START)      //identify start location
            {
               startRow = r;
               startCol = c;
            }
         }
      }
   }

   
   public char[][] getMaze()
   {
      return maze;
   }
   
   public void display()
   {
      if(maze==null) 
         return;
      for(int a = 0; a<maze.length; a++)
      {
         for(int b = 0; b<maze[0].length; b++)
         {
            System.out.print(maze[a][b]);
         }
         System.out.println("");
      }
      System.out.println("");
   }
   
   public void solve(int n)
   {
      switch(n)
      {    
         case 1:
            {   
               int shortestPath = findShortestLengthPath(startRow, startCol);
               if( shortestPath!=-1 )
                  System.out.println("Sortest path is " + shortestPath);
               else
                  System.out.println("No path exists."); 
               break;
            }   
            
          case 2:
            {
               String strShortestPath = findShortestPath(startRow, startCol);
               if( strShortestPath.length()!=0 )
               {
                  System.out.println("Sortest lenght path is: " + getPathLength(strShortestPath));
                  System.out.println("  Sortest path is: " + strShortestPath);
                  markPath(strShortestPath);
                  display();  //display solved maze
               }
               else
                  System.out.println("No path exists."); 
               break;
            }
         default:
            System.out.println("File not found");   
      }
   }
   
 /*  1   recur until you find E, then return the shortest path
     returns -1 if it fails
     precondition: Start can't match with Exit
 */ 
   public int findShortestLengthPath(int r, int c)
   {
      if(r < 0 || r >= maze.length || c < 0 || c >= maze[0].length) {
         return 99999;
      }
      if(maze[r][c] == WALL) {
         return 99999;
      }
      if(maze[r][c] == EXIT) {
         System.out.println("Number of steps = " + count);
         return 0;
      }
      if(maze[r][c] == DOT || maze[r][c] == START) {
         if(maze[r][c] != START)
            maze[r][c] = TEMP;
         int tempnum = 99999999;
         int temppos = 0;
         int[] comparer = {findShortestLengthPath(r+1, c), findShortestLengthPath(r-1, c), findShortestLengthPath(r, c+1), findShortestLengthPath(r, c-1)};
         for (int i = 0; i < comparer.length; i++) {
            if(comparer[i] < tempnum) {
               tempnum = comparer[i];
               temppos = i;
            }
         }
         foundExit = (markCorrectPathAndCountSteps(r+1, c, count+1) || markCorrectPathAndCountSteps(r-1, c, count+1) || markCorrectPathAndCountSteps(r, c+1, count+1) || markCorrectPathAndCountSteps(r, c-1, count+1));
         if (!foundExit) {
            maze[r][c] = DOT;
            return false;
         }
         else {
            if(maze[r][c] == TEMP)
               maze[r][c] = PATH;
            return true;
         }
      }
      return false;
   }  
   
/*  2   recur until you find E, then build the True path 
     use only the shortest path
     returns -1 if it fails
     precondition: Start can't match with Exit
 */
   public String findShortestPath(int r, int c)
   {
      return ""; //replace this with something useful
   }	


   //a recursive method that takes an argument created by the method 2 in the form of 
   //((5,0),10),((5,1),9),((6,1),8),((6,2),7),((6,3),6),((6,4),5),((6,5),4),((6,6),3),((5,6),2),((4,6),1),((4,7),0)
   //and it marks the actual path in the maze with STEP
   //precondition:   the String is either an empty String or one that has the correct format above
   //                the indexes must be correct for this method to work  
   public void markPath(String strPath)
   {
   
   }
}

 // Enter the maze's filename (no .txt): maze0
 // WWWWWWWW
 // W....W.W
 // WW.W...W
 // W....W.W
 // W.W.WW.E
 // S.W.WW.W
 // W......W
 // WWWWWWWW
 // 
 // Options: 
 // 1: Find the shortest path
 // 	If no path exists, say so.
 // 2: Mark only the shortest correct path and display the count of STEPs.
 // 	If no path exists, say so.
 // Please make a selection: 2
 // Sortest lenght path is: 10
 //   Sortest path is: ((5,0),10),((5,1),9),((6,1),8),((6,2),7),((6,3),6),((6,4),5),((6,5),4),((6,6),3),((5,6),2),((4,6),1),((4,7),0)
 // WWWWWWWW
 // W....W.W
 // WW.W...W
 // W....W.W
 // W.W.WW*E
 // S*W.WW*W
 // W******W
 // WWWWWWWW