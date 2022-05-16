public abstract class SortMaster {

    public abstract void sort();

    private int[] arr;

    public SortMaster(int[] targetArr) {
        this.arr = new int[targetArr.length];
        for(int i = 0; i < this.arr.length; i++) {
            this.arr[i] = targetArr[i];
        }
    }

    public int[] getArr() {
        return arr;
    }

    public String toString() {
        String result = "";
        if(this.arr != null) {
            for(int i : this.arr) {
                result = result + i + " ";
            }
        }
        return result;
    }

    public void swap(int index1, int index2) {
        int temp = this.arr[index1];
        this.arr[index1] = this.arr[index2];
        this.arr[index2] = temp;
    }
}
