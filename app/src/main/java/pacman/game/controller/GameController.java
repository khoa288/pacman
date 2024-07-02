/*
  VinUniversity
  Course: COMP1020 - Object-Oriented Programming & Data Structures
  Semester: Spring 2024
  Assessment: Term Project
  Author: Team 3
*/
package pacman.game.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import pacman.game.model.Game;
import pacman.game.model.PacMan;

public class GameController extends KeyAdapter {
    private Game game;

    public GameController(Game game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        PacMan pacMan = game.getPacMan();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                pacMan.setDirection(PacMan.Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                pacMan.setDirection(PacMan.Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                pacMan.setDirection(PacMan.Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                pacMan.setDirection(PacMan.Direction.RIGHT);
                break;
        }
    }
}
