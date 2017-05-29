package algorithms;

/**
 * Created by maxmya on 07/08/16.
 */
public class QuickSort {

    public static void quickSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void RquickSort(int[] array) {
        RQuickSort(array, 0, array.length - 1);
    }

    static int[] RQuickSort(int[] main, int p, int r) {
        int temp;
        if (p < r) {

            int x = p + (int) (Math.random() * (r - p)) % (r - p + 1);

            temp = main[x];
            main[x] = main[p];
            main[p] = temp;
            int q = partition(main, p, r);
            RQuickSort(main, p, q);
            RQuickSort(main, q + 1, r);
        }

        return main;
    }

    private static void sort(int[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            sort(a, p, q);
            sort(a, q + 1, r);
        }
    }

    private static int partition(int[] a, int p, int r) {

        int x = a[p];
        int i = p - 1;
        int j = r + 1;

        while (true) {
            i++;
            while (i < r && a[i] < x)
                i++;
            j--;
            while (j > p && a[j] > x)
                j--;

            if (i < j)
                swap(a, i, j);
            else
                return j;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
