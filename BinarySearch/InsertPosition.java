public class InsertPosition {
    public static int searchInsert(int[] nums, int target) {
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
        if(index != -1){
            return index;
        }else {
            return i;
        }
    }
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6},7));
    }
}