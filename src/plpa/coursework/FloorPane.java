package plpa.coursework;

import java.util.ArrayList;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class FloorPane extends Pane {
	
	private double tileWidth = 20;
	private double tileHeight = 20;
	private double paneWidth;
	private double paneHeight;
	private Factory factory;
	private ArrayList<Tile> tiles;
	
	public FloorPane(Factory factory) {
		super();
		this.factory = factory;

		widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				paneWidth = newValue.doubleValue();				
				repaint();
			}
        });

		heightProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				paneHeight = newValue.doubleValue();
				repaint();
			}
        });

		tiles = factory.getTiles();
	}

	public void repaint() {
		
		double tileSize = Math.min(Math.floor(paneWidth/factory.floorWidth()), Math.floor(paneHeight/factory.floorHeight()));
		tileWidth = tileSize;
		tileHeight = tileSize;
		
		getChildren().clear();
		for (Tile t : tiles) {
			t.setX(t.getXCoord() * tileWidth);
			t.setY(t.getYCoord() * tileHeight);
			t.setWidth(tileWidth);
			t.setHeight(tileHeight);
			getChildren().add(t);
			
			if (t.hasArrow()) { 
				createArrow(t.getXCoord(), t.getYCoord(), t.getArrowDir());
			}
		}
		
		createRobot();
	}

	private void createArrow(int x, int y, int dir) {
		Image image = new Image(getClass().getResourceAsStream("arrow.png"));
		ImageView im = new ImageView(image);
		im.setX(x*tileWidth);
		im.setY(y*tileHeight);
		im.setFitHeight(tileWidth);
		im.setFitWidth(tileHeight);
		im.setRotate(90*dir);
		getChildren().add(im);
	}

	private void createRobot() {
		int x = factory.getRobot().getX();
		int y = factory.getRobot().getY();
		int xOld = factory.getRobot().getXOld();
		int yOld = factory.getRobot().getYOld();
		int dir = factory.getRobot().getDir();
		int dirOld = factory.getRobot().getDirOld();
		
		Image image = new Image(getClass().getResourceAsStream("robot.png"));
		ImageView im = new ImageView(image);
		
        im.setX(xOld*tileWidth);
        im.setY(yOld*tileHeight);
		im.setFitWidth(tileWidth);
		im.setFitHeight(tileHeight);
		
		if (dir != dirOld) {
			RotateTransition rt = new RotateTransition(Duration.millis(1000), im);
			rt.setFromAngle(90 * dirOld);
			rt.setByAngle(90 * dir - dirOld * 90);
			rt.play();
		} else {
			im.setRotate(90 * dir);
			TranslateTransition tt = new TranslateTransition(Duration.millis(1000), im);
			tt.setByX(x * tileWidth - xOld * tileWidth);
			tt.setByY(y * tileHeight - yOld * tileHeight);
			tt.setAutoReverse(false);
			tt.play();
		}
		
		
		getChildren().add(im);
		
	}
	
}
