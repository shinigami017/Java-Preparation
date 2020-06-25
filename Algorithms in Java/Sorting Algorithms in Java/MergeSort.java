import java.util.*;
class MergeSort{
    public static void sort(int[] array){
        int low = 0, high = array.length - 1;
        mergesort(array, low, high);
    }
    public static void mergesort(int[] array, int low, int high){
        if(low < high){
            int middle = (high + low) / 2;
            mergesort(array, low, middle);
            mergesort(array, middle + 1, high);
            merge(array, low, middle, high);
        }
    }
    public static void merge(int[] array, int low, int middle, int high){
        int size_left = middle - low + 1, size_right = high - middle;
        int left[] = new int[size_left];
        int right[] = new int[size_right];
        for(int i = 0; i < size_left; i++){
            left[i] = array[low + i];
        }
        for(int i = 0; i < size_right; i++){
            right[i] = array[middle + 1 + i];
        }
        int i = 0, j = 0, k = low;
        while(i < size_left && j < size_right){
            if(left[i] <= right[j]){
                array[k++] = left[i++];
                // array[k] = left[i];
                // i++;
            } else {
                array[k++] = right[j++];
                // array[k] = right[j];
                // j++;
            }
            // k++;
        } 
        while(i < size_left){
            array[k++] = left[i++];
            // array[k] = left[i];
            // k++;
            // i++;
        }
        while(j < size_right){
            array[k++] = right[j++];
            // array[k] = right[j];
            // k++;
            // j++;
        }
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