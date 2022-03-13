public class Node<T extends Comparable<T>>{
    enum Color{
        RED,
        BLACK
    }

    T data;
    Color color = Color.BLACK;
    Node<T> parent = null;
    Node<T> leftChild = null;
    Node<T> rightChild = null;

    public Node(T data, Color color){
        this.data = data;
        this.color = color;
    }

    public Node(Node<T> node, Color color){
        this.data = node.data;
        this.color = color;
        if (node.leftChild != null){
            this.leftChild = new Node<T>(node.leftChild, node.leftChild.color);
        }
        if (node.rightChild != null){
            this.rightChild = new Node<T>(node.rightChild, node.rightChild.color);
        }
    }
}
