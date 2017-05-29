package algorithms;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by maxmya on 07/08/16.
 */
public class ArrayOperations {

    public static int[] getRandomArray(int size, int rangeStart, int rangeEnd) {

        int[] myArray = new int[size];

        for (int i = 0; i < size; i++) {

            myArray[i] = ThreadLocalRandom.current().nextInt((rangeEnd - rangeStart) + 1) + rangeStart;

        }

        return myArray;

    }

    public static void reverse(int[] data) {
        int left = 0;
        int right = data.length - 1;

        while (left < right) {
            int temp = data[left];
            data[left] = data[right];
            data[right] = temp;

            left++;
            right--;
        }
    }


    public static int[] getRandomArray(int size) {

        int[] returnValue = getRandomArray(size, 9999, 999999);

        return returnValue;

    }

    public static long getMin(long... x) {

        int size = x.length;
        long min = x[0];
        for (int i = 0; i < size; i++) {

            if (x[i] < min) {
                min = x[i];
            }

        }


        return min;

    }


    public static long getMax(long... x) {

        int size = x.length;
        long max = x[0];
        for (int i = 0; i < size; i++) {

            if (x[i] > max) {
                max = x[i];
            }

        }


        return max;

    }

}
