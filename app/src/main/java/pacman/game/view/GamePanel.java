/*
  VinUniversity
  Course: COMP1020 - Object-Oriented Programming & Data Structures
  Semester: Spring 2024
  Assessment: Term Project
  Author: Team 3
*/
package pacman.game.view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import pacman.game.controller.GameController;

public class GamePanel extends JPanel implements ActionListener {
    private GameController gameController;
    private Timer timer;

    public GamePanel() {
        gameController = new GameController();
        timer = new Timer(16, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        gameController.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameController.update();
        repaint();
    }
}
