/*
  VinUniversity
  Course: COMP1020 - Object-Oriented Programming & Data Structures
  Semester: Spring 2024
  Assessment: Term Project
  Author: Team 3
*/
package pacman.game.model;

import java.util.Random;

public class Ghost {
    public enum Type {
        RED,
        PINK,
        BLUE,
        ORANGE
    }

    private int x, y;
    private Grid grid;
    private Random random;
    private Type type;

    public Ghost(int x, int y, Grid grid, Type type) {
        this.x = x;
        this.y = y;
        this.grid = grid;
        this.random = new Random();
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move() {
        // Simple random movement logic for ghost
        int direction = random.nextInt(4);
        switch (direction) {
            case 0:
                if (grid.isValidMove(x, y - 1)) y--; // Move up
                break;
            case 1:
                if (grid.isValidMove(x, y + 1)) y++; // Move down
                break;
            case 2:
                if (grid.isValidMove(x - 1, y)) x--; // Move left
                break;
            case 3:
                if (grid.isValidMove(x + 1, y)) x++; // Move right
                break;
        }
    }

    public Type getType() {
        return type;
    }
}
