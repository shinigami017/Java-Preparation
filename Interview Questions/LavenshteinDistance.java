// Lavneshtein Distance Problem : find minimum number of changes required to make the two given strings identical
// O(3^M) - time | O(1) - space
import java.util.*;
class LavenshteinDistance
{	
    // O(3^M) - time | O(1) - space
    public static int getLavneshteinDistance(String a, String b, int m, int n){
        if(m == 0){
            return n;
        }
        if(n == 0){
            return m;
        }
        if(a.charAt(m - 1) == b.charAt(n - 1)){
            return getLavneshteinDistance(a, b, m - 1, n - 1);
        }
        // getLavneshteinDistance(a, b, m, n - 1) : insert
        // getLavneshteinDistance(a, b, m - 1, n) : remove
        // getLavneshteinDistance(a, b, m - 1, n - 1) : replace
        return 1 + Math.min(Math.min(getLavneshteinDistance(a, b, m, n - 1), getLavneshteinDistance(a, b, m - 1, n)), getLavneshteinDistance(a, b, m - 1, n - 1));
    }

    public static void main(String[] args)throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nLavneshtein Distance Problem : find minimum number of changes required to make the two given strings identical\n");
		System.out.print("Enter number of test cases : ");
		int t = sc.nextInt();
		while(t-->0){
			System.out.print("Enter 2 space separated words in the array : ");
            String a = sc.next();
            String b = sc.next();
            System.out.println();
            int changes = getLavneshteinDistance(a, b, a.length(), b.length());
            System.out.print("Lavenshtein Distance : Minimum number of changes required to make " + a + " and " + b + " identical is : " + changes);
        }
		sc.close();
	}
}