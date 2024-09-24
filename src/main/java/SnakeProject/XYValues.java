package SnakeProject;



public class XYValues {

    private int xValues; 
    private int yValues;


    public XYValues(int x, int y) {
        if (x < -1 || x > 13|| y < -1 || x > 13) {
            throw new IndexOutOfBoundsException("Out of range");
        }

        this.xValues = x;
        this.yValues = y;
    }

    public int getXValue() {
        return xValues;
    }

    public int getYValue() {
        return yValues;
    }

    public void setXValue(int x) {
        this.xValues = x;

    }
    public void setYValue(int y) {
        this.yValues = y;

    }


    
}
