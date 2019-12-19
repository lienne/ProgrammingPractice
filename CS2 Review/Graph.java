// Some terminology
// Vertices are adjacent 

// A cycle is a path in which the first and last vertex are the same, but no edges are repeated, and there is at least one edge.
// (This is also a closed path)

// A simple cycle is a cycle in which no vertices or edges are repeated (except, of course, for the first/last vertex in the cycle, 
// which is visited exactly twice.)

// The path length of some path is the # of edges in that path. A path can be many edges!

// An undirected graph that has a path from every vertex to every other vertex in the graph is said to be connected.
// An undirected graph that does not satisfy this property is said to be disconnected.

// A connected component is a maximal connected subgraph.

// Any graph is a subgraph of itself.

// An empty graph can have nodes, but it can't have any edges.

// Complete Bipartite Graph - "bi" means two, so there are two partitions of vertices. Vertices within a partition can't be connected
// to each other, but each vertex in one partition connects to every other vertex in the other partition.
// Bi = two, partite = partitions, two partitions

// Petersen Graph - a very good graph for testing! This thing will wreck your shit.

// Two common representations for graphs in memory: Adjacency Matrix an Adjacency List.

// Adjacency matrix:
// An NxN matrix (or array) where N is the # of vertices in the graph.
// The (i, j) entry of the matrix is the weight of the edge from i to j (or a boolean value indicating whether there's an edge at all,
// or in the case of multigraphs, the # of edges from i to j).
// Arrays are row major. # of rows comes first when we declare a 2D array.
// Space complexity is O(|v|^2), for v = # of vertices.
// An array has O(1) for look-up and for insertion.
// If you have an indirected graph, the 2D array is mirrored along the diagonal.

// Adjacency List:
// Keeps a linked list for each vertex, indicating the adjacent vertices for that vertex (that is, a list of vertices such that 
// there exists an edge from the source node to each of the other vertices).
// Gets really bad if we have a lot of edges - the linked list can get really long, and runtime gets really slow.
// Good for sparce graphs.
// You can also use a hash map of hash sets to represent adjacency lists as well!
// HashMap<Integer, HashSet<Integer>> - O(1) runtime for lookup

// Sparse vs. Dense graphs
// Sparce - relatively few edges compared to # of vertices.
// Dense - a lot of edges

// Exotic representations!
// Edge List - A list of pairs of adjaceny vertices. Finding all the edges adjacent to a given vertex is
// inneficient, but there are algorithms where this representation might be useful.
// Adjacency Function - For generating adjacent vertices where the representation is implicit. Ex: The 8-puzzle problem

//
//
//
//
//
//
//
//

// This is a framework for initializing a graph from an input file that contains an 
// adjacency matrix.
// The first line of the input file indicates how many vertices are in the graph.
// The following n lines contain the adjacency matrix for the (zero and ones).
// (Remember: edges are the lines, vertices are the points)
//
// For example:
//
// 4
// 0 1 0 1
// 1 0 1 1
// 0 1 0 1
// 1 1 1 0
//
// ....which corresponds to the unweighted, undirected graph:
//
// 0---1
//  \ /|
//   X |
//  / \|
// 2---3
//
// These values are read into a boolean matrix, and we perform breadth-first and
// depth-first search traversals starting from an arbitrary vertex.

import java.util.*;
import java.io.*;

public class Graph {
    int[][] matrix;
    // boolean [][] matrix;

    // Initialize 'matrix' from input file
    public Graph(String filename) throws Exception {
        Scanner in = new Scanner(new File(filename));
        int N = in.nextInt();

        matrix = new int[N][N];
        // matrix = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = (in.nextInt());
                // matrix[i][j] = (in.nextInt() == 1);
            }
        }

        // for(int j = 0; j < N; j++) {
        // for(int k = 0; k < N; k++) {
        // System.out.print(matrix[j][k] + " ");
        // }
        // System.out.println();
        // }

        in.close();
    }

    // Iterative BFS method.
    // Iterative BFS places vertices in a queue.
    // When we pull a vertex out of the queue, we process it (in this case, print it
    // to screen), then place all its unvisited neighbors in the queue.
    // We mark each vertex as visiter as it goes into the queue, because that
    // ensures we never place a vertex into the queue more than once.
    // (That can significantly reduce the space complexity of this algorithm
    // when dealing with a large, dense graph).
    // A queue is an abstract data type. We need to decide what underlying data
    // structure to use to implement it. Java will not allow you to do, for example,
    // Queue<Integer> q = new Queue<>();
    public void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];

        // Start by adding the start vertex to the queue. It will be the first
        // thing dequeued, at which point we'll print it and add its neighbors
        // to the queue.
        q.add(start);
        visited[start] = true;

    }

    public static void main(String[] args) throws Exception {
        Graph g = new Graph("g1.txt");
    }
}