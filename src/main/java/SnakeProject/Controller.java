package SnakeProject;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;





public class Controller {



    private Timeline timeline;
    private SnakeBody snakeBody;
    private Apple apple;
    private boolean gameover = false;
    private HighScoreManager highScoreManager = new HighScoreManager();



    @FXML
    private Label score;

 

    @FXML
    private GridPane grid;

    @FXML
    private Button restartButton;

    @FXML
    private Label highScore;


    @FXML
    private Button stopButton;

    @FXML
    private Button startButton;

  


    public void startsnake() {
        
        stopButton.setVisible(true);
        restartButton.setVisible(false);
        startButton.setVisible(false);
        
        snakeBody = new SnakeBody();
        apple = new Apple(snakeBody);
        drawSnake(snakeBody);
        drawApple();
 

        this.timeline = new Timeline(new KeyFrame(Duration.seconds(0.08), event -> {
            if (!gameover) {
                highScore.setText("");
                grid.setVisible(true);

            if (snakeBody.appleEaten(apple)) {
                snakeBody.moveSnake();


                apple = new Apple(snakeBody);
                drawApple();
            }

            else {
                snakeBody.moveSnake();
                snakeBody.getSnakeList().remove(0);
            }

            grid.getChildren().removeIf(node -> node instanceof Rectangle);
            drawSnake(snakeBody);

            if (snakeBody.collidesWithSelf() || snakeBody.collidesWithWall()) {
                gameover = true;
                timeline.stop();
                startButton.setVisible(false);
                stopButton.setVisible(false);
                restartButton.setVisible(true);
                grid.setVisible(false);
                updateHighScore();
                
            }
            updateScore();


            writeHighScoreToFile();
        
        

        
        }}));
    timeline.setCycleCount(Timeline.INDEFINITE); // Gjenta tidslinjen uendelig
    timeline.play();
    
        
    }




    @FXML
    public void KeyPressed(KeyEvent event) {
        KeyCode code = event.getCode();
        switch (code) {
            case W:
                snakeBody.changeDirection('U');
                break;
            case S:
                snakeBody.changeDirection('D');
                break;
            case A:
                snakeBody.changeDirection('L');
                break;
            case D:
                snakeBody.changeDirection('R');
                break;
            default:
                // Håndter andre tastetrykk om nødvendig
                break;
        }
    }


    public void restart() {
        highScore.setText("");
        gameover = false;
        grid.getChildren().removeIf(node -> node instanceof Rectangle);
        restartButton.setVisible(false);
        startButton.setVisible(true);

    }

    public void writeHighScoreToFile() {
        if (snakeBody.getScore() > highScoreManager.readFromFile()) {
            highScoreManager.writeToFile("New highscore: " + snakeBody.getHighScore());
        }
    }

    public void updateScore() {
        score.setText( snakeBody.getScore() + ":)");
   
   
    }

    public void updateHighScore() {
        highScore.setText("Best Score : " + highScoreManager.readFromFile() + "!");
    }
        
    



  

       


    

    public void stopTimeline() {
        if (timeline != null) {
            timeline.stop();
            stopButton.setVisible(false);
            startButton.setVisible(true);
            restartButton.setVisible(true);
        }
    }

     public void drawApple() {
        grid.getChildren().removeIf(node -> node instanceof Circle);
        Circle apple1 = new Circle(20);
        apple1.setFill(Color.RED);

        grid.add(apple1, apple.getXValue(), apple.getYValue());

    }



    public void drawSnake(SnakeBody snake) {
        Rectangle snakeHead = new Rectangle(40,40);
        snakeHead.setFill(javafx.scene.paint.Color.BROWN);
        XYValues snakeheadxy = snake.getSnakeList().get(snake.getSnakeList().size() -1);
        if(snakeheadxy.getXValue()>=0 && snakeheadxy.getYValue()>=0 && snakeheadxy.getXValue()<=12 && snakeheadxy.getYValue()<=12){
            grid.add(snakeHead, snakeheadxy.getXValue(), snakeheadxy.getYValue());
        }

        for (int i = 0; i < snake.getSnakeList().size() -1; i++) {
            Rectangle snakebody = new Rectangle(40,40);
            snakebody.setFill(Color.GOLD);
            if (snake.getSnakeList().get(i).getXValue() >= 0 && snake.getSnakeList().get(i).getYValue() >= 0) {
                grid.add(snakebody,snake.getSnakeList().get(i).getXValue(),snake.getSnakeList().get(i).getYValue());
            }

        }
    }
    

   

    

    
    
  





}
