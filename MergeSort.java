
public class MergeSort extends SortMaster {

    public MergeSort(int[] targetArr) {
        super(targetArr);
    }

    public void sort() {
        int[] arr = super.getArr();
        
        this.mergeSort(arr, 0, arr.length-1);
    }

    public void mergeSort(int[] arr, int low, int high) {
        if(low < high) {
            int mid = (high+low)/2;
            this.mergeSort(arr, low, mid);
            this.mergeSort(arr, mid+1, high);

            this.merge(arr, low, mid, high);
        }
    }

    public void merge(int[] arr, int low, int mid, int high) {
        // copy arrays into temp arrays

        int[] temp1 = new int[mid - low + 1];
        int[] temp2 = new int[high - mid];

        for(int i = 0; i < temp1.length; i++){
            temp1[i] = arr[low + i];
        }
        for(int i = 0; i < temp2.length; i++) {
            temp2[i] = arr[mid + i + 1];
        }

        int j = 0;  // index for temp1
        int k = 0;  // index for temp2

        int i = low;
        while(j < temp1.length && k < temp2.length) {
            if(temp1[j] < temp2[k]) {
                arr[i++] = temp1[j++];
            }
            else {
                arr[i++] = temp2[k++];
            }
        }

        while(j < temp1.length) {
            arr[i++] = temp1[j++];
        }

        while(k < temp2.length) {
            arr[i++] = temp2[k++];
        }
    }
}
