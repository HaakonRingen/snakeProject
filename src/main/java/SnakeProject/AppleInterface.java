package SnakeProject;

import java.util.ArrayList;

public interface AppleInterface {
    public void placeApple(ArrayList<XYValues> snakeBody);

   public XYValues getPosition();
   
   public int getXValue();

  public  int getYValue();
}