public class SelectionSort extends SortMaster {

    public SelectionSort(int[] targetArr) {
        super(targetArr);
    }

    public void sort() {
        int[] arr = super.getArr();
        
        for(int i = 0; i < arr.length; i++) {
            int j;
            int minIndex = i;
            for(j = i+1; j < arr.length; j++) {
                // find min
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // swap min with current index
            super.swap(i, minIndex);
        }
    }

}
