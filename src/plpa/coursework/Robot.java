package plpa.coursework;

public class Robot {
	
	private int x;
	private int y;
	private int dir;

	public Robot(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}
	
	public int getDir() {
		return dir;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setDir(int dir) {
		this.dir = dir;
	}

}
