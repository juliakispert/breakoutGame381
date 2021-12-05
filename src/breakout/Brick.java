package breakout;


import edu.macalester.graphics.*;

import java.awt.*;
import edu.macalester.graphics.Rectangle;

public class Brick {
    public static final int brickWidth = 50;
    public static final int brickHeight = 10;
    private double centerX;
    private double centerY;
    private Color color;
    private Rectangle brick;

    /* creates Brick */
    public Brick(double centerX, double centerY, Color color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.color = color;
        drawBrick(color);

    }

    /* creates brick drawing */
    public void drawBrick(Color color) {
        brick = new Rectangle(centerX, centerY, brickWidth, brickHeight);
        brick.setFillColor(color);
        brick.setFilled(true);
        brick.setStrokeColor(Color.black);
        brick.setStroked(true);
    }

    /* adds to graphic group */
    public void addToGraphicsGroup(GraphicsGroup graphicsGroup) {
        graphicsGroup.add(brick);
    }

    /* remove to graphic group */
    public void removeFromGraphicsGroup(GraphicsGroup graphicsGroup) {

        graphicsGroup.remove(brick);

    }

    /* returns x position left corner */
    public double getLeftCornerBrick() {
        return centerX - brickWidth / 2;
    }

    /* returns x position right corner */
    public double getRightCornerBrick() {
        return centerX + brickWidth / 2;
    }

}
