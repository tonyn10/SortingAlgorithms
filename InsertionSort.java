public class InsertionSort extends SortMaster {

    public InsertionSort(int[] targetArr) {
        super(targetArr);
    }

    public void sort() {
        int[] arr = super.getArr();
        
        for(int i = 1; i < arr.length; i++) {
            int target = arr[i];
            // moving and inserting it in right place
            int j = i;
            while(j > 0 && (target < arr[j-1]) ) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = target;
        }
    }

}
