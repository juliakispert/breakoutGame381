package breakout;

import edu.macalester.graphics.*;

public class Ball extends Ellipse {
    public static final double BALL_RADIUS = 10;
    private double centerX, centerY;
    private double speedX, speedY;

    public Ball(double centerX, double centerY, double initialSpeed) {
        super(centerX-BALL_RADIUS, centerY-BALL_RADIUS, 2*BALL_RADIUS, 2*BALL_RADIUS);  

        this.centerX = centerX;
        this.centerY = centerY;

        double angle = (Math.random() * 50) + 20;
        speedX = initialSpeed * Math.cos(Math.toRadians(angle));
        speedY = initialSpeed * Math.sin(Math.toRadians(angle));

        this.setFilled(true);
    }

    /**
     * This method updates the ball's position, and also deals with what happens when the ball
     * hits the wall, the paddle, or the bricks.  
     */
    public void updatePosition(CanvasWindow canvas, double dt, BrickManager brickManager, Paddle paddle){
        centerX +=  speedX * dt;
        centerY +=  speedY * dt;
        this.setCenter(centerX, centerY);
        hitWall(canvas);
        if (!hitPaddle(canvas, paddle)){
            hitBricks(brickManager);
        }      
    }

    /**
     * Given a canvas, this method changes the direction of the ball if it doesn't hit the top, 
     * left and right wall.
     */
    private void hitWall(CanvasWindow canvas){
        if (centerX - BALL_RADIUS <= 0 || centerX + BALL_RADIUS >= canvas.getWidth()){
            speedX = -speedX;
        }
        if (centerY - BALL_RADIUS <= 0){
            speedY = -speedY;
        }
    }
    
    /**
     * Given a brick manager object, this method checks 4 pairs of nearby corners,
     * removes any bricks there as well as changing the direction of the ball.
     */
    private void hitBricks(BrickManager brickManager){
        
        Point topLeft = new Point(centerX - BALL_RADIUS, centerY - BALL_RADIUS);
        Point topRight = new Point(centerX + BALL_RADIUS, centerY - BALL_RADIUS);
        Point bottomLeft = new Point(centerX - BALL_RADIUS, centerY + BALL_RADIUS);
        Point bottomRight = new Point(centerX + BALL_RADIUS, centerY + BALL_RADIUS);
      
        if (brickManager.checkNull(topLeft, topRight)){
            speedY = -speedY;
            brickManager.removeBricks(topLeft, topRight);
        }

        if (brickManager.checkNull(bottomLeft, bottomRight)){
            speedY = -speedY;
            brickManager.removeBricks(bottomLeft, bottomRight);
        }

        if (brickManager.checkNull(topLeft, bottomLeft)){
            speedX = -speedX;
            brickManager.removeBricks(topLeft, bottomLeft);
        }

        if (brickManager.checkNull(topRight, bottomRight)){
            speedX = -speedX;
            brickManager.removeBricks(topRight, bottomRight);
        }
    }

    /**
     * Given a canvas, this returns true if either corner of the ball touches the paddle.
     * It also makes the ball bounce off the paddle.
     */
    private boolean hitPaddle(CanvasWindow canvas, Paddle paddle){
        
        Point bottomLeft = new Point(centerX - BALL_RADIUS, centerY + BALL_RADIUS);
        Point bottomRight = new Point(centerX + BALL_RADIUS, centerY + BALL_RADIUS);

        if(canvas.getElementAt(bottomLeft) instanceof Paddle || canvas.getElementAt(bottomRight) instanceof Paddle){
            speedY *=-1; 
            return true; 
        }else{
            return false; 
        }
    }

    /**
     * This resets the position of the ball to the middle of the given canvas.
     */
    public void resetPosition(CanvasWindow canvas){
        this.setCenter(canvas.getWidth()/2, canvas.getHeight()/2);
        centerX = canvas.getWidth()/2;
        centerY = canvas.getHeight()/2;
    }

    public double getCenterX(){
        return centerX;
    }

    public double getCenterY(){
        return centerY;
    }
}
