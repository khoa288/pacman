/*
  VinUniversity
  Course: COMP1020 - Object-Oriented Programming & Data Structures
  Semester: Spring 2024
  Assessment: Term Project
  Author: Team 3
*/
package pacman.game.model;

public class Grid {
    private int width;
    private int height;
    private char[][] layout;

    public Grid() {
        // Initialize grid with default layout or load from a file
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getLayout() {
        return layout;
    }

    public void setLayout(char[][] layout) {
        this.layout = layout;
    }

    // Methods to interact with grid
}
