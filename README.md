# BreakoutGame381

### This implementation is based of the Comp-127 Breakout Game Homework assignment. 

Breakout was developed in 1976 by Steve Wozniak, shortly before he cofounded Apple Computer, Inc. He cited the experience of building the game as part of his inspiration in creating the Apple ][, the first commercially viable home computer.

The game
The initial configuration of the Breakout game appears in the image below. The colored rectangles aka the bricks (red, orange, yellow, green, cyan, magenta, pink) are the targets.

The slightly larger rectangle at the bottom is the paddle. The paddle is in a fixed position in the vertical dimension, but moves back and forth horizontally across the screen along with the mouse until it reaches the edge of its space.

The ball will be released at an random angle and your job is to move the paddle with your mouse to prevent the ball from going off the screen and hit all the bricks. When the ball hits a brick it will disapear The ball will have 3 lives.

Note: the trajectory of the ball will change based on where it hits the brick, the paddle or the sides of the screen. 

## You will lose if: 
- you run out of lives (ball goes off the screen 3 times) 

## You will win if: 
- you hit all the bricks/ no more bricks on the screen

<img width="594" alt="Screen Shot 2021-12-15 at 3 16 00 PM" src="https://user-images.githubusercontent.com/54856485/146266126-1c84a771-e1a2-47b0-9190-9d0f368141e5.png">

## How to Play 
You can run this code in a text editor or terminal
### Specficics for our rendition: 
  Our Java rendition of Breakout Game is divided into five classes; the main class– Breakout Game– and four object classes– Ball, Paddle, BrickManager, and Brick.
  The Ball class extends an Ellipse class from the Macalester Kilt Graphics to create a ball object with variables for radius, center x and y coordinates, and initial speed. Ball’s constructor takes in values for coordinates and initial speed for the ball object and sets a random angle for its trajectory. Within Ball class there are several methods that handle ball movement, including individual methods for handling collision with the walls, bricks, or paddle. While the methods for wall and paddle collisions are simpler, just flipping the ball’s direction, any hit brick needs to be removed. So the method for hitting bricks calls on a method from a different class, Brick Manager, to remove them. Since Java recognizes Brick and Paddle as separate types, it makes handling these collisions easier.
  We use a separate Paddle class which extends Rectangle– another from the Macalester Kilt Graphics library– to create a paddle object. The constructor creates a paddle with width and height set according to the canvas’ size, placing it near the bottom of the canvas. There are only two methods in Paddle: one moves the paddle horizontally and the other returns a boolean based on whether a graphical object at any given point on the canvas is a paddle object. 
  The third of our simple classes is Brick, which creates a single brick object. Similar to the paddle, a brick is a rectangle. There are two constructors in the Brick class. The first sets the width, height, and x and y coordinates on a brick object. The second constructor also takes in x and y coordinates, but instead of width and height, it takes in a canvas object. Inside this constructor is a call to the first, using the canvas to generate proportional values for width and height. Since BrickManager handles the positioning of many brick objects, having separate constructors simplifies this placement. The only methods in Brick are getters for width and height, and most brick related operations get handled in separate classes. 
  BrickManager is responsible for adding and removing bricks from the screen. Its initial variables include a CanvasWindow, several variables pertaining to the brick wall itself, and an integer for the number of bricks removed. Like previous constructors, the constructor here uses the canvas to make the placement of objects proportional. Inside this class is a method to generate the brick wall, getters for number of bricks removed and total bricks, and methods for checking and removing bricks. The check brick method returns true if the graphical object at any given point is a brick object, and false otherwise. The method for removing bricks also updates the number of bricks removed. 
  BreakoutGame, our main class, handles basic game logic. Its constructor generates new canvas, paddle, and brickManager objects, and ties the paddle’s movement to the computer mouse. The run method starts the game by creating and adding a new ball object to the canvas and calling a method to restart a round. A method for restarting rounds checks how many rounds have been played, places the ball in the center of the canvas, and pauses for three seconds. If 3 rounds have been played, the user has lost. Until the number of bricks removed equals the total number of bricks, run continues, calling a separate method to handle the game in progress. This method checks to see if the ball’s position goes below the paddle’s, meaning the user has lost. Whenever a round is lost, the restart method is called again.
