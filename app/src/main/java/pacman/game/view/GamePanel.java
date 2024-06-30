/*
  VinUniversity
  Course: COMP1020 - Object-Oriented Programming & Data Structures
  Semester: Spring 2024
  Assessment: Term Project
  Author: Team 3
*/
package pacman.game.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import pacman.game.model.Dot;
import pacman.game.model.Game;
import pacman.game.model.Ghost;
import pacman.game.model.PacMan;
import pacman.game.model.PowerPellet;

public class GamePanel extends JPanel {
    private Game game;

    public GamePanel(Game game) {
        this.game = game;
        setPreferredSize(new Dimension(420, 420));
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        drawDots(g);
        drawPowerPellets(g);
        drawPacMan(g);
        drawGhosts(g);
    }

    private void drawGrid(Graphics g) {
        int[][] walls = game.getGrid().getWalls();
        g.setColor(Color.BLUE);
        for (int i = 0; i < walls.length; i++) {
            for (int j = 0; j < walls[i].length; j++) {
                if (walls[i][j] == 1) {
                    g.fillRect(i * 20, j * 20, 20, 20);
                }
            }
        }
    }

    private void drawDots(Graphics g) {
        for (int i = 0; i < game.getGrid().dots.length; i++) {
            for (int j = 0; j < game.getGrid().dots[i].length; j++) {
                Dot dot = game.getGrid().getDot(i, j);
                if (!dot.isEaten()) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(dot.getX() * 20 + 8, dot.getY() * 20 + 8, 4, 4);
                }
            }
        }
    }

    private void drawPowerPellets(Graphics g) {
        for (int i = 0; i < game.getGrid().powerPellets.length; i++) {
            for (int j = 0; j < game.getGrid().powerPellets[i].length; j++) {
                PowerPellet powerPellet = game.getGrid().getPowerPellet(i, j);
                if (powerPellet != null && !powerPellet.isEaten()) {
                    g.setColor(Color.RED);
                    g.fillOval(powerPellet.getX() * 20 + 5, powerPellet.getY() * 20 + 5, 10, 10);
                }
            }
        }
    }

    private void drawPacMan(Graphics g) {
        PacMan pacMan = game.getPacMan();
        g.setColor(Color.YELLOW);
        g.fillArc(pacMan.getX() * 20, pacMan.getY() * 20, 20, 20, 45, 270);
    }

    private void drawGhosts(Graphics g) {
        for (Ghost ghost : game.getGhosts()) {
            switch (ghost.getType()) {
                case RED:
                    g.setColor(Color.RED);
                    break;
                case PINK:
                    g.setColor(Color.PINK);
                    break;
                case BLUE:
                    g.setColor(Color.CYAN);
                    break;
                case ORANGE:
                    g.setColor(Color.ORANGE);
                    break;
            }
            g.fillOval(ghost.getX() * 20, ghost.getY() * 20, 20, 20);
        }
    }
}
