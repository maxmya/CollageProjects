package GUI;

import algorithms.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Arrays;


public class ChartForSortingAlgorithms extends Application {

    public static long fACost;
    public static long sACost;
    public static long tACost;
    public static long foACost;
    public static long fiACost;

    private Object[] arrays = new Object[1000];
    private XYChart.Series series1 = new XYChart.Series();
    private XYChart.Series series2 = new XYChart.Series();
    private XYChart.Series series3 = new XYChart.Series();
    private XYChart.Series series4 = new XYChart.Series();
    private XYChart.Series series5 = new XYChart.Series();
    private XYChart.Series series6 = new XYChart.Series();

    public static WinnersParser myWiners;

    long[] insertionObject = new long[1000];
    long[] selectionObject = new long[1000];
    long[] mergeObject = new long[1000];
    long[] quickObject = new long[1000];
    long[] javaObject = new long[1000];
    long[] randomQuickSortObject = new long[1000];

    long[] winnersObject = new long[1000];
    String[] winnersName = new String[1000];


    int insertionWins;
    int selectionWins;
    int mergeWins;
    int quickWins;
    int javaObjectWins;
    int randQSortWins;


    @Override
    public void start(Stage stage) {

        stage.setTitle("Sorting Algorithms Time Cost");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Array Length (int)");
        yAxis.setLabel("Time of Sorting (ms)");
        final LineChart<String, Number> myLineChart = new LineChart<String, Number>(xAxis, yAxis);


        myLineChart.setCreateSymbols(false);
        myLineChart.setTitle("Sorting Time Cost");
        series1.setName("Insertion Sort");
        series2.setName("Selection Sort");
        series3.setName("Merge Sort");
        series4.setName("Quick Sort");
        series5.setName("Java Sort");
        series6.setName("Randomized Quick Sort");

        for (int i = 0; i < 1000; i++) {

            arrays[i] = (int[]) ArrayOperations.getRandomArray(10 * i + 1);

            int[] insertionArr = new int[10 * i + 1];
            System.arraycopy((int[]) arrays[i], 0, insertionArr, 0, (10 * i) + 1);
            int[] selectionArr = new int[10 * i + 1];
            System.arraycopy((int[]) arrays[i], 0, selectionArr, 0, (10 * i) + 1);

            long startInsertion = System.currentTimeMillis();
            InsertionSort.insertionSort(insertionArr);
            long endInsertion = System.currentTimeMillis();
            insertionObject[i] = endInsertion - startInsertion;

            long startSelection = System.currentTimeMillis();
            SelectionSort.selectionSort(selectionArr);
            long endSelection = System.currentTimeMillis();
            selectionObject[i] = endInsertion - startInsertion;

        }
        for (int i = 0; i < 1000; i++) {

            arrays[i] = ArrayOperations.getRandomArray(100 * i + 1);

            int[] mergearr = new int[100 * i + 1];
            System.arraycopy((int[]) arrays[i], 0, mergearr, 0, 100 * i + 1);
            int[] quickArr = new int[100 * i + 1];
            System.arraycopy((int[]) arrays[i], 0, quickArr, 0, 100 * i + 1);
            int[] javaArr = new int[100 * i + 1];
            System.arraycopy((int[]) arrays[i], 0, javaArr, 0, 100 * i + 1);
            int[] randArr = new int[100 * i + 1];
            System.arraycopy((int[]) arrays[i], 0, randArr, 0, 100 * i + 1);

            long startMerge = System.currentTimeMillis();
            MergeSort.mergeSort(mergearr);
            long endMerge = System.currentTimeMillis();
            mergeObject[i] = endMerge - startMerge;

            long startquick = System.currentTimeMillis();
            QuickSort.quickSort(quickArr);
            long endquick = System.currentTimeMillis();
            quickObject[i] = endquick - startquick;

            long startBuiltInSort = System.currentTimeMillis();
            BuiltInSortAlgorithm.javaSort(javaArr);
            long endBuit = System.currentTimeMillis();
            javaObject[i] = endBuit - startBuiltInSort;

            long startRquick = System.currentTimeMillis();
            QuickSort.RquickSort(randArr);
            long endRquick = System.currentTimeMillis();
            randomQuickSortObject[i] = endRquick - startRquick;


        }


        for (int i = 0; i < 1000; i++) {

            series1.getData().add(new XYChart.Data((i + "k"), insertionObject[i]));
            series2.getData().add(new XYChart.Data((i + "k"), selectionObject[i]));
            series3.getData().add(new XYChart.Data((i + "k"), mergeObject[i]));
            series4.getData().add(new XYChart.Data((i + "k"), quickObject[i]));
            series5.getData().add(new XYChart.Data((i + "k"), javaObject[i]));
            series6.getData().add(new XYChart.Data((i + "k"), randomQuickSortObject[i]));


            long min = ArrayOperations.getMin(insertionObject[i], selectionObject[i], mergeObject[i], quickObject[i], javaObject[i], randomQuickSortObject[i]);

            winnersObject[i] = min;

            if (min == insertionObject[i]) {
                System.out.println("At loop " + i + " the Insertion sort scored minimum time " + min + " ms");
                winnersName[i] = "Insertion";
                insertionWins++;
            } else if (min == selectionObject[i]) {
                System.out.println("At loop " + i + " the Selection sort scored minimum time " + min + " ms");
                winnersName[i] = "Selection";
                selectionWins++;
            } else if (min == mergeObject[i]) {
                System.out.println("At loop " + i + " the Merge sort scored minimum time " + min + " ms");
                winnersName[i] = "Merge";
                mergeWins++;
            } else if (min == quickObject[i]) {
                System.out.println("At loop " + i + " the Quick sort scored minimum time " + min + " ms");
                winnersName[i] = "Quick";
                quickWins++;
            } else if (min == javaObject[i]) {
                System.out.println("At loop " + i + " the Java Built-in sort scored minimum time " + min + " ms");
                winnersName[i] = "Java Built-in";
                javaObjectWins++;
            } else if (min == randomQuickSortObject[i]) {
                System.out.println("At loop " + i + " the Randomized Quick sort scored minimum time " + min + " ms");
                winnersName[i] = "Randomized Quick";
                randQSortWins++;

            }

        }

        myWiners = new WinnersParser(winnersObject, winnersName);

        int[] wins = new int[]{insertionWins, selectionWins, mergeWins, quickWins, javaObjectWins, randQSortWins};
        Arrays.sort(wins);
        ArrayOperations.reverse(wins);
        System.out.println(Arrays.toString(wins));
        long max = ArrayOperations.getMax(insertionWins, selectionWins, mergeWins, quickWins, javaObjectWins, randQSortWins);

        String[] winners = getListOfWinners(wins);

        for (int i = 0; i < winners.length; i++) {
            if (i == 0)
                System.out.println("1st winner is the " + winners[i]);
            else if (i > 0 && i < 3)
                System.out.println((i + 1) + "nd winner is the " + winners[i]);
            else
                System.out.println((i + 1) + "th winner is the " + winners[i]);
        }
        System.out.println("");
        if (max == insertionWins) {
            System.out.println(" The Insertion sort Wins at all");
        } else if (max == selectionWins) {
            System.out.println(" The Selection sort Wins at all");
        } else if (max == mergeWins) {
            System.out.println(" The Merge sort Wins at all");
        } else if (max == quickWins) {
            System.out.println(" The Quick sort Wins at all");
        } else if (max == javaObjectWins) {
            System.out.println(" The Java Built-in sort Wins at all");
        } else if (max == randQSortWins) {
            System.out.println(" The Randomized Quick sort Wins at all");

        }


        Scene scene = new Scene(myLineChart, 800, 600);
        myLineChart.getData().addAll(series1, series2, series3, series4, series5, series6);
        stage.setScene(scene);
        stage.show();
    }

    public String[] getListOfWinners(int[] x) {

        String[] winners = new String[x.length];

        for (int i = 0; i < x.length; i++) {
            if (x[i] == insertionWins) {
                winners[i] = "Insertion Sort";
            } else if (x[i] == selectionWins) {
                winners[i] = "Selection Sort";
            } else if (x[i] == mergeWins) {
                winners[i] = "Merge Sort";
            } else if (x[i] == quickWins) {
                winners[i] = "Quick Sort";
            } else if (x[i] == javaObjectWins) {
                winners[i] = "Java Built-In Sort";
            } else if (x[i] == randQSortWins) {
                winners[i] = "Randomized Quick Sort";
            }


        }

        return winners;
    }


    public static void main(String[] args) throws Exception {
        launch();
    }
}
