package gui;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * Created by OlavH on 18-Nov-16.
 */
public class BarCharts {

    public static BarChart<String, Number> getBarchartFor(String[] titles, Number[] data){

        if (titles.length != data.length) return null;

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis,yAxis);

        barChart.setTitle("File Reduction");
        xAxis.setLabel("File");
        yAxis.setLabel("Size (MB)");

        XYChart.Series series = new XYChart.Series();
        for (int i = 0; i < titles.length; i++) {

            series.getData().add(new XYChart.Data(titles[i], data[i]));

        }
        barChart.getData().add(series);
        barChart.setLegendVisible(false);


        return barChart;
    }

}
