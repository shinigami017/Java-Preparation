import java.io.IOException;
import java.util.*;

class FibonacciDP{

    // Regular recursive approach
    public static int fibonacci(int N){
        if(N < 2){
            return N;
        }
        return fibonacci(N - 2) + fibonacci(N - 1);
    }

    // Top-down approach with Memoization
    public static int fibonacciDP1(int N){
        int[] mem = new int[N + 1];
        return fibonacci(N, mem);
    }

    public static int fibonacci(int N, int[] mem){
        if(N < 2){
            return N;
        }
        if(mem[N] != 0){
            return mem[N];
        }
        mem[N] = fibonacci(N - 2, mem) + fibonacci(N - 1, mem);
        return mem[N];
    }

    // Bottom-up approach with Tabulation
    public static int fibonacciDP2(int N){
        int[] mem = new int[N + 1];
        mem[0] = 0;
        mem[1] = 1;
        for(int i = 2; i < N + 1; i++){
            mem[i] = mem[i - 2] + mem[i - 1];
        }
        return mem[N];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nFibonacci Problem using Dynamic Programming\n");
        System.out.print("Enter any number : ");
        int N = sc.nextInt();
        int fib = fibonacci(N);
        System.out.println("[ Regular recursive approach ] " + N + " element of fibonacci series is : " + fib);
        fib = fibonacciDP1(N);
        System.out.println("[ DP-Memoization approach ] " + N + " element of fibonacci series is : " + fib);
        fib = fibonacciDP2(N);
        System.out.println("[ DP-Tabulation approach ] " + N + " element of fibonacci series is : " + fib);
        sc.close();
    }
}