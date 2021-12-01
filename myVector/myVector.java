import java.util.Arrays;

public class myVector {
    Object[] array;
    int elems;
    int capacity;

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.deepHashCode(array);
        result = prime * result + capacity;
        result = prime * result + elems;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        myVector other = (myVector) obj;
        if (!Arrays.deepEquals(array, other.array))
            return false;
        if (capacity != other.capacity)
            return false;
        if (elems != other.elems)
            return false;
        return true;
    }

    public myVector(int value){
        capacity = value*2 + 10;
        array = new Object[capacity];
        elems = 0;
    }

    public myVector(myVector vector){
        array = new Object[capacity];
        array = vector.array;
        elems = vector.elems;
        capacity = vector.capacity;
    }

    public myVector(){
        capacity = 0;
        array = new Object[0];
        elems = 0;
    }

    public void addElement(Object data){
        if(capacity > elems){
            array[elems] = data;
            elems++;
        }
        else{
            Object[] temp = new Object[capacity+1];
            for(int i = 0; i < elems; i++){
                temp[i] = array[i];
            }
            array = temp;
            array[elems] = data;
            elems++;
        }        
    }

    public void addElement(Object data, int position){
        if(capacity > elems){
            for(int i = elems; i > position - 1; i--){
                array[i + 1] = array[i];
            }
            array[position] = data;
            elems++;
        }
        else{
            Object[] temp = new Object[capacity];
            for(int i = 0; i < elems; i++){
                temp[i] = array[i];
            }
            array = temp;
            for(int i = elems; i > position - 1; i--){
                array[i + 1] = array[i];
            }
            array[position] = data;
            elems++;
        }       
    }

    public void delElement(int position){
        if(capacity > elems){
            array[position] = null;
            for(int i = position; i < elems; i++){
                array[i] = array[i + 1];
            }
            elems--;
        }        
    }

    public void delElement(){
        if(capacity > elems){
            elems--;
            array[elems] = null;
            
        }        
    }

    public void clear(){
        for(int i = 0; i < capacity; i++){
            array[i] = null;
        }
        elems = 0;
    }

    public Object get(int index) {
        if(index >= elems || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        

        return array[index];
    }

    public void addCapacity(myVector vector, int value){
        capacity = capacity + value;
        Object[] temp = new Object[capacity];
        for(int i = 0; i < elems; i++){
            temp[i] = array[i];
        }
        array = temp;
        
    }

    public int getElements(){
        return elems;
    }

    public int getCapacity(){
        return capacity;
    }

    public void printMyVector() {       
        for(int i = 0; i < elems; i++){
            if(array[i] != null){
                System.out.print(array[i] + " ");
            }
        }
    }


}
