// Dynamic programming approach for finding longest palindromic substring in the given text
// O(N^2) time and O(N^2) space
import java.util.*;

class LongestPalindromeSubstringDP {

    public static String getLongestPalindromicSubstringDP(String text){
        if(text.length() <= 1){
            return text;
        }
        int start = 0, n = text.length();
        boolean[][] dp = new boolean[n][n];
        int max = 1;
        // All substrings of length 1 are palindrome
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        // Checking for substrings of length 2
        for(int i = 0; i < n - 1; i++){
            if(text.charAt(i) == text.charAt(i + 1)){
                dp[i][i + 1] = true;
                start = i;
                max = 2;
            }
        }
        // Checking for substrings of length k
        for(int k = 3; k <= n; k++){
            // starting index of substring
            for(int i = 0; i < n - k + 1; i++){
                // ending index of substring
                int j = i + k - 1;
                if(dp[i + 1][j - 1] && text.charAt(i) == text.charAt(j)){
                    dp[i][j] = true;
                    if(k > max){
                        max = k;
                        start = i;
                    }
                }

            }
        }
        return text.substring(start, start + max);
    }

    public static void main(final String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        System.out.println("\nLongest Palindrome Substring using Dynamic Programming Approach\n");
        System.out.print("Enter your text : ");
        final String text = sc.nextLine();
        final String lps = getLongestPalindromicSubstringDP(text);
        System.out.println("Longest Palindromic Substring in " + text + " is " + lps);
        sc.close();
    }
}