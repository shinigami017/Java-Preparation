// This is idol solution for obtaining the maximum possible sum obtained by a subarray of array without including the adjacent elements
// O(n) time | O(1) space
import java.util.*;
class MaximumSumSubarrayNoAdjacent{

    // O(n)-time | O(n)-space but no changes in the original array
    public static int getMaximumSubarraySumNoAdjacent1(int[] array){
        if(array.length == 1){
            return array[0];
        }
        int[] dp = new int[array.length];
        System.out.print("Adding ");
        dp[0] = array[0];
        dp[1] = Math.max(array[0], array[1]);
        System.out.print(array[1] + " ");
        for(int i = 2; i < array.length; i++){
            // just for printing the subarray
            // if we need this subarray then, we can store it and return it too
            if(dp[i - 1] < dp[i - 2] + array[i]){
                System.out.print(array[i] + " ");
            }
            // main logic
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + array[i]);
        }
        System.out.println();
        return dp[dp.length - 1];
    }

    // O(n)-time | O(1)-space but alters the original array
    public static int getMaximumSubarraySumNoAdjacent2(int[] array){
        if(array.length == 1){
            return array[0];
        }
        System.out.print("Adding ");
        array[1] = Math.max(array[0], array[1]);
        System.out.print(array[1] + " ");
        for(int i = 2; i < array.length; i++){
            // just for printing the subarray
            // if we need this subarray then, we can store it and return it too
            if(array[i - 1] < array[i - 2] + array[i]){
                System.out.print(array[i] + " ");
            }
            // main logic
            array[i] = Math.max(array[i - 1], array[i - 2] + array[i]);
        }
        System.out.println();
        return array[array.length - 1];
    }
    public static void main(String args[])throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nMaximum Sum of Subarray with No Adjacent elements Problem\n");
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
            int sum = getMaximumSubarraySumNoAdjacent1(array);
            System.out.println("{ O(n)-time | O(n)-space } Maximum possible Sum of any subarray of array with no adjacent elements : " + sum);
            System.out.println("------------------------------------------------------------------------------------------------------------");
            sum = getMaximumSubarraySumNoAdjacent2(array);
            System.out.println("{ O(n)-time | O(1)-space } Maximum possible Sum of any subarray of array with no adjacent elements : " + sum);
        }
        sc.close();
    }
}