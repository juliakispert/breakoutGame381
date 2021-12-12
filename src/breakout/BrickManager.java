package breakout;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

/**
 * this class adds bricks to the screen, and removes them.
 * Inspired by bubbleManager from bubble blitz assignment/
 * 
 */
public class BrickManager {

    private CanvasWindow canvas;

    private static final int NUM_BRICK_IN_A_ROW = 1;
    private static final int NUM_ROW = 1; // equal to the length of brick_colors
    private double brickSpacingHorizontal, brickSpacingVertical;
    private static final Color[] BRICK_COLORS = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN,
            Color.MAGENTA, Color.PINK };
    private int numOfBricksRemoved;

    /**
     * Constructs a brick manager for the specified window object.
     */
    public BrickManager(CanvasWindow canvas) {
        this.canvas = canvas;
        brickSpacingHorizontal = Math.round(canvas.getWidth() * .025);
        ;
        brickSpacingVertical = Math.round(canvas.getWidth() * .05) + brickSpacingHorizontal;
        numOfBricksRemoved = 0;
        generateBrickWall();
    }

    /**
     * Creates the bricks and adds them on to the screen.
     */
    public void generateBrickWall() {
        double x = brickSpacingHorizontal;
        double y = canvas.getHeight() * .1;
        for (int i = 0; i < NUM_ROW; i++) {
            Color BrickColor = BRICK_COLORS[i];
            for (int j = 0; j < NUM_BRICK_IN_A_ROW; j++) {
                Brick brick = new Brick(x, y, canvas);
                brick.setFilled(true);
                brick.setFillColor(BrickColor);
                brick.setStroked(false);
                canvas.add(brick);
                x += brick.getBrickWidth() + brickSpacingHorizontal;
            }
            y += brickSpacingVertical;
            x = brickSpacingHorizontal;
        }
    }

    /**
     * Removes a graphical object at the first point.
     * Then checks whether there is still a graphical object left at the second
     * point (removes if present).
     * Checks two points as a ball can hit two bricks at the same time based on the
     * differences in sizes.
     * tracks bricks it has removed.
     */
    public void removeBricks(Point point1, Point point2) {
        canvas.remove(canvas.getElementAt(point1));
        numOfBricksRemoved = numOfBricksRemoved + 1;
        if (canvas.getElementAt(point2) instanceof Brick) {
            canvas.remove(canvas.getElementAt(point2));
            numOfBricksRemoved = numOfBricksRemoved + 1;
        }
    }

    /**
     * Method returns true when there are graphical objects at both points.
     */
    public boolean checkIfBrick(Point pos1, Point pos2) {
        return (canvas.getElementAt(pos1) instanceof Brick && canvas.getElementAt(pos2) instanceof Brick);
    }

    public int getNumOfBricksRemoved() {
        return numOfBricksRemoved;
    }

    public int getTotalBricks() {
        return NUM_BRICK_IN_A_ROW * NUM_ROW;
    }

}