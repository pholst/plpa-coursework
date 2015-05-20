package plpa.coursework;

import java.io.*;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class FactoryFloorController {


	@FXML
	public AnchorPane factoryFloorPane;
	
	
	public FactoryFloorController() {
	}

	@FXML
	public void initialize() {
		Robot robot = new Robot(0,8,0);
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
				String[] args = line.split(",");
				robot.setXOld(robot.getX());
				robot.setYOld(robot.getY());
				robot.setDirOld(robot.getDir());
				robot.setX(Integer.parseInt(args[1]));
				robot.setY(Integer.parseInt(args[2]));
				robot.setDir(Integer.parseInt(args[3]));
				floorPane.repaint(); 
			}
			previousLine = line;
		}
		
	}

}
