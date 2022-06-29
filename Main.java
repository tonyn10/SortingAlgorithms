import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        System.out.println("1. Bubble Sort");
        System.out.println("2. Insertion Sort");
        System.out.println("3. Selection Sort");
        System.out.println("4. Quick Sort");
        System.out.println("5. Merge Sort");
        System.out.println("6. Count Sort");
        System.out.println();

        Scanner sc = new Scanner(System.in);

        SortMaster obj = null;

        try {
            int choice = sc.nextInt();
            if(!(choice >= 1 && choice <= 6)) {
                throw new InputMismatchException();
            }

            int n = 50;                                          // number of sorts to be done
            double[] times = new double[n];                      // how much time the sorting method took
            HashSet<Boolean> outcomes = new HashSet<>(2); // set to contain true or false of the success of sort

            // parameters of array
            int minVal = 0;
            int maxVal = 10;
            int length = 10;

            for(int i = 0; i < n; i++) {
                int[] arr = generateRandomArray(minVal, maxVal, length);
    
                System.out.println("\n");
                switch(choice) {
                    case 1:
                        System.out.println("Bubble Sort");
                        obj = new BubbleSort(arr);
                        break;
                    case 2:
                        System.out.println("Insertion Sort");
                        obj = new InsertionSort(arr);
                        break;
                    case 3:
                        System.out.println("Selection Sort");
                        obj = new SelectionSort(arr);
                        break;
                    case 4:
                        System.out.println("Quick Sort");
                        obj = new QuickSort(arr);
                        break;
                    case 5:
                        System.out.println("Merge Sort");
                        obj = new MergeSort(arr);
                        break;
                    case 6:
                        System.out.println("Count Sort");
                        obj = new CountSort(arr, maxVal);
                        break;
                    default:
                        System.out.println("Improper choice");
                }

                System.out.println();
                System.out.println("Original:");
                System.out.println(obj);

                System.out.println();
                System.out.println("Sorted:");

                double startTime = System.nanoTime();
                obj.sort();
                double finishTime = System.nanoTime();

                double elapsedTime = finishTime - startTime;
                System.out.println(obj);
                System.out.println("Time: " + elapsedTime + " ns"); // nano seconds

                times[i] = elapsedTime;
                outcomes.add(isSorted(obj.getArr()));

                System.out.println();
                System.out.println("Sorted?: " + isSorted(obj.getArr()));
            }


            System.out.println("\n");
            System.out.println("Average time: " + getAverage(times));
            System.out.println("All sorted?: " + (outcomes.size() == 1 && outcomes.contains(true)));    // hashset should only have 1 true if successful
            
        }
        catch(InputMismatchException e){
            System.out.println("Not a proper choice.");
        }
        finally {
            sc.close();
        }      
    }

    private static int[] generateRandomArray(int minVal, int maxVal, int length) {
        int[] arr = new int[length];
        int range = maxVal - minVal + 1;
        for(int i = 0; i < length; i++) {
            arr[i] = minVal + (int) (Math.random() * range);
        }
        return arr;
    }

    private static double getAverage(double[] times) {
        double sum = 0;
        for(double t : times) {
            sum += t;
        }
        return sum / times.length;
    }

    private static boolean isSorted(int[] arr) {
        int i = 1;
        while( (i < arr.length) && (arr[i] >= arr[i-1])) {
            i++;
        }

        return i == arr.length;
    }
}