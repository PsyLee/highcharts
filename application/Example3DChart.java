package application;

import java.io.PrintStream;
import java.net.URL;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Example3DChart extends Application
{

    public Example3DChart()
    {
        url = getResource("/3dchartexample.html");
    }

    public void start(Stage stage)
    {
        stage.setWidth(700D);
        stage.setHeight(700D);
        Scene scene = new Scene(new Group());
        WebView browser = new WebView();
        WebEngine webEngine = browser.getEngine();
        StackPane pane = new StackPane();
        pane.getChildren().add(browser);
        StackPane.setAlignment(browser, Pos.TOP_LEFT);
        webEngine.load(url.toExternalForm());
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
