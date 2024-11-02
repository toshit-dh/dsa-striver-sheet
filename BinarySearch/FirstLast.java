import java.util.Arrays;

public class FirstLast {
    public static int[] searchRange(int[] nums, int target) {
        int[] array = new int[]{-1,-1};
        array[0] = firstOccurnce(nums, target);
        array[1] = lastOccurnce(nums, target);
        return array;
    }
    public static int firstOccurnce(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int index = -1;
        while (i <= j){
            int mid = (i+j)/2;
            if(nums[mid] < target){
                i = mid + 1;
            }else if(nums[mid] > target){
                j = mid - 1;
            }else {
                index = mid;
                j = mid -1;
            }
        }
        return index;
    }
    public static int lastOccurnce(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int index = -1;
        while (i <= j){
            int mid = (i+j)/2;
            if(nums[mid] < target){
                i = mid + 1;
            }else if(nums[mid] > target){
                j = mid - 1;
            }else {
                index = mid;
                i = mid + 1;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10},9)));
    }
}
