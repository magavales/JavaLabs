import java.util.Arrays;

public class testSimpleSort {
    public static void main(String[] args) {
        try{
            Integer[] arr = {1, 5, 3, 2, 4};
            simpleSort.bubbleSorter(arr); 

            assert Arrays.equals(new Integer[]{1, 2, 3, 4, 5}, arr) : "Failed test #1";
        }  
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            Integer[] arr = {1, 5, 3, 2, 4, 1, 2, 7, 1, 2, 3, 4, 5, 9, 0};
            simpleSort.bubbleSorter(arr); 

            assert Arrays.equals(new Integer[]{0, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 7, 9}, arr) : "Failed test #2";
        }  
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            Integer[] arr = {1, 2, 3, 4, 5};
            simpleSort.bubbleSorter(arr, 3, 3); 

            assert Arrays.equals(new Integer[]{1, 2, 3, 4, 5}, arr) : "Failed test #3";
        }  
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            Integer[] arr = {};
            simpleSort.bubbleSorter(arr); 

            assert Arrays.equals(new Integer[]{}, arr) : "Failed test #4";
        }  
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            Integer[] arr = {5, 4, 3, 2, 1};
            simpleSort.bubbleSorter(arr, 1, 2); 

            assert Arrays.equals(new Integer[]{5, 3, 4, 2, 1}, arr) : "Failed test #5";
        }  
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            Character[] arr = {'a', 'b', 'c', 'd', 'e'};
            simpleSort.bubbleSorter(arr); 

            assert Arrays.equals(new Character[]{'a', 'b', 'c', 'd', 'e'}, arr) : "Failed test #1";
        }  
        catch(Exception e) {
            System.out.println(e.getMessage());
        }




        try{
            Integer[] arr = {1, 5, 3, 2, 4};
            simpleSort.insertionSorter(arr); 

            assert Arrays.equals(new Integer[]{1, 2, 3, 4, 5}, arr) : "Failed test #1";
        }  
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            Integer[] arr = {1, 5, 3, 2, 4, 1, 2, 7, 1, 2, 3, 4, 5, 9, 0};
            simpleSort.insertionSorter(arr); 

            assert Arrays.equals(new Integer[]{0, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 7, 9}, arr) : "Failed test #2";
        }  
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            Integer[] arr = {1, 2, 3, 4, 5};
            simpleSort.insertionSorter(arr, 3, 3); 

            assert Arrays.equals(new Integer[]{1, 2, 3, 4, 5}, arr) : "Failed test #3";
        }  
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            Integer[] arr = {};
            simpleSort.insertionSorter(arr); 

            assert Arrays.equals(new Integer[]{}, arr) : "Failed test #4";
        }  
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            Integer[] arr = {5, 4, 3, 2, 1};
            simpleSort.insertionSorter(arr, 1, 3); 

            assert Arrays.equals(new Integer[]{5, 3, 4, 2, 1}, arr) : "Failed test #5";
        }  
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            Character[] arr = {'a', 'b', 'c', 'd', 'e'};
            simpleSort.insertionSorter(arr); 

            assert Arrays.equals(new Character[]{'a', 'b', 'c', 'd', 'e'}, arr) : "Failed test #6";
        }  
        catch(Exception e) {
            System.out.println(e.getMessage());
        }



        try{
            Integer[] arr = {1, 5, 3, 2, 4};
            simpleSort.selectionSorter(arr); 

            assert Arrays.equals(new Integer[]{1, 2, 3, 4, 5}, arr) : "Failed test #7";
        }  
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            Integer[] arr = {1, 5, 3, 2, 4, 1, 2, 7, 1, 2, 3, 4, 5, 9, 0};
            simpleSort.selectionSorter(arr); 

            assert Arrays.equals(new Integer[]{0, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 7, 9}, arr) : "Failed test #8";
        }  
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            Integer[] arr = {1, 2, 3, 4, 5};
            simpleSort.selectionSorter(arr, 3, 3); 

            assert Arrays.equals(new Integer[]{1, 2, 3, 4, 5}, arr) : "Failed test #9";
        }  
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            Integer[] arr = {};
            simpleSort.selectionSorter(arr); 

            assert Arrays.equals(new Integer[]{}, arr) : "Failed test #10";
        }  
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            Integer[] arr = {5, 4, 3, 2, 1};
            simpleSort.selectionSorter(arr, 1, 3); 

            assert Arrays.equals(new Integer[]{5, 3, 4, 2, 1}, arr) : "Failed test #11";
        }  
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            Character[] arr = {'a', 'b', 'c', 'd', 'e'};
            simpleSort.selectionSorter(arr); 

            assert Arrays.equals(new Character[]{'a', 'b', 'c', 'd', 'e'}, arr) : "Failed test #12";
        }  
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
