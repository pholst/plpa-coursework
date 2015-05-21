package plpa.coursework;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
		//back.setOnAction(e -> app.showRobotControlLayout());
	}
	
	@FXML
	private void back(ActionEvent event) {
		app.showRobotControlLayout();
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
