import java.util.*;
class BinarySearch{
    // ITERATIVE APPROACH
    public static boolean search(int[] array, int key){
        int low = 0, high = array.length - 1;
        while(low <= high){
            int middle = (low + high) / 2;
            if(array[middle] < key){
                low = middle + 1;
            } else if(array[middle] > key){
                high = middle - 1;
            } else {
                return true;
            }
        }
        return false;
    }
    // ITERATIVE APPROACH
    public static int searchPosition(int[] array, int key){
        int low = 0, high = array.length - 1;
        while(low <= high){
            int middle = (low + high) / 2;
            if(array[middle] < key){
                low = middle + 1;
            } else if(array[middle] > key){
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    // RECURSIVE APPROACH
    public static boolean searchRecursively(int[] array, int low, int high, int key){
        if(low <= high){
            int middle = (low + high) / 2;
            if(array[middle] < key){
                return searchRecursively(array, middle + 1, high, key);
            } else if(array[middle] > key){
                return searchRecursively(array, low, middle - 1, key);
            } else {
                return true;
            }
        }
        return false;
    }
    // RECURSIVE APPROACH
    public static int searchPositionRecursively(int[] array, int low, int high, int key){
        if(low <= high){
            int middle = (low + high) / 2;
            if(array[middle] < key){
                return searchPositionRecursively(array, middle + 1, high, key);
            } else if(array[middle] > key){
                return searchPositionRecursively(array, low, middle - 1, key);
            } else {
                return middle;
            }
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
        // Just checking if element is present or not recursively 
        // System.out.println((searchRecursively(array, 0, size-1, key)) ? "Found" : "Not Found");
        // Giving the position of element, if found, recursively
        // System.out.println((searchPositionRecursively(array, 0, size-1, key) == -1) ? "Not Found" : "Found at position " + (searchPosition(array, key)+1));
    }
}