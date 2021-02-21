package PointInRectangle;

/**
 * Created by Zlatimir Ivanov on 21.2.2021 г..
 */

public class Rectangle {
    private PointInRectangle.Point bottomLeft;
    private PointInRectangle.Point upperRight;

    public Rectangle(PointInRectangle.Point bottomLeft, PointInRectangle.Point upperRight) {
        this.bottomLeft = bottomLeft;
        this.upperRight = upperRight;
    }

    public  boolean isIn(PointInRectangle.Point point){
        return point.isGreater(upperRight) && point.isLess(bottomLeft);
    }
}
