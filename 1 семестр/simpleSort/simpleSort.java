public class simpleSort<T> {

    public simpleSort(){
        
    }

    public static <T extends Comparable<T>> void printArray(T[] array){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");   
        }
    }

    private static <T extends Comparable<T>> void toSwap(T[] array, int first, int second){
        T temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static <T extends Comparable<T>> void bubbleSorter(T[] array){ 
        for (int i = array.length - 1; i >= 1; i--){
            for (int j = 0; j < i; j++){
                if(array[j].compareTo(array[j + 1]) > 0) 
                    toSwap(array, j, j + 1);
            }
        }
    }

    public static <T extends Comparable<T>> void bubbleSorter(T[] array, int start, int end){ 
        for (int i = end - 1; i >= 1; i--){
            for (int j = start; j < i; j++){
                if(array[j].compareTo(array[j + 1]) > 0) 
                    toSwap(array, j, j + 1);
            }
        }
    }

    public static <T extends Comparable<T>> void insertionSorter(T[] array){
        T key;
        int j = 0;
        for(int i = 0; i < array.length; i++){
            key = array[i];
            j = i - 1;
            for(; j >= 0; j--){
                if(array[j].compareTo(key) > 0){
                    array[j + 1] = array[j];
                }
                else{
                    break;
                }
            }
            array[j + 1] = key;
        }
    }

    public static <T extends Comparable<T>> void insertionSorter(T[] array, int start, int end){
        T key;
        int j = 0;
        for(int i = start; i < end; i++){
            key = array[i];
            j = i - 1;
            for(; j >= start; j--){
                if(array[j].compareTo(key) > 0){
                    array[j + 1] = array[j];
                }
                else{
                    break;
                }
            }
            array[j + 1] = key;
        }
    }

    public static <T extends Comparable<T>> void selectionSorter(T[] array, int start, int end){
        T temp;
        int min;
        int j = 0;
        for(int i = start; i < end; i++){
            min = i;
            j = i + 1;
            while(j < end){
                if(array[j].compareTo(array[min]) < 0){
                    min = j;
                }
                j++;
            }
            temp = array[i];
            array[i] = array[min];
            array[min] = temp;
            
        }
    }

    public static <T extends Comparable<T>> void selectionSorter(T[] array){
        T temp;
        int min;
        int j = 0;
        for(int i = 0; i < array.length; i++){
            min = i;
            j = i + 1;
            while(j < array.length){
                if(array[j].compareTo(array[min]) < 0){
                    min = j;
                }
                j++;
            }
            temp = array[i];
            array[i] = array[min];
            array[min] = temp;
            
        }
    }

    public class Main {
        public static void main(String[] args) {
            simpleSort<String> array = new simpleSort<String>();
            
            System.out.println();
        }
    }
}
