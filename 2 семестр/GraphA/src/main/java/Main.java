import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        Graph<String> graph = new Graph<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A", "B", 7);
        graph.addEdge("A", "D", 5);
        graph.addEdge("B", "A", 7);
        graph.addEdge("B", "D", 9);
        graph.addEdge("B", "C", 8);
        graph.addEdge("B", "E", 7);
        graph.addEdge("C", "B", 8);
        graph.addEdge("C", "E", 5);
        graph.addEdge("D", "A", 5);
        graph.addEdge("D", "B", 9);
        graph.addEdge("D", "E", 15);
        graph.addEdge("D", "F", 6);
        graph.addEdge("E", "C", 5);
        graph.addEdge("E", "B", 7);
        graph.addEdge("E", "D", 15);
        graph.addEdge("E", "G", 9);
        graph.addEdge("E", "F", 8);
        graph.addEdge("F", "D", 6);
        graph.addEdge("F", "E", 8);
        graph.addEdge("F", "G", 11);
        graph.addEdge("G", "F", 11);
        graph.addEdge("G", "E", 9);

        Algorithms.PrimAlgorithm(graph, "D");
    }
}
