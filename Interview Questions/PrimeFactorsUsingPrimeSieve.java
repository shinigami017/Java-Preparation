import java.util.*;

class PrimeFactorsUsingPrimeSieve {

    // Sieve of Eratosthenes for Smallest Prime Factor - O(n*loglogn) time | O(n) space
    public static List<Integer> generateSPF(final int N) {
        List<Integer> spf = new ArrayList<>();
        if (N < 1) {
            return spf;
        }
        spf.add(0, 0);
        spf.add(1, 1);
        for(int i = 2; i <= N; i++){
            if(i % 2 == 0){
                spf.add(i, 2);
            }else{
                spf.add(i, i);
            }
        }
        for(int i = 3; i*i <= N; i++){
            if(spf.get(i) == i){
                for(int j = i * i; j <= N; j += i){
                    if(spf.get(j) == j){
                        spf.set(j, i);
                    }
                }
            }
        }
        return spf;
    }

    public static List<Integer> getPrimeFactors(int N, List<Integer> spf){
        List<Integer> prime_factors = new ArrayList<>();
        while(N != 1){
            prime_factors.add(spf.get(N));
            N /= spf.get(N);
        }
        return prime_factors;
    }

    public static void main(final String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        System.out.println("\nPrime Factorization using Prime Sieve\n");
        System.out.print("Enter any number : ");
        final int N = sc.nextInt();
        List<Integer> spf = generateSPF(N);
        List<Integer> prime_factors = getPrimeFactors(N, spf);
        System.out.print("Prime Factors of " + N + " : ");
        for (int factor : prime_factors) {
            System.out.print(factor + " ");
        }
        sc.close();
    }
}