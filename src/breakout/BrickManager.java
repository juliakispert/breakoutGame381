package breakout;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;


/**
* this class adds bricks to the screen, and removes them. 
* Inspired by bubbleManger from bubble blitz assignment/ 
* 
*/
public class BrickManager {

    private CanvasWindow canvas;

    private static final int NUM_BRICK_IN_A_ROW = 7;
    private static final int NUM_ROW = 7; // equal to the length of brick_colors 
    private double brickWidth, brickHeight, brickSpacing;  
    private static final Color[] BRICK_COLORS = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.PINK};
    private int numOfBricksRemoved = 0;


    /**
     * Constructs a brick manager for the specified window object.
     */
    public BrickManager(CanvasWindow canvas) {
        this.canvas = canvas;
        brickWidth = Math.round(canvas.getWidth()*.11); 
        brickHeight = Math.round(canvas.getWidth()*.05); 
        brickSpacing = Math.round(canvas.getWidth()*.025); 
        generateBrick();
    }

    /**
     * Creates the bricks and adds them on to the screen.
     */
    public void generateBrick(){
        double x = brickSpacing;
        double y = canvas.getHeight()*.1;  
        for(int i=0; i < NUM_ROW; i++){
            Color BrickColor = BRICK_COLORS[i];
            for(int j =0; j<NUM_BRICK_IN_A_ROW; j++){
                Rectangle brick = new Rectangle(x, y, brickWidth, brickHeight);
                brick.setFilled(true);
                brick.setFillColor(BrickColor); 
                canvas.add(brick);
                x += brickWidth + brickSpacing; 
            }
            y+=brickSpacing*0.5+brickHeight; 
            x=brickSpacing; 
        }
    }

     /**
    * removes a graphical object at the first point. 
    * then checks whether there is still a graphical object left at the second point (removes if present)
    * tracks objects it has removed.
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
    * method returns true when there are graphical objects at both points.
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