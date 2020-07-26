// Coin Change Problem - Obtain the maximum possible number of ways in which given amount can be made from given set of coins
// O(m*n) - time | O(n) - space, where m -> amount to be changed, n-> number of coins available
import java.util.*;
class CoinChangeWays{

    // Dynamic programming bottom-up approach : O(m*n) - time | O(n) - space
    public static int getNumberOfWays(int[] coins, int amount){
        // only one solution, i.e. to include no coin
        if(amount == 0){
            return 1;
        }
        // no solution as there are no coins
        if(coins.length < 1){
            return 0;
        }
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        // long[] dp = new long[amount + 1];
        Arrays.fill(dp, 0);
        // for amount = 0, take 1 possible way to change, i.e no coin
        dp[0] = 1;
        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j < dp.length; j++){
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String args[])throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nCoin Change Problem : Obtain the maximum possible number of ways in which given amount can be made from given set of coins\n");
        System.out.print("Enter number of testcases : ");
        int T = sc.nextInt();
        while(T-->0){
            System.out.print("Enter number of coins available : ");
            int N = sc.nextInt();
            int[] coins = new int[N];
            System.out.print("Enter " + N + " space separated coins values : ");
            for(int i = 0; i < N; i++){
                coins[i] = sc.nextInt();
            }
            System.out.print("Enter amount to be changed using coins : ");
            int M = sc.nextInt();
            System.out.println();
            int ways = getNumberOfWays(coins, M);
            System.out.println("There are " + ways + " maximum possible ways to change " + M + " using available coins.");
        }
        sc.close();
    }
}