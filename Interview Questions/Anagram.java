import java.util.*;

class Anagram {
    // O(n) complexity approach
    public static boolean areAnagram(String A, String B){
        int[] frequency = new int[256];
        for(char ch : A.toCharArray()){
            frequency[(int)ch]++;
        }
        for(char ch : B.toCharArray()){
            frequency[(int)ch]--;
        }
        for(int freq : frequency){
            if(freq != 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("!!----CASE SENSITIVE ANAGRAM CHECK----!!");
        System.out.println("Enter number of testcases : ");
        int T = sc.nextInt();
        sc.nextLine();
        while(T-->0){
            System.out.println("Enter first string : ");
            String A = sc.nextLine();
            System.out.println("Enter second string : ");
            String B = sc.nextLine();
            System.out.println((areAnagram(A,B)) ? "ANAGRAM" : "NOT ANAGRAM");
        }
        sc.close();
    }
}