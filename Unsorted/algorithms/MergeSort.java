package algorithms;


/**
 * Created by maxmya on 07/08/16.
 */
public class MergeSort {


    public static int[] a;


    public static int arraySize;

    public static void mergeSort(int[] array) {

        arraySize = array.length;
        a = array;
        mergeSorty();


    }


    public static void mergeSorty() {
        {
            int[] workSpace = new int[arraySize];
            recMergeSort(workSpace, 0, arraySize - 1);
        }
    }

    private static void recMergeSort(int[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
        } else {
            int mid = (lowerBound + upperBound) / 2;

            recMergeSort(workSpace, lowerBound, mid);

            recMergeSort(workSpace, mid + 1, upperBound);

            merge(workSpace, lowerBound, mid + 1, upperBound);
        }
    }

    private static void merge(int[] workSpace, int lowPtr,
                              int highPtr, int upperBound) {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;
        while (lowPtr <= mid && highPtr <= upperBound) {
            if (a[lowPtr] < a[highPtr]) {
                workSpace[j++] = a[lowPtr++];
            } else {
                workSpace[j++] = a[highPtr++];
            }
        }
        while (lowPtr <= mid) {
            workSpace[j++] = a[lowPtr++];
        }
        while (highPtr <= upperBound) {
            workSpace[j++] = a[highPtr++];
        }
        for (j = 0; j < n; j++) {
            a[lowerBound + j] = workSpace[j];
        }
    }


}
