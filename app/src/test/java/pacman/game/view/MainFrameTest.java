/*
  VinUniversity
  Course: COMP1020 - Object-Oriented Programming & Data Structures
  Semester: Spring 2024
  Assessment: Term Project
  Author: Team 3
*/
package pacman.game.view;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainFrameTest {
    private MainFrame mainFrame;

    @BeforeEach
    public void setUp() {
        mainFrame = new MainFrame();
    }

    @Test
    public void testMainFrameInitialization() {
        assertNotNull(mainFrame.getContentPane());
        assertTrue(mainFrame.getContentPane() instanceof JPanel);
    }

    @Test
    public void testTitle() {
        assertEquals("Pac-Man Game", mainFrame.getTitle());
    }

    @Test
    public void testFrameSize() {
        assertEquals(800, mainFrame.getWidth());
        assertEquals(600, mainFrame.getHeight());
    }
}
