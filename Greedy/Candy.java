package Greedy;

public class Candy {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int i = 1;
        int count = 1;
        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                count++;
                i++;
                continue;
            }
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                count+=peak;
                i++;
            }
            int down = 1;
            while (i < n && ratings[i] < ratings[i - 1]) {
                down++;
                count+=down;
                i++;
            }
            if (down > peak) count += down - peak -1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(candy(
                new int[]{1,3,2,2,1}
        ));
    }
}
