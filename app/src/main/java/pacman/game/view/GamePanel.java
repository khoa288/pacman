/*
  VinUniversity
  Course: COMP1020 - Object-Oriented Programming & Data Structures
  Semester: Spring 2024
  Assessment: Term Project
  Author: Team 3
*/
package pacman.game.view;

import java.awt.*;
import javax.swing.*;
import pacman.game.model.Dot;
import pacman.game.model.Game;
import pacman.game.model.Ghost;
import pacman.game.model.PacMan;
import pacman.game.model.PowerPellet;

public class GamePanel extends JPanel {
    private Game game;
    private boolean chaseMode;
    private Timer normalModeTimer;
    private Timer chaseModeTimer;
    private Timer gameUpdateTimer; // Add game update timer

    public GamePanel(Game game) {
        this.game = game;
        this.chaseMode = false;
        setPreferredSize(new Dimension(420, 420));
        setBackground(Color.BLACK);

        // Initialize timers
        initializeTimers();
        normalModeTimer.start();

        // Initialize and start game update timer
        int gameUpdateInterval = 1000 / 60; // 60 updates per second
        gameUpdateTimer =
                new Timer(
                        gameUpdateInterval,
                        e -> {
                            game.update(chaseMode); // Pass chaseMode to update method
                            repaint();
                        });
        gameUpdateTimer.start();
    }

    private void initializeTimers() {
        normalModeTimer = new Timer(20000, e -> switchToChaseMode());
        chaseModeTimer = new Timer(5000 + (int) (Math.random() * 5000), e -> switchToNormalMode());
    }

    private void switchToChaseMode() {
        chaseMode = true;
        normalModeTimer.stop();
        chaseModeTimer.start();
    }

    private void switchToNormalMode() {
        chaseMode = false;
        chaseModeTimer.stop();
        normalModeTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.getGrid().getRemainingDots() == 0) {
            drawWinScreen(g);
        } else if (game.isGameOver()) {
            drawGameOverScreen(g);
        } else {
            drawGrid(g);
            drawDots(g);
            drawPowerPellets(g);
            drawPacMan(g);
            drawGhosts(g);
        }
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

    private void drawGameOverScreen(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        String gameOverText = "Game Over";
        String scoreText = "Score: " + game.getScore();
        int gameOverWidth = g.getFontMetrics().stringWidth(gameOverText);
        int scoreWidth = g.getFontMetrics().stringWidth(scoreText);
        g.drawString(gameOverText, getWidth() / 2 - gameOverWidth / 2, getHeight() / 2 - 24);
        g.drawString(scoreText, getWidth() / 2 - scoreWidth / 2, getHeight() / 2 + 24);
    }

    private void drawWinScreen(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Congratulations!", 100, 200);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("You won the game!", 130, 240);
        g.drawString("Score: " + game.getScore(), 160, 280);
    }
    private void drawLeaderboard(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Leaderboard", 150, 100);
        java.util.List<Integer> topScores = leaderboard.getTopScores(10);
        for (int i = 0; i < topScores.size(); i++) {
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString((i + 1) + ". " + topScores.get(i), 180, 150 + i * 30);
        }
    }
}
