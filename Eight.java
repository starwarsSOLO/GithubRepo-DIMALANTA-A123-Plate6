import java.util.Arrays;
import java.util.Scanner;

public class Eight {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices for the first graph:");
        int noOfVertices1 = scanner.nextInt();

        System.out.println("Enter the adjacency matrix for the first graph:");
        int[][] adjacencyMatrix1 = new int[noOfVertices1][noOfVertices1];
        for (int i = 0; i < noOfVertices1; i++) {
            for (int j = 0; j < noOfVertices1; j++) {
                adjacencyMatrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the number of vertices for the second graph:");
        int noOfVertices2 = scanner.nextInt();

        System.out.println("Enter the adjacency matrix for the second graph:");
        int[][] adjacencyMatrix2 = new int[noOfVertices2][noOfVertices2];
        for (int i = 0; i < noOfVertices2; i++) {
            for (int j = 0; j < noOfVertices2; j++) {
                adjacencyMatrix2[i][j] = scanner.nextInt();
            }
        }

        if (isIsomorphic(adjacencyMatrix1, adjacencyMatrix2)) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }
    }

    private static boolean isIsomorphic(int[][] adjacencyMatrix1, int[][] adjacencyMatrix2) {
        if (adjacencyMatrix1.length != adjacencyMatrix2.length) {
            return false;
        }

        int n = adjacencyMatrix1.length;
        int[] mapping = new int[n];
        Arrays.fill(mapping, -1);
        boolean[] used = new boolean[n];

        return isIsomorphicUtil(adjacencyMatrix1, adjacencyMatrix2, mapping, used, 0);
    }

    private static boolean isIsomorphicUtil(int[][] adjacencyMatrix1, int[][] adjacencyMatrix2, int[] mapping, boolean[] used, int vertex) {
        int n = adjacencyMatrix1.length;

        if (vertex == n) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                mapping[vertex] = i;
                used[i] = true;

                if (areCompatible(adjacencyMatrix1, adjacencyMatrix2, mapping, vertex)) {
                    if (isIsomorphicUtil(adjacencyMatrix1, adjacencyMatrix2, mapping, used, vertex + 1)) {
                        return true;
                    }
                }

                mapping[vertex] = -1;
                used[i] = false;
            }
        }

        return false;
    }

    private static boolean areCompatible(int[][] adjacencyMatrix1, int[][] adjacencyMatrix2, int[] mapping, int vertex) {
        for (int j = 0; j <= vertex; j++) {
            if (adjacencyMatrix1[vertex][j] != adjacencyMatrix2[mapping[vertex]][mapping[j]]) {
                return false;
            }
        }
        return true;
    }
}