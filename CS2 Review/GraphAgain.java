import java.util.*;
import java.io.File;

public class GraphAgain {

    // n is number of verticex
    private int n;
    private boolean[][] matrix;

    private boolean[] visited;

    GraphAgain(String filename) throws Exception {
        Scanner in = new Scanner(new File(filename));

        n = in.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (in.nextInt() == 1);
            }
        }

        in.close();
    }

    // iterative
    public void bfs(int start) {
        visited = new boolean[n];

        Queue<Integer> q = new LinkedList<>();

        q.add(start);

        while (!q.isEmpty()) {
            int current = q.remove();

            System.out.println((char) (current + 'A'));

            for (int i = 0; i < n; i++) {
                if (matrix[current][i] && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[n];
        dfs(start, visited);
    }

    private void dfs(int current, boolean[] visited) {
        visited[current] = true;
        System.out.println((char) ('A' + current));

        for (int i = 0; i < n; i++) {
            if (matrix[current][i] && !visited[i]) {
                dfs(i, visited);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        GraphAgain g = new GraphAgain("g1.txt");
        g.dfs(0);
    }
}