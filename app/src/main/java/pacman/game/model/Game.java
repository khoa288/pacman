/*
  VinUniversity
  Course: COMP1020 - Object-Oriented Programming & Data Structures
  Semester: Spring 2024
  Assessment: Term Project
  Author: Team 3
*/
package pacman.game.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private PacMan pacMan;
    private List<Ghost> ghosts;
    private Grid grid;
    private int score;
    private boolean gameOver;

    public Game() {
        grid = new Grid();
        pacMan = new PacMan(10, 15, grid);
        ghosts = new ArrayList<>();
        ghosts.add(new Ghost(grid, Ghost.Type.RED));
        ghosts.add(new Ghost(grid, Ghost.Type.PINK));
        ghosts.add(new Ghost(grid, Ghost.Type.BLUE));
        ghosts.add(new Ghost(grid, Ghost.Type.ORANGE));
        score = 0;
        gameOver = false;
    }

    public void movePacManUp() {
        pacMan.setDirection(PacMan.Direction.UP);
    }

    public void movePacManDown() {
        pacMan.setDirection(PacMan.Direction.DOWN);
    }

    public void movePacManLeft() {
        pacMan.setDirection(PacMan.Direction.LEFT);
    }

    public void movePacManRight() {
        pacMan.setDirection(PacMan.Direction.RIGHT);
    }

    public void update(boolean chaseMode) {
        if (pacManAteAllDots()) {
            endGame();
            return;
        }

        pacMan.move();
        pacMan.eatDots();

        for (Ghost ghost : ghosts) {
            if (chaseMode) {
                ghost.moveChaseMode(pacMan);
            } else {
                ghost.moveNormalMode();
            }
            if (ghost.getX() == pacMan.getX() && ghost.getY() == pacMan.getY()) {
                handleCollision();
                return;
            }
        }

        score = grid.getRemainingDots();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    private boolean pacManAteAllDots() {
        return grid.getRemainingDots() == 0;
    }

    private void handleCollision() {
        endGame();
    }

    private void endGame() {
        gameOver = true;
    }

    public PacMan getPacMan() {
        return pacMan;
    }

    public List<Ghost> getGhosts() {
        return ghosts;
    }

    public Grid getGrid() {
        return grid;
    }

    public int getScore() {
        return score;
    }
}
