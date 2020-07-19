// Manachers's Algorithm for finding longest palindromic substring in the given text
// O(N) time and O(2*N) space
import java.util.*;

class ManachersLongestPalindromeSubstring {

    public static String generateString(String text){
        // using StringBuilder instead of String since it is faster as String traverses whole string before adding characters to it
        StringBuilder sb = new StringBuilder();
        // $ - start of string
        sb.append('$');
        sb.append('#');
        // # - in between characters of string
        for(char ch : text.toCharArray()){
            sb.append(ch);
            sb.append('#');
        }
        // @ - end of string
        sb.append('@');
        return sb.toString();
    }
    public static String getManachersLongestPalindromicSubstring(String text){
        if(text.length() <= 1){
            return text;
        }
        // including symbols in between original text for considering even length palindromes
        String str = generateString(text);
        char[] T = str.toCharArray();
        // P[] -> to store length of palindromes with each character as center 
        int[] P = new int[T.length]; 
        // C -> center of current palindrome
        // R -> right bound of current palindrome
        int C = 0, R = 0;
        // Consider each character as center of palindrome
        for(int i = 1; i < T.length - 1; i++){
            int mirror = 2 * C - i;
            if(i < R){
                P[i] = Math.min(R - i, P[mirror]);
            }
            while(T[i + (1 + P[i])] == T[i - (1 + P[i])]){
                P[i]++;
            }
            if(i + P[i] > R){
                C = i;
                R = i + P[i];
            }
        }
        // find length of longest palindrome from P[] and its index to obtain longest palindromic substring from generated string 
        int max = Integer.MIN_VALUE, index = -1;
        for(int i = 0; i < P.length; i++){
            if(max < P[i]){
                index = i;
                max = P[i];
            }
        }
        int start = (max % 2 == 0) ? (index - max + 1) : (index - max);
        int end = (max % 2 == 0) ? (index + max) : (index + max - 1);
        // remove symbols and generate longest palindromic substring of original text
        // using StringBuilder instead of String since it is faster as String traverses whole string before adding characters to it
        StringBuilder lps = new StringBuilder();
        for(int i = start; i <= end; i++){
            // we can use this but it will be better to check for our added symbols ourselves, then our code would be valid for symbols containing texts too.
            // if(Character.isLetter(T[i])){
            if(T[i] != '#' && T[i] != '$' && T[i] != '@'){
                lps.append(T[i]);
            }
        }
        return lps.toString();
    }

    // more elaborative algorithm for better understanding [Source : geeksforgeeks]
    public static String getManachersLongestPalindromicSubstring2(String text){
        if(text.length() <= 1){
            return text;
        }
        int N = text.length();
        N = 2 * N + 1; // Position count
        int[] L = new int[N + 1]; // LPS Length Array
        L[0] = 0;
        L[1] = 1;
        int C = 1; // centerPosition
        int R = 2; // centerRightPosition
        int i = 0; // currentRightPosition
        int iMirror; // currentLeftPosition
        int maxLPSLength = 0;
        int maxLPSCenterPosition = 0;
        int start = -1;
        int end = -1;
        int diff = -1;

        for (i = 2; i < N; i++){
            // get currentLeftPosition iMirror 
            // for currentRightPosition i
            iMirror = 2 * C - i;
            L[i] = 0;
            diff = R - i;

            // If currentRightPosition i is within 
            // centerRightPosition R
            if (diff > 0){
                L[i] = Math.min(L[iMirror], diff);
            }
            // Attempt to expand palindrome centered at currentRightPosition i. 
            // Here for odd positions, we compare characters and if match then increment LPS Length by ONE.
            // If even position, we just increment LPS by ONE without any character comparison
            while ( ( ((i + L[i]) + 1) < N && (i - L[i]) > 0) &&  (( (i + L[i] + 1) % 2 == 0) || (text.charAt((i + L[i] + 1) / 2) ==  text.charAt((i - L[i] - 1) / 2)) ) ){
                L[i]++;
            }
            // Track maxLPSLength
            if (L[i] > maxLPSLength){
                maxLPSLength = L[i];
                maxLPSCenterPosition = i;
            }

            // If palindrome centered at currentRightPosition i
            // expand beyond centerRightPosition R,
            // adjust centerPosition C based on expanded palindrome.
            if (i + L[i] > R){
                C = i;
                R = i + L[i];
            }
        }

        start = (maxLPSCenterPosition - maxLPSLength) / 2;
        end = start + maxLPSLength - 1;
        return text.substring(start, end + 1);
    }
    public static void main(final String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        System.out.println("\nLongest Palindrome Substring using Manacher's Algorithm\n");
        System.out.print("Enter your text : ");
        final String text = sc.nextLine();
        final String lps = getManachersLongestPalindromicSubstring(text);
        // final String lps = getManachersLongestPalindromicSubstring2(text);
        System.out.println("Longest Palindromic Substring in " + text + " is " + lps);
        sc.close();
    }
}