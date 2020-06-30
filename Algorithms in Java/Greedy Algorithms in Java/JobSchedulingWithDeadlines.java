// We can create an alternative class Job with all its parameters and sort the array of Jobs according to their profit
// But I have solved the problem in the simplest way for better understanding of the algorithm 

import java.util.*;

class JobSchedulingWithDeadlines{

    public static int solveJobScheduling(int n, int[] deadlines, int[] profits, int time){
        TreeSet<Integer> slots = new TreeSet<>();
        List<Integer> jobs = new ArrayList<>();
        int max_profit = 0;
        // creating unit slots till n time
        for(int i = 1; i <= n; i++){
            slots.add(i);
        }
        int job = getHighestProfitJob(profits);
        while(job != -1){
            // getting the slot available for job within its deadline period 
            Integer slot = slots.floor(deadlines[job]);
            if(slot != null){
                // Adding current job's profit to max profit
                max_profit += profits[job];
                // Adding current job to alloted jobs
                jobs.add(job + 1);
                slots.remove(slot);
            }
            // marking the profit for this job to 0 as we have alloted the current job
            profits[job] = 0;
            job = getHighestProfitJob(profits);
        }
        // Generating all the jobs completed for maximum profit
        for(int j : jobs){
            System.out.println("Job number " + j + " should be completed");
        }
        return max_profit;
    }

    public static int getHighestProfitJob(int[] profits){
        int max = 0;
        int index = -1;
        for(int i = 0; i < profits.length; i++){
            if(profits[i] > max){
                max = profits[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nJob Scheduling with Deadlines Problem using Greedy approach\n");
        System.out.print("Enter number of jobs : ");
        int n = sc.nextInt();
        sc.nextLine();
        int[] deadlines = new int[n];
        int[] profits = new int[n];
        
        System.out.println("In next " + n + " lines, enter deadline and profit of each job separated by a single space (deadline profit)");
        for(int i = 0; i < n; i++){
            String[] input = sc.nextLine().split(" ");
            deadlines[i] = Integer.parseInt(input[0]);
            profits[i] = Integer.parseInt(input[1]);
        }

        System.out.print("Enter time for completing the jobs : ");
        int time = sc.nextInt();
        System.out.println();

        int max_profit = solveJobScheduling(n, deadlines, profits, time);
        System.out.println("\nMaximum possible profit : " + max_profit + "\n");
        sc.close();
    }
}