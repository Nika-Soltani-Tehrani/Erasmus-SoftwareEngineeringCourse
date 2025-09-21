public class Rectangle {

    private double width;
    private double height;

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calculateArea(){
        return width * height;
    }
}
