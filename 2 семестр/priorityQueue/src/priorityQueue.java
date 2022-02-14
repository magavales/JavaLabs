import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class priorityQueue<T extends Comparable<T>> {
    List<T> heapArray;

    public priorityQueue() {
        heapArray = new ArrayList<>();
    }

    public priorityQueue(int capacity) {
        heapArray = new ArrayList<>(capacity);
    }

    public priorityQueue(Class<? extends List> listImplementation) {
        Objects.requireNonNull(listImplementation);
        try {
            heapArray = listImplementation.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Failed to create new instance of " + listImplementation.getName() + " Message: " + ex);
        }
    }

    public priorityQueue(int capacity, Class<? extends List> listImplementation) {
        Objects.requireNonNull(listImplementation);
        try {
            heapArray = listImplementation.getDeclaredConstructor(Integer.TYPE).newInstance(capacity);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Failed to create new instance of " + listImplementation.getName() + " Message: " + ex);
        }
    }

    public void insertHeap(T data){
        int parent = 1;
        heapArray.add(data);
        int child = heapArray.size() - 1;
        while(parent != 0){
            if(heapArray.size() - 1 % 2 == 0){
                parent = (child) / 2;
            }
            else{
                parent = (child - 1) / 2;
            }
            if(heapArray.get(parent) == null){
                T temp = heapArray.get(child);
                heapArray.set(child, heapArray.get(parent));
                heapArray.set(parent, temp);
                child = parent;
                continue;
            }
            if (heapArray.get(parent).compareTo(heapArray.get(child)) > 0){
                break;
            }
            if (heapArray.get(parent).compareTo(heapArray.get(child)) < 0){
                T temp = heapArray.get(child);
                heapArray.set(child, heapArray.get(parent));
                heapArray.set(parent, temp);
                child = parent;
            }
        }
    }
    public void checkEmpty(){
        if(heapArray.size() == 0){
            System.out.print("Heap is empty!\n");
        }
        else{
            System.out.print("Heap isn't empty!\n");
        }
    }
    public int getCountElem(){
        return heapArray.size();
    }
    public void delElem(T data){
        int child = 0, parent = 0, count = 0, delIndex = 0;
        delIndex = heapArray.indexOf(data);
        if(delIndex == heapArray.size() - 1){
            heapArray.remove(data);
        }
        else {
            parent = delIndex;
            heapArray.set(delIndex, null);
            while (true) {
                if (2 * parent + 1 > heapArray.size() - 1){
                    break;
                }
                if (2 * parent + 2 > heapArray.size() - 1 && 2 * parent + 1 > heapArray.size() - 1){
                    break;
                }
                if (heapArray.get(2 * parent + 1).compareTo(heapArray.get(2 * parent + 2)) > 0) {
                    heapArray.set(parent, heapArray.get(2 * parent + 1));
                    heapArray.set(2 * parent + 1, null);
                    parent = 2 * parent + 1;
                }
                else{
                    heapArray.set(parent, heapArray.get(2 * parent + 2));
                    heapArray.set(2 * parent + 2, null);
                    parent = 2 * parent + 2;
                }

            }
        }
    }
    public T getMaxElem(){
        return heapArray.get(0);
    }
}