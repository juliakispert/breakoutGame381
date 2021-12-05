package breakout;


// import comp127graphics.CanvasWindow;
// import comp127graphics.GraphicsGroup;
// import comp127graphics.GraphicsText;
import edu.macalester.graphics.*;
import java.awt.*;


/**
 * The game of Breakout.
 */
public class BreakoutGame {

    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;

    private static CanvasWindow canvas;
    private static Paddle paddle;
    private static BrickWall brickWall;
    private static Ball ball;
    public static int lives;
    private static GraphicsGroup brickWallDrawing;
    private static GraphicsText lose, win, playAgain;

    /* sets up breakOut Game and creates graphics, sets lives to 3 and sends data to create the background and to run game */
    public BreakoutGame() {
        this.canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        this.paddle = new Paddle(CANVAS_WIDTH / 2, CANVAS_HEIGHT - 50, CANVAS_WIDTH / 10, CANVAS_HEIGHT / 80);
        this.brickWall = new BrickWall(CANVAS_WIDTH * .05, CANVAS_HEIGHT * .2, canvas);
        this.ball = new Ball(CANVAS_WIDTH, CANVAS_HEIGHT);
        brickWallDrawing = new GraphicsGroup();
        lose = new GraphicsText();
        win = new GraphicsText();
        playAgain = new GraphicsText();
        lives = 3;
        createGameScreen();
        runBreakoutGame();

    }

    /* adds graphics elements to canvas, except for text which will be added when needed */
    public static void createGameScreen() {
        canvas.removeAll();
        lives =3;
        paddle.addToCanvas(canvas);
        ball.addToCanvas(canvas);
        brickWall.addToGraphicsGroup(brickWallDrawing);
        canvas.add(brickWallDrawing);
        lose.setFontSize(20);
        lose.setFillColor(Color.black);
        lose.setCenter(250, CANVAS_HEIGHT / 3);
        win.setFontSize(20);
        win.setFillColor(Color.black);
        win.setCenter(250, CANVAS_HEIGHT / 3);
        playAgain.setFontSize(10.0);
        playAgain.setFillColor(Color.black);
        playAgain.setCenter(250, CANVAS_HEIGHT / 2);
        brickWallDrawing.add(lose);
        brickWallDrawing.add(win);
        brickWallDrawing.add(playAgain);


    }

    /* streams that run game. One moves paddle when mouse moves and the other moves ball while it still has lives and there are still are still bricks in the wall*/
    public void runBreakoutGame() {
        canvas.onMouseMove(event -> paddle.setCurrentPosition());
        canvas.animate(() -> {
            if (lives > 0 && brickWall.getAllBricks().size() > 0) {
                ball.updatePositionOfBall();
            }
            else {
                endGame();
            }
        });


    }

    /* checks if ball hits paddle*/
    public static boolean ballHitsPaddle() {
        return ball.getCenterX() > paddle.getLeftCornerX() && ball.getCenterX() < paddle.getRightCornerX() && ball.getBottomCornersY() > paddle.getYOfTop();
    }

    /* checks if ball hits brick*/
    public static boolean ballHitBrick() {
        for (BrickRow brickRow : brickWall.getBrickRows()) {
            if (ball.getTopCornersY() < (brickRow.getYLocation() + Brick.brickHeight / 2) && (ball.getBottomCornersY() > (brickRow.getYLocation() - Brick.brickHeight / 2))) {
                for (Brick brick : brickRow.getBricks()) {
                    if (brick.getLeftCornerBrick() <= (ball.getCenterX() + ball.BALL_RADIUS) && brick.getRightCornerBrick() >= (ball.getCenterX() - ball.BALL_RADIUS)) {
                        brick.removeFromGraphicsGroup(brickWallDrawing);
                        brickRow.removeBrick(brick);
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /* creates new turn when ball hits the bottom of the canvas (this method is called by ball)*/
    public static void newTurn(){
        lives--;
        ball.removeFromCanvas(canvas);
        if (lives > 0) {
            canvas.pause(1000);
            ball = new Ball(CANVAS_WIDTH, CANVAS_HEIGHT);
            ball.addToCanvas(canvas);
            canvas.pause(1000);
        }
    }

    /* ends game and tells user outcome(if they won or lose)*/
    public static void endGame() {
        if (brickWall.getAllBricks().size() > 0) {
            canvas.pause(1000);
            lose.setText("You Lose");
            canvas.pause(1000);
        } else {
            win.setText("You win!");
            brickWallDrawing.add(win);
            canvas.pause(1000);

        }
        brickWallDrawing.add(playAgain);
        playAgain.setText("Thanks for Playing!");
        canvas.pause(1000);
    }

    /* returns width*/

    public static int getCanvasWidth() {
        return CANVAS_WIDTH;
    }
/* main method */
    public static void main(String[] args) {
        new BreakoutGame();

    }


}
