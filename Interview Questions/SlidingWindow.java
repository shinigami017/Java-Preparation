import java.util.*;

class SlidingWindow {
    public static int[] maxSlidingWindow(int[] array, int k) {
        int n = array.length;
        if(n <= 1) return array;
        Deque<Integer> dq = new LinkedList<>();
        int[] output = new int[n - k + 1];
        int i = 0;
        while(i < k){
            while(!dq.isEmpty() && array[dq.peekLast()] <= array[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            i++;
        }
        while(i < n){
            output[i - k] = array[dq.peekFirst()];
            while(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && array[dq.peekLast()] <= array[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            i++;
        }
        output[i - k] = array[dq.peekFirst()];
        return output;
    }
    public static void main(final String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        System.out.println("\nSliding Window Problem\n");
        System.out.print("Enter number of testcases : ");
        int T = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            System.out.print("Enter the number of elements : ");
            int N = sc.nextInt();
            int[] array = new int[N];
            System.out.print("Enter " + N + " space separated elements in array : ");
            for(int i = 0; i < N; i++){
                array[i] = sc.nextInt();
            }
            System.out.print("Enter size of sliding window : ");
            int k = sc.nextInt();
            System.out.println(N +" : " + k + " : " + array[0] + " : " + array[N-1] );
            int max[] = maxSlidingWindow(array, k);
            System.out.println();
            for (int i = 0; i < max.length; i++) {
                System.out.println("For " + (i + 1) + " slide, maximum : " + max[i]);                
            }
        }
        sc.close();
    }
}