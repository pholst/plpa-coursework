package plpa.coursework;

import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.*;
import java.util.ArrayList;

import javafx.scene.*;

public class MainApp extends Application {

	private Stage primaryStage;
	private SplitPane rootLayout;
	private AnchorPane robotControlLayout;
	private AnchorPane robotExecutionLayout;
	private RobotExecutionController robotExecutionController;

	private ObservableList<String> commands = FXCollections.observableArrayList();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage; 
		this.primaryStage.setTitle("Robot factory floor");
		this.primaryStage.setMaximized(true);
		
		initRootLayout();
		loadRobotControlLayout();
		loadRobotExecutionLayout();
		

		showFactoryFloorLayout();
		showRobotControlLayout();
        rootLayout.setDividerPositions(0.70);

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
	
	private void loadRobotControlLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("RobotControlLayout.fxml"));
			robotControlLayout = (AnchorPane) loader.load();
			RobotControlController controller = loader.getController();
			controller.setApplication(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void loadRobotExecutionLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("RobotExecutionLayout.fxml"));
			robotExecutionLayout = (AnchorPane) loader.load();
			robotExecutionController = loader.getController();
			robotExecutionController.setApplication(this);
		} catch (Exception e) {
			e.printStackTrace();
			
		};
	}
	
	public void showRobotControlLayout() {
		rootLayout.getItems().set(1, robotControlLayout);
	}
	
	public void showRobotExecutionLayout() {
		rootLayout.getItems().set(1, robotExecutionLayout);
		robotExecutionController.updateListView(commands);
	}
	
	public void addCommand(String command) {
		commands.add(command);
	}
	
	public void clearCommands() {
		commands.clear();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
