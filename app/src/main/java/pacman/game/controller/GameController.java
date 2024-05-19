/*
  VinUniversity
  Course: COMP1020 - Object-Oriented Programming & Data Structures
  Semester: Spring 2024
  Assessment: Term Project
  Author: Team 3
*/
package pacman.game.controller;

import java.awt.Graphics;
import pacman.game.model.Game;

public class GameController {
    private Game game;

    public GameController() {
        game = new Game();
    }

    public void update() {
        game.update();
    }

    public void draw(Graphics g) {
        // Draw the game state (PacMan, ghosts, grid, etc.)
    }
}
