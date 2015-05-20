package plpa.coursework;

import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.*;
import javafx.fxml.FXMLLoader;

import java.io.*;

import javafx.scene.*;

public class MainApp extends Application {

	private Stage primaryStage;
	private SplitPane rootLayout;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage; 
		this.primaryStage.setTitle("Robot factory floor");
		this.primaryStage.setMaximized(true);
		
		initRootLayout();
		showFactoryFloorLayout();
	}

	private void initRootLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("RootLayout.fxml"));
        rootLayout = (SplitPane) loader.load();

        Scene scene = new Scene(rootLayout);

        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
	}

	private void showFactoryFloorLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("FactoryFloorLayout.fxml"));
        AnchorPane pane = (AnchorPane) loader.load();
        rootLayout.getItems().set(0, pane);
        

	}

	public static void main(String[] args) {
		launch(args);
	}

}
