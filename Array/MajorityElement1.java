package Array;

public class MajorityElement1 {
    public static int majorityElement(int nums[]){
        int current = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                current = num;
                count = 1;
            } else if (current == num) {
                count++;
            } else {
                count--;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1,1,1,2,3,4}));
    }
}
