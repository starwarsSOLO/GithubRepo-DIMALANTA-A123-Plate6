import java.util.*;

public class One {
    private int vertices;
    private List<List<Integer>> adjacencyList;

    public One(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u); // Since the graph is undirected
    }

    private void DFS(int vertex, boolean[] visited) {
        visited[vertex] = true;
        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                DFS(neighbor, visited);
            }
        }
    }

    public boolean isConnected() {
        boolean[] visited = new boolean[vertices];
        DFS(0, visited);
        for (boolean visitStatus : visited) {
            if (!visitStatus) {
                return false;
            }
        }
        return true;
    }

    public int countConnectedComponents() {
        boolean[] visited = new boolean[vertices];
        int count = 0;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                DFS(i, visited);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Example usage
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();

        One graph = new One(n);

        System.out.print("Enter the number of edges: ");
        int e = scanner.nextInt();

        System.out.println("Enter the edges (u v): ");
        for (int i = 0; i < e; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

        if (graph.isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            int connectedComponents = graph.countConnectedComponents();
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + connectedComponents);
        }

        scanner.close();
    }
}


 