// This solution is for the maximum sum subsequene problem of obtaining the subarray with maximum possible sum in a given array
// O(n) time | O(1) space
import java.util.*;
class MaximumSumSubarray{

    // O(n)-time | O(n)-space but no changes in the original array
    public static int getMaximumSumOfSubarray1(int[] array){
        if(array.length == 1){
            return array[0];
        }
        int[] dp = new int[array.length];
        dp[0] = array[0];
        for(int i = 1; i < array.length; i++){
            dp[i] = Math.max(array[i], dp[i - 1] + array[i]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    // O(n)-time | O(1)-space but alters the original array
    public static int getMaximumSumOfSubarray2(int[] array){
        if(array.length == 1){
            return array[0];
        }
        for(int i = 1; i < array.length; i++){
            array[i] = Math.max(array[i], array[i - 1] + array[i]);
        }
        return Arrays.stream(array).max().getAsInt();
    }
    
    // faster than above approach for O(n)
    public int getMaximumSumOfSubarray3(int[] array) {
        int max_sum = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (sum < 0) ? nums[i] : sum + nums[i];
            max_sum = Math.max(sum, max_sum);
        }
        return max_sum;
    }

    public static void main(String args[])throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nMaximum Sum Subarray Problem\n");
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
            int sum = getMaximumSumOfSubarray1(array);
            System.out.println("{ O(n)-time | O(n)-space } Maximum possible sum for any subarray in the given array : " + sum);
            System.out.println("---------------------------------------------------------------------------------------------");
            sum = getMaximumSumOfSubarray2(array);
            System.out.println("{ O(n)-time | O(1)-space } Maximum possible sum for any subarray in the given array : " + sum);
        }
        sc.close();
    }
}
