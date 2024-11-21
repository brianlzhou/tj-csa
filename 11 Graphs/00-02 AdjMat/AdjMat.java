// Name:   
// Date:
 
import java.util.*;
import java.io.*;

/* Resource classes and interfaces
 * for use with Graph0 AdjMat_0_Driver,
 *              Graph1 WarshallDriver,
 *          and Graph2 FloydDriver
 */

interface AdjacencyMatrix
{
   public int[][] getGrid();
   public void addEdge(int source, int target);
   public void removeEdge(int source, int target);
   public boolean isEdge(int from, int to);
   public String toString();  //returns the grid as a String
   public int edgeCount();
   public List<Integer> getNeighbors(int source);
   //public List<String> getReachables(String from);  //Warshall extension
}

interface Warshall      //User-friendly functionality
{
   public boolean isEdge(String from, String to);
   public Map<String, Integer> getVertices();     
   public void readNames(String fileName) throws FileNotFoundException;
   public void readGrid(String fileName) throws FileNotFoundException;
   public void displayVertices();
   public void allPairsReachability();   // Warshall's Algorithm
   // public List<String> getReachables(String from);  //Warshall extension
}

interface Floyd
{
   public int getCost(int from, int to);
   public int getCost(String from, String to);
   public void allPairsWeighted(); 
}

public class AdjMat implements AdjacencyMatrix,Warshall,Floyd 
{
   private int[][] grid = null;   //adjacency matrix representation
   private Map<String, Integer> vertices = null;   // name maps to index (for Warshall & Floyd)
   /*for Warshall's Extension*/  ArrayList<String> nameList = null;  //reverses the map, index-->name
	  
   /*  write constructor, accessor method, and instance methods here  */  
   public AdjMat(int size) {
      grid = new int[size][size];
      vertices = new TreeMap<String, Integer>();
   }
   
   public int[][] getGrid() {
      return grid;
   }
   
   public void addEdge(int source, int target) {
      if(source >= 0 && source < grid.length && target >= 0 && target < grid.length) {
         grid[source][target] = 1;
      }
   }
   
   public void removeEdge(int source, int target) {
      if(source >= 0 && source < grid.length && target >= 0 && target < grid.length) {
         grid[source][target] = 0;
      }
   }
   
   public boolean isEdge(int from, int to) {
      return(grid[from][to] < 9999);
   }
      
   public String toString() {
      String returner = "";
      for(int[] i : grid) {
         for(int j : i) {
            returner = returner + j + " ";
         }
         returner = returner + "\n";
      }
      return returner;
   }
   
   public int edgeCount() {
      int count = 0;
      for(int[] i : grid) {
         for(int j : i) {
            if(j == 1)
               count++;
         }
      }
      return count;
   }
   
   public List<Integer> getNeighbors(int source) {
      List<Integer> returner = new ArrayList<>();
      for(int i = 0; i< grid[source].length; i++) {
         if(grid[source][i] == 1) {
            returner.add(i);
         }
      }
      return returner;
   }
   
   public ArrayList<Integer> getNeighborsRemoveImpossible(int source) {
      ArrayList<Integer> returner = new ArrayList<>();
      for(int i = 0; i< grid[source].length; i++) {
         if(grid[source][i] < 9999) {
            returner.add(i);
         }
      }
      return returner;
   }
   
   public boolean isEdge(String from, String to) {
      return(grid[vertices.get(from)][vertices.get(to)] == 1);
   }
   
   public Map<String, Integer> getVertices() {
      return vertices;
   }     
   
   public void readNames(String fileName) throws FileNotFoundException {
      Scanner sc = new Scanner(new File(fileName));
      int size = sc.nextInt();
      for(int i = 0; i<size; i++) {
         vertices.put(sc.next(), i);
      }
   }
   
   public void readGrid(String fileName) throws FileNotFoundException {
      Scanner sc = new Scanner(new File(fileName));
      int size = sc.nextInt();
      for(int r = 0; r<size; r++) {
         for(int c = 0; c<size; c++) {
            grid[r][c] = sc.nextInt();
         }
      }
   }
   
   public void displayVertices() {
      String returner = "";
      Iterator<String> i = vertices.keySet().iterator();
      while(i.hasNext()){
         String temp = i.next();
         returner = returner + vertices.get(temp) + "-" + temp + "\n";
      }
      System.out.println(returner);
   }
   
   public void allPairsReachability() {   // Warshall's Algorithm 
      for (int r= 0; r< grid.length; r++) {
         for (int c= 0; c< grid.length; c++) {
            if(reachabilityHelper(r, c, new ArrayList<Integer>())){
               grid[r][c] = 1;
            }
            else{
               grid[r][c] = 0;
            }
         }
      }
   }
   
   public boolean reachabilityHelper(int origin, int target, ArrayList<Integer> pathway){
      if(origin==target && pathway.size() > 0){
         return true;
      }
      
      for (Integer i : getNeighbors(origin)) {
         if(pathway.contains(i)) {//skip
         }
         else {
            pathway.add(i);
            if(reachabilityHelper(i, target, pathway)) {
               return true;
            }
         }
      }
      return false;
   }
   
   public int getCost(int from, int to) {
      return costHelper(from, to, new ArrayList<>(), 9999, new ArrayList<Integer>());
   }
   
   public int costHelper(int origin, int target, ArrayList<Integer> pathway, int min, ArrayList<Integer> neighbors) {
      if(origin==target){
         if(pathway.contains(target))
            pathway.remove(target);
         return grid[origin][target];
      }  

      for (Integer i : getNeighborsRemoveImpossible(origin)) {
         if(pathway.contains(i) || !neighbors.contains(i)) {//skip
         }
         else {
            pathway.add(i);
            if(getNeighborsRemoveImpossible(origin).size()>1)
               neighbors = getNeighborsRemoveImpossible(origin);
            
            int testRun = grid[origin][i] + costHelper(i, target, pathway, min, neighbors);
            if(testRun < min){
               min = testRun;
            }
         }
      }
      return min;
   }
   
   public int getCost(String from, String to) {
      return getCost(vertices.get(from), vertices.get(to));
   }
   
   public void allPairsWeighted() {
      int[][] newGrid = new int[grid.length][grid.length];
      for (int r = 0; r < grid.length; r++) {
         for (int c = 0; c < grid.length; c++) {
            newGrid[r][c] = getCost(r,c);
         }
      }
      grid = newGrid;
   }
}
