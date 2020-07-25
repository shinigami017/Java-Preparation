// This is solution for the problem based on shifiting all the occurences of given element k to the end of the given array
// This is the most efficient solution based on Two-Pointer Algorithm, and it takes
// O(n) time | O(1) space
import java.util.*;
class ShiftInArray{

    // O(n) time | O(1) space
    // this approach alters original array as well as does not maintains the natural order of non-k elements of array
    public static void shiftInArray(int[] array, int k){
        int i = 0, j = array.length - 1;
        while(i < j){
            while(i < j && array[j] == k){
                j--;
            }
            if(array[i] == k){
                // swap(array, i, j);
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            i++;
        }
    }

    // O(n) time | O(n) space
    // this approach maintains the natural order of non-k elements of array and the original array remains unchanged
    public static int[] getShiftedArray(int[] array, int k){
        int[] array2 = new int[array.length];
        int j = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] != k){
                array2[j++] = array[i];
            }
        }
        while(j < array2.length){
            array2[j++] = k;
        }
        return array2;
    }

    public static int[] getSmallestDifferencePair(int[] array1, int[] array2){
        int[] pair = new int[2];
        Arrays.sort(array1);
        Arrays.sort(array2);
        int i = 0, j = 0, current, smallest = Integer.MAX_VALUE;
        while(i < array1.length && j < array2.length){
            if(array1[i] < array2[j]){
                current = array2[j] - array1[i];
                if(smallest > current){
                    smallest = current;
                    pair[0] = array1[i];
                    pair[1] = array2[j];
                }
                i++;
            }else if(array1[i] > array2[j]){
                current = array1[i] - array2[j];
                if(smallest > current){
                    smallest = current;
                    pair[0] = array1[i];
                    pair[1] = array2[j];
                }
                j++;
            }else{
                pair[0] = array1[i];
                pair[1] = array2[j];
                return pair;
            }
        }
        return pair;
    }

    public static void main(String args[])throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nShift In Array Problem : move all the occurences of given element to the end of the array\n");
        System.out.print("Enter number of elements in the array : ");
        int N = sc.nextInt();
        int[] array = new int[N];
        System.out.print("Enter " + N + " space separated elements for the array : ");
        for(int i = 0; i < N; i++){
            array[i] = sc.nextInt();
        }
        System.out.print("Enter the element to be shifted : ");
        int k = sc.nextInt();
        System.out.println();
        System.out.print("Original array : ");
        for(int a : array){
            System.out.print(a + " ");
        }
        // shifting in new array
        int[] new_array = getShiftedArray(array, k);
        System.out.print("\nArray after shift using another array : ");
        for(int a : new_array){
            System.out.print(a + " ");
        }
        System.out.println("\n-----------------------------------------------------");
        System.out.print("Original array : ");
        for(int a : array){
            System.out.print(a + " ");
        }
        // Shifting in original array
        shiftInArray(array, k);
        System.out.print("\nArray after shift without using any other array : ");
        for(int a : array){
            System.out.print(a + " ");
        }
        sc.close();
    }
}