package Array;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        int longestStreak = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int streak = 1;
                while (set.contains(num + streak)) streak++;
                longestStreak = Math.max(longestStreak, streak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
