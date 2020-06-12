import java.util.*;
class SelectionSort{
    public static void sort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < array[min]){
                    min = j;
                }
            }
            if(min != i){
                swap(array, min, i);
            }
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