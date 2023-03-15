/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Ste-PC
 */
public class ComponentBuilder {
    
    public ComponentBuilder(){
    }
    
    public BorderPane[] buildBorderPanes(int number){
        BorderPane[] borderPanes = new BorderPane[number];
        for(int i = 0; i < number; i++){
            BorderPane borderPane = new BorderPane();
            borderPanes[i] = borderPane;
        }
        return borderPanes;
    }
    
    public Label[] buildLabels(int number){
        Label[] labels = new Label[number];
        for(int i = 0; i < number; i++){
            Label label = new Label();
            label.setMinWidth(100);
            label.setMaxWidth(100);
            labels[i] = label;
        }
        return labels;
    }
    
    public Slider[] buildSliders(int number){
        Slider[] sliders = new Slider[number];
        for(int i = 0; i < number; i++){
            Slider slider = new Slider();
            slider.setPrefWidth(500);
            slider.setShowTickMarks(true);
            slider.setShowTickLabels(true);
            slider.setMinHeight(30);
            slider.setMaxHeight(30);
            sliders[i] = slider;
        }
        return sliders;
    }
    
    public void editSlider(Slider slider, double min, double max, double inc){
        slider.setMin(min);
        slider.setMax(max);
        slider.setBlockIncrement(inc);
    }
    
    public LineChart<Number, Number> buildLineChart(){
        NumberAxis xAxis = new NumberAxis(0,30,1);
        NumberAxis yAxis = new NumberAxis(0,27500,2500);
        LineChart<Number, Number> lineChart = new LineChart(xAxis, yAxis);
        return lineChart;
    }
}
