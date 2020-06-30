// I have traced the objects that were included for maximum profit from Tabulation method only.

import java.util.*;

class Knapsack01{

    // Top-down approach with Memoization
    public static int knapsackDP1(int n, int[] weights, int[] profits, int capacity){
        int[][] mem = new int[n + 1][capacity + 1];
        for(int i = 0; i < mem.length; i++){
            for(int j = 0; j < mem[i].length; j++){
                mem[i][j] = -1;
            }
        }
        return solveKnapsack(n, profits, weights, capacity, mem, 0);
    }

    public static int solveKnapsack(int n, int[] profits, int[] weights, int capacity, int[][] mem, int current_index){
        if(capacity <= 0 || current_index >= n){
            return 0;
        }
        if(mem[current_index][capacity] != -1){
            return mem[current_index][capacity];
        }
        int profit1 = 0;
        // If current object's weight is less than capacity of knapsack, 
        // then profit1 is profit when we include current object 
        if(weights[current_index] <= capacity){
            profit1 = profits[current_index] + solveKnapsack(n, profits, weights, capacity - weights[current_index], mem, current_index + 1);
        }
        // Profit2 is profit when we don't include current object
        int profit2 = profits[current_index] + solveKnapsack(n, profits, weights, capacity, mem, current_index + 1);
        mem[current_index][capacity] = Math.max(profit1, profit2);
        return mem[current_index][capacity];
    }

    // Bottom-up approach with Tabulation
    public static int knapsackDP2(int n, int[] weights, int[] profits, int capacity){
        int[][] mem = new int[n + 1][capacity + 1];
        for(int i = 0; i < mem.length; i++){
            for(int j = 0; j < mem[i].length; j++){
                // Initializing 0 to 0th object row and 0 capacity column as our objects start from index 1
                if(i == 0 || j == 0){
                    mem[i][j] = 0;
                }
                else if(weights[i] <= j){
                    // Main formula we derived for dyanmic approach
                    mem[i][j] = Math.max(profits[i] + mem[i - 1][j - weights[i]], mem[i - 1][j]);
                }
                else{
                    mem[i][j] = mem[i - 1][j];
                }
            }
        }
        // Generate objects which were included in maximum profit
        List<Integer> objects = getObjects(mem, weights);
        for(int object : objects){
            System.out.println("Object number " + object + " is taken");
        }
        return mem[n][capacity];        
    }

    // Method to trace all objects which were included in maximum profit
    public static List<Integer> getObjects(int[][] mem, int[] weights){
        List<Integer> objects = new ArrayList<Integer>();
        int i = mem.length - 1, j = mem[0].length - 1;
        while(i > 0 && j > 0){
            if(mem[i][j] == mem[i - 1][j]){
                i--;
            }else{
                objects.add(i);
                i--;
                j -= weights[i]; 
            }
        }
        return objects;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n0/1 Knapsack Problem using Dynamic Programming\n");
        System.out.print("Enter number of objects : ");
        int n = sc.nextInt();
        sc.nextLine();
        int[] weights = new int[n + 1];
        weights[0] = 0;
        int[] profits = new int[n + 1];
        profits[0] = 0;
        
        System.out.println("In next " + n + " lines, enter weight and profit of each object separated by a single space (weight profit)");
        for(int i = 0; i < n; i++){
            String[] input = sc.nextLine().split(" ");
            weights[i + 1] = Integer.parseInt(input[0]);
            profits[i + 1] = Integer.parseInt(input[1]);
        }
        System.out.print("Enter capacity of knapsack : ");
        int capacity = sc.nextInt();
        int max_profit = knapsackDP1(n, weights, profits, capacity);
        System.out.println("\n[DP-Memoizaton approach] Maximum possible profit : " + max_profit + "\n");
        max_profit = knapsackDP2(n, weights, profits, capacity);
        System.out.println("[DP-Tabulation approach] Maximum possible profit : " + max_profit + "\n");
        sc.close();
    }
}