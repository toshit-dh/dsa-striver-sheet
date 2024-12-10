package Greedy;

public class Jump2 {
    public static int jump(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0, jump = 0;
        while (r < n - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            jump++;
        }
        return jump;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }
}
