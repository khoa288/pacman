/*
  VinUniversity
  Course: COMP1020 - Object-Oriented Programming & Data Structures
  Semester: Spring 2024
  Assessment: Term Project
  Author: Team 3
*/
package pacman.game;

import javax.swing.SwingUtilities;
import pacman.game.view.MainFrame;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> {
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.setVisible(true);
                });
    }
}
