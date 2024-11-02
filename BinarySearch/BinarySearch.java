public class BinarySearch {
    public static int search(int[] nums, int target) {
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
                break;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        System.out.println(search(new int[]{5},5));
    }
}
