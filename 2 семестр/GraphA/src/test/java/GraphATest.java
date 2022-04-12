import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class GraphATest {

    @Test
    @DisplayName("Should be true")
    void GraphA_test_0() {
    }


    @Test
    @DisplayName("Test graph with 10 elements without edges by DFS")
    void GraphA_dfs_0() throws Exception {
        Graph<Integer> graph = new Graph<>();
        Set<Integer> expectedSet = new HashSet<>(); // Expected set [1] for vertex "1"
        expectedSet.add(1);

        for (int i = 1; i <= 10; i++) {
            graph.addVertex(i);
        }

        Assertions.assertEquals(expectedSet, Algorithms.dfs(graph, 1));
    }

    @Test
    @DisplayName("Test graph with 10 elements with 10 edges by DFS")
    void GraphA_dfs_1() throws Exception {
        Graph<Integer> graph = new Graph<>();
        Set<Integer> expectedSet = new HashSet<>(); // Expected set [1, 10] for vertex "1"
        expectedSet.add(1);
        expectedSet.add(10);

        for (int i = 1; i <= 10; i++) {
            graph.addVertex(i);
        }

        for (int i = 1; i <= 10; i++) {
            graph.addEdge(i, 10);
        }

        Assertions.assertEquals(expectedSet, Algorithms.dfs(graph, 1));
    }

    @Test
    @DisplayName("Test full-linked graph with 1000 elements by DFS")
    void GraphA_dfs_2() throws Exception {
        Graph<Integer> graph = new Graph<>();
        Set<Integer> expectedSet = new HashSet<>(); // Expected set [1, 2, ... 1000] for vertex "1"
        for (int i = 1; i <= 1000; i++) {
            expectedSet.add(i);
            graph.addVertex(i);
        }
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                graph.addEdge(i, j, i + j);
            }
        }
        Assertions.assertEquals(expectedSet, Algorithms.dfs(graph, 1));
    }

    @Test
    @DisplayName("Test graph with 10 elements without edges by BFS")
    void GraphA_bfs_0() throws Exception {
        Graph<Integer> graph = new Graph<>();
        Set<Integer> expectedSet = new HashSet<>(); // Expected set [1] for vertex "1"
        expectedSet.add(1);

        for (int i = 1; i <= 10; i++) {
            graph.addVertex(i);
        }

        Assertions.assertEquals(expectedSet, Algorithms.bfs(graph, 1));
    }

    @Test
    @DisplayName("Test graph with 10 elements with 10 edges by BFS")
    void GraphA_bfs_1() throws Exception {
        Graph<Integer> graph = new Graph<>();
        Set<Integer> expectedSet = new HashSet<>(); // Expected set [1, 10] for vertex "1"
        expectedSet.add(1);
        expectedSet.add(10);

        for (int i = 1; i <= 10; i++) {
            graph.addVertex(i);
        }

        for (int i = 1; i <= 10; i++) {
            graph.addEdge(i, 10);
        }

        Assertions.assertEquals(expectedSet, Algorithms.bfs(graph, 1));
    }

    @Test
    @DisplayName("Test full-linked graph with 1000 elements by BFS")
    void GraphA_bfs_2() throws Exception {
        Graph<Integer> graph = new Graph<>();
        Set<Integer> expectedSet = new HashSet<>(); // Expected set [1, 2, ... 1000] for vertex "1"
        for (int i = 1; i <= 1000; i++) {
            expectedSet.add(i);
            graph.addVertex(i);
        }
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                graph.addEdge(i, j, i + j);
            }
        }
        Assertions.assertEquals(expectedSet, Algorithms.bfs(graph, 1));
    }

    @Test
    @DisplayName("Test #1 algorithm Dijkstra's")
    void GraphA_dijkstra_0() throws Exception {
        Graph<String> graph = new Graph<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge("A", "B", 10);
        graph.addEdge("A", "C", 15);
        graph.addEdge("B", "F", 15);
        graph.addEdge("B", "D", 12);
        graph.addEdge("C", "E", 10);
        graph.addEdge("D", "F", 1);
        graph.addEdge("D", "E", 2);
        graph.addEdge("F", "E", 5);

        Assertions.assertEquals(24, Algorithms.DijkstrasAlgorithm(graph, "A", "E"));
    }

    @Test
    @DisplayName("Test #2 algorithm Dijkstra's")
    void GraphA_dijkstra_1() throws Exception {
        Graph<Integer> graph = new Graph<>();

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        graph.addEdge(0, 4, 21);
        graph.addEdge(0, 3, 18);
        graph.addEdge(1, 2, 7);
        graph.addEdge(1, 4, 6);
        graph.addEdge(2, 1, 7);
        graph.addEdge(3, 0, 18);
        graph.addEdge(3, 4, 11);
        graph.addEdge(3, 5, 7);
        graph.addEdge(4, 0, 21);
        graph.addEdge(4, 1, 6);
        graph.addEdge(4, 3, 11);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 4, 10);
        graph.addEdge(5, 3, 7);


        Assertions.assertEquals(34, Algorithms.DijkstrasAlgorithm(graph, 0, 2));
    }

    @Test
    @DisplayName("Test #1 algorithm Kruskal's")
    void GraphA_kruskal_0() {
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

        Graph<String> test = new Graph<>();

        test.addVertex("A");
        test.addVertex("B");
        test.addVertex("C");
        test.addVertex("D");
        test.addVertex("E");
        test.addVertex("F");
        test.addVertex("G");

        test.addEdge("A", "B", 7);
        test.addEdge("A", "D", 5);
        test.addEdge("B", "A", 7);
        test.addEdge("B", "E", 7);
        test.addEdge("C", "E", 5);
        test.addEdge("D", "A", 5);
        test.addEdge("D", "F", 6);
        test.addEdge("E", "B", 7);
        test.addEdge("E", "C", 5);
        test.addEdge("E", "G", 9);
        test.addEdge("F", "D", 6);
        test.addEdge("G", "E", 9);

        Algorithms.KruskalAlgorithm(graph).equals(test);
        Assertions.assertTrue(Algorithms.KruskalAlgorithm(graph).equals(test));
    }

    @Test
    @DisplayName("Test #1 algorithm Prim's")
    void GraphA_prim_0(){
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

        Graph<String> test = new Graph<>();

        test.addVertex("A");
        test.addVertex("B");
        test.addVertex("C");
        test.addVertex("D");
        test.addVertex("E");
        test.addVertex("F");
        test.addVertex("G");

        test.addEdge("A", "B", 7);
        test.addEdge("B", "E", 7);
        test.addEdge("D", "A", 5);
        test.addEdge("D", "F", 6);
        test.addEdge("E", "C", 5);
        test.addEdge("E", "G", 9);

        Assertions.assertTrue(Algorithms.PrimAlgorithm(graph, "D").equals(test));
    }

    @Test
    @DisplayName("Test #1 algorithm Floyd-Warshall's")
    void GraphA_floydWarshall_0() throws Exception {
        Graph<Integer> graph = new Graph<>();

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        graph.addEdge(0, 1, 5);
        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 3, 1);
        graph.addEdge(0,3, 10);

        List<Edge<Integer>> expected = new ArrayList<>();
        expected.add(new Edge<>(0, 1, 5));
        expected.add(new Edge<>(0, 2, 8));
        expected.add(new Edge<>(0, 3, 9));
        expected.add(new Edge<>(1, 2, 3));
        expected.add(new Edge<>(1, 3, 4));
        expected.add(new Edge<>(2, 3, 1));

        Assertions.assertEquals(expected, Algorithms.FloydWarshallAlgorithm(graph));
    }
}
