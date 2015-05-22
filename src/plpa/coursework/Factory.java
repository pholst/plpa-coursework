package plpa.coursework;

import java.util.ArrayList;
import kawa.standard.Scheme;

public class Factory {
	
	private Robot robot;
	private int[][] floor = 
		{
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10,10,10,0},
			{0,0,0,0,1,1,3,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10,10,10,0},
			{0,0,0,0,0,11,11,11,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0},
			{0,0,0,0,0,11,11,11,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,11,11,11,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
			{7,7,7,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
			{2,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0},
			{2,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0},
			{2,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,12,12,12,12,12,4,0,0,1,0,0},
			{2,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0},
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
			{2,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
			{7,7,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,13,13,13,5,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,13,13,13,1,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,13,13,13,1,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,13,13,13,1,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,13,13,13,4,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,14,14,14,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,14,14,14,0}
		};
	
	
	
	public Factory(Robot robot) {
		this.robot = robot; 
		
		Scheme.registerEnvironment();
        	Scheme scm = new Scheme();

        	try {
			scm.loadClass("map");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        	Object result = null;
		try {
			int width = 32;
			
			result = scm.eval("floor");
			
			String sch = result.toString();
			
			sch = sch.replaceAll("\\[","");
			sch = sch.replaceAll("\\]","");
			
			String[] array = sch.split(", ");
				
			int j = 0;
			for(int i=0;i<=array.length-1;i++){
				int res = 0;
				int h = i % width;
				if(h == 0 && i != 0){
					j++;
				}
				switch (array[i]) {
					case "-": res = 0; break;
					case "g": res = 1; break;
					case "r": res = 2; break;
					case "v": res = 3; break;
					case ">": res = 4; break;
					case "<": res = 5; break;
					case "b": res = 7; break;
					case "0": res = 10; break;
					case "1": res = 11; break;
					case "2": res = 12; break;
					case "3": res = 13; break;
					case "4": res = 14; break;
					default: res = 0; 
				}
				floor[j][h] = res;
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int floorWidth() {
		return floor[0].length;
	}
	
	public int floorHeight() {
		return floor.length;
	}
	
	public ArrayList<Tile> getTiles() {
		ArrayList<Tile> shapes = new ArrayList<Tile>();

		for (int i = 0; i < floor.length; i++) {
			for (int j = 0; j < floor[i].length; j++) {
				
				Tile tile = new Tile(j,i);
				tile.getStyleClass().add("tile");
				switch (floor[i][j]) {
					case 0: tile.getStyleClass().add("empty"); break;
					case 1: tile.getStyleClass().add("path"); break;
					case 2: tile.getStyleClass().add("parking"); break;
					case 3: tile.getStyleClass().add("path"); tile.setArrow(2); break;
					case 4: tile.getStyleClass().add("path"); tile.setArrow(1); break;
					case 5: tile.getStyleClass().add("path"); tile.setArrow(3); break;
					case 6: tile.getStyleClass().add("path"); tile.setArrow(0); break;
					case 7: tile.getStyleClass().add("barrier"); break;
					default: tile.getStyleClass().add("workstation"); break;
				}
				if (tile != null) { shapes.add(tile); };
			}
		}
		
		return shapes;
	}
	
	public Robot getRobot() {
		return robot;
	}

}
