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
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

public class RangeGetter extends Application
{

    public RangeGetter()
    {
        url = getResource("rangegetter.html");
    }

    public void start(final Stage stage)
    {
        stage.setWidth(1200D);
        stage.setHeight(500D);
        Scene scene = new Scene(new Group());
        WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener() {

            public void changed(ObservableValue ov, javafx.concurrent.Worker.State oldState, javafx.concurrent.Worker.State newState)
            {
                if(newState == javafx.concurrent.Worker.State.SUCCEEDED)
                    stage.setTitle(webEngine.getLocation());
            }

            public volatile void changed(ObservableValue observablevalue, Object obj, Object obj1)
            {
                changed((ObservableValue)observablevalue, (javafx.concurrent.Worker.State)obj, (javafx.concurrent.Worker.State)obj1);
            }

            final RangeGetter this$0;
            private final Stage val$stage;
            private final WebEngine val$webEngine;

            
            {
                this$0 = RangeGetter.this;
                stage = stage1;
                webEngine = webengine;
                super();
            }
        });
        webEngine.load(url.toExternalForm());
        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener() {

            public void changed(ObservableValue ov, javafx.concurrent.Worker.State oldState, javafx.concurrent.Worker.State newState)
            {
                if(newState == javafx.concurrent.Worker.State.SUCCEEDED)
                {
                    JSObject win = (JSObject)webEngine.executeScript("window");
                    win.setMember("app", new RangeGetter());
                }
            }

            public volatile void changed(ObservableValue observablevalue, Object obj, Object obj1)
            {
                changed((ObservableValue)observablevalue, (javafx.concurrent.Worker.State)obj, (javafx.concurrent.Worker.State)obj1);
            }

            final RangeGetter this$0;
            private final WebEngine val$webEngine;

            
            {
                this$0 = RangeGetter.this;
                webEngine = webengine;
                super();
            }
        });
        HBox hb = new HBox();
        Label label = new Label();
        label.setText("Please enter the year:");
        final TextField tf = new TextField();
        tf.setOnAction(new EventHandler() {

            public void handle(ActionEvent event)
            {
                if(webEngine != null)
                    webEngine.executeScript((new StringBuilder("var chart = $('#container').highcharts();chart.xAxis[0].setExtremes(Date.UTC(")).append(tf.getText()).append(", 0, 1),").append("Date.UTC(").append(tf.getText()).append(", 11, 31)").append(");").toString());
            }

            public volatile void handle(Event event)
            {
                handle((ActionEvent)event);
            }

            final RangeGetter this$0;
            private final WebEngine val$webEngine;
            private final TextField val$tf;

            
            {
                this$0 = RangeGetter.this;
                webEngine = webengine;
                tf = textfield;
                super();
            }
        });
        hb.getChildren().addAll(new Node[] {
            browser, label, tf
        });
        scene.setRoot(hb);
        stage.setScene(scene);
        stage.show();
    }

    public void print(String value)
    {
        System.out.println(value);
        label.setText((new StringBuilder("Value from chart: ")).append(value).toString());
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
