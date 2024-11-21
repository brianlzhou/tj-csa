// Name:   
// Date:
 
import java.util.*;
import java.io.*;

/* Resource classes and interfaces
 * for use with Graphs3: EdgeList,
 *              Graphs4: DFS-BFS
 *          and Graphs5: EdgeListCities
 */

/**************** Graphs 3: EdgeList *****/
interface VertexInterface
{
   public String getName();
   public HashSet<Vertex> getAdjacencies();
   
   /*
     postcondition: if the set already contains a vertex with the same name, the vertex v is not added
                    this method should be O(1)
   */
   public void addAdjacent(Vertex v);
   /*
     postcondition:  returns as a string one vertex with its adjacencies, without commas.
                     for example, D [C A]
     */
   public String toString(); 
 
} 
 
/*************************************************************/
class Vertex implements VertexInterface, Comparable<Vertex> //2 vertexes are equal if and only if they have the same name
{
   private final String name;
   private HashSet<Vertex> adjacencies;
   private TreeSet<Vertex> Tadjacencies;
   /* enter your code here  */
   
   public Vertex(String n) {
      name = n;
      adjacencies = new HashSet<Vertex>();
      Tadjacencies = new TreeSet<Vertex>();
   }
   
   public String getName() {
      return name;
   }
   
   public HashSet<Vertex> getAdjacencies() {
      return adjacencies;
   }
   
   public TreeSet<Vertex> getTAdjacencies() {
      return Tadjacencies;
   }
   
   public void addAdjacent(Vertex v) {
      adjacencies.add(v);
      Tadjacencies.add(v);
   }
   
   public String toString() {
      String returner = name + " [";
      if (adjacencies.isEmpty()) 
         return returner + "]";
      /*for (Vertex v : adjacencies) {
         returner = returner + v.getName() + " ";
      }*/
      Iterator<Vertex> i = adjacencies.iterator();
      while (i.hasNext())
         returner = returner + i.next().getName() + " ";
      returner = returner.substring(0, returner.length() - 1);
      return returner + "]";
   }
   
   public int compareTo(Vertex v) {
      return name.compareTo(v.getName());
   }
   
   public boolean equals(Object other) {
      return other.getClass() == this.getClass() && ((Vertex)other).getName().equals(((Vertex)this).getName());
   }
   
   public int hashCode() {
      return this.toString().hashCode();
   }
}   

/*************************************************************/
interface AdjListInterface 
{
   public Set<Vertex> getVertices();
   public Vertex getVertex(String vName);
   public Map<String, Vertex> getVertexMap();  //this is just for codepost testing
   
   /*      
      postcondition: if a Vertex with the name v exists, then the map is unchanged.
                     addVertex should work in O(log n)
   */
   public void addVertex(String vName);
   
   /*
      precondition:  both Vertexes, source and target, are already stored in the graph.
      postcondition:  addEdge should work in O(1)
   */
   public void addEdge(String source, String target); 
   
   /*
       returns the whole graph as one string, e.g.:
       A [C]
       B [A]
       C [C D]
       D [C A]
     */
   public String toString(); 

}

  
/********************** Graphs 4: DFS and BFS *****/
interface DFS_BFS
{
   public List<Vertex> depthFirstSearch(String name);
   public List<Vertex> breadthFirstSearch(String name);
   /*   extra credit methods 
   public List<Vertex> depthFirstRecur(String name);
   public List<Vertex> depthFirstRecurHelper(Vertex v, ArrayList<Vertex> reachable);*/
}

/****************** Graphs 5: Edgelist with Cities *****/
interface EdgeListWithCities
{
   public void readData(String cities, String edges) throws FileNotFoundException;
   public int edgeCount();
   public int vertexCount();
   public boolean isReachable(String source, String target);
   public boolean isStronglyConnected(); //return true if every vertex is reachable from every 
                                          //other vertex, otherwise false 
}


/*************  start the Adjacency-List graph  *********/
public class AdjList implements AdjListInterface, DFS_BFS//, EdgeListWithCities
{
   //we want our map to be ordered alphabetically by vertex name
   private Map<String, Vertex> vertexMap = new TreeMap<String, Vertex>();
      
   /* constructor is not needed because of the instantiation above */
  
   /* enter your code here  */
   public Set<Vertex> getVertices() {
      return new TreeSet<Vertex>(vertexMap.values());
   }
   
   public Vertex getVertex(String vName) {
      return vertexMap.get(vName);
   }
   
   public Map<String, Vertex> getVertexMap() {  //this is just for codepost testing
      return vertexMap;
   }
   /*      
      postcondition: if a Vertex with the name v exists, then the map is unchanged.
                     addVertex should work in O(log n)
   */
   public void addVertex(String vName) {
      if(vertexMap.get(vName) == null)
         vertexMap.put(vName, new Vertex(vName));
   }
   
   /*
      precondition:  both Vertexes, source and target, are already stored in the graph.
      postcondition:  addEdge should work in O(1)
   */
   public void addEdge(String source, String target) {
      vertexMap.get(source).addAdjacent(vertexMap.get(target));
   }
   
   /*
       returns the whole graph as one string, e.g.:
       A [C]
       B [A]
       C [C D]
       D [C A]
     */
   public String toString() {
      String returner = "";
      for (String key : vertexMap.keySet()) {
         returner = returner + vertexMap.get(key).toString() + "\n";
      }
      return returner;
   } 
   
   public List<Vertex> depthFirstSearch(String name) {
      //First, create both a list of reachable vertices and a stack.  
      List<Vertex> l = new ArrayList<>();
      Stack<Vertex> s = new Stack<>();
      Vertex d = vertexMap.get(name);
      //Push Ds adjacent vertices on the stack.
      for(Vertex adjvtx : d.getAdjacencies()) {
         s.push(adjvtx);
      }
      //While the stack is not empty
      while(!s.isEmpty()) {
         //Pop a vertex. If the vertex isn't in the list, put it in the list.
         Vertex p = s.pop();
         if(!l.contains(p)) {
            l.add(p);
            //Process the vertexs edges:  push each vertex on the stack
            for(Vertex vtx : p.getAdjacencies()) {
               s.push(vtx);
            }   
         }
      }
      //Return the list of reachable vertices.
      return l;  
   }
   
   public List<Vertex> breadthFirstSearch(String name) {
      //First, create both a list of reachable vertices and a queue.
      List<Vertex> l = new ArrayList<>();
      Queue<Vertex> q = new LinkedList<>();
      Vertex d = vertexMap.get(name);
      //Enqueue Ds adjacent vertices.
      for(Vertex enqueue : d.getAdjacencies()) {
         q.add(enqueue);
      }
      //While the queue is not empty
      while(!q.isEmpty()) {
         //Dequeue a vertex.  If the vertex isn't in the list, put it in the list.
         Vertex dequeue = q.remove();
         if(!l.contains(dequeue)) {
            l.add(dequeue);
            //Process the vertexs edges:  enqueue each adjacent vertex.
            for(Vertex adjvtx : dequeue.getAdjacencies()) {
               q.add(adjvtx);
            }
         }
      }
      return l;
   }
}