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

    /**
     * Проверяет очередь на пустоту
     *
     * @param data - элемент, который необходимо вставить в очередь
     */
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
                swap(child, parent);
                child = parent;
            }
        }
    }
    public void swap(int child, int parent){
        T temp = heapArray.get(child);
        heapArray.set(child, heapArray.get(parent));
        heapArray.set(parent, temp);
    }

    /**
     * Проверка очереди на пустоту
     *
     * @return Возвращает True, если очередь пуста, и False - в противном случае.
     */
    public boolean isEmpty(){
        return heapArray.isEmpty();
    }

    /**
     * Получение количества элементов в очереди
     *
     * @return Возвращает размер очереди.
     */
    public int getCountElem(){
        return heapArray.size();
    }

    /**
     * Проверяет очередь на пустоту
     *
     * @param data - элемент, который необходимо удалить из очереди.
     */
    public void delElem(T data){
        int child = 0, parent = 0, count = 0, delIndex = 0;
        delIndex = heapArray.indexOf(data);

        if(delIndex == heapArray.size() - 1){
            heapArray.remove(data);
        }
        else {
            heapArray.remove(delIndex);
            heapArray.add(delIndex, heapArray.get(heapArray.size() - 1));
            heapArray.remove(heapArray.size() - 1);

            parent = delIndex;

            while (true) {
                if (2 * parent + 1 > heapArray.size() - 1){
                    break;
                }
                if (2 * parent + 2 > heapArray.size() - 1 && 2 * parent + 1 > heapArray.size() - 1){
                    break;
                }
                if (2 * parent + 2 > heapArray.size() - 1){
                    if(heapArray.get(parent).compareTo(heapArray.get(2 * parent + 1)) < 0){
                        swap(2 * parent + 1, parent);
                    }
                    break;
                }
                if(heapArray.get(parent).compareTo(heapArray.get(2 * parent + 1)) < 0) {
                    if (heapArray.get(2 * parent + 1).compareTo(heapArray.get(2 * parent + 2)) > 0) {
                        swap(parent, 2 * parent + 1);
                        parent = 2 * parent + 1;
                    } else {
                        swap(parent, 2 * parent + 2);
                        parent = 2 * parent + 2;
                    }
                } else{
                    break;
                }
            }
        }
    }

    /**
     * Проверяет очередь на пустоту
     *
     * @return Возвращает максимальный элемент очереди.
     */
    public T getMaxElem(){
        return heapArray.get(0);
    }
}