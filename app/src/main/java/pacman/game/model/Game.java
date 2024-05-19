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

    // Getters and other game logic methods
}
