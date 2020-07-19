// Optimised naive approach for finding longest palindromic substring in the given text
// O(N^2) time and O(1) space
import java.util.*;

class LongestPalindromeSubstring {

    public static String getLongestPalindromicSubstring(String text){
        if(text.length() <= 1){
            return text;
        }
        int start = 0, n = text.length();
        int max = 1;
        int low, high;
        // Consider each character as center of palindrome
        for(int i = 1; i < n; i++){
            // for longest even length palindrome with center at (i - 1) and (i)
            low = i - 1;
            high = i;
            while(low >= 0 && high < n && (text.charAt(low) == text.charAt(high))){
                if(high - low + 1 > max){
                    start = low;
                    max = high - low + 1;
                }
                low--;
                high++;
            }
            // for longest odd length palindrome with center at (i)
            low = i - 1;
            high = i + 1;
            while(low >= 0 && high < n && (text.charAt(low) == text.charAt(high))){
                if(high - low + 1 > max){
                    start = low;
                    max = high - low + 1;
                }
                low--;
                high++;
            }
        }
        return text.substring(start, start + max);
    }

    public static void main(final String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        System.out.println("\nLongest Palindrome Substring Naive Approach\n");
        System.out.print("Enter your text : ");
        final String text = sc.nextLine();
        final String lps = getLongestPalindromicSubstring(text);
        System.out.println("Longest Palindromic Substring in " + text + " is " + lps);
        sc.close();
    }
}