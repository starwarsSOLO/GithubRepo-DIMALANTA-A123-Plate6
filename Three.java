import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Three {

    private static class Graph {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        boolean[] visited;

        public void addEdge(int source, int destination) {
            adjacencyList.computeIfAbsent(source, key -> new ArrayList<>()).add(destination);
            adjacencyList.computeIfAbsent(destination, key -> new ArrayList<>()).add(source);
        }

        public boolean hasCycle() {
            visited = new boolean[adjacencyList.size() + 1]; // +1 to account for zero-based index if vertices start from 1

            for (int vertex : adjacencyList.keySet()) {
                if (!visited[vertex]) {
                    if (hasCycleHelper(vertex, -1)) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean hasCycleHelper(int vertex, int parentVertex) {
            visited[vertex] = true;

            for (int neighbor : adjacencyList.get(vertex)) {
                if (!visited[neighbor]) {
                    if (hasCycleHelper(neighbor, vertex)) {
                        return true;
                    }
                } else if (neighbor != parentVertex) {
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of vertices
        System.out.print("Enter the number of vertices: ");
        int numberOfVertices = scanner.nextInt();

        // Input the number of edges
        System.out.print("Enter the number of edges: ");
        int numberOfEdges = scanner.nextInt();

        // Input the edges
        Three.Graph graph = new Three.Graph();
        System.out.println("Enter the edges (vertex1 vertex2):");
        for (int i = 0; i < numberOfEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            graph.addEdge(vertex1, vertex2);
        }

        // Check if the graph has a cycle
        boolean hasCycle = graph.hasCycle();
        System.out.println("Does the graph have a cycle? " + hasCycle);

        scanner.close();
    }
}
