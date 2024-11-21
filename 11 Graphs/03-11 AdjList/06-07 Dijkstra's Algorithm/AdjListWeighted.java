// Name:   
// Date:
 
import java.util.*;
import java.io.*;

/* Resource classes and interfaces for 
 *              Graphs6: Dijkstra
 *              Graphs7: Dijkstra with Cities
 */

class Neighbor implements Comparable<Neighbor>
{
   //2 Neighbors are equal if and only if they have the same name
   //implement all methods needed for a HashSet and TreeSet to work with Neighbor objects
   private final wVertex target;
   private final double edgeDistance;
   
   public Neighbor(wVertex t, double d) {
      target = t;
      edgeDistance = d;
   }
   
   //add all methods needed for a HashSet and TreeSet to function with Neighbor objects
   //use only target, not distances, since a vertex can't have 2 neighbors that have the same target
   //.........
   
   public int compareTo(Neighbor n) {
      return target.compareTo(n.target);
   }
   
   public boolean equals(Neighbor n) {
      return target.getName().equals(n.target.getName());
   }
   
   public int hashCode()
   {
      return target.getName().hashCode();
   } 
   
   public String toString()
   {
      return target.getName() + " " + edgeDistance;  
   }
   
   public double getEdgeDistance() {
      return edgeDistance;
   }
   
   public wVertex getTarget() {
      return target;
   }
}

 /**************************************************************/
class PQelement implements Comparable<PQelement> { 
//used just for a PQ, contains a wVertex and a distance, also previous that is used for Dijksra 7
//compareTo is using the distanceToVertex to order them such that the PriorityQueue works
//will be used by the priority queue to order by distance
 
   private wVertex vertex;
   private Double distanceToSource; 
   private Double distanceToVertex;
   private wVertex previous; //for Dijkstra 7
      
   public PQelement(wVertex v, double d) {
      vertex = v;
      distanceToVertex = d;
   }
   
   //getter and setter methods provided
   public wVertex getVertex() {
      return this.vertex;
   }
   
   public Double getDistanceToVertex() {
      return this.distanceToVertex;
   }
   
   public void setVertex(wVertex v) {
      this.vertex = v;
   }
   
   public void setDistanceToVertex(Double d) {
      this.distanceToVertex = d;
   }   
   
   public int compareTo(PQelement other) {
      //we assume no overflow will happen since distances will not go over the range of int
      return (int)(distanceToVertex - other.distanceToVertex);
   }
   
   public wVertex getPrevious()  //Dijkstra 7
   {
      return this.previous;
   }
   public void setPrevious(wVertex v) //Dijkstra 7
   {
      this.previous = v;
   } 
   
   //implement toString to match the sample output   
   public String toString()
   { 
      String toReturn = "";
      //your code here...
      toReturn = toReturn + vertex.getName() + " " + distanceToVertex;
      return toReturn;
   }
}

/********************* wVertexInterface ************************/
interface wVertexInterface 
{
   public String getName(); 
      
    //returns an arraylist of PQelements that store distanceToVertex to another wVertex
   public ArrayList<PQelement> getAlDistanceToVertex();
   
   //returns the PQelement that has the vertex equal to v
   public PQelement getPQelement(wVertex v);
      
   /*
   postcondition: returns null if wVertex v is not in the alDistanceToVertex
                  or the distance associated with that wVertex in case there is a PQelement that has v as wVertex
   */
   public Double getDistanceToVertex(wVertex v);
   
   /*
   precondition:  v is not null
   postcondition: - if the alDistanceToVertex has a PQelement that has the wVertex component equal to v
                  it updates the distanceToVertex component to d
                  - if the alDistanceToVertex has no PQelement that has the wVertex component equal to v,
                  then a new PQelement is added to the alDistanceToVertex using v and d   
   */
   public void setDistanceToVertex(wVertex v, double m);
   public Set<Neighbor> getNeighbors(); 
   public void addAdjacent(wVertex v, double d);  
   public String toString(); 
}

class wVertex implements Comparable<wVertex>, wVertexInterface 
{ 
   public static final double NODISTANCE = Double.POSITIVE_INFINITY; //constant to be used in class
   private final String name;
   private Set<Neighbor> neighbors;  
   private ArrayList<PQelement> alDistanceToVertex; //should have no duplicates, enforced by the getter/setter methods
  
   public wVertex(String n) {
      name = n;
      neighbors = new HashSet<Neighbor>();
      alDistanceToVertex = new ArrayList<PQelement>();
   }
   
   /* constructor, accessors, modifiers  */ 
   public String getName() {
      return name;
   } 
      
    //returns an arraylist of PQelements that store distanceToVertex to another wVertex
   public ArrayList<PQelement> getAlDistanceToVertex() {
      return alDistanceToVertex;
   }
   
   //returns the PQelement that has the vertex equal to v
   public PQelement getPQelement(wVertex v) {
      for(PQelement p : alDistanceToVertex) {
         if(p.getVertex().getName().equals(v.getName())) {
            return p;
         }
      }
      return null;
   }
      
   /*
   postcondition: returns null if wVertex v is not in the alDistanceToVertex
                  or the distance associated with that wVertex in case there is a PQelement that has v as wVertex
   */
   public Double getDistanceToVertex(wVertex v) {
      for(PQelement p : alDistanceToVertex) {
         if(p.getVertex().equals(v))
            return p.getDistanceToVertex();
      }
      return null;
   }
   
   /*
   precondition:  v is not null
   postcondition: - if the alDistanceToVertex has a PQelement that has the wVertex component equal to v
                  it updates the distanceToVertex component to d
                  - if the alDistanceToVertex has no PQelement that has the wVertex component equal to v,
                  then a new PQelement is added to the alDistanceToVertex using v and d   
   */
   public void setDistanceToVertex(wVertex v, double m) {
      if(v.getPQelement(v) != null) {
         v.getPQelement(v).setDistanceToVertex(m);
      }
      else {
         alDistanceToVertex.add(new PQelement(v,m));
      }
   }
   
   public Set<Neighbor> getNeighbors() {
      return neighbors;
   } 
   
   public void addAdjacent(wVertex v, double d) {
      neighbors.add(new Neighbor(v,d));
   }  
   
   /* 2 vertexes are equal if and only if they have the same name
      add all methods needed for a HashSet and TreeSet to function with Neighbor objects
      use only target, not distances, since a vertex can't have 2 neighbors that have the same target   
   */
   public int compareTo(wVertex v) {
      return name.compareTo(v.name);
   }
   
   public int hashCode()
   {
      return name.hashCode();
   } 
   
   public boolean equals(wVertex w) {
      return name.equals(w.getName());
   }
   
   public String toString()
   { 
      String toReturn = name;
      toReturn += " "+ neighbors;
      toReturn += " List: " + alDistanceToVertex; 
      return toReturn;
   }
}

/*********************   Interface for Graphs 6:  Dijkstra ****************/
interface AdjListWeightedInterface 
{
   public Set<wVertex> getVertices();  
   public Map<String, wVertex> getVertexMap();  //this is just for codepost testing
   public wVertex getVertex(String vName);
   /* 
      postcondition: if a Vertex with the name v exists, then the map is unchanged.
                     addVertex should work in O(logn)
   */
   public void addVertex(String vName);
   /*
      precondition:  both Vertexes, source and target, are already stored in the graph.
                     addEdge should work in O(1)
   */   
   public void addEdge(String source, String target, double d);
   public void minimumWeightPath(String vertexName); // Dijstra's algorithm
   public String toString();  
}  

 /***********************  Interface for Graphs 7:  Dijkstra with Cities   */
interface AdjListWeightedInterfaceWithCities 
{       
   public List<String> getShortestPathTo(wVertex target);
   public void readData(String vertexNames, String edgeListData) ;
}
 
/****************************************************************/ 
/**************** this is the graph  ****************************/
public class AdjListWeighted implements AdjListWeightedInterface//,AdjListWeightedInterfaceWithCities
{
   //we want our map to be ordered alphabetically by vertex name
   private Map<String, wVertex> vertexMap = new TreeMap<String, wVertex>();
   
   /* default constructor -- not needed!  */
  
   /* similar to AdjList, but handles distances (weights) and wVertex*/ 
   public Set<wVertex> getVertices(){
      return new TreeSet<wVertex>(vertexMap.values());
   }  
   
   public Map<String, wVertex> getVertexMap() {
      return vertexMap;
   }   
   
   public wVertex getVertex(String vName) {
      return vertexMap.get(vName);
   }
   /* 
      postcondition: if a Vertex with the name v exists, then the map is unchanged.
                     addVertex should work in O(logn)
   */
   public void addVertex(String vName) {
      if(vertexMap.get(vName) == null)
         vertexMap.put(vName, new wVertex(vName));
   }
   /*
      precondition:  both Vertexes, source and target, are already stored in the graph.
                     addEdge should work in O(1)
   */   
   public void addEdge(String source, String target, double d) {
      vertexMap.get(source).addAdjacent(vertexMap.get(target), d);
   }
   
   public void minimumWeightPath(String vertexName) {// Dijstra's algorithm
      wVertex source = getVertex(vertexName);
      
      for(String s : vertexMap.keySet()) {
         wVertex temp = vertexMap.get(s);
         source.setDistanceToVertex(temp, source.NODISTANCE);
      }
      source.getPQelement(source).setDistanceToVertex(0.0);
      
      PriorityQueue<PQelement> p = new PriorityQueue<>();
      p.add(source.getPQelement(source));

      while(!p.isEmpty()){
         PQelement removedPQ = p.remove();
         wVertex removedV = removedPQ.getVertex();
         
         for(Neighbor n : removedV.getNeighbors()) {
            PQelement nbor = source.getPQelement(n.getTarget());
            Double newnum = source.getDistanceToVertex(removedV) + n.getEdgeDistance();                                                                                                                          ; 
            Double oldnum = nbor.getDistanceToVertex();
            if(newnum<oldnum) {
               p.remove(nbor);
               nbor.setDistanceToVertex(newnum);
               p.add(nbor);
            }
            
         }
      }
   }

   public String toString()
   {
      String strResult = "";
      for(String vName: vertexMap.keySet())
      {
         strResult += vertexMap.get(vName) + "\n"; 
      }
      return strResult;
   }
   
   /*  Graphs 7 has two more methods */
   /*  Graphs 7 has two more methods */
   public List<String> getShortestPathTo(wVertex vSource, wVertex target)
   {
      wVertex sourceVertex;
      wVertex targetVertex;
      wVertex copyVertex;
      PQelement copyPQelement;
      List<String> result;
      double copyDistance;
       
      sourceVertex = vSource;
      targetVertex = target;
      copyVertex = targetVertex;
      result = new ArrayList<String>();    
      while (!copyVertex.equals(vSource))
      {
         result.add(0, copyVertex.getName());
         copyPQelement = sourceVertex.getPQelement(copyVertex); 
         copyVertex = copyPQelement.getPrevious();
         copyDistance = copyPQelement.getDistanceToVertex();
         if (copyVertex==null || copyDistance == wVertex.NODISTANCE)
            return result;
      }
      result.add(0, vSource.getName());
      return result;       
   }
   public void readData(String vertexNames, String edgeListData) throws FileNotFoundException
   {
      /* use a try-catch  */
      String linestr, passtr;
      Scanner inputFile = null;
      Scanner edgeFile=null;
      double edgelength;
     
      try
      {
         inputFile = new Scanner(new File(vertexNames + ".txt"));
      }
      catch(Exception e)
      {
         System.out.print("File I/O exception caught.");
         System.exit(0);
      }
      if (inputFile.hasNext()) 
      {
         inputFile.nextLine();
      }
      while (inputFile.hasNext())
      {
         linestr = inputFile.nextLine();
         addVertex(linestr);
      }
      try
      {
         edgeFile = new Scanner(new File(edgeListData + ".txt"));
      }
      catch(Exception e)
      {
         System.out.print("File I/O exception caught.");
         System.exit(0);
      }
   
      while (edgeFile.hasNext())
      {
         linestr = edgeFile.nextLine();
         String[] words = linestr.split(" ");
         edgelength=Double.parseDouble(words[2]);     
         addEdge(words[0],words[1],edgelength);
      }
   
   }

}