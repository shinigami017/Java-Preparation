import java.util.*;

class LongestCommonSubsequence{
    // Regular Recursive Approach
    public static int lcs(char[] a, char[] b){
        return lcsRecursive(a, b, a.length, b.length);
    }
    public static int lcsRecursive(char[] a, char[] b, int x, int y){
        if(x == 0 || y == 0){
            return 0;
        }
        if(a[x - 1] == b[y - 1]){
            return 1 + lcsRecursive(a, b, x - 1, y - 1);
        }
        return Math.max(lcsRecursive(a, b, x - 1, y), lcsRecursive(a, b, x, y - 1));
    }
    // Dyanmic Programming using bottom up approch
    public static String lcsDP(char[] a, char[] b){
        int m = a.length;
        int n = b.length;
        // Taking extra 0th row and column for simplicity of program
        int[][] LCS = new int[m + 1][n + 1];
        for(int i = 0; i < LCS.length; i++){
            for(int j = 0; j < LCS[i].length; j++){
                if( i == 0 || j == 0 ){
                    LCS[i][j] = 0;
                }
                else if(a[i - 1] == b[j - 1]){
                    LCS[i][j] = 1 + LCS[i - 1][j - 1];
                }
                else{
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }
            }
        }
        String lcs = getLCS(a, b, LCS);
        return lcs;
    }
    public static String getLCS(char[] a, char[] b, int[][] LCS){
        int i = LCS.length - 1;
        int j = LCS[i].length - 1;
        StringBuilder lcs = new StringBuilder();
        while(i > 0 && j > 0){
            if(a[i - 1] == b[j - 1]){
                lcs.append(a[i - 1]);
                i--;
                j--;
            }
            // if characters are not same then check for left and top element in LCS[][]
            // if left element in LCS[][] is greater than go left
            else if(LCS[i - 1][j] > LCS[i][j - 1]){
                i--;
            }
            // if top element in LCS[][] is greater than go up
            else{
                j--;
            }
        }
        return lcs.reverse().toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nLongest Common Subsequence Problem using Dynamic Programming\n");
        System.out.print("Enter two space separated strings : ");
        String[] input = sc.nextLine().split(" ");
        char[] a = input[0].toCharArray();
        char[] b = input[1].toCharArray();
        System.out.println();
        int length = lcs(a, b);
        System.out.println("[Normal Recursive approach] Length of Longest Common Subsequence : " + length);
        String lcs = lcsDP(a, b);
        length = lcs.length();
        System.out.println("[DP approach] Length of Longest Common Subsequence : " + length);
        System.out.println("Longest Common Subsequence : " + lcs);
        sc.close();
    } 
}