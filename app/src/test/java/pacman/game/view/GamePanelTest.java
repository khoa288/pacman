/*
  VinUniversity
  Course: COMP1020 - Object-Oriented Programming & Data Structures
  Semester: Spring 2024
  Assessment: Term Project
  Author: Team 3
*/
package pacman.game.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GamePanelTest {
    private GamePanel gamePanel;

    @BeforeEach
    public void setUp() {
        gamePanel = new GamePanel();
    }

    @Test
    public void testGamePanelInitialization() {
        assertNotNull(gamePanel.getGameController());
    }

    @Test
    public void testPaintComponent() {}

    @Test
    public void testActionPerformed() {}
}
