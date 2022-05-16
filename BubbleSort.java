public class BubbleSort extends SortMaster {

    public BubbleSort(int[] targetArr) {
        super(targetArr);
    }

    // optimized bubble sort where if no sort occurs in inner loop, stop whole algorithm
    public void sort() {
        // think sorting in reverse order, bringing the largest values to the right
        int[] arr = super.getArr();
        
        for(int wall = arr.length; wall > 1; wall--) {
            // moves wall in at the end of each iteration since the last value is in correct place
            boolean swapped = false;
            for(int i = 0; i < wall-1; i++) {
                if(arr[i] > arr[i+1]) {
                    super.swap(i, i+1);
                    swapped = true;
                }
            }

            if(!swapped) {
                break;
            }
        }
    }

}
