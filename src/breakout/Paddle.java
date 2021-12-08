package breakout;

import edu.macalester.graphics.*;

/*
* Paddle Class to represent paddle(rectangle) object for breakout game. 
*/

public class Paddle extends Rectangle {

    /**
     * Constructs a paddle, a rectangle with width and height that depends on the
     * canvas size,
     * and places it almost at the bottom of the canvas.
     */
    public Paddle(CanvasWindow canvas) {
        super(0, 0, canvas.getWidth() * 0.2, canvas.getHeight() * 0.03);
        canvas.add(this);
        this.setCenter(canvas.getWidth() / 2, canvas.getHeight() * 0.85);
    }

    /**
     * Moves the paddle horizontally to the x-coordinate of the given position.
     */
    public void movePaddle(Point position) {
        this.setX(position.getX() - this.getWidth() / 2);
    }

    /**
     * Given a canvas and a point, this returns true if the graphical object at that
     * point is a paddle.
     */
    public boolean checkPaddle(CanvasWindow canvas, Point point1) {
        return ((canvas.getElementAt(point1)) != null
                && canvas.getElementAt(point1).getSize().getX() == this.getWidth());
    }
}
