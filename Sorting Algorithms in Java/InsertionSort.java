import java.util.*;
class InsertionSort{
    public static void sort(int[] array){
        for(int i = 0; i < array.length; i++){
            int current = array[i], j = i;
            while(j > 0 && array[j-1] > current){
                array[j] = array[j-1];
                j--;
            }
            array[j] = current;
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