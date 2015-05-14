package plpa.coursework;

import javafx.scene.shape.*;

public class Tile extends Rectangle {
	
	private int xCoordinate;
	private int yCoordinate;

	public Tile(int x, int y) {
		super();
		this.xCoordinate = x;
		this.yCoordinate = y;
	}
	
	public int getXCoord() {
		return xCoordinate;
	}
	
	public int getYCoord() {
		return yCoordinate;
	}

}
