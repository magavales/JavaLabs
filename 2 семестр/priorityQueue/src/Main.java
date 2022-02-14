import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        priorityQueue<Integer> heap = new priorityQueue<Integer>(10, ArrayList.class);
        heap.insertHeap(15);
        heap.insertHeap(14);
        heap.insertHeap(10);
        heap.insertHeap(100);
        heap.insertHeap(13);
        heap.insertHeap(20);
        heap.insertHeap(12);
        heap.insertHeap(11);
        heap.insertHeap(9);
        heap.insertHeap(8);
        heap.insertHeap(7);
        heap.insertHeap(6);
        heap.insertHeap(5);
        heap.insertHeap(4);
        heap.insertHeap(3);
        heap.delElem(15);
        heap.insertHeap(2);
        heap.checkEmpty();
        heap.getCountElem();
    }
}