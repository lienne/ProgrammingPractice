import java.util.*;
import java.io.*;

public class BFS {
  // Global variables can be used within any method
  boolean [][] matrix;

  // constructor
  public BFS(String filename) throws Exception {
    Scanner in = new Scanner(new File(filename));
    int N = in.nextInt();

    matrix = new boolean[N][N];

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        matrix[i][j] = (in.nextInt() == 1); // checks for true or false
      }
    }
  }

  public void bfsImplementation(int start) {
    /*
    //  Iterative BFS places vertices in a Queue.
    // When we pull a vertex out of the que, we process it (in this case, print it to screen),
    // then place all its unvisited neighbors in the queue.
    // We mark each vertex as visited as it goes into the queue, because that ensures we never place
    // a vertex into the queue more than once.
    // (That significantly reduces the space complexity of this algorithm when dealing with a
    // large, dense graph.)
    //
    // A Queue is an  abstract data type. We need to decide what underlying data structure to use
    // to implement it. Java will not allow you to do, for ex, Queue<Integer> q = new Queue<>();
    */

    Queue<Integer> q = new LinkedList<Integer>();
    boolean [] visited = new boolean[matrix.length]; // matrix is a global variable

    // Start by adding the start vertex to the queue.
    // It will be the first thing dequeued, at which point we'll print it and add
    // its neighbors to the queue.
    q.add(start); // .add() is a LinkedList method
    visited[start] = true; // start is being passed in

    while(!q.isEmpty()) {
      // Remove a node from the queue and process it. If we were searching for
      // a particular node (a "goal"), this is where we would check whether we
      // had found it. If so, we would terminate the BFS. However,  since the goal
      // of *this* BFS method is simply to print all nodes of a graph in BFS order,
      // we simply print this node and move on.
      // We're iterating through the whole graph.
      int node = q.remove(); // .remove() is a LinkedList method
      System.out.println(node);

      // Add all neighbors of 'node' to the queue (as long as they haven't been visited already).
      for(int i = 0; i < matrix.length; i++) {
        if(matrix[node][i] && !visited[i]) {
          visited[i] = true;
          q.add(i);
        }
      }
    }
  }

  public static void main(String [] args) throws Exception {
    BFS g = new BFS("g1.txt");
    System.out.println("BFS(0):"); g.bfsImplementation(0);

  }
}
