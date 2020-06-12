import java.util.*;
class ShellSort{
    public static void sort(int[] array){
        int n = array.length;
        for(int interval = n/2; interval > 0; interval /= 2){
            for(int inner = interval; inner < n; inner++){
                int temp = array[inner], outer = inner;
                for(outer = inner; outer >= interval && array[outer - interval] > temp; outer -= interval){
                    array[outer] = array[outer - interval];
                }
                array[outer] = temp;
            }
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