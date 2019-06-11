// Shortest path from one node to each of
// the other nodes, and return it as
// an array
// Using BFS

import java.util.*;
import java.lang.*;

public class ShortestPath {
  public static class Graph {
    // Global variables
    private Node[] nodes;
    private static int EDGE_DISTANCE = 6;

    // constructor
    public Graph(int size) {

    }

    private class Node {

    }

    private Node getNode(int d) {

    }

    public void addEdge(int first, int second) {

    }

    public int [] shortestPath(int start) {
      LinkedList<Integer> queue = new LinkedList<Integer>();
      queue.add(start);

      //boolean[] visited = new boolean[nodes.length]; // not even needed
      int[] distances = new int[nodes.length];

      // If you don't find some node, return -1
      // as the distance to that node (not connected)
      Arrays.fill(distances, -1);

      // Distance from myself to myself is just 0
      distances[start] = 0;

      while(!queue.isEmpty()) {
        // retrieves & removes head of queue
        // returns null if queue is empty
        int node = queue.poll();

        for(int neighbor : nodes[node].neighbors) {
          if(distances[neighbor] == -1) {
            // The distance to our neighbor is just one more than
            // the distance to us
            distances[neighbor] = distances[node] + EDGE_DISTANCE;

            queue.add(neighbor);

          }
        }
      }
      return distances;
    }
  }
}
