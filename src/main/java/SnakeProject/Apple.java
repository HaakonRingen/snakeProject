package SnakeProject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Apple implements AppleInterface  {
    private static final int GRID_WIDTH = 12;
    private static final int GRID_HEIGHT = 12;

    private ArrayList<XYValues> possiblePlaces = new ArrayList<>();
    private XYValues apple;
    private Random random;

    public Apple(SnakeBody snakeBody) {
        for (int x = 0; x < GRID_WIDTH; x++) {
            for (int y = 0; y < GRID_HEIGHT; y++) {
                possiblePlaces.add(new XYValues(x, y));
            }
        }
        random = new Random();
        placeApple(snakeBody.getSnakeList());
    }

    public void placeApple(ArrayList<XYValues> snakeBody) {
        Iterator<XYValues> iterator = possiblePlaces.iterator();
        while (iterator.hasNext()) {
            XYValues compare = iterator.next();
            for (XYValues first : snakeBody) {
                if (first.getXValue() == compare.getXValue() && first.getYValue() == compare.getYValue()) {
                    iterator.remove();
                }
            }
        }

        if (possiblePlaces.isEmpty()) {
            System.out.println("Ingen flere ledige plasser");
            return;
        }

        XYValues randomPlace = possiblePlaces.get(random.nextInt(possiblePlaces.size()));
        apple = randomPlace;
    }

    public XYValues getPosition() {
        return apple;
    }

    public int getXValue() {
        return apple.getXValue();
    }

    public int getYValue() {
        return apple.getYValue();
    }

    public static void main(String[] args) {
        SnakeBody snakeBody = new SnakeBody();
        Apple apple = new Apple(snakeBody);
        System.out.println(apple.getXValue());
        System.out.println(apple.getYValue());
    }

   

}



