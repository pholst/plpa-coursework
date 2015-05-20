package plpa.coursework;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RobotControlController {
	
	private MainApp app;
	
	@FXML
	private TextArea input;
	
	@FXML
	private Button run;
	
	@FXML
	public void initialize() {
		run.setOnAction((e) -> { 
			interpretInput(input.getText());
		} );
	}
	
	public void setApplication(MainApp app) {
		this.app = app;
	}
	
	private void interpretInput(String input) {
		String[] lines = input.split("\\r?\\n");
		app.clearCommands();
		for (String line : lines) {
			app.addCommand(line);
		}
		app.showRobotExecutionLayout(); 
	}
	

}
