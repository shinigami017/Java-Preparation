// This is solution for the problem of Pair of elements with Smallest Difference from given two arrays 
import java.util.*;
class SmallestDifferencePair{
    
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
        System.out.println("\nSmallest Difference Pair Problem : obtain a pair of elements with Smallest Difference from given two arrays\n");
        System.out.print("Enter number of elements in first array : ");
        int M = sc.nextInt();
        int[] array1 = new int[M];
        System.out.print("Enter " + M + " space separated elements for the first array : ");
        for(int i = 0; i < M; i++){
            array1[i] = sc.nextInt();
        }
        System.out.print("Enter number of elements in second array : ");
        int N = sc.nextInt();
        int[] array2 = new int[N];
        System.out.print("Enter " + N + " space separated elements for the second array : ");
        for(int i = 0; i < N; i++){
            array2[i] = sc.nextInt();
        }
        System.out.println();
        int[] pair = getSmallestDifferencePair(array1, array2);
        System.out.println("Pair of elements from");
        System.out.print("Array 1 : { ");
        for(int a : array1){
            System.out.print(a+" ");
        }
        System.out.print("}\nArray 2 : { ");
        for(int a : array2){
            System.out.print(a+" ");
        }
        System.out.println("}\n with smallest difference : ( " + pair[0] + ", "+ pair[1] +" )");
        sc.close();
    }
}