import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class priorityQueueTest {
    @Test
    @DisplayName("Should be true")
    void PriorityQueue_Success_0() {
    }

    @Test
    @DisplayName("No parameters constructor and constructor with initialCapacity parameter")
    void PriorityQueue_Constructors_0() {
        priorityQueue<Integer> pq0 = new priorityQueue<>();
        priorityQueue<Integer> pq1 = new priorityQueue<>(100);
    }

    @Test
    @DisplayName("Constructors with listImplementation as parameter")
    void PriorityQueue_Constructors_1() {
        priorityQueue<Integer> pq0 = new priorityQueue<>(ArrayList.class);
        priorityQueue<Integer> pq1 = new priorityQueue<>(LinkedList.class);
    }

    @Test
    @DisplayName("LinkedList has not constructor with initialCapacity parameter, expected IllegalArgumentException")
    void PriorityQueue_Constructors_2() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new priorityQueue<>(10, LinkedList.class)
        );
    }

    @Test
    @DisplayName("Test 'isEmpty' function")
    void PriorityQueue_isEmpty_0() {
        priorityQueue<Integer> pq = new priorityQueue<>();
        Assertions.assertTrue(pq.isEmpty());
        pq.insertHeap(1);
        Assertions.assertFalse(pq.isEmpty());
    }

    @Test
    @DisplayName("Test 'getSize' function")
    void PriorityQueue_getSize_0() {
        priorityQueue<Integer> pq = new priorityQueue<>();
        Assertions.assertEquals(0, pq.getCountElem());
        pq.insertHeap(1);
        Assertions.assertEquals(1, pq.getCountElem());
    }

    @Test
    @DisplayName("Test 'delete' function")
    void PriorityQueue_remove_0() {
        priorityQueue<Integer> pq = new priorityQueue<>();
        pq.insertHeap(15);
        pq.insertHeap(14);
        pq.insertHeap(10);
        pq.insertHeap(100);
        pq.insertHeap(13);
        pq.insertHeap(20);
        pq.insertHeap(12);
        pq.insertHeap(11);
        pq.insertHeap(9);

        pq.delElem(15);

        priorityQueue<Integer> test = new priorityQueue<>();
        test.insertHeap(100);
        test.insertHeap(14);
        test.insertHeap(20);
        test.insertHeap(11);
        test.insertHeap(13);
        test.insertHeap(10);
        test.insertHeap(12);
        test.insertHeap(9);

        priorityQueue<Integer> test1 = new priorityQueue<>();
        priorityQueue<Integer> test2 = new priorityQueue<>();

        Assertions.assertEquals(true, checkQueue(pq, test));
    }

    @Test
    @DisplayName("Adding numbers in reverse order.")
    void PriorityQueue_Push_0() {
        priorityQueue<Integer> pq = new priorityQueue<>();
        pq.insertHeap(1);
        pq.insertHeap(2);
        pq.insertHeap(3);
        pq.insertHeap(4);
        pq.insertHeap(5);
        pq.insertHeap(6);

        Assertions.assertEquals(6, pq.getMaxElem());
    }


    public static boolean checkQueue(priorityQueue pq, priorityQueue pq1){
        return pq.heapArray.equals(pq1.heapArray);
    }
}
