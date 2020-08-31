// Largest Range Problem :- To find the largest range of numbers whose all elements are present in array
// O(N) - time | O(N) - space

import java.util.*;
class LargestRange
{
	// O(N) - time | O(N) - space
	public static int[] getLargestRange(int[] arr){
		int[] output = new int[2];
		Map<Integer, Boolean> map = new HashMap<>();
		for(int a : arr){
			map.put(a, false);
		}
		int longest = 0;
		for(int i = 0; i < map.size(); i++){
			if(map.get(arr[i])){
				continue;
			}
			map.put(arr[i], true);
			int left = arr[i] - 1, right = arr[i] + 1;
			while(map.containsKey(left)){
				map.put(left, true);
				left--;
			}
			while(map.containsKey(right)){
				map.put(right, true);
				right++;
			}
			left += 1;
			right -= 1;
			if(right - left + 1 > longest){
				longest = right - left + 1;
				output[0] = left;
				output[1] = right;
			}
		}
		return output;
	}
    
    public static void main(String[] args)throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nLargest Range Problem :- To find the largest range of numbers whose all elements are present in array\n");
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
            int[] range = getLargestRange(arr);
            System.out.println("Given array contains all the numbers that lying in the range [" + range[0] + ", " + range[1] + "]");
        }
		sc.close();
	}
}