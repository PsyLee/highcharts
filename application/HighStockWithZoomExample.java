package application;

import java.io.PrintStream;
import java.net.URL;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

public class HighStockWithZoomExample extends Application
{

    public HighStockWithZoomExample()
    {
        url = getResource("/chart.html");
    }

    public void start(Stage stage)
    {
        stage.setWidth(1200D);
        stage.setHeight(500D);
        Scene scene = new Scene(new Group());
        WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        StackPane pane = new StackPane();
        pane.getChildren().add(browser);
        StackPane.setAlignment(browser, Pos.TOP_LEFT);
        webEngine.load(url.toExternalForm());
        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener() {

            public void changed(ObservableValue ov, javafx.concurrent.Worker.State oldState, javafx.concurrent.Worker.State newState)
            {
                if(newState == javafx.concurrent.Worker.State.SUCCEEDED)
                {
                    JSObject win = (JSObject)webEngine.executeScript("window");
                    win.setMember("app", new HighStockWithZoomExample());
                }
            }

            public volatile void changed(ObservableValue observablevalue, Object obj, Object obj1)
            {
                changed((ObservableValue)observablevalue, (javafx.concurrent.Worker.State)obj, (javafx.concurrent.Worker.State)obj1);
            }

            final HighStockWithZoomExample this$0;
            private final WebEngine val$webEngine;

            
            {
                this$0 = HighStockWithZoomExample.this;
                webEngine = webengine;
                super();
            }
        });
        scene.setRoot(pane);
        label = new Label("Value from chart");
        pane.getChildren().add(label);
        StackPane.setAlignment(label, Pos.BOTTOM_CENTER);
        Button btn = new Button();
        btn.setText("Set 150");
        btn.setOnAction(new EventHandler() {

            public void handle(ActionEvent event)
            {
                if(webEngine != null)
                    webEngine.executeScript("var chart = $('#container').highcharts();var json = JSON.parse(app.send());var series = chart.series[0];var x = (new Date()).getTime(),y = json;series.addPoint([x, y], true, true);");
            }

            public volatile void handle(Event event)
            {
                handle((ActionEvent)event);
            }

            final HighStockWithZoomExample this$0;
            private final WebEngine val$webEngine;

            
            {
                this$0 = HighStockWithZoomExample.this;
                webEngine = webengine;
                super();
            }
        });
        pane.getChildren().add(btn);
        StackPane.setAlignment(btn, Pos.BOTTOM_LEFT);
        stage.setScene(scene);
        stage.show();
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
