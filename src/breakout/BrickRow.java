package breakout;

import edu.macalester.graphics.*;

import java.awt.*;
import java.util.ArrayList;

public class BrickRow {
    private double firstBrickXLocation, yLocation;
    private ArrayList<Brick> bricks = new ArrayList();

    /* creates brick row ()sets location */
    public BrickRow(double firstBrickXLocation, double yLocation, Color color) {
        this.firstBrickXLocation = firstBrickXLocation;
        this.yLocation = yLocation;
        drawBrickRow(firstBrickXLocation, yLocation, color);

    }
    /* creates brick row (adds bricks to it)*/

    public void drawBrickRow(double firstBrickXLocation, double yLocation, Color color) {
        for (int i = 0; i < 10; i++) {
            Brick addingBrick = new Brick(firstBrickXLocation + 53 * i, yLocation, color);
            bricks.add(addingBrick);
        }

    }

    /* adds brick row to graphic group */
    public void addToGraphicsGroup(GraphicsGroup graphicsGroup) {
        for (Brick brick : bricks) {
            brick.addToGraphicsGroup(graphicsGroup);
        }
    }

    /* returns bricks in brick row*/
    public ArrayList<Brick> getBricks() {
        return bricks;
    }

    /* returns y position of row*/
    public double getYLocation() {
        return yLocation;
    }

    /* removes brick from row*/
    public void removeBrick(Brick b) {
        bricks.remove(b);

    }

}