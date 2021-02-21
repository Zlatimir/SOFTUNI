package PointInRectangle;

/**
 * Created by Zlatimir Ivanov on 21.2.2021 г..
 */

public class Point {
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean isGreater(Point point){
        return point.x >= this.x && point.y >= this.y;
    }

    public boolean isLess(Point point){
        return point.x <= this.x && point.y <= this.y;
    }
}
