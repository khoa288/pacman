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
import pacman.game.view.GamePanel;

public class GameController extends KeyAdapter {
    private Game game;
    private GamePanel gamePanel;

    public GameController(Game game, GamePanel gamePanel) {
        this.game = game;
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                game.movePacManUp();
                break;
            case KeyEvent.VK_DOWN:
                game.movePacManDown();
                break;
            case KeyEvent.VK_LEFT:
                game.movePacManLeft();
                break;
            case KeyEvent.VK_RIGHT:
                game.movePacManRight();
                break;
        }
        game.update();
        gamePanel.repaint();
    }
}
