import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Six {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of vertices
        System.out.print("Enter the number of vertices: ");
        int numberOfVertices = scanner.nextInt();

        // Input the number of edges
        System.out.print("Enter the number of edges: ");
        int numberOfEdges = scanner.nextInt();

        // Input the edges
        System.out.println("Enter the edges (vertex1 vertex2):");
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < numberOfEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            edges.add(new int[]{vertex1, vertex2});
        }

        // Create the adjacency matrix
        int[][] adjacencyMatrix = new int[numberOfVertices][numberOfVertices];

        // Populate the adjacency matrix
        for (int[] edge : edges) {
            int vertex1 = edge[0] - 1; 
            int vertex2 = edge[1] - 1; 
            adjacencyMatrix[vertex1][vertex2]++;
            if (vertex1 != vertex2) {
                adjacencyMatrix[vertex2][vertex1]++;
            }
        }

        
        System.out.println("Adjacency matrix:");
        for (int[] row : adjacencyMatrix) {
            System.out.println(Arrays.toString(row));
        }

        scanner.close();
    }
}
