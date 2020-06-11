import java.util.*;
class LinearSearch{
    public static boolean search(int[] array, int key){
        for(int element : array){
            if(element == key) return true;
        }
        return false;
    }
    public static int searchPosition(int[] array, int key){
        for(int i = 0; i < array.length; i++){
            if(array[i] == key) return i;
        }
        return -1;
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
        System.out.print("Enter element to search : ");
        int key = sc.nextInt();
        // Just checking if element is present or not 
        // System.out.println((search(array, key)) ? "Found" : "Not Found");
        // Giving the position of element, if found
        System.out.println((searchPosition(array, key) == -1) ? "Not Found" : "Found at position " + (searchPosition(array, key)+1));
    }
}