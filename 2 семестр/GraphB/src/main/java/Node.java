import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Node <T extends Comparable<T>>{
    T nameVertex;
    ArrayList<Edge<T>> edges = new ArrayList<>() {
        @Override
        public boolean add(Edge<T> edge) {
            super.add(edge);
            this.sort((x, y) -> {
                if (x.weight != y.weight) {
                    return x.weight - y.weight;
                } else if (!x.nameVertexTo.equals(y.nameVertexTo)) {
                    return x.nameVertexTo.compareTo(y.nameVertexTo);
                } else {
                    return x.nameVertexFrom.compareTo(y.nameVertexFrom);
                }
            });

            return true;
        }
    };

    public Node(T nameVertex){
        this.nameVertex = nameVertex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;

        return Objects.equals(nameVertex, node.nameVertex) && Objects.equals(edges, node.edges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameVertex, Arrays.hashCode(edges.toArray()));
    }
}
