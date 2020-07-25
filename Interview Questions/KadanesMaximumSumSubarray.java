// This solution is based on Kadane's Algorithm for obtaining the subarray with maximum possible sum for a given array
// O(n) time | O(1) space
import java.util.*;
class KadanesMaximumSumSubarray{

    // O(n)-time | O(1)-space and no changes in the original array
    public static int[] getMaximumSumSubarray(int[] array){
        if(array.length == 1){
            return array;
        }
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0, start = 0, end = 0, index = 0;
        for(int i = 0; i < array.length; i++){
            max_ending_here += array[i];
            if(max_so_far < max_ending_here){
                max_so_far = max_ending_here;
                start = index;
                end = i;
            }
            if(max_ending_here < 0){
                max_ending_here = 0;
                index = i + 1;
            }
        }
        System.out.println("Maximum Sum : " + max_so_far);
        return Arrays.copyOfRange(array, start, end + 1);
    }

    // O(n)-time | O(n)-space but no changes in the original array
    public static int getMaximumSumOfSubarray1(int[] array){
        if(array.length == 1){
            return array[0];
        }
        System.out.print("Subarray : ");
        int[] dp = new int[array.length];
        dp[0] = array[0];
        for(int i = 1; i < array.length; i++){
            // just for printing the subarray
            // if we need this subarray then, we can store it and return it too
            if(array[i] < dp[i - 1] + array[i]){
                System.out.print(array[i] + " ");
            }
            // main logic
            dp[i] = Math.max(array[i], dp[i - 1] + array[i]);
        }
        System.out.println();
        return dp[dp.length - 1];
    }

    // O(n)-time | O(1)-space but alters the original array
    public static int getMaximumSumOfSubarray2(int[] array){
        if(array.length == 1){
            return array[0];
        }
        System.out.print("Subarray : ");
        for(int i = 1; i < array.length; i++){
            // just for printing the subarray
            // if we need this subarray then, we can store it and return it too
            if(array[i] < array[i - 1] + array[i]){
                System.out.print(array[i] + " ");
            }
            // main logic
            array[i] = Math.max(array[i], array[i - 1] + array[i]);
        }
        System.out.println();
        return array[array.length - 1];
    }

    public static void main(String args[])throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nKadane's Algorithm for Maximum Sum Subarray Problem\n");
        System.out.print("Enter number of testcases : ");
        int T = sc.nextInt();
        while(T-->0){
            System.out.print("Enter number of elements in array : ");
            int N = sc.nextInt();
            int[] array = new int[N];
            System.out.print("Enter " + N + " space separated elements for the array : ");
            for(int i = 0; i < N; i++){
                array[i] = sc.nextInt();
            }
            System.out.println();
            int[] subarray = getMaximumSumSubarray(array);
            System.out.print("{ O(n)-time | O(1)-space } Subarray with the maximum possible sum : ");
            for(int e : subarray){
                System.out.print(e + " ");
            }
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------");
            int sum = getMaximumSumOfSubarray1(array);
            System.out.println("{ O(n)-time | O(n)-space } Maximum possible sum for any subarray in the given array : " + sum);
            System.out.println("---------------------------------------------------------------------------------------------");
            sum = getMaximumSumOfSubarray2(array);
            System.out.println("{ O(n)-time | O(1)-space } Maximum possible sum for any subarray in the given array : " + sum);
        }
        sc.close();
    }
}