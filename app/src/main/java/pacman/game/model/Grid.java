/*
  VinUniversity
  Course: COMP1020 - Object-Oriented Programming & Data Structures
  Semester: Spring 2024
  Assessment: Term Project
  Author: Team 3
*/
package pacman.game.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Grid {
    public Dot[][] dots;
    public PowerPellet[][] powerPellets;
    private int[][] walls;

    public Grid() {
        String[] map = {
            "####################",
            "#         #        #",
            "# ## ### # ### ### #",
            "# ## ### # ### ### #",
            "#                  #",
            "# ### # #### # ### #",
            "#     # #### #     #",
            "#### #   #    # ####",
            "#### ### # #### ####",
            "#### #        # ####",
            "#### #        # ####",
            "#### #   #    # ####",
            "#### ### # #### ####",
            "#        #         #",
            "# ## ### # ### ### #",
            "#  #          #    #",
            "#   #     #     #  #",
            "# ###### # ####### #",
            "#                  #",
            "####################"
        };

        int rows = map.length;
        int cols = map[0].length();
        dots = new Dot[rows][cols];
        powerPellets = new PowerPellet[rows][cols];
        walls = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = map[i].charAt(j);
                dots[i][j] = new Dot(i, j);
                if ((i + j) % 7 == 0) {
                    powerPellets[i][j] = new PowerPellet(i, j);
                }
                if (c == '#') {
                    walls[i][j] = 1;
                } else if (c == ' ') {
                    //                    dots[i][j] = new Dot(i, j);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(walls[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Dot getDot(int x, int y) {
        if (x >= 0 && x < dots.length && y >= 0 && y < dots[0].length) {
            return dots[x][y];
        }
        return null;
    }

    public PowerPellet getPowerPellet(int row, int col) {
        return powerPellets[row][col];
    }

    public boolean isValidMove(int x, int y) {
        return x >= 0 && x < dots.length && y >= 0 && y < dots[0].length && walls[x][y] == 0;
    }

    public int getRemainingDots() {
        int count = 0;
        for (Dot[] row : dots) {
            for (Dot dot : row) {
                if (!dot.isEaten()) {
                    count++;
                }
            }
        }
        return count;
    }

    public int[][] getWalls() {
        return walls;
    }

    public List<int[]> bfs(int startX, int startY, int targetX, int targetY) {
        int rows = dots.length;
        int cols = dots[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] parentX = new int[rows][cols];
        int[][] parentY = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {startX, startY});
        visited[startX][startY] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == targetX && y == targetY) {
                List<int[]> path = new LinkedList<>();
                while (x != startX || y != startY) {
                    path.add(0, new int[] {x, y});
                    int tempX = parentX[x][y];
                    int tempY = parentY[x][y];
                    x = tempX;
                    y = tempY;
                }
                return path;
            }

            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (isValidMove(newX, newY) && !visited[newX][newY]) {
                    queue.add(new int[] {newX, newY});
                    visited[newX][newY] = true;
                    parentX[newX][newY] = x;
                    parentY[newX][newY] = y;
                }
            }
        }
        return null; // No path found
    }
}
