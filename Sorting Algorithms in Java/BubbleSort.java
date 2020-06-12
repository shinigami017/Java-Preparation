import java.util.*;
class BubbleSort{
    public static void sort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            boolean sorted = true;
            for (int j = 0; j < array.length - 1; j++) {
                if(array[j+1] < array[j]){
                    swap(array, j, j + 1);
                    sorted = false;
                }
            }
            if(sorted) break;
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