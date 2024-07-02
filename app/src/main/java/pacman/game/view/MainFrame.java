/*
  VinUniversity
  Course: COMP1020 - Object-Oriented Programming & Data Structures
  Semester: Spring 2024
  Assessment: Term Project
  Author: Team 3
*/
package pacman.game.view;

import javax.swing.JFrame;
import pacman.game.controller.GameController;
import pacman.game.model.Game;

public class MainFrame extends JFrame {
    public MainFrame() {
        Game game = new Game();
        GamePanel gamePanel = new GamePanel(game);
        add(gamePanel);

        GameController controller = new GameController(game);
        addKeyListener(controller);

        setTitle("Pac-Man Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}
