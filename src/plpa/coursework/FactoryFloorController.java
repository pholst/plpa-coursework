package plpa.coursework;

import java.io.*;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;

public class FactoryFloorController {


	@FXML
	private SplitPane splitPane;

	@FXML
	private Button runBtn;

	public FactoryFloorController() {
	}

	@FXML
	public void initialize() {
		Robot robot = new Robot(1,10,0);
		Factory factory = new Factory(robot);
		FloorPane floorPane = new FloorPane(factory);
		splitPane.getItems().set(0, floorPane);
		splitPane.setDividerPositions(0.75);

		Thread th = new Thread(new ReadFromLogFileTask(robot, floorPane));
		th.setDaemon(true);
		th.start();

		runBtn.setOnAction((event) -> {

		});

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
