package plpa.coursework;

public class Robot {
	
	private int x;
	private int y;
	private int xOld;
	private int yOld;
	private int dir;
	private int dirOld;

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
	
	public int getXOld() {
		return xOld;
	}
	
	public int getYOld() {
		return yOld;
	}
	
	public int getDir() {
		return dir;
	}
	
	public int getDirOld() {
		return dirOld;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
		
	public void setXOld(int xOld) {
		this.xOld = xOld;
	}

	public void setYOld(int yOld) {
		this.yOld = yOld;
	}
	
	public void setDir(int dir) {
		this.dir = dir;
	}
	
	public void setDirOld(int dirOld) {
		this.dirOld = dirOld;
	}

}
