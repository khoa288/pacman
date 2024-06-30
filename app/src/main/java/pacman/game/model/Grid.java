/*
  VinUniversity
  Course: COMP1020 - Object-Oriented Programming & Data Structures
  Semester: Spring 2024
  Assessment: Term Project
  Author: Team 3
*/
package pacman.game.model;

public class Grid {
    public Dot[][] dots;
    public PowerPellet[][] powerPellets;
    private int[][] walls;

    public Grid(int rows, int cols) {
        dots = new Dot[rows][cols];
        powerPellets = new PowerPellet[rows][cols];
        walls = new int[rows][cols];
        // Initialize dots, power pellets, and walls
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dots[i][j] = new Dot(i, j);
                if ((i + j) % 7 == 0) {
                    powerPellets[i][j] = new PowerPellet(i, j);
                }
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    walls[i][j] = 1; // Border walls
                }
                // Add additional walls as per game design
            }
        }
    }

    public Dot getDot(int row, int col) {
        return dots[row][col];
    }

    public PowerPellet getPowerPellet(int row, int col) {
        return powerPellets[row][col];
    }

    public boolean isValidMove(int x, int y) {
        return x >= 0 && x < dots.length && y >= 0 && y < dots[0].length && walls[x][y] == 0;
    }

    public int getRemainingDots() {
        int count = 0;
        for (Dot[] row : dots) {
            for (Dot dot : row) {
                if (!dot.isEaten()) {
                    count++;
                }
            }
        }
        return count;
    }

    public int[][] getWalls() {
        return walls;
    }
}
