// We can create an alternative class Activity with all its parameters and sort the array of Activities according to their finish time
// But I have solved the problem in the simplest way for better understanding of the algorithm 

import java.util.*;

class ActivitySelection{

    public static int solveActivitySelection(int n, int[] start, int[] finish){
        List<Integer> activities = new ArrayList<>();
        int current_activity = getLowestFinishTimeActivity(finish);
        while(current_activity != -1){
            // Adding current activity to completed activities
            activities.add(current_activity + 1);
            int current_finish = finish[current_activity];
            // marking the finish time for this activity to 0 as we have completed the current activity
            finish[current_activity] = Integer.MAX_VALUE;
            int next_activity = getLowestFinishTimeActivity(finish);
            while(next_activity != -1 && start[next_activity] < current_finish){
                // we need to reject this activity as its start time is overlapping with our current_finish time
                finish[next_activity] = Integer.MAX_VALUE;
                next_activity = getLowestFinishTimeActivity(finish);
            }
            current_activity = next_activity;
        }
        // Generating all the jobs completed for maximum profit
        for(int activity : activities){
            System.out.println("Activity number " + activity + " should be completed");
        }
        return activities.size();
    }

    public static int getLowestFinishTimeActivity(int[] finish){
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < finish.length; i++){
            if(finish[i] < min){
                min = finish[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nActivity Selection Problem using Greedy approach\n");
        System.out.print("Enter number of activities : ");
        int n = sc.nextInt();
        sc.nextLine();
        int[] start = new int[n];
        int[] finish = new int[n];
        
        System.out.println("In next " + n + " lines, enter start and finish time of each activity separated by a single space (start finish)");
        for(int i = 0; i < n; i++){
            String[] input = sc.nextLine().split(" ");
            start[i] = Integer.parseInt(input[0]);
            finish[i] = Integer.parseInt(input[1]);
        }

        System.out.println();

        int count = solveActivitySelection(n, start, finish);
        System.out.println("\nMaximum " + count + " activities can be completed.\n");
        sc.close();
    }
}