/*
  VinUniversity
  Course: COMP1020 - Object-Oriented Programming & Data Structures
  Semester: Spring 2024
  Assessment: Term Project
  Author: Team 3
*/
package pacman.game.model;

public class PacMan {
    private int x, y;
    private Grid grid;
    private Direction direction;
    private int moveCounter;
    private int moveFrequency; // Number of updates before moving

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public PacMan(int startX, int startY, Grid grid) {
        this.x = startX;
        this.y = startY;
        this.grid = grid;
        this.direction = Direction.DOWN; // Default direction
        this.moveFrequency = 9; // Adjust this value to change speed
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move() {
        moveCounter++;
        if (moveCounter >= moveFrequency) {
            moveCounter = 0;
            switch (direction) {
                case UP:
                    if (grid.isValidMove(x, y - 1)) {
                        y--;
                    }
                    break;
                case DOWN:
                    if (grid.isValidMove(x, y + 1)) {
                        y++;
                    }
                    break;
                case LEFT:
                    if (grid.isValidMove(x - 1, y)) {
                        x--;
                    }
                    break;
                case RIGHT:
                    if (grid.isValidMove(x + 1, y)) {
                        x++;
                    }
                    break;
            }
        }
    }

    public int eatDots() {
        int scoreIncrement = 0;
        Dot dot = grid.getDot(x, y);
        if (dot != null && !dot.isEaten()) {
            dot.eat();
            scoreIncrement = 1;
        }

        return scoreIncrement;
    }
}
