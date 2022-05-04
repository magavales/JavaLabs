import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Graph <T extends Comparable<T>>{
    ArrayList<Node<T>> vertexList;
    int numVertex = 0;
    int numEdge = 0;

    public Graph(){
        vertexList = new ArrayList<>();
    }

    public Graph(Graph<T> graph) {
        vertexList = new ArrayList<>();
        for (T vertex : graph.getVertexNames()) {
            this.addVertex(vertex);
        }

        for (Edge<T> edge : graph.getAllEdges()) {
            this.addEdge(edge.nameVertexFrom, edge.nameVertexTo, edge.weight);
        }
    }

    public void addVertex(T nameVertex){
        vertexList.add(new Node<>(nameVertex));
        numVertex++;
    }

    public void addEdge(T from, T to){
        addEdge(from, to, 1);
    }

    public void addEdge(T from, T to, int weight) {
        int indexFrom = 0;
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).nameVertex.compareTo(from) == 0) {
                indexFrom = i;
                break;
            }
        }

        vertexList.get(indexFrom).edges.add(new Edge<>(from, to, weight));
        numEdge++;
    }

    public void addEdgeOriented(T from, T to){
        addEdgeOriented(from, to, 1);
    }

    public void addEdgeOriented(T from, T to, int weight){
        int indexFrom = 0;
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).nameVertex.compareTo(from) == 0) {
                indexFrom = i;
                break;
            }
        }

        vertexList.get(indexFrom).edges.add(new Edge<>(from, to, weight));
        numEdge++;
        vertexList.get(indexFrom).edges.add(new Edge<>(to, from, weight));
        numEdge++;
    }

    public boolean isContain(T vertex){
        for (Node<T> tNode : vertexList) {
            if (tNode.nameVertex.compareTo(vertex) == 0) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<T> getOutEdges(T vertex){
        ArrayList<T> result = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < vertexList.size(); i++){
            if (vertexList.get(i).nameVertex.compareTo(vertex) == 0){
                index = i;
                break;
            }
        }
        for (int i = 0; i < vertexList.get(index).edges.size(); i++){
            result.add(vertexList.get(index).edges.get(i).nameVertexTo);
        }

        return result;
    }

    public ArrayList<Edge<T>> getAllEdges(){
        ArrayList<Edge<T>> result = new ArrayList<>();

        for (Node<T> tNode : vertexList) {
            for (int j = 0; j < tNode.edges.size(); j++) {
                result.add(tNode.edges.get(j));
            }
        }

        return result;
    }

    public List<Edge<T>> getEdges(T vertex) {
        List<Edge<T>> result = new ArrayList<>();

        int indexVertex = getIndex(vertex);
        result = vertexList.get(indexVertex).edges;
        return result;
    }

    public Edge<T> getEdge(T nameVertexFrom, T nameVertexTo) {
        for (Edge<T> edge : getEdges(nameVertexFrom)) {
            if (edge.nameVertexFrom.equals(nameVertexFrom) && edge.nameVertexTo.equals(nameVertexTo)) {
                return edge;
            }
        }
        return null;
    }

    public List<T> getInEdges(T vertex) {
        ArrayList<T> result = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < vertexList.size(); i++){
            if (vertexList.get(i).nameVertex.compareTo(vertex) == 0){
                index = i;
                break;
            }
        }
        for (int i = 0; i < vertexList.get(index).edges.size(); i++){
            result.add(vertexList.get(index).edges.get(i).nameVertexFrom);
        }

        return result;
    }

    public List<T> getVertexNames(){
        ArrayList<T> result = new ArrayList<>();

        for (Node<T> node : vertexList){
            result.add(node.nameVertex);
        }

        return result;
    }

    public int getWeight(T from, T to){
        int indexFrom = getIndex(from);

        for (int i = 0; i < vertexList.size(); i++){
            if (vertexList.get(indexFrom).edges.get(i).nameVertexTo.compareTo(to) == 0){
                return vertexList.get(indexFrom).edges.get(i).weight;
            }
        }

        return 0;
    }

    public int getIndex(T data){
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).nameVertex.compareTo(data) == 0) {
                return i;
            }
        }
        return 0;
    }

    public void removeEdge(T from, T to) {
        int fromIndex = getIndex(from);
        for (Edge<T> temp : vertexList.get(fromIndex).edges){
            if (temp.nameVertexFrom.compareTo(from) == 0 && temp.nameVertexTo.compareTo(to) == 0){
                vertexList.get(fromIndex).edges.remove(vertexList.get(fromIndex).edges.indexOf(temp));
                break;
            }
        }
    }

    public Graph<T> getNewInstance() {
        return new Graph<>();
    }

    public Graph<T> getTransposedGraph() {
        Graph<T> transposedGraph = this.getNewInstance();

        for (T vertex : this.getVertexNames()) {
            transposedGraph.addVertex(vertex);
        }

        for (Edge<T> edge : this.getAllEdges()) {
            transposedGraph.addEdge(edge.nameVertexTo, edge.nameVertexFrom, edge.weight);
        }

        return transposedGraph;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graph<?> graph = (Graph<?>) o;

        var SetVertexA = new HashSet<>(graph.vertexList);
        var SetVertexB = new HashSet<>(this.vertexList);

        var SetEdgeA = new HashSet<>(graph.getAllEdges());
        var SetEdgeB = new HashSet<>(graph.getAllEdges());

        if (!SetVertexA.equals(SetVertexB)) return false;
        return SetEdgeA.equals(SetEdgeB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertexList, numVertex, numEdge);
    }

    @Override
    public String toString() {
        return stringListGraph();
    }

    private String stringListGraph() {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < vertexList.size(); i++) {
            T root = vertexList.get(i).nameVertex;
            strBuilder.append(root).append(" -> ").append(vertexList).append("\n");
        }
        return strBuilder.toString();
    }
}
