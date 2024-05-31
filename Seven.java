import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Seven {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of vertices
        System.out.print("Enter the number of vertices: ");
        int numberOfVertices = scanner.nextInt();

        // Input the number of edges
        System.out.print("Enter the number of edges: ");
        int numberOfEdges = scanner.nextInt();

        // Input the edges and their frequencies
        System.out.println("Enter the edges (vertex1 vertex2 frequency):");
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < numberOfEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            int frequency = scanner.nextInt();
            edges.add(new int[]{vertex1, vertex2, frequency});
        }

        // Create the incidence matrix
        int[][] incidenceMatrix = new int[numberOfVertices][numberOfEdges];

        // Populate the incidence matrix
        for (int i = 0; i < numberOfEdges; i++) {
            int vertex1 = edges.get(i)[0];
            int vertex2 = edges.get(i)[1];
            incidenceMatrix[vertex1][i] = edges.get(i)[2];
            incidenceMatrix[vertex2][i] = edges.get(i)[2];
        }

        // Print the incidence matrix
        System.out.println("Incidence matrix:");
        for (int[] row : incidenceMatrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}