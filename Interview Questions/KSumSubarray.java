// This is idol solution for checking if there exists any subarray in the given array whose sum is equal to given k.
// This solution can be used to solve popular problem of ZeroSumSubarray
import java.util.*;
class KSumSubarray{
    public static boolean findSubarray(int[] array, int k){
        if(array.length == 0) return false;
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for(int element : array){
            set.add(sum);
            sum += element;
            if(set.contains(sum - k)){
                return true;
            }
        }
        return false;
    }
    public static void main(String args[])throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nKSumSubarray Problem : check whether any subarray exists in the array whose sum is equal to given K\n");
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
            System.out.print("Enter value for K : ");
            int k = sc.nextInt();
            System.out.println();
            if(findSubarray(array, k)){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }
        sc.close();
    }
}