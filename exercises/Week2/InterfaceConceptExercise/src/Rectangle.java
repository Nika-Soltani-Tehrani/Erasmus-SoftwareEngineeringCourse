import java.awt.*;

public class Rectangle implements Comparable<Rectangle> {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calculateArea(){
        return width * height;
    }

    @Override
    public int compareTo(Rectangle other) {
        double area1 = width * height;
        double area2 = other.width * other.height;
        return Double.compare(area1, area2);
    }
}
