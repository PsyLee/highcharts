package application;

import java.io.PrintStream;
import java.net.URL;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

// Referenced classes of package application:
//            HighStockWithZoomExample

public class InteractiveColumns extends Application
{

    public InteractiveColumns()
    {
        url = getResource("interactivecolumns.html");
    }

    public void start(final Stage stage)
    {
        stage.setWidth(650D);
        stage.setHeight(500D);
        Scene scene = new Scene(new Group());
        WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        StackPane pane = new StackPane();
        pane.getChildren().add(browser);
        StackPane.setAlignment(browser, Pos.TOP_LEFT);
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

            final InteractiveColumns this$0;
            private final Stage val$stage;
            private final WebEngine val$webEngine;

            
            {
                this$0 = InteractiveColumns.this;
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
                    win.setMember("app", new HighStockWithZoomExample());
                }
            }

            public volatile void changed(ObservableValue observablevalue, Object obj, Object obj1)
            {
                changed((ObservableValue)observablevalue, (javafx.concurrent.Worker.State)obj, (javafx.concurrent.Worker.State)obj1);
            }

            final InteractiveColumns this$0;
            private final WebEngine val$webEngine;

            
            {
                this$0 = InteractiveColumns.this;
                webEngine = webengine;
                super();
            }
        });
        scene.setRoot(pane);
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
