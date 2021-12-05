package breakout;

import edu.macalester.graphics.*;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;

import java.awt.*;

public class Paddle {
    private double centerX;
    private double centerY;
    private double width;
    private double height;
    private double currentXPosition;

    private Color paddleColor = new Color(0);
    private Rectangle paddle;
    /* creates paddle and gives it size and position*/

    public Paddle(double centerX, double centerY, double width, double height) {
        this.centerX = centerX;
        this.centerY = centerY;
        currentXPosition = centerX;
        this.width = width;
        this.height = height;
        createPaddleDrawing();
    }

    /* creates paddle graphic */
    public void createPaddleDrawing() {
        this.paddle = new Rectangle(centerX, centerY, width, height);
        paddle.setFillColor(paddleColor);
        paddle.setFilled(true);
        paddle.setStrokeColor(paddleColor);
        paddle.setStroked(true);
    }

    /* adds paddle to canvas*/
    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(paddle);
    }

    /* sets paddle position to mouse (this is what the lambda expression calls in BreakoutGame*/
    public void setCurrentPosition() {
        Point p = MouseInfo.getPointerInfo().getLocation();
        // 600 is the canvas width
        if (p.x > BreakoutGame.getCanvasWidth() - width) {
            currentXPosition = BreakoutGame.getCanvasWidth() - width;
        } else {
            currentXPosition = p.x;
        }
        paddle.setPosition(currentXPosition, centerY);
    }

    /* following methods are get methods returning positions of the paddle */
    public double getLeftCornerX() {
        return currentXPosition;
    }

    public double getRightCornerX() {
        return currentXPosition + width;
    }

    public double getYOfTop() {
        return centerY + height / 2;
    }

}
