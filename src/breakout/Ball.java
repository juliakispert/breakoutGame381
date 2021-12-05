package breakout;

import edu.macalester.graphics.*;


import java.awt.*;
import java.util.Random;

// adding a comment here

public class Ball {
    public static final double BALL_RADIUS = 10;
    private static final double VELOCITY = 10;
    private double angle, centerX, centerY;
    private double topCornersY, bottomCornersY, leftCornersX, rightCornersX, dy, dx;
    private double maxX, maxY;
    private Ellipse ball;
    private Random random = new Random();
    /* creates ball and gives it a starting angle for movement */

    public Ball(double canvasWidth, double canvasHeight) {
        this.centerX = canvasWidth / 2;
        this.centerY = canvasHeight / 2;
        maxX = canvasWidth + BALL_RADIUS;
        maxY = canvasHeight + BALL_RADIUS;
        angle = Math.toRadians(random.nextInt(45)) + .2;
        dx = VELOCITY * Math.cos(angle);
        dy = VELOCITY * Math.sin(angle);
        ball = new Ellipse(centerX, centerY, BALL_RADIUS, BALL_RADIUS);
        ball.setFillColor(Color.LIGHT_GRAY);
        ball.setFilled(true);
    }

    /* changes position and direction of movement of the ball based on if it touches a wall/brick or paddle (in regards to its corner positions) This is what the lambda call to animate is calling in BreakoutGame*/
    public void updatePositionOfBall() {

        if (rightCornersX > maxX) {
            dx *= -1;
        }
        if (leftCornersX < 0) {
            dx *= -1;

        }
        if (topCornersY < 0) {
            dy *= -1;

        }
        if (BreakoutGame.ballHitsPaddle()) {
            dy *= -1;
        }

        if (BreakoutGame.ballHitBrick()) {
            if(angle>3*Math.PI/2 && angle<Math.PI)
                dx*= -1;
            else
                dy*=-1;

        }
        if (bottomCornersY > maxY) {
            BreakoutGame.newTurn();

        }

        centerX += (dx * .2);
        centerY += (dy * .2);
        ball.setPosition(centerX, centerY);
        updateCornerPositions();

    }

    /*keeps track of positions of the corners of the ball and updates them after ball has moved*/

    public void updateCornerPositions() {
        leftCornersX = ball.getX();
        topCornersY = ball.getY();
        rightCornersX = ball.getX() + 2 * BALL_RADIUS;
        bottomCornersY = ball.getY() + 2 * BALL_RADIUS;
    }

    /*adds ball to canvas*/
    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(ball);
    }

    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(ball);
    }

    /* get methods that returns important ball position*/
    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public double getBottomCornersY() {
        return bottomCornersY;
    }

    public double getTopCornersY() {
        return topCornersY;
    }

    public double getLeftCornersX() {
        return leftCornersX;
    }

    public double getRightCornersX() {
        return rightCornersX;
    }


}