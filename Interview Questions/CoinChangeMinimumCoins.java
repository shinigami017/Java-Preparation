// Coin Change Problem - Obtain the minimum possible number of coins using which given amount can be made from given set of coins
// O(m*n) - time | O(n) - space, where m -> amount to be changed, n-> number of coins available
import java.util.*;
class CoinChangeMinimumCoins{

    // Dynamic programming bottom-up approach : O(m*n) - time | O(n) - space
    public static int getNumberOfCoins(int[] coins, int amount){
        // when amount is 0 or there are no coins then, only one solution is include no coin
        if(amount == 0 || coins.length < 1){
            return 0;
        }
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        // long[] dp = new long[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // Arrays.fill(dp, Long.MAX_VALUE);
        // for amount = 0, take 0 possible coins to change
        dp[0] = 0;
        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j < dp.length; j++){
                dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
            }
        }
        return dp[amount];
    }

    public static void main(String args[])throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nCoin Change Problem : Obtain the minimum possible number of coins using which given amount can be made from given set of coins\n");
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
            int ways = getNumberOfCoins(coins, M);
            System.out.println("There are " + ways + " minimum possible coins to change " + M + " using available coins.");
        }
        sc.close();
    }
}