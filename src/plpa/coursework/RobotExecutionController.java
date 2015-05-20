package plpa.coursework;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class RobotExecutionController {

	private MainApp app;
	
	@FXML
	private Button back;
	
	@FXML
	private ListView<String> instructions;

	@FXML
	public void initialize() {
		back.setOnAction(e -> app.showRobotControlLayout());
	}

	public void setApplication(MainApp app) {
		this.app = app; 
	}
	
	public void updateListView(ObservableList<String> commands) {
		instructions.setItems(commands);
		
	}
}
