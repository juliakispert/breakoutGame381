package breakout;

import edu.macalester.graphics.*;

import java.awt.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class BrickWall {
    private double width;
    private double height;
    private CanvasWindow canvas;
    private static final List<Color> possibleRowColors = Arrays.asList(Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA, Color.pink);
    private ArrayList<BrickRow> brickRows = new ArrayList();
    private ArrayList<Brick> brickColumns = new ArrayList();
    private ArrayList<Brick> bricks = new ArrayList();


    /* creates brick wall*/
    public BrickWall(double width, double height, CanvasWindow canvas) {

        this.width = width;
        this.height = height;
        this.canvas = canvas;
        drawBrickWall(width, height);

    }


    /*  brick wall creation, adding rows to an array list to keep track */
    public void drawBrickWall(double width, double height) {
        /* 8  because 8 rows and 8 colors */
        for (int i = 0; i < 8; i++) {
            BrickRow addingRow = new BrickRow(width, height, possibleRowColors.get(i));
            brickRows.add(addingRow);
            height = height - 10;
        }
    }


    /* adds brick wall to graphic group */
    public void addToGraphicsGroup(GraphicsGroup graphicsGroup) {
        for (BrickRow brickRow : brickRows) {
            brickRow.addToGraphicsGroup(graphicsGroup);
        }
    }

    /* returns list of all brick rows in brick wall */
    public ArrayList<BrickRow> getBrickRows() {
        return brickRows;
    }

    /* returns list of all bricks in brick wall*/
    public ArrayList<Brick> getAllBricks() {
        for (BrickRow brickRow : brickRows) {
            for (Brick brick : brickRow.getBricks())
                bricks.add(brick);
        }
        return bricks;
    }

}