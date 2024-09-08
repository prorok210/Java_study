package lab2.src;

public class Parallelepiped extends GeoBasicClass {
    private double height;
    private double side;
    private double width;

    public Parallelepiped() {
        this.height = 0;
        this.side = 0;
        this.width = 0;
        this.volume = 0;
        this.surfaceArea = 0;
    }

    public Parallelepiped(double height, double side, double width) {
        if (height < 0.0 || side < 0.0 || width < 0.0) {
            throw new IllegalArgumentException("Одно из значений не может быть отрицательным");
        }
        this.height = height;
        this.side = side;
        this.width = width;
        recalculateGeometry();
    }

    public Parallelepiped(double height, double side){
        if (height < 0.0 || side < 0.0) {
            throw new IllegalArgumentException("Одно из значений не может быть отрицательным");
        }
        this.height = height;
        this.side = side;
    }

    public Parallelepiped(double height){
        if (height < 0.0) {
            throw new IllegalArgumentException("Высота не может быть отрицательной");
        }
        this.height = height;
    }

    public void setHeight(double height) {
        if (height < 0.0) {
            throw new IllegalArgumentException("Высота не может быть отрицательной");
        }
        this.height = height;
        recalculateGeometry();
    }

    public void setSide(double side) {
        if (side < 0.0) {
            throw new IllegalArgumentException("Сторона не может быть отрицательной");
        }
        this.side = side;
        recalculateGeometry();
    }

    public void setWidth(double width) {
        if (width < 0.0) {
            throw new IllegalArgumentException("Ширина не может быть отрицательной");
        }
        this.width = width;
        recalculateGeometry();
    }

    private double calculateVolume() {
        if (height == 0 || side == 0 || width == 0) {
            System.out.println("Одно из значений не задано");
        }
        return height * side * width;
    }

    private double calculateSurfaceArea() {
        if (height == 0 || side == 0 || width == 0) {
            System.out.println("Одно из значений не задано");
        }
        return 2 * (height * side + side * width + height * width);
    }

    @Override
    protected void recalculateGeometry() {
        if (height > 0 && side > 0 && width > 0) {
            this.volume = calculateVolume();
            this.surfaceArea = calculateSurfaceArea();
        }
    }

    public double getHeight() {
        return height;
    }

    public double getSide() {
        return side;
    }

    public double getWidth() {
        return width;
    }
}