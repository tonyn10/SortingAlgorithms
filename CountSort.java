
public class CountSort extends SortMaster {

    // preconditions: nums is all positive, max is known and positive

    private final int max;

    public CountSort(int[] targetArr, int max) {
        super(targetArr);
        this.max = max;
    }

    @Override
    public void sort() {

        int[] nums = super.getArr();

        int[] counts = new int[max+1];
        for(int v : nums) {
            counts[v]++;
        }

        for(int i = 0, j = 0; i < counts.length; i++) {
            if(counts[i] != 0) {
                int k;
                for(k = 0; k < counts[i]; k++) {
                    // overwrites nums
                    nums[j+k] = i;
                }
                j += k;
            }
        }

    }
}
