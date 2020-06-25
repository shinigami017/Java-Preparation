import java.util.*;
class CountingSort{
    public static void sort(int[] array){
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[array.length];
        for(int i = 0; i < array.length; i++){
            count[array[i]-min]++;
        }
        for(int i = 1; i < range; i++){
            count[i] += count[i-1];
        }
        for(int i = array.length - 1; i >= 0; i--){
            output[count[array[i] - min] - 1] = array[i];
            count[array[i] - min]--;
        }
        for (int i = 0; i < output.length; i++) {
            array[i] = output[i];
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