public class QuickSort extends SortMaster {

    public QuickSort(int[] targetArr) {
        super(targetArr);
    }

    public void sort() {
        int[] arr = super.getArr();
        
        this.quicksort(arr, 0, arr.length-1);
    }

    // returns correct position of pivot
    private int partition(int[] arr, int low, int high) {
        // choosing the pivot value

        // find median-of-three, median out of low, middle, and high
        int middle = (high + low) / 2;
        if(middle < low && low < high) {
            super.swap(low, high);  // make the low value the pivot
        }
        else if(low < middle && middle < high) {
            super.swap(middle, high);
        }
        // if high is the median, no swap is needed

        int pivotVal = arr[high];

        int i = low;    // correct position of pivot so far

        for(int j = low; j < high; j++) {
            if(arr[j] < pivotVal) {
                super.swap(i, j);
                i++;    // move marker up, becomes new position for pivot value
            }
        }
        super.swap(i, high);    // swap with high at the end to bring it in correct place
        return i;
    }

    // a hybrid of quick sort and insertion sort
    private void quicksort(int[] arr, int low, int high) {
        if(low < high) {
            if(high - low < 10) {
                insertionSort(arr, low, high);  // do insertion sort if less than 10 elements since it's faster
            }
            else {
                // partition elements based on pivot (swapping values to allow pivot to be in place)
                int pivotIndex = this.partition(arr, low, high);
                
                this.quicksort(arr, low, pivotIndex - 1);    // quick sort left side of pivot
                this.quicksort(arr, pivotIndex + 1, high);   // quick sort right side of pivot
            }
        }
    }

    private void insertionSort(int arr[], int low, int high) {
        for(int i = low+1; i <= high; i++) {
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
