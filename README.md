# breakoutGame381

This implementation is based of the Comp-127 Breakout Game Homework assignment. 

Breakout was developed in 1976 by Steve Wozniak, shortly before he cofounded Apple Computer, Inc. He cited the experience of building the game as part of his inspiration in creating the Apple ][, the first commercially viable home computer.

The game
The initial configuration of the Breakout game appears in the left image below. The colored rectangles in the top part of the screen are bricks in a wall: two rows each of red, orange, yellow, green, and cyan. These colors are not required; you can choose to be creative about the colors and the size of the bricks and the number of bricks in each row.

The slightly larger rectangle at the bottom is the paddle. The paddle is in a fixed position in the vertical dimension, but moves back and forth horizontally across the screen along with the mouse until it reaches the edge of its space.

Example of breakout game

A complete Breakout game consists of three turns, or lives. On each turn, a ball is launched from the center of the window towards the bottom of the screen at a random angle. That ball bounces off of the paddle and the “side walls” of the world (left, right, and top). Thus, after two bounces — one off of the paddle and one off of the right side — the ball might have the trajectory shown in the second diagram. (Note that the dotted line is illustrative to show the ball’s path. The dotted line won’t appear on the screen.)

In the second diagram, the ball is about to collide with one of the bricks on the bottom row of the brick wall. When that happens, the ball bounces just as it does on any other collision, but the brick disappears. The third diagram shows what the game looks like after that collision and after you have moved the paddle to line it up with the oncoming ball. The play continues in this way until one of the following conditions occurs:

The ball moves below the paddle, which means that the player must have missed it with the paddle. In this case, the turn ends and the next ball is served, assuming that you have not already exhausted your allotment of three turns. If you have, the game ends in a loss.
The last brick is eliminated. In this case, the game ends immediately, and you can retire in victory.
