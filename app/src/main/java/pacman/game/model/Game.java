/*
  VinUniversity
  Course: COMP1020 - Object-Oriented Programming & Data Structures
  Semester: Spring 2024
  Assessment: Term Project
  Author: Team 3
*/
package pacman.game.model;

public class Game {
    private Grid grid;
    private PacMan pacMan;
    private Ghost[] ghosts;

    public Game() {
        grid = new Grid();
        pacMan = new PacMan();
        ghosts = new Ghost[] {new Ghost(), new Ghost(), new Ghost(), new Ghost()}; // Four ghosts
    }

    public void update() {
        // Update game state: move PacMan, check collisions, etc.
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public PacMan getPacMan() {
        return pacMan;
    }

    public void setPacMan(PacMan pacMan) {
        this.pacMan = pacMan;
    }

    public Ghost[] getGhosts() {
        return ghosts;
    }

    public void setGhosts(Ghost[] ghosts) {
        this.ghosts = ghosts;
    }
}
