package test;
import java.util.*;

public class GraphExample {
    private int vertices; // Оройн тоо
    private int[] degrees; // Ирмэгийн тоо
    private int[][] adjacencyMatrix; // Хадгалах матриц

    // Графын конструктор
    public GraphExample(int vertices) {
        this.vertices = vertices;
        this.degrees = new int[vertices];
        adjacencyMatrix = new int[vertices][vertices];
    }

    // Хоёр оройн хооронд ирмэг нэмэх
    public void addEdge(int src, int dest) {
        if (src >= 0 && src < vertices && dest >= 0 && dest < vertices && degrees[src] < 10 && degrees[dest] < 10) {
            degrees[src]++;
            degrees[dest]++;
            adjacencyMatrix[src][dest] = 1;
            adjacencyMatrix[dest][src] = 1; // Чиглэлгүй граф
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

        // Орой бүрийн хөршүүдийг хэвлэх
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Орой " + i + ": ");
            for (int j = 0; j < numVertices; j++) {
                if (graph.adjacencyMatrix[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }

        long startTime = System.currentTimeMillis();
        // BFS хэрэгжүүлэлт
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        System.out.print("BFS зам: ");
        while (!q.isEmpty()) {
            int q1 = q.poll();
            System.out.print(q1 + " ");
            for (int i = 0; i < numVertices; i++) {
                if (graph.adjacencyMatrix[q1][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        // Миллисекундээс секундэд хөрвүүлэх
        double elapsedTimeInSeconds = (endTime - startTime) / 1000.0;
        System.out.println("\nБүх оройг амжилттай шалгасан. Зарцуулсан хугацаа: " + elapsedTimeInSeconds + " секунд");

        long startTimedfs = System.currentTimeMillis();
        // DFS хэрэгжүүлэлт
        boolean[] visiteddfs = new boolean[numVertices];
        visiteddfs[0] = true;
        Stack<Integer> s= new Stack<>();
        s.push(0);

        System.out.print("DFS зам: ");
        while(!s.isEmpty()){
            int s1= s.pop();
            System.out.print(s1+ " ");
            for (int i=0; i<numVertices; i++){
                if (graph.adjacencyMatrix[s1][i] == 1 && !visiteddfs[i]) {
                    s.push(i);
                    visiteddfs[i] = true;
                }
            }
        }
        
        long endTimedfs = System.currentTimeMillis();
        // Миллисекундээс секундэд хөрвүүлэх
        double elapsedTimeInSecondsdfs = (endTimedfs - startTimedfs) / 1000.0;
        System.out.println("\nБүх оройг амжилттай шалгасан. Зарцуулсан хугацаа: " + elapsedTimeInSecondsdfs + " секунд");
    }
}
