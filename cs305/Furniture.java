package cs305;

public class Furniture {
    private String type;
    private double width;
    private double length;
    private double height;


    public Furniture(String type, double width, double length, double height) {
        this.type = type;
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
