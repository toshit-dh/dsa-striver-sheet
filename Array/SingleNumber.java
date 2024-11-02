package Array;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int m = nums.length;
        int result = 0;
        for (int i : nums){
            result ^= i;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1}));
    }
}
