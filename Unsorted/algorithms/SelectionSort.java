package algorithms;

/**
 * Created by maxmya on 07/08/16.
 */
public class SelectionSort {


    public static void selectionSort(int arr[]) {

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }

    }

}
