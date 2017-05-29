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


/**
 * Created by Maxmya on 11/08/2016.
 */
public class JavaSortChallange extends Application {

    private XYChart.Series series1 = new XYChart.Series();

    @Override
    public void
    init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Sorting Algorithms Time Cost");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Array Length (int)");
        yAxis.setLabel("Time of Sorting (ms)");
        final LineChart<String, Number> myLineChart = new LineChart<String, Number>(xAxis, yAxis);


        myLineChart.setCreateSymbols(false);
        myLineChart.setTitle("Sorting Time Cost");
        series1.setName("Java Sort");

        for (int i = 0; i < 100; i++) {
            int[] myarr = ArrayOperations.getRandomArray(10000 * i + 1);
            long startJavaSort = System.currentTimeMillis();
            Arrays.sort(myarr);
            series1.getData().add(new XYChart.Data((i + "k"), System.currentTimeMillis() - startJavaSort));
        }

        Scene scene = new Scene(myLineChart, 800, 600);
        myLineChart.getData().add(series1);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        try {
            launch();
        } catch (Exception e) {

        }
    }
}
