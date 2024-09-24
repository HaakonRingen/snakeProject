package SnakeProject;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;



public class SnakeTest {
    

    @Test
    public void testWriteAndReadFromFile() {
        HighScoreManager highScoreManager = new HighScoreManager();
        String message = "New highscore: 100";

        // Skriv highscore til fil
        highScoreManager.writeToFile(message);

        // Les highscore fra fil og sammenlign
        int actualHighScore = highScoreManager.readFromFile();
        assertEquals(100, actualHighScore, "High score should be 100 after writing to file");
    }

   

    @Test
    public void testMoveSnake() {
        SnakeBody snake = new SnakeBody();
        ArrayList<XYValues> initialSnake = new ArrayList<>(snake.getSnakeList());

        // Flytt slangen
        snake.moveSnake();

        // Sjekk om slangen har flyttet seg
        ArrayList<XYValues> updatedSnake = snake.getSnakeList();
        assertNotEquals(initialSnake, updatedSnake, "Snake should have moved");
    }


    @Test
    public void testInitialScore() {
        SnakeBody snake = new SnakeBody();
        assertEquals(0, snake.getScore(), "Initial score should be 0");
    }


    @Test
    public void testCollidesWithWall() {
        SnakeBody snake = new SnakeBody();

        // Flytt slangen til kanten av spillområdet
        for (int i = 0; i < 12; i++) {
            snake.moveSnake();
        }

        // Sjekk om slangen kolliderer med veggen
        boolean collidesWithWall = snake.collidesWithWall();
        assertTrue(collidesWithWall, "Snake should collide with the wall");
    }

    @Test
    public void testPlaceApple() {
        SnakeBody snake = new SnakeBody();
        Apple apple = new Apple(snake);

        // Sjekk om eplet er plassert i et gyldig område
        int appleX = apple.getXValue();
        int appleY = apple.getYValue();
        assertTrue(appleX >= 0 && appleX < 13 && appleY >= 0 && appleY < 12,
                   "Apple should be placed within the game grid");
    }

    @Test
    public void testGetPosition() {
        SnakeBody snake = new SnakeBody();
        Apple apple = new Apple(snake);

        // Sjekk om getPosition-metoden returnerer en gyldig posisjon
        XYValues position = apple.getPosition();
        assertNotNull(position, "Apple position should not be null");
    }
}


