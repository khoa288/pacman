/*
  VinUniversity
  Course: COMP1020 - Object-Oriented Programming & Data Structures
  Semester: Spring 2024
  Assessment: Term Project
  Author: Team 3
*/
package pacman.game.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameControllerTest {
    private GameController gameController;

    @BeforeEach
    public void setUp() {
        gameController = new GameController();
    }

    @Test
    public void testGameControllerInitialization() {
        assertNotNull(gameController.getGame());
    }

    @Test
    public void testUpdate() {
        gameController.update();
        // Add assertions to verify the state of the game after an update
    }

    @Test
    public void testDraw() {}
}
