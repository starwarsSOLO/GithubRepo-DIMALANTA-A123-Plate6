import java.util.*;

public class Five {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

        // Determine if the graph is bipartite
        boolean isBipartite = isBipartite(edges);
        System.out.println("The graph is " + (isBipartite ? "bipartite" : "not bipartite"));

        scanner.close();
    }

    private static boolean isBipartite(List<int[]> edges) {
        // Create an adjacency list
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int[] edge : edges) {
            adjacencyList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjacencyList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        // Create a map to store the color of each vertex
        Map<Integer, Integer> vertexColors = new HashMap<>();

        // Iterate through each vertex in the adjacency list
        for (int vertex : adjacencyList.keySet()) {
            // If the vertex is not colored, start a BFS from that vertex
            if (!vertexColors.containsKey(vertex)) {
                if (!bfsCheck(vertex, adjacencyList, vertexColors)) {
                    return false;
                }
            }
        }

        // If no conflicts were found, the graph is bipartite
        return true;
    }

    private static boolean bfsCheck(int startVertex, Map<Integer, List<Integer>> adjacencyList, Map<Integer, Integer> vertexColors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        vertexColors.put(startVertex, 0);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            int currentColor = vertexColors.get(currentVertex);

            for (int neighbor : adjacencyList.get(currentVertex)) {
                
                if (!vertexColors.containsKey(neighbor)) {
                    vertexColors.put(neighbor, 1 - currentColor);
                    queue.add(neighbor);
                }
               
                else if (vertexColors.get(neighbor) == currentColor) {
                    return false;
                }
            }
        }

        return true;
    }
}
