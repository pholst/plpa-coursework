package plpa.coursework.controller;

import plpa.coursework.MainApp;
import kawa.standard.*;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

        StringBuilder result = new StringBuilder();


        try {
            BufferedReader br = new BufferedReader(new FileReader("scm/robot-with-map.scm"));
            String line = "";
            while ((line = br.readLine()) != null) {
                result.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(result.toString());

		try {
            result.append(in);
            Object obj = (Object) scheme.eval(result.toString());

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
