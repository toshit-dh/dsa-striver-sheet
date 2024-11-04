package Array;

class PositiveNegative {
    public int[] rearrangeArray(int[] nums) {
        int posIdx = 0;
        int negIdx = 1;
        int m = nums.length;
        int[] result = new int[m];
        for (int i: nums) {
            if (i > 0) {
                result[posIdx] = i;
                posIdx += 2;
            } else {
                result[negIdx] = i;
                negIdx += 2;
            }
        }
        return result;
    }
}
