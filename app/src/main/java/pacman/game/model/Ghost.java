/*
  VinUniversity
  Course: COMP1020 - Object-Oriented Programming & Data Structures
  Semester: Spring 2024
  Assessment: Term Project
  Author: Team 3
*/
package pacman.game.model;

import java.util.List;
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
    private int moveCounter;
    private int moveFrequency; // Number of updates before moving

    public Ghost(Grid grid, Type type) {
        this.grid = grid;
        this.random = new Random();
        this.type = type;
        this.moveFrequency = 11; // Adjust this value to change speed
        initializeRandomPosition();
    }

    private void initializeRandomPosition() {
        int rows = grid.dots.length;
        int cols = grid.dots[0].length;
        do {
            x = random.nextInt(rows);
            y = random.nextInt(cols);
        } while (!grid.isValidMove(x, y));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Type getType() {
        return type;
    }

    public void moveChaseMode(PacMan pacMan) {
        moveCounter++;
        if (moveCounter >= moveFrequency) {
            moveCounter = 0;

            int targetX = pacMan.getX();
            int targetY = pacMan.getY();

            List<int[]> path = grid.bfs(x, y, targetX, targetY);
            if (path != null && !path.isEmpty()) {
                int[] nextMove = path.get(0);
                x = nextMove[0];
                y = nextMove[1];
            }
        }
    }

    public void moveNormalMode() {
        moveCounter++;
        if (moveCounter >= moveFrequency) {
            moveCounter = 0;

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
    }
}
