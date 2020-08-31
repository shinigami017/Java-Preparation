// Minimum Rewards Problem :- In this probem, we are given the grades of N students and we need to output the minimum rewards that can be given to the students
// We need to distribute the rewards among the students based on the following condition,
// For two adjacent students, one with higher grades will have more rewards than the one with lesser grades, given that no two students have same grades
// 
// Best : O(N) - time | O(N) - space

import java.util.*;
class MinimumRewards
{
	// O(N^2) - time | O(N) - space : Naive Solution
	public static int[] getMinimumRewards1(int[] grades){
		int[] rewards = new int[grades.length];
		Arrays.fill(rewards, 1);
		for(int i = 1; i < grades.length; i++){
			int j = i-1;
			if(grades[i] > grades[j]){
				rewards[i] = rewards[j] + 1;
			}
			else{
				// backtrack and fix all rewards
				while(j >= 0 && grades[j] > grades[j + 1]){
					rewards[j] = Math.max(rewards[j], rewards[j + 1] + 1);
					j--;
				}
			}
		}
		System.out.println("Minimum Rewards to be distributed : " + Arrays.stream(rewards).sum());
		return rewards;
	}
	
	// O(N) - time | O(N) - space : Better Solution
	public static int[] getMinimumRewards2(int[] grades){
		int[] rewards = new int[grades.length];
		Arrays.fill(rewards, 1);
		List<Integer> indices = getLocalMinimaIndices(grades);
		for(int index : indices){
			expandFromLocalMinimaIndex(index, grades, rewards);
		}
		System.out.println("Minimum Rewards to be distributed : " + Arrays.stream(rewards).sum());
		return rewards;
	}
	
	public static List<Integer> getLocalMinimaIndices(int[] arr){
		List<Integer> indices = new ArrayList<>();
		if(arr == null){
			return indices;
		}
		if(arr.length == 1){
			indices.add(0);
			return indices;
		}
		for(int i = 0; i < arr.length; i++){
			if(i == 0 && arr[i] < arr[i + 1]){
				indices.add(i);
			}
			if(i == arr.length - 1 && arr[i] < arr[i - 1]){
				indices.add(i);
			}
			if(i == 0 || i == arr.length - 1){
				continue;
			}
			if(arr[i] < arr[i - 1] && arr[i] < arr[i + 1]){
				indices.add(i);
			}
		}
		return indices;
	}
	
	public static void expandFromLocalMinimaIndex(int index, int[] grades, int[] rewards){
		// traverse left of the local minima
		int left = index - 1;
		while(left >= 0 && grades[left] > grades[left + 1]){
			rewards[left] = Math.max(rewards[left], rewards[left + 1] + 1);
			left--;
		}
		// traverse right of the local minima
		int right = index + 1;
		while(right < grades.length && grades[right] > grades[right - 1]){
			rewards[right] = rewards[right - 1] + 1;
			right++;
		}
	}
	
	// O(N) - time | O(N) - space : Best Solution(Simpler)
	public static int[] getMinimumRewards3(int[] grades){
		int[] rewards = new int[grades.length];
		Arrays.fill(rewards, 1);
		// first traversal from left to right
		for(int i = 1; i < grades.length; i++){
			if(grades[i] > grades[i - 1]){
				rewards[i] = rewards[i - 1] + 1;
			}
		}
		// second traversal from right to left
		for(int i = grades.length - 2; i >= 0; i--){
			if(grades[i] > grades[i + 1]){
				rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
			}
		}
		System.out.println("Minimum Rewards to be distributed : " + Arrays.stream(rewards).sum());
		return rewards;
	}
    
    public static void printArray(int[] arr){
        System.out.print("[ ");
        for(int a : arr){
            System.out.print(a + " ");
        }
        System.out.print("]");
    }

	public static void main(String[] args)throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nMinimum Rewards Problem :- In this probem, we are given the grades of N students and we need to output the minimum rewards that can be given to the students\n");
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
            int[] rewards = getMinimumRewards1(arr);
            // int[] rewards = getMinimumRewards2(arr);
			// int[] rewards = getMinimumRewards3(arr);
            System.out.print("Rewards dstributed among the students : ");
			printArray(rewards);
        }
		sc.close();
	}
}