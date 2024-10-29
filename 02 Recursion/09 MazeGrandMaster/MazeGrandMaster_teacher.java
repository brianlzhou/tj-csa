//mlbillington@fcps.edu  Nov 2014
//updated for GradeIt, tmrudwick@fcps.edu  Nov 2015 
//shortest path, counts the steps.  ejurj@fcps.edu   Oct 2019
import java.util.*;
import java.io.*;
public class MazeGrandMaster_teacher
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the maze's filename (no .txt): ");
      Maze m = new Maze(sc.next());
     // Maze m = new Maze();     //extension:  generate a random maze
      m.display();      //display maze
      System.out.println("Options: ");
      System.out.println("1: Find the shortest path\n\tIf no path exists, say so.");
      System.out.println("2: Mark only the shortest correct path and display the count of STEPs.\n\tIf no path exists, say so.");
      System.out.print("Please make a selection: ");
      m.solve(sc.nextInt());
     
   } 
}
 

class Maze
{
   //constants
   private final char WALL = 'W';
   private final char DOT = '.';
   private final char START = 'S';
   private final char EXIT = 'E';
   private final char STEP = '*';
   //fields
   private char[][] maze;
   private int startRow, startCol;
 
  //constructors
   public Maze()  //extension:  generate a random maze
   {
   }
   public Maze(char[][] m)  //copy constructor
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
   public Maze(String filename)  
   {
      //use a try-catch block
      //use next(), not nextLine()
      Scanner infile = null;
      try{
         infile = new Scanner(new File(filename +".txt"));
      }
      catch(FileNotFoundException e)
      {
         System.out.println("File not found");
         System.exit(0);
      }
      int rows = infile.nextInt();
      int cols = infile.nextInt();
      maze = new char[rows][cols];
      for(int r = 0; r < rows; r++)
      {
         String s = infile.next();        //read a row
         for(int c = 0; c < cols; c++)
            maze[r][c] = s.charAt(c);     //take it apart   
      }
      infile.close();
      
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
                  display();
               }
               else
                  System.out.println("No path exists."); 
               break;
            }
         default:
            System.out.println("File not found");   
      }
   }
   
   
   
   //helper method for the extension
   //returns -1 only if all are -1
   //otherwise returns the min that is not -1
   public int findMinNotNegative1(int u,int l,int d,int r) 
   {
      int result = -1;
      if(u!=-1)
         if(result == -1) result = u;
         else result = Math.min(result, u);
      
      if(l!=-1)
         if(result == -1) result = l;
         else result = Math.min(result, l);
         
      if(d!=-1)
         if(result == -1) result = d;
         else result = Math.min(result, d);
         
      if(r!=-1)
         if(result == -1) result = r;
         else result = Math.min(result, r);  
         
      return result;       
   }
 /*  1   recur until you find E, then return the shortest path
     returns -1 if it fails
     precondition: Start can't match with Exit
 */ 
   public int findShortestLengthPath(int r, int c)
   {
      if(r < 0 || c < 0 || r >= maze.length || c >= maze[0].length)
         return -1;
      if( maze[r][c] == WALL || maze[r][c] == 'o')
         return -1;
      if( maze[r][c] == EXIT )
         return 0;
    
      if(maze[r][c] == DOT || maze[r][c] == START )    //check for DOT
      {
         if( maze[r][c] == DOT ) 
            maze[r][c] = 'o';    //mark the STEP with a temporary character
    
         int up = findShortestLengthPath(r - 1, c),
             left = findShortestLengthPath(r, c - 1),
             down = findShortestLengthPath(r + 1, c),
             right = findShortestLengthPath(r, c + 1); //recur all directions  
    
         if(maze[r][c] != START)
         {
            maze[r][c] = DOT; //change back temp char
            if(up!=-1 || left!=-1 || down!=-1 || right!=-1)
               return 1 + findMinNotNegative1(up,left,down,right);
            else
               return -1; //not found
         }
         else
         {
            display();
            int shortestPath = findMinNotNegative1(up,left,down,right);
            if (shortestPath!=-1) 
               return 1 + shortestPath;
            else 
               return -1;
         }
      }
      return -1;
   }
   
   //returns the length when the format of the path is "((3,4),10),((3,5),9),..."
   //precondition: string is either empty or follows the formt above
   //returns - if the string is empty
   public int getPathLength(String strPath)
   {
      if(strPath.length()==0) return -1;
      
      int start = strPath.indexOf(",", strPath.indexOf(",") + 1) + 1,
         end = strPath.indexOf(")", strPath.indexOf(")") + 1);
      return Integer.parseInt(strPath.substring(start,end));
      
   }   
   
/*  2   recur until you find E, then build the True path 
     use only the shortest path
     returns -1 if it fails
     precondition: Start can't match with Exit
 */
   public String findShortestPath(int r, int c)
   {
      if(r < 0 || c < 0 || r >= maze.length || c >= maze[0].length)
         return "";
      if( maze[r][c] == WALL || maze[r][c] == 'o')
         return "";
      if( maze[r][c] == EXIT )
         return "((" + r + "," + c + ")," + 0 + ")";
    
      if(maze[r][c] == DOT || maze[r][c] == START )    //check for DOT
      {
         if( maze[r][c] == DOT ) 
            maze[r][c] = 'o';    //mark the STEP with a temporary character
    
         String strUp = findShortestPath(r - 1, c),
             strLeft = findShortestPath(r, c - 1),
             strDown = findShortestPath(r + 1, c),
             strRight = findShortestPath(r, c + 1); //recur all directions  
         int up = getPathLength(strUp),
            left = getPathLength(strLeft),
            down = getPathLength(strDown),
            right = getPathLength(strRight);    
    
         if(maze[r][c] != START)
         {
            maze[r][c] = DOT; //change back temp char
            if(up!=-1 || left!=-1 || down!=-1 || right!=-1)
            {
               int sp = findMinNotNegative1(up,left,down,right);
               if(up==sp)
                  return "((" + r + "," + c + ")," + (1+sp) + ")," + strUp;
               if(left==sp)
                  return "((" + r + "," + c + ")," + (1+sp) + ")," + strLeft;
               if(down==sp)
                  return "((" + r + "," + c + ")," + (1+sp) + ")," + strDown;
               if(right==sp)
                  return "((" + r + "," + c + ")," + (1+sp) + ")," + strRight;         
            }
            else
               return ""; //not found
         }
         else
         {
            //display();
            int sp = findMinNotNegative1(up,left,down,right);
            if (sp!=-1) 
            {
               if(up==sp)
                  return "((" + r + "," + c + ")," + (1+sp) + ")," + strUp;
               if(left==sp)
                  return "((" + r + "," + c + ")," + (1+sp) + ")," + strLeft;
               if(down==sp)
                  return "((" + r + "," + c + ")," + (1+sp) + ")," + strDown;
               if(right==sp)
                  return "((" + r + "," + c + ")," + (1+sp) + ")," + strRight;
            }
            else 
               return "";
         }
      }
      return "";
   }
   
  
   
    
   
   //a recursive method that takes an argument created by the method 2 in the form of 
   //((5,0),10),((5,1),9),((6,1),8),((6,2),7),((6,3),6),((6,4),5),((6,5),4),((6,6),3),((5,6),2),((4,6),1),((4,7),0)
   //and it marks the actual path in the maze with STEP
   //precondition:   the String is either an empty String or one that has the correct format above
   //                the indexes must be correct for this method to work  
   public void markPath(String strPath)
   {
      if(strPath.equals(""))
         return;
      //now we know at least one element exists 
      int start,end;
      
      start = strPath.indexOf("(") + 2;
      end = strPath.indexOf(",");
      int row = Integer.parseInt(strPath.substring(start,end));
      

      start = strPath.indexOf(",") + 1;
      end = strPath.indexOf(")");
      int col = Integer.parseInt(strPath.substring(start,end));
      if (maze[row][col]!=START && maze[row][col]!=EXIT) 
         maze[row][col] = STEP;
      //now recur
      strPath =strPath.substring(strPath.indexOf(")", strPath.indexOf(")") + 1));
      if(strPath.length()!=1) //last parantheses
         markPath( strPath.substring(2));
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