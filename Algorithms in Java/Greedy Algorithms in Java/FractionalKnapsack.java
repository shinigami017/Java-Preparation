// We can create an alternative class Item with all its parameters and sort the array of Items according to their ratio
// But I have solved the problem in the simplest way for better understanding of the algorithm 

import java.util.*;

class FractionalKnapsack{

    public static double solveKnapsack(int n, int[] weights, int[] profits, double[] ratio, int capacity){
        int current_weight = 0;
        double current_profit = 0;
        List<Integer> objects = new ArrayList<>();
        while(current_weight < capacity){
            int object = getHighestRatioObject(ratio);
            if(object != -1){
                objects.add(object + 1);
                if(current_weight + weights[object] <= capacity){
                    current_weight += weights[object];
                    current_profit += profits[object];
                    // marking the ratio of current object to 0 as we have used the current object
                    ratio[object] = 0; 
                } else {
                    current_profit += (ratio[object] * (capacity - current_weight));
                    current_weight += (capacity - current_weight);
                    // Knapsack is full, i.e current weight = capacity
                    break;
                }
            }
            // No items left to include
            else{
                break;
            }
        }
        // Generating all the objects included for maximum profit
        for(int object : objects){
            System.out.println("Object number " + object + " is taken");
        }
        return current_profit;
    }

    public static int getHighestRatioObject(double[] ratio){
        double max = 0;
        int index = -1;
        for(int i = 0; i < ratio.length; i++){
            if(ratio[i] > max){
                max = ratio[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nFractional Knapsack Problem using Greedy approach\n");
        System.out.print("Enter number of objects : ");
        int n = sc.nextInt();
        sc.nextLine();
        int[] weights = new int[n];
        int[] profits = new int[n];
        double[] ratio = new double[n];
        
        System.out.println("In next " + n + " lines, enter weight and profit of each object separated by a single space (weight profit)");
        for(int i = 0; i < n; i++){
            String[] input = sc.nextLine().split(" ");
            weights[i] = Integer.parseInt(input[0]);
            profits[i] = Integer.parseInt(input[1]);
            ratio[i] = profits[i] / weights[i];
        }

        System.out.print("Enter capacity of knapsack : ");
        int capacity = sc.nextInt();
        System.out.println();

        double max_profit = solveKnapsack(n, weights, profits, ratio, capacity);
        System.out.println("\nMaximum possible profit : " + max_profit + "\n");
        sc.close();
    }
}