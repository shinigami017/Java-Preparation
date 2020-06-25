// Solved using TWO POINTER ALGORITHM 
// In this problem, we are given an array and asked to return 1 if there exists any triplet in array such that sum of its element is equal to 0
// We have implemented TWOSUM problem also in this solution, TwoSum problem is finding any pair with sum = given element x
import java.util.*;
class TripletsProblem{
    public static boolean findTriplet(int[] array, int start, int end, int x){
        Arrays.sort(array);
        for(int i = start; i <= end - 2; i++){
            if(twoSum(array, i + 1, end, -array[i])){
                return true;
            }
        }
        return false;
    }
    public static boolean twoSum(int[] array, int start, int end, int x){
        while(start < end){
            if(array[start] + array[end] < x){
                start++;
            } else if(array[start] + array[end] > x){
                end--;
            } else{
                return true;
            }
        }
        return false;
    }
    public static void main(String args[])throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nTriplets Problem : check whether such triplet exists in the array whose sum is 0\n");
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
            if(findTriplet(array, 0, N-1, 0)){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }
        sc.close();
    }
}