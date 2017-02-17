package application;

import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class ChangeChartType extends Application
{

    public ChangeChartType()
    {
        url = getResource("/changecharttype.html");
    }

    public void start(Stage stage)
    {
        stage.setWidth(1200D);
        stage.setHeight(500D);
        Scene scene = new Scene(new Group());
        WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        webEngine.load(url.toExternalForm());
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        Button btn3 = new Button();
        btn3.setText("Set Blue");
        Button btn4 = new Button();
        btn4.setText("Set Black");
        Button btn5 = new Button();
        btn5.setText("Column");
        Button btn6 = new Button();
        btn6.setText("Line");
        Button btn7 = new Button();
        btn7.setText("Spline");
        Button btn8 = new Button();
        btn8.setText("Area");
        Button btn9 = new Button();
        btn9.setText("Areaspline");
        Button btn10 = new Button();
        btn10.setText("Scatter");
        Button btn11 = new Button();
        btn11.setText("Pie");
        Button btn12 = new Button();
        btn12.setText("Change Values");
        Button btn = new Button();
        btn.setText("Add New Series");
        Button btn2 = new Button();
        btn2.setText("Show Data Labels");
        Button btn1 = new Button();
        btn1.setText("Hide Data Labels");
        btn.setOnAction(new EventHandler() {

            public void handle(ActionEvent event)
            {
                if(webEngine != null)
                    webEngine.executeScript((new StringBuilder("var chart = $('#container').highcharts();chart.addSeries({data: ")).append(getRandomSeries()).append("});").toString());
            }

            public volatile void handle(Event event)
            {
                handle((ActionEvent)event);
            }

            final ChangeChartType this$0;
            private final WebEngine val$webEngine;

            
            {
                this$0 = ChangeChartType.this;
                webEngine = webengine;
                super();
            }
        });
        btn12.setOnAction(new EventHandler() {

            public void handle(ActionEvent event)
            {
                if(webEngine != null)
                    webEngine.executeScript((new StringBuilder("var chart = $('#container').highcharts();chart.series[0].update({data: ")).append(getRandomSeries()).append("});").toString());
            }

            public volatile void handle(Event event)
            {
                handle((ActionEvent)event);
            }

            final ChangeChartType this$0;
            private final WebEngine val$webEngine;

            
            {
                this$0 = ChangeChartType.this;
                webEngine = webengine;
                super();
            }
        });
        btn1.setOnAction(new EventHandler() {

            public void handle(ActionEvent event)
            {
                if(webEngine != null)
                    webEngine.executeScript("var chart = $('#container').highcharts();chart.series[0].update({dataLabels: {enabled: false}});");
            }

            public volatile void handle(Event event)
            {
                handle((ActionEvent)event);
            }

            final ChangeChartType this$0;
            private final WebEngine val$webEngine;

            
            {
                this$0 = ChangeChartType.this;
                webEngine = webengine;
                super();
            }
        });
        btn2.setOnAction(new EventHandler() {

            public void handle(ActionEvent event)
            {
                if(webEngine != null)
                    webEngine.executeScript("var chart = $('#container').highcharts();chart.series[0].update({dataLabels: {enabled: true}});");
            }

            public volatile void handle(Event event)
            {
                handle((ActionEvent)event);
            }

            final ChangeChartType this$0;
            private final WebEngine val$webEngine;

            
            {
                this$0 = ChangeChartType.this;
                webEngine = webengine;
                super();
            }
        });
        btn3.setOnAction(new EventHandler() {

            public void handle(ActionEvent event)
            {
                if(webEngine != null)
                    webEngine.executeScript("var chart = $('#container').highcharts(), color = false;chart.series[0].update({color: Highcharts.getOptions().colors[0]});");
            }

            public volatile void handle(Event event)
            {
                handle((ActionEvent)event);
            }

            final ChangeChartType this$0;
            private final WebEngine val$webEngine;

            
            {
                this$0 = ChangeChartType.this;
                webEngine = webengine;
                super();
            }
        });
        btn4.setOnAction(new EventHandler() {

            public void handle(ActionEvent event)
            {
                if(webEngine != null)
                    webEngine.executeScript("var chart = $('#container').highcharts(), color = false;chart.series[0].update({color: Highcharts.getOptions().colors[1]});");
            }

            public volatile void handle(Event event)
            {
                handle((ActionEvent)event);
            }

            final ChangeChartType this$0;
            private final WebEngine val$webEngine;

            
            {
                this$0 = ChangeChartType.this;
                webEngine = webengine;
                super();
            }
        });
        btn5.setOnAction(new EventHandler() {

            public void handle(ActionEvent event)
            {
                if(webEngine != null)
                    webEngine.executeScript("var chart = $('#container').highcharts();chart.series[0].update({type: 'column'});");
            }

            public volatile void handle(Event event)
            {
                handle((ActionEvent)event);
            }

            final ChangeChartType this$0;
            private final WebEngine val$webEngine;

            
            {
                this$0 = ChangeChartType.this;
                webEngine = webengine;
                super();
            }
        });
        btn6.setOnAction(new EventHandler() {

            public void handle(ActionEvent event)
            {
                if(webEngine != null)
                    webEngine.executeScript("var chart = $('#container').highcharts();chart.series[0].update({type: 'line'});");
            }

            public volatile void handle(Event event)
            {
                handle((ActionEvent)event);
            }

            final ChangeChartType this$0;
            private final WebEngine val$webEngine;

            
            {
                this$0 = ChangeChartType.this;
                webEngine = webengine;
                super();
            }
        });
        btn7.setOnAction(new EventHandler() {

            public void handle(ActionEvent event)
            {
                if(webEngine != null)
                    webEngine.executeScript("var chart = $('#container').highcharts();chart.series[0].update({type: 'spline'});");
            }

            public volatile void handle(Event event)
            {
                handle((ActionEvent)event);
            }

            final ChangeChartType this$0;
            private final WebEngine val$webEngine;

            
            {
                this$0 = ChangeChartType.this;
                webEngine = webengine;
                super();
            }
        });
        btn8.setOnAction(new EventHandler() {

            public void handle(ActionEvent event)
            {
                if(webEngine != null)
                    webEngine.executeScript("var chart = $('#container').highcharts();chart.series[0].update({type: 'area'});");
            }

            public volatile void handle(Event event)
            {
                handle((ActionEvent)event);
            }

            final ChangeChartType this$0;
            private final WebEngine val$webEngine;

            
            {
                this$0 = ChangeChartType.this;
                webEngine = webengine;
                super();
            }
        });
        btn9.setOnAction(new EventHandler() {

            public void handle(ActionEvent event)
            {
                if(webEngine != null)
                    webEngine.executeScript("var chart = $('#container').highcharts();chart.series[0].update({type: 'areaspline'});");
            }

            public volatile void handle(Event event)
            {
                handle((ActionEvent)event);
            }

            final ChangeChartType this$0;
            private final WebEngine val$webEngine;

            
            {
                this$0 = ChangeChartType.this;
                webEngine = webengine;
                super();
            }
        });
        btn10.setOnAction(new EventHandler() {

            public void handle(ActionEvent event)
            {
                if(webEngine != null)
                    webEngine.executeScript("var chart = $('#container').highcharts();chart.series[0].update({type: 'scatter'});");
            }

            public volatile void handle(Event event)
            {
                handle((ActionEvent)event);
            }

            final ChangeChartType this$0;
            private final WebEngine val$webEngine;

            
            {
                this$0 = ChangeChartType.this;
                webEngine = webengine;
                super();
            }
        });
        btn11.setOnAction(new EventHandler() {

            public void handle(ActionEvent event)
            {
                if(webEngine != null)
                    webEngine.executeScript("var chart = $('#container').highcharts();chart.series[0].update({type: 'pie'});");
            }

            public volatile void handle(Event event)
            {
                handle((ActionEvent)event);
            }

            final ChangeChartType this$0;
            private final WebEngine val$webEngine;

            
            {
                this$0 = ChangeChartType.this;
                webEngine = webengine;
                super();
            }
        });
        hbox.getChildren().addAll(new Node[] {
            btn4, btn3, btn2, btn1, btn11, btn5, btn6, btn8, btn9, btn10, 
            btn7, btn12, btn
        });
        vbox.getChildren().addAll(new Node[] {
            browser, hbox
        });
        scene.setRoot(vbox);
        stage.setScene(scene);
        stage.show();
    }

    public ArrayList getRandomSeries()
    {
        ArrayList list = new ArrayList();
        Random rnd = new Random();
        for(int i = 0; i < 12; i++)
            list.add(Float.valueOf(rnd.nextFloat() * 200F));

        return list;
    }

    public void print(String value)
    {
        System.out.println(value);
        label.setText((new StringBuilder("Value from chart: ")).append(value).toString());
    }

    public String send()
    {
        return "150";
    }

    private URL getResource(String name)
    {
        return getClass().getResource(name);
    }

    public static void main(String args[])
    {
        launch(args);
    }

    URL url;
    static Label label;
}
