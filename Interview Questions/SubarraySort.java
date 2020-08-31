// Subarray Sort Problem :- There can be various problems derived from this concept like,
// Find the length of shortest possible subarray which needs to be sorted in order to sort the entire given array
// Find the starting and ending index of such shortest subarray
// O(N) - time | O(1) - space

import java.util.*;
class SubarraySort
{
	public static int[] getSubarrayIndices(int[] arr){
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		boolean flag = true;
		int[] indices = {-1, -1};
		for(int i = 0; i < arr.length; i++){
			if(isOutOfOrder(i, arr[i], arr)){
				flag = false;
				min = (min < arr[i]) ? min : arr[i];
				//min = Math.min(min,arr[i]);
				max = (max > arr[i]) ? max : arr[i];
				//max = Math.max(max,arr[i]);
			}
		}
		if(flag){
			return indices;
		}
		int start_index = 0, end_index = arr.length - 1;
		while(min >= arr[start_index]){
			start_index++;
		}
		while(max <= arr[end_index]){
			end_index--;
		}
		indices[0] = start_index;
		indices[1] = end_index;
		return indices;
	}
	
	public static boolean isOutOfOrder(int index, int element, int[] arr){
		if(index == 0){
			return element > arr[index + 1];
		}
		if(index == arr.length - 1){
			return element < arr[index - 1];
		}
		return element < arr[index - 1] || element > arr[index + 1];
	}
	
	public static void main(String[] args)throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nSubarray Sort Problem : find the length/indices of shortest possible subarray which needs to be sorted in order to sort the entire array\n");
		System.out.print("Enter number of test cases : ");
		int t = sc.nextInt();
		while(t-->0){
			System.out.print("Enter size of array : ");
			int n = sc.nextInt();
			int[] arr = new int[n];
			System.out.print("Enter " + n + " space separated elements in the array : ");
			for(int i = 0; i < n; i++){
				arr[i] = sc.nextInt();
			}
			System.out.println();
			int[] indices = getSubarrayIndices(arr);
			System.out.println("We need to sort the subarray starting at index " + indices[0] + " and ending at index " + indices[1]);
			System.out.println("Length of the shortest possible subarray which we need to sort is : " + (indices[1] - indices[0] + 1));
		}
		sc.close();
	}
}