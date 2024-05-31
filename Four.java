import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Four {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of edges
        System.out.print("Enter the number of edges: ");
        int numberOfEdges = scanner.nextInt();

        // Input the edges
        System.out.println("Enter the edges (vertex1 vertex2):");
        int[][] edges = new int[numberOfEdges][2];
        for (int i = 0; i < numberOfEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            edges[i] = new int[]{vertex1, vertex2};
        }

        // Calculate the degree of each vertex
        Map<Integer, Integer> vertexDegrees = new HashMap<>();
        for (int[] edge : edges) {
            int vertex1 = edge[0];
            int vertex2 = edge[1];
            vertexDegrees.put(vertex1, vertexDegrees.getOrDefault(vertex1, 0) + 1);
            vertexDegrees.put(vertex2, vertexDegrees.getOrDefault(vertex2, 0) + 1);
        }

        // Print the degree of each vertex
        System.out.println("Vertex degrees:");
        for (int vertex = 0; vertex < vertexDegrees.size(); vertex++) {
            System.out.printf("Vertex %d: %d%n", vertex, vertexDegrees.getOrDefault(vertex, 0));
        }

        scanner.close();
    }
}