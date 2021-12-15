package breakout;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;

/**
 * The game of Breakout.
 */
public class BreakoutGame {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;
    private static final double INTIAL_BALL_SPEED = 0.75;
    private CanvasWindow canvas;
    private Paddle paddle;
    private BrickManager brickManager;
    private int round = 0;
    private Ball ball;

    public BreakoutGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        startGame(); 
    }
    
    /*
    * sets up the start of the game by creating all elements 
    */
    public void startGame(){
        paddle = new Paddle(canvas);
        paddle.setFillColor(Color.BLACK);
        brickManager = new BrickManager(canvas);
        ball = new Ball(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2, INTIAL_BALL_SPEED);
        canvas.add(ball);
        restartRound();
        run();
    }

    /*
    * runs main movememnt function of game
    */
    public void run() {
        canvas.onMouseMove(event -> paddle.movePaddle(event.getPosition()));
        canvas.animate(() -> {
            if (brickManager.getTotalBricks() != brickManager.getNumOfBricksRemoved()) {
                gameInProgress();
                if (brickManager.getTotalBricks() == brickManager.getNumOfBricksRemoved()) {
                    tellUserGameHasEnded("You won!", ball);
                }
            }
        });
    }

    public static void main(String[] args) {
        new BreakoutGame();
    }

    /**
     * This method restart round or resume rounds depending on the ball's postion.
     * It will inform the user that they have lost if 3 rounds have been played.
     */
    private void gameInProgress() {
        if (round < 3) {
            if (!(ball.getCenterY() > paddle.getY() + CANVAS_HEIGHT * .1)) {
                for (int i = 0; i < 100; i++) {
                    ball.updatePosition(canvas, 0.1, brickManager, paddle); // making the physics time step smaller.
                }

            } else {
                restartRound();
                round = round + 1;
            }
            if (round == 3) {
                tellUserGameHasEnded("You lost. Game Over.", ball);
            }
        }
    }
    /**
     * This method check that if less than 2 rounds have been played, it will
     * reposition the ball into the middle of the canvas and also pauses for
     * 3s.
     */
    private void restartRound() {
        if (round < 2) {
            ball.resetPosition(canvas);
            canvas.draw();
            canvas.pause(3000);
        }
    }

     /**
     * Takes in a string input and shows this to the user as GraphicText. It also
     * removes the ball that it takes in as a parameter too.
     */
    private void tellUserGameHasEnded(String string, Ball ball) {
        GraphicsText text = new GraphicsText(string);
        text.setCenter(canvas.getCenter());
        canvas.add(text);
        canvas.remove(ball);
    }
}