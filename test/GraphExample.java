package test;
import java.util.*;

public class GraphExample {
    private int vertices; // Оройн тоо
    private int[] degrees ; // Ирмэгийн тоо 
    private int[][] adjacencyMatrix; // Хадгалах матриц

    // Графын конструктор
    public GraphExample(int vertices) {
        this.vertices = vertices;
        this.degrees = new int[vertices];
        adjacencyMatrix = new int[vertices][vertices];
    }

    // Хоёр оройн хооронд ирмэг нэмэх
    public void addEdge(int src, int dest) {
        if (src >= 0 && src < vertices && dest >= 0 && dest < vertices && degrees[src]<=10 && degrees[dest]<=10) {
            degrees[src]++;
            degrees[dest]++;
            adjacencyMatrix[src][dest] = 1;
            adjacencyMatrix[dest][src] = 1; // Чиглэлгүй граф
        } else {
            System.out.println("Оройн дугаар буруу байна!");
        }
    }

    // Графыг бүрэн хэвлэх
    public void printGraph() {
        System.out.println("Дамаар хадгалах матриц:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numVertices = 500; 
        GraphExample graph = new GraphExample(numVertices);

        // Ирмэгүүдийг нэмэх
        Random random = new Random();
        int numEdges = 1000; 
        for (int i = 0; i < numEdges; i++) {
            int src = random.nextInt(numVertices); 
            int dest = random.nextInt(numVertices);
            if (src != dest) { 
                graph.addEdge(src, dest);
            }
        }

        for (int i = 0; i < 500; i++) {
            System.out.print("Орой " + i + ": ");
            for (int j = 0; j < numVertices; j++) {
                if (graph.adjacencyMatrix[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}
