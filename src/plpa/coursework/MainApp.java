package plpa.coursework;

import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.*;
import javafx.fxml.FXMLLoader;
import kawa.standard.Scheme;

import java.io.*;

import plpa.coursework.controller.FactoryFloorController;
import plpa.coursework.controller.RobotControlController;
import plpa.coursework.controller.RobotExecutionController;
import javafx.scene.*;

public class MainApp extends Application {

	private Stage primaryStage;
	private SplitPane rootLayout;
	private AnchorPane robotControlLayout;
	private AnchorPane robotExecutionLayout;
	private RobotExecutionController robotExecutionController;
	private Scheme scheme;
	

	private ObservableList<String> commands = FXCollections.observableArrayList();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage; 
		this.primaryStage.setTitle("Robot factory floor");
		this.primaryStage.setMaximized(true);
		
		Scheme.registerEnvironment();
		scheme = new Scheme();

		initRootLayout();
		loadRobotControlLayout();
		loadRobotExecutionLayout();

		showFactoryFloorLayout();
		showRobotControlLayout();
        rootLayout.setDividerPositions(0.70);

	}

	private void initRootLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
        rootLayout = (SplitPane) loader.load();

        Scene scene = new Scene(rootLayout);

        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
	}

	private void showFactoryFloorLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/FactoryFloorLayout.fxml"));
        AnchorPane pane = (AnchorPane) loader.load();
        FactoryFloorController controller = loader.getController();
        controller.setApplication(this);
        rootLayout.getItems().set(0, pane);
	}
	
	private void loadRobotControlLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RobotControlLayout.fxml"));
			robotControlLayout = (AnchorPane) loader.load();
			RobotControlController controller = loader.getController();
			controller.setApplication(this);
			controller.setScheme(scheme);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void loadRobotExecutionLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RobotExecutionLayout.fxml"));
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
		robotExecutionController.setBackBtnDisabled(true);
	}
	
	public void programExecutionDone() {
		robotExecutionController.setBackBtnDisabled(false);
	}
	
	public void addCommand(String command) {
		commands.add(command);
	}
	
	public void clearCommands() {
		commands.clear();
	}
	
	public RobotExecutionController getRobotExecutionController() {
		return robotExecutionController;
	}
	
	public void printErrorMessage(String msg) {
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("An error occurred in program execution");
		alert.setContentText(msg);
		alert.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
