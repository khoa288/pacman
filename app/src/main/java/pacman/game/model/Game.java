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

    public Game() {
        grid = new Grid();
        pacMan = new PacMan(10, 15, grid);
        ghosts = new ArrayList<>();
        ghosts.add(new Ghost(grid, Ghost.Type.RED));
        ghosts.add(new Ghost(grid, Ghost.Type.PINK));
        ghosts.add(new Ghost(grid, Ghost.Type.BLUE));
        ghosts.add(new Ghost(grid, Ghost.Type.ORANGE));
        score = 0;
    }

    public void movePacManUp() {
        pacMan.moveUp();
    }

    public void movePacManDown() {
        pacMan.moveDown();
    }

    public void movePacManLeft() {
        pacMan.moveLeft();
    }

    public void movePacManRight() {
        pacMan.moveRight();
    }

    //    public void update() {
    //        pacMan.eatDots();
    //        for (Ghost ghost : ghosts) {
    //            ghost.move();
    //            if (ghost.getX() == pacMan.getX() && ghost.getY() == pacMan.getY()) {
    //                // Handle collision with ghosts
    //            }
    //        }
    //        score = grid.getRemainingDots();
    //    }
    public void update() {
        pacMan.eatDots();
        for (Ghost ghost : ghosts) {
            ghost.move(pacMan);
            if (ghost.getX() == pacMan.getX() && ghost.getY() == pacMan.getY()) {
                // Handle collision with ghosts
            }
        }
        score = grid.getRemainingDots();
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
