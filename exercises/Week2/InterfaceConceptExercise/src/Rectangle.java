public class Rectangle implements MyComparable<Rectangle> {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }

    @Override
    public int compareTo(Rectangle other) {
        double area1 = this.calculateArea();
        double area2 = other.calculateArea();
        return Double.compare(area1, area2);
    }
}
