/*
  VinUniversity
  Course: COMP1020 - Object-Oriented Programming & Data Structures
  Semester: Spring 2024
  Assessment: Term Project
  Author: Team 3
*/
package pacman.game.model;

import java.util.List;
import java.util.Random;

public class Ghost {
    public enum Type {
        RED,
        PINK,
        BLUE,
        ORANGE
    }

    private int x, y;
    private Grid grid;
    private Random random;
    private Type type;

    //    public Ghost(int x, int y, Grid grid, Type type) {
    //        this.x = x;
    //        this.y = y;
    //        this.grid = grid;
    //        this.random = new Random();
    //        this.type = type;
    //    }
    public Ghost(Grid grid, Type type) {
        this.grid = grid;
        this.random = new Random();
        this.type = type;
        initializeRandomPosition();
    }

    private void initializeRandomPosition() {
        int rows = grid.dots.length;
        int cols = grid.dots[0].length;
        do {
            x = random.nextInt(rows);
            y = random.nextInt(cols);
        } while (!grid.isValidMove(x, y));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //    public void move() {
    //        // Simple random movement logic for ghost
    //        int direction = random.nextInt(4);
    //        switch (direction) {
    //            case 0:
    //                if (grid.isValidMove(x, y - 1)) y--; // Move up
    //                break;
    //            case 1:
    //                if (grid.isValidMove(x, y + 1)) y++; // Move down
    //                break;
    //            case 2:
    //                if (grid.isValidMove(x - 1, y)) x--; // Move left
    //                break;
    //            case 3:
    //                if (grid.isValidMove(x + 1, y)) x++; // Move right
    //                break;
    //        }
    //    }

    public Type getType() {
        return type;
    }

    //    public void move(PacMan pacMan) {
    //        // Implement BFS to find shortest path to Pac-Man
    //        Queue<int[]> queue = new ArrayDeque<>();
    //        boolean[][] visited = new boolean[grid.dots.length][grid.dots[0].length];
    //
    //        // Start BFS from ghost's current position
    //        queue.offer(new int[] {x, y});
    //        visited[x][y] = true;
    //
    //        while (!queue.isEmpty()) {
    //            int[] current = queue.poll();
    //            int cx = current[0];
    //            int cy = current[1];
    //
    //            // Check if Pac-Man is reached
    //            if (cx == pacMan.getX() && cy == pacMan.getY()) {
    //                // Implement path reconstruction if needed
    //                // Update ghost's position based on BFS result
    //                // For simplicity, move one step towards Pac-Man
    //                if (cx < x) x--;
    //                else if (cx > x) x++;
    //                else if (cy < y) y--;
    //                else if (cy > y) y++;
    //
    //                return;
    //            }
    //
    //            // Explore adjacent cells (up, down, left, right)
    //            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    //            for (int[] dir : directions) {
    //                int nx = cx + dir[0];
    //                int ny = cy + dir[1];
    //
    //                if (grid.isValidMove(nx, ny) && !visited[nx][ny]) {
    //                    queue.offer(new int[] {nx, ny});
    //                    visited[nx][ny] = true;
    //                    // Optionally, track parent for path reconstruction
    //                }
    //            }
    //        }
    //
    //        // Default behavior if no path found (e.g., random movement)
    //        int direction = random.nextInt(4);
    //        switch (direction) {
    //            case 0:
    //                if (grid.isValidMove(x, y - 1)) y--; // Move up
    //                break;
    //            case 1:
    //                if (grid.isValidMove(x, y + 1)) y++; // Move down
    //                break;
    //            case 2:
    //                if (grid.isValidMove(x - 1, y)) x--; // Move left
    //                break;
    //            case 3:
    //                if (grid.isValidMove(x + 1, y)) x++; // Move right
    //                break;
    //        }
    //    }

    public void moveChaseMode(PacMan pacMan) {
        int targetX = pacMan.getX();
        int targetY = pacMan.getY();

        // Calculate 2 blocks ahead in the direction of PacMan
        //        switch (pacMan.getDirection()) {
        //            case UP:
        //                targetY -= 2;
        //                break;
        //            case DOWN:
        //                targetY += 2;
        //                break;
        //            case LEFT:
        //                targetX -= 2;
        //                break;
        //            case RIGHT:
        //                targetX += 2;
        //                break;
        //        }

        List<int[]> path = grid.bfs(x, y, targetX, targetY);
        if (path != null && !path.isEmpty()) {
            int[] nextMove = path.get(0);
            x = nextMove[0];
            y = nextMove[1];
        }
    }

    public void moveNormalMode() {
        // Simple random movement logic for ghost
        int direction = random.nextInt(4);
        switch (direction) {
            case 0:
                if (grid.isValidMove(x, y - 1)) y--; // Move up
                break;
            case 1:
                if (grid.isValidMove(x, y + 1)) y++; // Move down
                break;
            case 2:
                if (grid.isValidMove(x - 1, y)) x--; // Move left
                break;
            case 3:
                if (grid.isValidMove(x + 1, y)) x++; // Move right
                break;
        }
    }
}
