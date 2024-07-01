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
        this.direction = Direction.RIGHT; // Default direction
    }

    //    public PacMan(int startX, int startY, Grid grid) {
    //        this.x = startX;
    //        this.y = startY;
    //        this.grid = grid;
    //    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveUp() {
        if (grid.isValidMove(x, y - 1)) {
            y--;
            direction = Direction.UP;
        }
    }

    public void moveDown() {
        if (grid.isValidMove(x, y + 1)) {
            y++;
            direction = Direction.DOWN;
        }
    }

    public void moveLeft() {
        if (grid.isValidMove(x - 1, y)) {
            x--;
            direction = Direction.LEFT;
        }
    }

    public void moveRight() {
        if (grid.isValidMove(x + 1, y)) {
            x++;
            direction = Direction.RIGHT;
        }
    }

    public void eatDots() {
        Dot dot = grid.getDot(x, y);
        if (dot != null && !dot.isEaten()) {
            dot.eat();
        }

        PowerPellet powerPellet = grid.getPowerPellet(x, y);
        if (powerPellet != null && !powerPellet.isEaten()) {
            powerPellet.eat();
            // Handle power pellet effect
        }
    }
}
