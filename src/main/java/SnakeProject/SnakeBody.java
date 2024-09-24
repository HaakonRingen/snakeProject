package SnakeProject;


import java.util.ArrayList;

public class SnakeBody  {

    private ArrayList<XYValues> snakebody;
    private char direction;
    private int score;
    private int highScore;




    public SnakeBody() {
        score = 0;
        snakebody = new ArrayList<>();
        snakebody.add(new XYValues(0, 0));
        snakebody.add(new XYValues(1, 0));
        direction = 'R';


       

    }





    public void moveSnake() {
        XYValues head = snakebody.get(snakebody.size() -1);
        int headX = head.getXValue();
        int headY = head.getYValue();


       

        switch (direction) {
            case 'R': snakebody.add(new XYValues(headX +1, headY));
            break;
            case 'L': snakebody.add(new XYValues(headX -1, headY));
            break;
            case 'U': snakebody.add(new XYValues(headX , headY -1));
            break;
            case 'D': snakebody.add(new XYValues(headX, headY +1));
            break;
        }
    }
   

       

        

        public boolean appleEaten(Apple apple) {
         if (snakebody.get(snakebody.size() -1).getXValue() == apple.getXValue() && snakebody.get(snakebody.size() -1).getYValue() == apple.getYValue()) {  
            score ++;
            return true;
            

        }
        return false;
    
        
    }


    public int getScore() {
        return score;
    }

    public int getHighScore() {
        if (score > highScore) {
            highScore = score;
        }
        return highScore;
    }

    public int getHigh() {
        return highScore;
    }





        

        public boolean collidesWithSelf() {
            for (int i = 1; i < snakebody.size() - 1; i++) {
                XYValues part = snakebody.get(i);
                if (snakebody.get(snakebody.size() -1).getXValue() == part.getXValue() && snakebody.get(snakebody.size() -1).getYValue() == part.getYValue()) {
                    return true;
                }
            }
            return false;
        }

        public boolean collidesWithWall() {
            int x = snakebody.get(snakebody.size() -1).getXValue();
            int y = snakebody.get(snakebody.size() -1).getYValue();
            return x < 0 || x >= 13 || y < 0 || y >= 13;
        }

        public void changeDirection(char NewDirection) {
            if ((direction == 'U' || direction == 'D') && (NewDirection == 'L' || NewDirection == 'R') || (direction == 'L' || direction == 'R') && (NewDirection == 'U' || NewDirection == 'D')) {
                direction = NewDirection;
            }

        }

        public ArrayList<XYValues> getSnakeList() {
            return snakebody;
        }



    }
    

