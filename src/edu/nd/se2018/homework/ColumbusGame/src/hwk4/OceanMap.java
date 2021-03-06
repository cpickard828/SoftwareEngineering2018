package hwk4;

// Cameron Pickard
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;



public class OceanMap {
	int[][] oceanGrid = new int[25][25]; // 0 empty, 1 island
	final int dimensions = 25;

	// Create the sea
	public void drawMap(ObservableList<Node> root, int scale) {
		for(int x = 0; x < dimensions; x++){
			for(int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.PALETURQUOISE);
				root.add(rect);
				oceanGrid[x][y] = 0;
			}
		}
	}
	// Add 10 islands randomly
	public void drawIslands(ObservableList<Node> root, int scale, int x, int y) {
		Random rx = new Random();
		Random ry = new Random();
		int newX, newY;
		int madeIsland = 0;
		Rectangle rect;
		for(int i = 0; i < 10; i++) {
			madeIsland = 0;
			while(madeIsland == 0) {
				newX = rx.nextInt(25);
				newY = ry.nextInt(25);
				if(oceanGrid[newX][newY] == 0 && (newX != x && newY != y)) {
					rect = new Rectangle(newX*scale, newY*scale, scale, scale);
					rect.setStroke(Color.BLACK);
					rect.setFill(Color.GREEN);
					root.add(rect);
					oceanGrid[newX][newY] = 1;
					madeIsland = 1;
				}
			}
		}
	}

	// Return status of space
	public int seeSpace(int x, int y) {
		return oceanGrid[x][y];
	}
}
