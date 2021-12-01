public class effectiveSort<T> {
    public effectiveSort() {
        
    }

    public static <T extends Comparable<T>> void quickSort(T[] array, int leftBorder, int rightBorder) {
        int leftPosition = leftBorder;
        int rightPosition = rightBorder;
        T element = array[(leftBorder + rightBorder) / 2];
        while(leftPosition <= rightPosition){
            while(array[leftPosition].compareTo(element) < 0){
                leftPosition++;
            }
            while(array[rightPosition].compareTo(element) > 0){
                rightPosition--;
            }
            if(leftPosition <= rightPosition){
                if(leftPosition < rightPosition){
                    T temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }
        }
        if(leftPosition < rightBorder){
            quickSort(array, leftPosition, rightBorder);
        }
        if(leftBorder < rightPosition){
            quickSort(array, leftBorder, rightPosition);
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left+right)/2;
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, mid, right);
    }
    public static <T extends Comparable<T>> void merge(T[] array, int left, int mid, int right) {
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        Comparable leftPartArray[] = new Comparable [lengthLeft];
        Comparable rightPartArray[] = new Comparable [lengthRight];

        for (int i = 0; i < lengthLeft; i++)
            leftPartArray[i] = array[left+i];
        for (int i = 0; i < lengthRight; i++)
            rightPartArray[i] = array[mid+i+1];

        int leftIndex = 0;
        int rightIndex = 0;
    
        for (int i = left; i < right + 1; i++) {
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftPartArray[leftIndex].compareTo(rightPartArray[rightIndex]) < 0) {
                    array[i] = (T) leftPartArray[leftIndex];
                    leftIndex++;
                }
                else {
                    array[i] = (T) rightPartArray[rightIndex];
                    rightIndex++;
                }
            }
            else if (leftIndex < lengthLeft) {
                array[i] = (T) leftPartArray[leftIndex];
                leftIndex++;
            }
            else if (rightIndex < lengthRight) {
                array[i] = (T) rightPartArray[rightIndex];
                rightIndex++;
            }
        }
    }

    public static <T extends Comparable<T>> void heapSort(T[] array)
    {
        int n = array.length;
  
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);
  
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;
  
            // call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    public static <T extends Comparable<T>> void heapSort(T[] array, int start, int end)
    {
        Comparable tempArray[] = new Comparable [end - start];
        int j = 0;
        for(int i = start; i < end; i++){
            tempArray[j] = array[i];
            j++;
        }
        j = 0;
        int n = tempArray.length;
  
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(tempArray, n, i);
  
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            T temp = (T) tempArray[0];
            tempArray[0] = tempArray[i];
            tempArray[i] = temp;
  
            // call max heapify on the reduced heap
            heapify(tempArray, i, 0);
        }

        for(int i = start; i < end; i++){
            array[i] = (T) tempArray[j];
            j++;
        }
    }
  
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    public static <T extends Comparable<T>> void heapify(T array[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
  
        // If left child is larger than root
        if (l < n && array[l].compareTo(array[largest]) > 0)
            largest = l;
  
        // If right child is larger than largest so far
        if (r < n && array[r].compareTo(array[largest]) > 0)
            largest = r;
  
        // If largest is not root
        if (largest != i)
        {
            T swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
  
            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
    }


    public class Main {
        public static void main(String[] args) {
            effectiveSort<Integer> array = new effectiveSort<Integer>();
            Integer[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
            heapSort(arr, 1, 8);
            
            for(int i = 0; i < arr.length; i++){
                System.out.println(arr[i] + " ");
            }
            
        }
    }
}
