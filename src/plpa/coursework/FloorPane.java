package plpa.coursework;

import java.util.ArrayList;

import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class FloorPane extends Pane {
	
	private double tileWidth;
	private double tileHeight;
	private Factory factory;
	private ArrayList<Tile> tiles;
	
	public FloorPane(Factory factory) {
		super();
		this.factory = factory;

		widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				tileWidth = Math.floor(newValue.doubleValue() / factory.floorWidth());
				repaint();
			}
        });

		heightProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				tileHeight = Math.floor(newValue.doubleValue() / factory.floorHeight());
				repaint();
			}
        });

		tiles = factory.getTiles();
	}

	public void repaint() {
		getChildren().clear();
		for (Tile t : tiles) {
			t.setX(t.getXCoord() * tileWidth);
			t.setY(t.getYCoord() * tileHeight);
			t.setWidth(tileWidth);
			t.setHeight(tileHeight);
			getChildren().add(t);
		}
		
		createRobot();
	}
	
	private void createRobot() {
		int x = factory.getRobot().getX();
		int y = factory.getRobot().getY();
		
		Image image = new Image(getClass().getResourceAsStream("arrow.png"));
		ImageView im = new ImageView(image);

		im.setX(x*tileWidth);
		im.setY(y*tileHeight);
		
		
		im.setRotate(90 * factory.getRobot().getDir());
			im.setFitWidth(tileWidth);
			im.setFitHeight(tileHeight);
		
			TranslateTransition tt = new TranslateTransition(Duration.millis(1000), im);
			tt.setByX(200f);
			tt.play();
		
		
		getChildren().add(im);
		
	/*	
		if (factory.getRobot().getDir() % 2 == 0) {
			robot.getPoints().addAll(new Double[]{
		    x*tileWidth, y*tileHeight,
		    x*tileWidth+tileWidth, y*tileHeight+(tileHeight/2),
		    x*tileWidth, y*tileHeight+tileHeight });
		} else {
			robot.getPoints().addAll(new Double[]{
		    x*tileWidth, y*tileHeight,
		    x*tileWidth+tileWidth, y*tileHeight,
		    x*tileWidth+tileWidth/2, y*tileHeight+tileHeight});
		}
		*/
		
	}
	
}
