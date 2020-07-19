// Optimised naive approach for matching given pattern in the given text
/*
 This approach works well for non-overlapping patterns
 that is, text : AABABAABAB, pattern : AABAB, here if pattern is matched in text once then if it exists again then it will be after the first occurence of pattern 
*/
/*
 But not for overlapping patterns
 that is, text : ABABABAB, pattern : ABAB, here if pattern is matched in text once then if it exists again then it may start from in-between of previously matched pattern
*/
import java.util.*;

class StringMatching {

    public static List<Integer> getStringMatchPositions(String text, String pattern){
        List<Integer> positions = new ArrayList<>();
        int t = text.length(), p = pattern.length();
        int i = 0;
        while(i <= (t - p)){
            int j;
            // for current index i, check for pattern match
            for(j = 0; j < p; j++){
                if(text.charAt(i + j) != pattern.charAt(j)){
                    break;
                }
            }
            if(j == p){
                positions.add(i);
                i += p;
            } else if(j == 0){
                i +=1;
            } else{
                i += j;
            }
        }
        return positions;
    }

    public static void main(final String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        System.out.println("\nString Matching Naive Approach\n");
        System.out.print("Enter your text : ");
        final String text = sc.nextLine();
        System.out.print("Enter your pattern : ");
        final String pattern = sc.nextLine();
        final List<Integer> positions = getStringMatchPositions(text, pattern);
        System.out.println("[Pattern : " + pattern + "] is found " + positions.size() + " times in [Text : " + text + "]");
        for (int position : positions) {
            System.out.println("[Pattern : " + pattern + "] matched at " + (position + 1) + " position in [Text : " + text + "]");
        }
        sc.close();
    }
}