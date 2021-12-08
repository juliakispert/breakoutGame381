package breakout;

import edu.macalester.graphics.*;
/*
* Class to represent a single brick in the brick wall. Extends rextangle as a brick is a rectangle object. 
*/

public class Brick extends Rectangle {

    private double brickWidth, brickHeight;

    public Brick(double x, double y, double width, double height) {
        super(x, y, width, height);
        brickWidth = width;
        brickHeight = height;
    }

    public Brick(double x, double y, CanvasWindow canvas) {
        super(x, y, Math.round(canvas.getWidth() * .114), Math.round(canvas.getWidth() * .05));
        brickWidth = Math.round(canvas.getWidth() * .114);
        brickHeight = Math.round(canvas.getWidth() * .05);

    }

    public double getBrickWidth() {
        return brickWidth;
    }

    public double getBrickHeight() {
        return brickHeight;
    }
}
