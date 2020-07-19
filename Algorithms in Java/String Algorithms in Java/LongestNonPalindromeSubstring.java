// Finding longest non palindromic substring in the given text
// O(N) time and O(1) space
import java.util.*;

class LongestNonPalindromeSubstring {

    public static boolean isPalindrome(String text){
        for(int i = 0; i < text.length() / 2; i++){
            if(text.charAt(i) != text.charAt(text.length() - i - 1)){
                return false;
            }
        }
        return true;
    }

    public static String getLongestNonPalindromicSubstring(String text){
        // text of length 1 is always a palindrome
        if(text.length() <= 1){
            return "";
        }
        int n = text.length();
        // checking whether all characters are same or not
        int i;
        for(i = 1; i < n; i++){
            if(text.charAt(0) != text.charAt(i)){
                break;
            }
        }
        // since all characters are same so no non-palindromic substring is possible
        if(i == n){
            return "";
        }
        // if original string is palindrome, we can make it non-palindrome by removing any of first or last character
        if(isPalindrome(text)){
            return text.substring(0, n - 1);
            // return text.substring(1);
        }
        return text;
    }
    public static void main(final String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        System.out.println("\nLongest Non-Palindrome Substring\n");
        System.out.print("Enter your text : ");
        final String text = sc.nextLine();
        final String lps = getLongestNonPalindromicSubstring(text);
        System.out.println("Longest Non Palindromic Substring in " + text + " is " + lps);
        sc.close();
    }
}