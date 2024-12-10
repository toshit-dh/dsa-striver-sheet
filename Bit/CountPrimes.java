package Bit;

import java.util.Arrays;

public class CountPrimes {
    public static int countPrimes(int n) {
        int[] primes = new int[n];
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primes[i] == 0) {
                for (int j = i * i; j < n; j += i) {
                    primes[j] = 1;
                }
            }
        }
        System.out.println(Arrays.toString(primes));
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]==0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
