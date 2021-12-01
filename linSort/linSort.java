

public class linSort {
    private long[] array;
    private int elems;

    public linSort(int max){
        array = new long[max];
        elems = 0;
    }

    public void addElement(long value){
        array[elems] = value;
        elems++;
    }

    public void printArray(){
        for (int i = 0; i < elems; i++){
            System.out.print(array[i] + " ");   
        }
    }

    public static int getMaxLength(linSort value){
        int length = 0;
        long position = 0;
        long a = 0;
        int max = 0;
        for(int i = 0; i < value.elems; i++){
            a = value.array[i];
            while(a != 0){
                position = a % 10;
                a = a / 10;
                length++;
            }
            if(length > max){
                max = length;
            }
            length = 0;
        }
        return max;
    }

    public static long getPosition(long element, int count){
        long position = 0;
        long a = element;
        a = a / (int) Math.pow(10, count);
        position = a % 10;
        if(a == 0 && position == 0){
            return 10;
        }
        else{
            return position;
        }
    }

    public static linSort lsdSort(linSort value){
        linSort temp = new linSort(value.elems);
        long[][] bigData = new long[11][value.elems];
        int max = 0;
        int count = 0;
        int position = 0;
        int k = 0;
        max = getMaxLength(value);
        while(count != max){
            for(int i = 0; i < value.elems; i++){
                position = (int) getPosition(value.array[i], count);
                for(int j = 0; j < value.elems; j++){
                    if(bigData[position][j] == 0){
                        bigData[position][j] = value.array[i];
                        break;
                    }
                    
                }
            }
            for(int i = 0; i < value.elems; i++){
                if(bigData[10][i] != 0){
                    temp.array[k] = bigData[10][i];
                    value.array[k] = bigData[10][i];
                    bigData[10][i] = 0;
                    k++;
                }
                else{
                    break;
                }
            }
            for(int i = 0; i < 10; i++){
                for(int j = 0; j < value.elems; j++){
                    if(bigData[i][j] != 0){
                        temp.array[k] = bigData[i][j];
                        value.array[k] = bigData[i][j];
                        bigData[i][j] = 0;
                        k++;
                    }
                    else{
                        break;
                    }
                     
                }
            }
            k = 0;
            count++;
        }
        return temp;
    }

    public static int getLengthElem(long element) {
        int length = 0;
        while(element != 0){
            element = element / 10;
            length++;
        }
        return length;
    }

    public static int getMinLength(linSort value) {
        int min = 0;
        long a = 0;
        long position = 0;
        int length = 0;
        for(int i = 0; i < value.elems; i++){
            a = value.array[i];
            while(a != 0){
                position = a % 10;
                a = a / 10;
                length++;
                if(min == 0){
                    min = length;
                }
            }
            if(length < min){
                min = length;
            }
            length = 0;
        }

        return min;
    }
    
    public static void sortArray(long[]tempData){
        int length = 0;
        int position = 0;
        int k = 0;
        int max = tempData.length;
        int count = 1;
        long[][] bigData = new long[11][tempData.length];
        while(count != max){
            for(int i = 0; i < tempData.length; i++){
                if(tempData[i] == 0){
                    break;
                }
                length = getLengthElem(tempData[i]);
                if(count >= length){
                    for(int j = 0; j < tempData.length; j++){
                        if(bigData[10][j] == 0){
                            bigData[10][j] = tempData[i];
                            break;
                        }
                    }
                    
                }
                else{
                    position = (int) getPosition(tempData[i], length - count - 1);
                    for(int j = 0; j < tempData.length; j++){
                        if(bigData[position][j] == 0){
                            bigData[position][j] = tempData[i];
                            break;
                        }
                        
                    }
                }
            }
            count++;
            for(int i = 0; i < 10; i++){
                for(int j = 0; j < tempData.length; j++){
                    if(bigData[i][j] != 0){
                        tempData[k] = bigData[i][j];
                        bigData[i][j] = 0;
                        k++;
                    }
                    else{
                        break;
                    }
                     
                }
            }
            k = 0;
            
        }
    }

    public static linSort msdSort(linSort value) {
        linSort temp = new linSort(value.elems);
        long[][] bigData = new long[11][value.elems];
        long[] tempData = new long[value.elems];
        int count = 0;
        int position = 0;
        int length = 0;
        int max = getMaxLength(value);
        int min = getMinLength(value);
        int k = 0;
        for(int i = 0; i < value.elems; i++){
            length = getLengthElem(value.array[i]);
            position = (int) getPosition(value.array[i], length - 1);
            for(int j = 0; j < value.elems; j++){
                if(bigData[position][j] == 0){
                    bigData[position][j] = value.array[i];
                    break;
                }
                
            }
        }
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < value.elems; j++){
                if(bigData[i][j] != 0){
                    tempData[k] = bigData[i][j];
                    bigData[i][j] = 0;
                    k++;
                }
                else{
                    break;
                }
            }
            k = 0;
            if(tempData[0] != 0){
                sortArray(tempData);
                for(int n = 0; n < tempData.length; n++){
                    if(tempData[n] == 0){
                        break;
                    }
                    if(temp.array[k] == 0){
                        temp.array[k] = tempData[n];
                        tempData[n] = 0;
                    }
                    k++;
                }
                k = 0;
            }
            
        }
        
        
        return temp;
    }

    public class Main {
        public static void main(String[] args) {
            linSort array = new linSort(10);
            linSort sorter = new linSort(10);
            array.addElement(932);
            array.addElement(311);
            array.addElement(457);
            array.addElement(163);
            array.addElement(330);
            array.addElement(118);
            array.addElement(953);
            array.addElement(949);
            array.addElement(381);
            array.addElement(166);
            sorter = msdSort(array);
            // array.addElement('H');
            // array.addElement("Hello");

            sorter.printArray();
            System.out.println();
        }
    }
}
