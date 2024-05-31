import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input the number of vertices
        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();
        
        // Input the adjacency matrix
        int[][] adjacencyMatrix = new int[n][n];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }
        
       
        Map<String, Integer> edgeCount = new HashMap<>();
        
       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjacencyMatrix[i][j] != 0) { 
                    String edge = i < j ? i + "-" + j : j + "-" + i;
                    edgeCount.put(edge, edgeCount.getOrDefault(edge, 0) + adjacencyMatrix[i][j]);
                }
            }
        }
        
        
        System.out.println("Edges and their counts:");
        for (Map.Entry<String, Integer> entry : edgeCount.entrySet()) {
            System.out.println("Edge " + entry.getKey() + ": " + entry.getValue() + " times");
        }
        
        scanner.close();
    }
}
