import java.util.Objects;

public class Edge <T> implements Comparable<Edge<T>>{
    T nameVertexFrom;
    T nameVertexTo;
    int weight;

    public Edge(T nameVertexFrom, T nameVertexTo, int weight){
        this.nameVertexFrom = nameVertexFrom;
        this.nameVertexTo = nameVertexTo;
        this.weight = weight;

    }

    @Override
    public int compareTo(Edge<T> o) {
        return this.weight - o.weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        return weight == edge.weight && ((Objects.equals(nameVertexFrom, edge.nameVertexFrom) && Objects.equals(nameVertexTo, edge.nameVertexTo)) || (Objects.equals(nameVertexTo, edge.nameVertexFrom) && Objects.equals(nameVertexFrom, edge.nameVertexTo)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameVertexFrom, nameVertexTo, weight);
    }

    @Override
    public String toString() {
        return "(" + nameVertexFrom + ")" +
                " -- " + weight + " -->" +
                " (" + nameVertexTo + ")";
    }
}
