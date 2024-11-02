package Array;

import java.util.function.BiFunction;

/**
 * Array.MaxSumOfSubArray
 */
public class MaxSumOfSubArray {
    public static void main(String[] args) {
        int[] array = new int[]{22,11,-18,55,1,-32,12};
        System.out.println(timeRequired(naive, 3, array));
        System.out.println(timeRequired(slidingWindow, 3, array));
    }
    static BiFunction<Integer,int[],Integer> slidingWindow = (k,array) -> {
        int mSum = Integer.MIN_VALUE;
        int wSum = 0;
        for (int i = 0; i < k; i++) {
            wSum += array[i];
        }
        for(int i = k;i < array.length; i++){
            wSum += array[i] - array[i-k];
            mSum = Integer.max(wSum,mSum);
        }
        return mSum;
    };
    static BiFunction<Integer,int[],Integer> naive = (k,array) -> {
        int mSum = Integer.MIN_VALUE;
        for(int i = 0;i < array.length - 3;i++){
            int cSum = 0;
            for (int j = i; j < i+k; j++) {
                cSum += array[j];
            }
            mSum = Integer.max(mSum, cSum);
        }
        return mSum;
    };
    public static double timeRequired(BiFunction<Integer,int[],Integer> biFunction,int k,int[] array){
        long start = System.nanoTime();
        biFunction.apply(k,array);
        long end = System.nanoTime();
        long inNano = end - start;
        return (double) inNano / 1_000_000;
    }
}