import java.util.*;
class HeapSort{
    public static void sort(int[] array){
        for(int i = (array.length / 2) - 1; i >= 0; i--){
            heapify(array, array.length,i);
        }
        for(int i = array.length - 1; i > 0; i--){
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }
    public static void heapify(int[] array, int n, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if(left < n && array[left] > array[largest]){
            largest = left;
        }
        if(right < n && array[right] > array[largest]){
            largest = right;
        }
        if(largest != i){
            swap(array, i, largest);
            heapify(array, n, largest);
        }
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