package plpa.coursework;

import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class RobotExecutionController {

	private MainApp app;
	
	@FXML
	private Button back;
	
	@FXML
	private ListView<String> commandsListView;

	@FXML
	public void initialize() {
		back.setOnAction(e -> app.showRobotControlLayout());
	}

	public void setApplication(MainApp app) {
		this.app = app; 
	}
	
	public void updateListView(ObservableList<String> commands) {
		commandsListView.setItems(commands);
	}
	
	public void setInstructionNumber(int i) {
		commandsListView.getSelectionModel().select(i);
	}
}
