import java.util.*;

class PrimeSieveOfEratosthenes {

    // Sieve of Eratosthenes - O(n*loglogn) time | O(n) space
    public static List<Integer> generatePrimeSieve1(final int N) {
        List<Integer> prime_sieve = new ArrayList<>();
        if (N < 1) {
            return prime_sieve;
        }
        boolean[] visited = new boolean[N + 1];
        visited[0] = true;
        visited[1] = true;
        for(int p = 2; p <= N; p++){
            if(!visited[p]){
                for (int i = p * p; i <= N; i += p) {
                    visited[i] = true;
                }
            }
        }
        for(int i = 2; i <= N; i++){
            if(!visited[i]){
                prime_sieve.add(i);
            }
        }
        return prime_sieve;
    }

    // Segmented Sieve - O(n*loglogn) time | O(sqrt(n)) space
    public static void printSegmentedSieve(final int N) {
        if (N < 1) {
            return;
        }
        int limit = (int)Math.floor(Math.sqrt(N) + 1);
        List<Integer> primes = generatePrimeSieve2(limit);
        for (int prime : primes) {
            System.out.print(prime + " ");
        }
        int low = limit, high = 2 * limit;
        while(low < N){
            if(high >= N){
                high = N;
            }
            boolean[] mark = new boolean[limit + 1];
            Arrays.fill(mark, true);
            for(int i = 0; i < primes.size(); i++){
                int lowLim = (int)Math.floor(low / primes.get(i)) * primes.get(i);
                if(lowLim < low){
                    lowLim += primes.get(i);
                }
                for(int j = lowLim; j < high; j += primes.get(i)){
                    mark[j - low] = false;
                }
            }
            for(int i = low; i < high; i++){
                if(mark[i - low]){
                    System.out.print(i + " ");
                }
            }
            low += limit;
            high += limit;
        }
        System.out.println();
    }
    
    // modified sieve - effective than O(n*loglogn) time
    public static List<Integer> generatePrimeSieve2(final int N) {
        List<Integer> prime_sieve = new ArrayList<>();
        if (N < 1) {
            return prime_sieve;
        }
        boolean[] visited = new boolean[N + 1];
        final double sqrt = Math.sqrt(N);
        prime_sieve.add(2);
        int i;
        for (i = 2; i <= N; i += 2) {
            visited[i] = true;
        }
        for (i = 3; i <= sqrt; i++) {
            if (!visited[i]) {
                for (int j = i * i; j <= N; j += (i * 2)) {
                    visited[j] = true;
                }
            }
        }
        for (i = 2; i <= N; i++) {
            if (!visited[i]) {
                prime_sieve.add(i);
            }
        }
        return prime_sieve;
    }

    public static void main(final String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        System.out.println("\nPrime Sieve\n");
        System.out.print("Enter any number : ");
        final int N = sc.nextInt();
        System.out.println("----------------------------------");
        System.out.print("Segmented Sieve : ");
        printSegmentedSieve(N);
        System.out.println("----------------------------------");
        List<Integer> prime_sieve = generatePrimeSieve1(N);
        System.out.print("Prime Sieve of Eratosthenes for " + N + " (all prime numbers less than " + N + ") : ");
        for (int prime : prime_sieve) {
            System.out.print(prime + " ");
        }
        System.out.println("\n----------------------------------");
        prime_sieve = generatePrimeSieve2(N);
        System.out.print("Modified Prime Sieve of Eratosthenes for " + N + " (all prime numbers less than " + N + ") : ");
        for (int prime : prime_sieve) {
            System.out.print(prime + " ");
        }
        sc.close();
    }
}