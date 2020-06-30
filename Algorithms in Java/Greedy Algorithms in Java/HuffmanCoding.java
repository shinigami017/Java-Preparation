import java.util.*;

// HuffmanNode class for the basic structure
// of each node present in the Huffman tree.
class HuffmanNode { 
    int data;
    char character;
    HuffmanNode left;
    HuffmanNode right;
}

// Comparator class helps to compare the nodes on the basis of one of its attribute.
// Here we will compare on the basis of data values of the HuffmanNodes.
class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y)
    {
        return x.data - y.data; 
    }
}

class HuffmanCoding {
    // recursive function to print the huffman-code through the tree traversal.
    public static void printCode(HuffmanNode root, String code)
    {
        // base case
        if (root.left == null && root.right == null && Character.isLetter(root.character)) {
            System.out.println(root.character + " : " + code);
            return;
        }
        // if we go to left then add "0" to the code and if we go to the right add "1" to the code
        printCode(root.left, code + "0");
        printCode(root.right, code + "1");
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // Dummy input
        // int n = 5;
        // char[] char_array = { 'a', 'b', 'c', 'd', 'e'};
        // int[] freq_array = { 5, 10, 30, 20, 15 };
        System.out.println("\nHuffman Coding problem using Greedy appoach\n");
        System.out.print("Enter number of characters : ");
        int n = sc.nextInt();
        sc.nextLine();
        char[] char_array = new char[n];
        int[] freq_array = new int[n];
        System.out.println("In next " + n + " lines, enter each character and its frequency separated by a single space (character frequency)");
        for(int i = 0; i < n; i++){
            String[] input = sc.nextLine().split(" ");
            char_array[i] = input[0].charAt(0);
            freq_array[i] = Integer.parseInt(input[1]);
        }
        // creating a priority queue for implementing min-heap
        PriorityQueue<HuffmanNode> min_heap = new PriorityQueue<HuffmanNode>(n, new MyComparator());
        for (int i = 0; i < n; i++) {
            // creating a Huffman node object and add it to the priority queue
            HuffmanNode hn = new HuffmanNode();
            hn.character = char_array[i];
            hn.data = freq_array[i];
            min_heap.add(hn);
        }
        HuffmanNode root = null;

        // Here we will extract the two minimum nodes from the heap each time 
        // until its size reduces to 1
        while (min_heap.size() > 1) {
            // first min extract
            HuffmanNode x = min_heap.poll();
            // second min extarct
            HuffmanNode y = min_heap.poll();
            
            // creating new node to store intermediate of above two
            HuffmanNode internal = new HuffmanNode();
            internal.data = x.data + y.data;
            internal.character = '-';

            // first extracted node as left child
            internal.left = x;
            // second extracted node as the right child
            internal.right = y;

            // marking the f node as the root node
            root = internal;
  
            // add this node to the priority-queue
            min_heap.add(internal);
        }
        // print the codes by traversing the tree
        printCode(root, "");
        sc.close();
    }
}