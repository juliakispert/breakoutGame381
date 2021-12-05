package breakout;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;


/**
 * Represent a paddle that can be drawn on the screen.
 */
public class Paddle{
    private Rectangle paddleShape;

     /**
     * Constructs a paddle, a rectangle with width and height that depends on the canvas size,
     * and places it almost at the bottom of the canvas.
     */
    public Paddle(CanvasWindow canvas){
        paddleShape = new Rectangle(0, 0, canvas.getWidth() * 0.2,  canvas.getHeight() * 0.01);
        canvas.add(paddleShape);
        paddleShape.setCenter(canvas.getWidth()/2, canvas.getHeight() * 0.85 );
    }   

    /**
     * Moves the paddle horizontally to the x-coordinate of the given position.
     */
    public void movePaddle(Point position){
        paddleShape.setX(position.getX() - paddleShape.getWidth()/2);
    }    

    public Rectangle getPaddleShape(){
        return paddleShape;
    }

    /**
     * Given a canvas and a point, this returns true if the graphical object at that point is a paddle.
     */
    public boolean checkPaddle(CanvasWindow canvas, Point point1){
        return ((canvas.getElementAt(point1)) != null  && canvas.getElementAt(point1).getSize().getX() == paddleShape.getWidth());
    }

}
