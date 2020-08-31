// GroupOfAnagrams Problem : find all sets of words that belong to common anagram from a list of words
// O(W*N*logN) - time | O(W*N) - space
import java.util.*;
class GroupOfAnagrams
{
	public static List<List<String>> getWordsSortedByTheirAnagrams(String[] words){
        Map<String, List<String>> anagrams = new HashMap<>();
        for(String word : words){
            // sorting current word
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String current = String.valueOf(arr);
            if(anagrams.containsKey(current)){
                List<String> w = anagrams.get(current);
                w.add(word);
                anagrams.put(current, w);
            }else{
                List<String> w = new ArrayList<>();
                w.add(word);
                anagrams.put(current, w);
            }
        }
        return new ArrayList(anagrams.values());
    }
	public static void main(String[] args)throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nGroupOfAnagrams Problem : find all sets of words that belong to common anagram from a list of words\n");
		System.out.print("Enter number of test cases : ");
		int t = sc.nextInt();
		while(t-->0){
			System.out.print("Enter size of array : ");
            int n = sc.nextInt();
            sc.nextLine();
			System.out.print("Enter " + n + " space separated words in the array : ");
            String[] arr = sc.nextLine().split(" ");
            System.out.println();
            List<List<String>> words = getWordsSortedByTheirAnagrams(arr);
            System.out.print("Words sorted by their anagrams : "+words);
        }
		sc.close();
	}
}