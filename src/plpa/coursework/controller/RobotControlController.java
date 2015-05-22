package plpa.coursework.controller;

import plpa.coursework.MainApp;
import kawa.standard.*;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class RobotControlController {
	
	private MainApp app;
	private Scheme scheme;

	@FXML
	private TextArea input;

	@FXML
	private Button run;

	@FXML
	private void run() {
		String in = input.getText();
		interpretInput(in);
		try {
			Object obj = (Object) scheme.eval(in);
			System.out.println(obj);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void setApplication(MainApp app) {
		this.app = app;
	}
	
	public void setScheme(Scheme scheme) {
		
		this.scheme = scheme;
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
