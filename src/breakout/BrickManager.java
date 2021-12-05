package breakout;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;


/**
 * This class keeps track of creating the bricks on the screen and also removing them.
 * 
 * Author: Chinhsan Sieng
 */
public class BrickManager {

    private CanvasWindow canvas;

    private static final int NUM_BRICK_IN_A_ROW = 10;
    private static final int NUM_ROW = 10;
    private int numOfBricksRemoved = 0;


    /**
     * Constructs a brick manager for the specified window object.
     */
    public BrickManager(CanvasWindow canvas) {
        this.canvas = canvas;
        generateBrick();
    }

    /**
     * Creates the bricks and adds them on to the screen.
     */
    public void generateBrick(){
        for (int j=0; j< NUM_ROW; j++){
            for (int i = 0; i < NUM_BRICK_IN_A_ROW; i++) {
                Rectangle brick = new Rectangle((i+0.05) * canvas.getWidth() * 0.1
                , canvas.getHeight() * (0.2 + 0.018*j)
                , canvas.getWidth() * (0.1 - 0.005)
                , canvas.getHeight() * 0.015);
                brick.setFilled(true);
                brick.setFillColor(Color.green);
                canvas.add(brick);
            }
        } 
    }

     /**
     * Given two points, this method removes a graphical object at the first point. 
     * It then checks whether there is still a graphical object left at the second point. If there is, 
     * it also removes that too. It also keeps count of the object it has removed.
     */
    public void removeBricks(Point point1, Point point2){
        canvas.remove(canvas.getElementAt(point1));
        numOfBricksRemoved = numOfBricksRemoved + 1;
        if (canvas.getElementAt(point2) != null){
            canvas.remove(canvas.getElementAt(point2));
            numOfBricksRemoved = numOfBricksRemoved + 1;
        }
    }

    /**
     * Given two points on a given canvas, this method returns true when there are graphical objects
     * at both points.
     */
    public boolean checkNull(Point pos1, Point pos2){
        return (canvas.getElementAt(pos1) != null && canvas.getElementAt(pos2) != null);
    }

    public int getNumOfBricksRemoved(){
        return numOfBricksRemoved;
    }

    public int getTotalBricks(){
        return NUM_BRICK_IN_A_ROW * NUM_ROW;
    }

}