// KMP (Knuth Morris Pratt) Algorithm for matching given pattern in the given text
// In linear time complexity O(n) 

import java.util.*;

class KMPStringMatching {

    // method to compute Longest Proper Prefix/Suffix
    public static int[] computeLPSArray(String pattern){
        int[] lps = new int[pattern.length()];
        int index = 0;
        for(int i = 1; i < pattern.length();){
            if(pattern.charAt(i) == pattern.charAt(index)){
                lps[i] = index + 1;
                index++;
                i++;
            }else{
                if(index != 0){
                    index = lps[index - 1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static List<Integer> getStringMatchPositionsKMP(String text, String pattern){
        List<Integer> positions = new ArrayList<>();
        int t = text.length(), p = pattern.length();
        int[] lps = computeLPSArray(pattern);
        int i = 0, j = 0;
        while(i < t){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            if(j == p){
                positions.add(i - j);
                j = lps[j - 1];
            }else if(i < t && text.charAt(i) != pattern.charAt(j)){
                if(j != 0){
                    j = lps[j - 1];
                }else{
                    i++;
                }
            }
        }
        return positions;
    }

    public static void main(final String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        System.out.println("\nString Matching using KMP Algorithm (Knuth-Morris-Pratt Algorithm)\n");
        System.out.print("Enter your text : ");
        final String text = sc.nextLine();
        System.out.print("Enter your pattern : ");
        final String pattern = sc.nextLine();
        final List<Integer> positions = getStringMatchPositionsKMP(text, pattern);
        System.out.println("[Pattern : " + pattern + "] is found " + positions.size() + " times in [Text : " + text + "]");
        for (int position : positions) {
            System.out.println("[Pattern : " + pattern + "] matched at " + (position + 1) + " position in [Text : " + text + "]");
        }
        sc.close();
    }
}