// Finding longest palindromic substring after removing any substring from the given text

import java.util.*;

class LongestPalindromeSubstringAfterRemoval {

    public static String getReverse(String text){
        return new StringBuilder(text).reverse().toString();
        // char[] arr = text.toCharArray();
        // for(int i = 0, j = arr.length - 1; i < j; i++, j--){
        //     char ch = arr[i];
        //     arr[i] = arr[j];
        //     arr[j] = t;
        // }
        // return String.valueOf(arr);
    }

    public static String findKMPLongestPalindomePrefix(String text){
        String rev = getReverse(text);
        // & -> separator
        text = text + "&" + rev;
        int n = text.length();
        int[] lps = new int[n];
        lps[0] = 0;
        int i = 1, len = 0;
        // KMP Algorithm
        while(i < n){
            if(text.charAt(i) == text.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = lps[len - 1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return text.substring(0, lps[n - 1]);
    }

    public static String getLongestPalindromeSubstringAfterRemoval(String text){
        String A = "", B = "", F = "";
        int n = text.length();
        // pointer t starting of text
        int i = 0;
        // poitner to ending of text
        int j = text.length() - 1;
        // finding longest substrings from both ends which are reverse/mirror of each other
        while(i < j && text.charAt(i) == text.charAt(j)){
            i++;
            j--;
        }
        if(i > 0){
            A = text.substring(0, i);
            B = text.substring(n - i, n);
        }
        if(n > 2 * i){
            String C = text.substring(i, n - i);
            // finding longest palindrome prefix of C
            String D = findKMPLongestPalindomePrefix(C);
            // finding longest palindrome suffix of C
            String E = findKMPLongestPalindomePrefix(getReverse(C));
            // store maximum of D and E in F
            F = (D.length() > E.length()) ? D : E;
        }
        return A + F + B;
    }
    public static void main(final String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        System.out.println("\nLongest Palindrome Substring after removing any one substring.\n");
        System.out.print("Enter your text : ");
        final String text = sc.nextLine();
        final String lps = getLongestPalindromeSubstringAfterRemoval(text);
        System.out.println("Longest Palindromic Substring after removal of a substring in " + text + " is " + lps);
        sc.close();
    }
}