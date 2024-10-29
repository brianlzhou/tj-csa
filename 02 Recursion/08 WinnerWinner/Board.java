public class Board
{
   private char[][] board;
   private int maxPath; // length of the longest possible path
   public Board(int rows, int cols, String line) { /* to be implemented in part (a) */ 
      zboard = new char[cols, rows];
      
   }
   
   /** returns the length of the longest possible path in the board */
   public int getMaxPath()
   { /* code not shown */ }
   /** calculates and returns the shortest path from S to X, if it exists
   * @param r is the number of rows in the board
   * @param c is the number of columns in the board
   */
   
   public int check(int r, int c )
   { /* to be implemented in part (b) */ }
   /** precondition: S and X exist in board
   * postcondition: returns either the length of the path from S to X,
   * or -1, if no path exists.
   */
   
   public int win()
   { /* to be implemented in part (c) */ }
}