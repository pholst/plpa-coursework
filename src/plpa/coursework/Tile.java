package plpa.coursework;

import javafx.scene.shape.*;

public class Tile extends Rectangle {
	
	private int xCoordinate;
	private int yCoordinate;
	private boolean arrow;
	private int arrowDir;

	public Tile(int x, int y) {
		super();
		this.xCoordinate = x;
		this.yCoordinate = y;
	}
	
	public int getYCoord() {
		return yCoordinate;
	}
	
	public int getXCoord() {
		return xCoordinate;
	}
	
	public boolean hasArrow() {
		return arrow;
	}
	
	public void setArrow(int direction) {
		arrow = true;
		arrowDir = direction; 
	}
	
	public int getArrowDir() {
		return arrowDir;
	}

}
