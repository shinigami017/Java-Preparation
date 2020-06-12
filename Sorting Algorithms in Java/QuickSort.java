import java.util.*;
class QuickSort{
    public static void sort(int[] array){
        int low = 0, high = array.length - 1;
        quicksort(array, low, high);
    }
    public static void quicksort(int[] array, int low, int high){
        if(low < high){
            int pivot = partition(array, low, high);
            quicksort(array, low, pivot - 1);
            quicksort(array, pivot + 1, high);
        }
    }
    public static int partition(int[] array, int low, int high){
        int pivot = array[high]; // taking last element of array as pivot
        int i = low;
        for(int j = low; j < high; j++){
            if(array[j] < pivot){
                // swap array[i] with array[j] element
                swap(array, i, j);
                i++; 
            }
        }
        // swap array[i] with pivot element
        swap(array, i, high);
        return i;    
    }
    public static void swap(int[] array, int x, int y){
        int temp = array[x];
            array[x] = array[y];
            array[y] = temp;
    }
    public static void printArray(int[] array){
        for(int element : array){
            System.out.print(element + "\t");
        }
        System.out.println();
    }
    public static void main(String args[])throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements : ");
        int size = sc.nextInt();
        System.out.println("\nEnter elements : ");
        int array[] = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = sc.nextInt();
        }
        sort(array);
        printArray(array);
        sc.close();
    }
}