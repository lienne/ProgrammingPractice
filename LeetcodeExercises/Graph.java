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
    int [][] matrix;
    // boolean [][] matrix;

    // Initialize 'matrix' from input file
    public Graph(String filename) throws Exception{
        Scanner in = new Scanner(new File(filename));
        int N = in.nextInt();

        matrix = new int[N][N];
        // matrix = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                matrix[i][j] = (in.nextInt());
                // matrix[i][j] = (in.nextInt() == 1);
            }
        }

        // for(int j = 0; j < N; j++) {
        //     for(int k = 0; k < N; k++) {
        //         System.out.print(matrix[j][k] + " ");
        //     }
        //     System.out.println();
        // }
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
    public  void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean [] visited = new boolean[matrix.length];

        // Start by adding the start vertex to the queue. It will be  the first
        // thing dequeued, at which point we'll print it and add its neighbors
        // to the queue.
        q.add(start);
        visited[start] = true;

    }

    public static void main(String [] args) throws Exception {
        Graph g = new Graph("g1.txt");
    }
}