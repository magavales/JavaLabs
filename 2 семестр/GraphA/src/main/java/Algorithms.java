import java.util.*;


public class Algorithms {
    public Algorithms(){

    }

    public static <T extends Comparable<T>> Set<T> dfs(Graph<T> graph, T srcVertex) throws Exception {
        if (!graph.isContain(srcVertex)) {
            throw new Exception("Vertex '" + srcVertex + "' does not exist");
        }

        Stack<T> stack = new Stack<>();
        Set<T> visited = new HashSet<>();
        stack.push(srcVertex);
        while (!stack.isEmpty()) {
            T cur = stack.pop();
            if (!visited.contains(cur)) {
                visited.add(cur);

                List<T> neighbors = graph.getOutEdges(cur);
                for (T neighborVertex : neighbors) {
                    if (!visited.contains(neighborVertex)) {
                        stack.add(neighborVertex);
                    }
                }
            }
        }

        return visited;
    }

    public static <T extends Comparable<T>> Set<T> bfs(Graph<T> graph, T srcVertex) throws Exception {
        if (!graph.isContain(srcVertex)) {
            throw new Exception("Vertex '" + srcVertex + "' does not exist");
        }
        Queue<T> queue = new LinkedList<>();
        Set<T> visited = new HashSet<>();

        queue.add(srcVertex);

        while (!queue.isEmpty()) {
            T cur = queue.poll();
            if (!visited.contains(cur)) {
                visited.add(cur);
                List<T> neighbors = graph.getOutEdges(srcVertex);
                for (T neighborVertex : neighbors) {
                    if (!visited.contains(neighborVertex)) {
                        queue.add(neighborVertex);
                    }
                }
            }
        }

        return visited;
    }

    public static <T extends Comparable<T>> int  DijkstrasAlgorithm(Graph<T> graph, T from, T to){
        int indexFrom = graph.getIndex(from);
        Map<T, Integer> shortestWeight = new HashMap<>(); // Minimal weight of path from src to vertex
        for (int i = 0; i < graph.vertexList.size(); i++) {
            if (graph.vertexList.get(i).nameVertex.equals(from)) {
                shortestWeight.put(graph.vertexList.get(i).nameVertex, 0);
            } else {
                shortestWeight.put(graph.vertexList.get(i).nameVertex, Integer.MAX_VALUE); // MAX_VALUE instead of positive infinity
            }
        }
        int sum = 0;
        int root = indexFrom;

        Queue<T> unvisited = new LinkedList<>();
        Set<T> visited = new HashSet<>();
        unvisited.add(from);
        while (!unvisited.isEmpty()){
            T cur = unvisited.poll();
            visited.add(cur);

            int weightCur = shortestWeight.get(cur);
            List<T> neighbors = graph.getOutEdges(cur);
            for (T vertexNeighbor : neighbors){
                if (vertexNeighbor.equals(cur)){
                    continue;
                }

                int oldWeight = shortestWeight.get(vertexNeighbor);
                int newWeight = graph.getWeight(cur, vertexNeighbor);
                if ((oldWeight == Integer.MAX_VALUE) || (oldWeight > newWeight + shortestWeight.get(cur))){
                    shortestWeight.replace(vertexNeighbor, newWeight + weightCur);
                }

                if (!visited.contains(vertexNeighbor) && !unvisited.contains(vertexNeighbor)){
                    unvisited.add(vertexNeighbor);
                }
            }

        }
        return shortestWeight.get(to);
    }

    public static <T extends Comparable<T>> Graph<T> KruskalAlgorithm(Graph<T> graph){
        List<Edge<T>> edge = new ArrayList<>();

        for (int i = 0; i < graph.vertexList.size(); i++){
            for (int j = 0; j < graph.vertexList.get(i).edges.size(); j++){
                if (edge.size() > 0){
                    for (int t = 0; t < edge.size(); t++){
                        if (!edge.contains(graph.vertexList.get(i).edges.get(j))){
                            edge.add(graph.vertexList.get(i).edges.get(j));
                        }
                        else {
                            continue;
                        }
                    }
                }
                else {
                    edge.add(graph.vertexList.get(i).edges.get(j));
                }
            }
        }

        Collections.sort(edge);
        Map<T, Integer> result = new HashMap<>();
        Graph<T> resultGraph = new Graph<>();
        for (int i = 0; i < graph.vertexList.size(); i++) {
            result.put(graph.vertexList.get(i).nameVertex, Integer.MAX_VALUE);
            resultGraph.addVertex(graph.vertexList.get(i).nameVertex);
        }
        int countSet = 1;

        for (int i = 0; i < edge.size(); i++){
            if (result.get(edge.get(i).nameVertexFrom) == Integer.MAX_VALUE &&
                    result.get(edge.get(i).nameVertexTo) == Integer.MAX_VALUE){
                result.put(edge.get(i).nameVertexFrom, countSet);
                result.put(edge.get(i).nameVertexTo, countSet);
                resultGraph.addEdge(edge.get(i).nameVertexFrom, edge.get(i).nameVertexTo, edge.get(i).weight);
                resultGraph.addEdge(edge.get(i).nameVertexTo, edge.get(i).nameVertexFrom, edge.get(i).weight);
                countSet++;
            }
            else {
                if (result.get(edge.get(i).nameVertexFrom) != Integer.MAX_VALUE &&
                        result.get(edge.get(i).nameVertexTo) == Integer.MAX_VALUE){
                    result.put(edge.get(i).nameVertexTo, result.get(edge.get(i).nameVertexFrom));
                    resultGraph.addEdge(edge.get(i).nameVertexFrom, edge.get(i).nameVertexTo, edge.get(i).weight);
                    resultGraph.addEdge(edge.get(i).nameVertexTo, edge.get(i).nameVertexFrom, edge.get(i).weight);
                }
                if (result.get(edge.get(i).nameVertexFrom) == Integer.MAX_VALUE &&
                        result.get(edge.get(i).nameVertexTo) != Integer.MAX_VALUE){
                    result.put(edge.get(i).nameVertexFrom, result.get(edge.get(i).nameVertexTo));
                    resultGraph.addEdge(edge.get(i).nameVertexFrom, edge.get(i).nameVertexTo, edge.get(i).weight);
                    resultGraph.addEdge(edge.get(i).nameVertexTo, edge.get(i).nameVertexFrom, edge.get(i).weight);
                }
                if (result.get(edge.get(i).nameVertexFrom) != Integer.MAX_VALUE &&
                        result.get(edge.get(i).nameVertexTo) != Integer.MAX_VALUE &&
                        result.get(edge.get(i).nameVertexFrom) != result.get(edge.get(i).nameVertexTo)){
                    Set<T> keySet = result.keySet();
                    for (T vertex : keySet){
                        if (result.get(vertex) != result.get(edge.get(i).nameVertexFrom) &&
                                result.get(vertex) != Integer.MAX_VALUE &&
                                result.get(vertex) == result.get(edge.get(i).nameVertexTo)){
                            result.put(vertex, result.get(edge.get(i).nameVertexFrom));
                        }
                    }
                    resultGraph.addEdge(edge.get(i).nameVertexFrom, edge.get(i).nameVertexTo, edge.get(i).weight);
                    resultGraph.addEdge(edge.get(i).nameVertexTo, edge.get(i).nameVertexFrom, edge.get(i).weight);
                }
            }
        }

        return resultGraph;
    }

    public static <T extends Comparable<T>> Graph<T> PrimAlgorithm(Graph<T> graph, T srcVertex){
        Set<T> visited = new HashSet<>();
        Graph<T> resultGraph = new Graph<>();
        for (int i = 0; i < graph.vertexList.size(); i++) {
            resultGraph.addVertex(graph.vertexList.get(i).nameVertex);
        }

        visited.add(srcVertex);
        while (visited.size() != resultGraph.vertexList.size()) {
            int min = 0;
            int index = -1;
            int i = 0;
            T from = null;
            T to = null;
            for (T t : visited) {
                i = graph.getIndex(t);
                index = getMin(graph.vertexList.get(i).edges, visited);
                if (min == 0 && index != -1) {
                    min = graph.vertexList.get(i).edges.get(index).weight;
                    from = graph.vertexList.get(i).edges.get(index).nameVertexFrom;
                    to = graph.vertexList.get(i).edges.get(index).nameVertexTo;
                } else {
                    if (index != -1 && min > graph.vertexList.get(i).edges.get(index).weight) {
                        min = graph.vertexList.get(i).edges.get(index).weight;
                        from = graph.vertexList.get(i).edges.get(index).nameVertexFrom;
                        to = graph.vertexList.get(i).edges.get(index).nameVertexTo;
                    }
                }
            }
            resultGraph.addEdge(from, to, min);
            visited.add(to);
        }
        return resultGraph;
    }

    public static <T extends Comparable<T>> int getMin(ArrayList<Edge<T>> edges, Set<T> visited){
        int min = 0;
        int index = -1;
        for (int i = 0; i < edges.size(); i++){
            if (visited.contains(edges.get(i).nameVertexTo)){
                continue;
            }
            else{
                if (min == 0){
                    min = edges.get(i).weight;
                    index = i;
                }
                if (min > edges.get(i).weight){
                    index = i;
                }
            }
        }
        return index;
    }

    public static <T extends Comparable<T>> List<Edge<T>> FloydWarshallAlgorithm(Graph<T> graph){
        List<ArrayList<Integer>> matrix = new ArrayList<>();
        List<T> vertexNames = graph.getVertexNames();

        for (int i = 0; i < vertexNames.size(); i++){
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < vertexNames.size(); j++){
                row.add(Integer.MAX_VALUE);
            }

            matrix.add(row);
        }

        // Initial edges
        List<Edge<T>> edgeList = graph.getAllEdges();
        for (Edge<T> edge : edgeList) {
            int indexSrc = vertexNames.indexOf(edge.nameVertexFrom);
            int indexDest = vertexNames.indexOf(edge.nameVertexTo);
            matrix.get(indexSrc).set(indexDest, edge.weight);
        }

        // Initial positive infinitive
        for (List<Integer> row : matrix) {
            for(int i = 0; i < row.size(); i++) {
                if (row.get(i) == 0) {
                    row.set(i, Integer.MAX_VALUE);
                }
            }
        }

        // Algorithm body
        for(int k = 0; k < vertexNames.size(); k++) {
            for(int i = 0; i < vertexNames.size(); i++) {
                for(int j = 0; j < vertexNames.size(); j++) {
                    int oldValue = matrix.get(i).get(j);
                    int newValue = matrix.get(i).get(k) + matrix.get(k).get(j);

                    if(newValue < 0) { // More than maxValue
                        continue;
                    }

                    if (newValue < oldValue) {
                        matrix.get(i).set(j, matrix.get(i).get(k) + matrix.get(k).get(j));
                    }
                }
            }
        }

        // Represent result
        List<Edge<T>> result = new ArrayList<>();
        for(int i = 0; i < matrix.size(); i++) {
            for(int j = 0; j < matrix.size(); j++) {
                int value = matrix.get(i).get(j);
                if (value != Integer.MAX_VALUE) {
                    result.add(
                            new Edge<>(vertexNames.get(i), vertexNames.get(j), value)
                    );
                }
            }
        }

        return result;
    }
}
