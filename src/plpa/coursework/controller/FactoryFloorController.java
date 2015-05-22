package plpa.coursework.controller;

import java.io.*;

import plpa.coursework.Factory;
import plpa.coursework.FloorPane;
import plpa.coursework.MainApp;
import plpa.coursework.Robot;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class FactoryFloorController {

	private MainApp app;

	@FXML
	public AnchorPane factoryFloorPane;
	
	@FXML
	public void initialize() {
		Robot robot = new Robot(1,10,0);
		Factory factory = new Factory(robot);
		FloorPane floorPane = new FloorPane(factory);
		AnchorPane.setBottomAnchor(floorPane, 0.0);
		AnchorPane.setLeftAnchor(floorPane, 0.0);
		AnchorPane.setRightAnchor(floorPane, 0.0);
		AnchorPane.setTopAnchor(floorPane, 0.0);
		factoryFloorPane.getChildren().add(floorPane);

		Thread th = new Thread(new ReadFromLogFileTask(robot, floorPane));
		th.setDaemon(true);
		th.start();
	}
	
	public void setApplication(MainApp mainApp) {
		this.app = mainApp; 
	}
	
	class ReadFromLogFileTask extends Task<Void> {
		
		private Robot robot;
		private FloorPane floorPane;
		private String previousLine = "df";
		
		public ReadFromLogFileTask(Robot robot, FloorPane floorPane) {
			
			this.robot = robot;
			this.floorPane = floorPane;
		}

		@Override
		protected Void call() throws Exception {
			readFromFile();
			return null;
		}
		
		private void readFromFile() {
			try {
				while (true) {
					BufferedReader br = new BufferedReader(new FileReader("log.txt"));
					final String line = br.readLine();
					if (line != null) {
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								handleInput(line);
							}
						});
					} else {
						br.close();
					}
					Thread.sleep(50);

					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		private void handleInput(String line) {
			if (!line.equals(previousLine)) {
				
				if (line.startsWith("error")) {
					app.printErrorMessage("Bad things happens..");
				} else if (line.startsWith("end")) {
					app.programExecutionDone();
				} else {
					String[] args = line.split(",");
					robot.setXOld(robot.getX());
					robot.setYOld(robot.getY());
					robot.setDirOld(robot.getDir());
					robot.setX(Integer.parseInt(args[1]));
					robot.setY(Integer.parseInt(args[2]));
					robot.setDir(Integer.parseInt(args[3]));
					floorPane.repaint(); 
					app.getRobotExecutionController().setInstructionNumber(Integer.parseInt(args[0]));
				}
			}
			previousLine = line;
		}
		
	}

}
