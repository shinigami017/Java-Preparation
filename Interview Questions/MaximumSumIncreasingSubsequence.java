// MaximumSumIncreasingSubsequence Problem : find any increasing subsequence from the given array whose sum is maximum
// there can be two variants for this problem : one with strictly increasing subsequence and other with not strictly increasing subsequence
// O(N^2) - time | O(N) - space
import java.util.*;

class MaximumSumIncreasingSubsequence{
    // O(N^2) - time | O(N) - space
    public static List<Integer> getMaximumSumIncreasingSubsequence(int[] arr){
        int[] sequence = new int[arr.length];
        Arrays.fill(sequence, -1);
        int[] sums = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            sums[i] = arr[i];
        }
        int maxSumIndex = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                // for strictly increasing subsequence
                // if(arr[j] < arr[i] && sums[j] + arr[i] >= sums[i]){
                // for not strictly increasing subsequence 
                if(arr[j] <= arr[i] && sums[j] + arr[i] >= sums[i]){
                    sums[i] = sums[j] + arr[i];
                    sequence[i] = j;
                }
            }
            maxSumIndex = (sums[i] >= sums[maxSumIndex]) ? i : maxSumIndex;
        }
        return buildMaximumSumIncreasingSubsequence(arr, sequence, maxSumIndex);
    }

    public static List<Integer> buildMaximumSumIncreasingSubsequence(int[] arr, int[] sequence, int index){
        List<Integer> subsequence = new ArrayList<>();
        while(index != -1){
            subsequence.add(arr[index]);
            index = sequence[index];
        }
        Collections.reverse(subsequence);
        return subsequence;
    }
    public static void main(String args[])throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nMaximumSumIncreasingSubsequence Problem : find any increasing subsequence from the given array whose sum is maximum\n");
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
            List<Integer> subsequence = getMaximumSumIncreasingSubsequence(array);
            int sum = 0;
            System.out.print("Not strictky increasing subsequence with maximum sum :");
            for(int a : subsequence){
                sum += a;
                System.out.print(" " + a);
            }
            System.out.println("\nMaximum sum : " + sum);
        }
        sc.close();
    }
}