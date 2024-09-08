package lab2.src;

public class Cylinder extends GeoBasicClass {
    private double radius;
    private double height;

    public Cylinder() {
        this.radius = 0;
        this.height = 0;
    }

    public Cylinder(double radius, double height) {
        if (radius < 0.0 || height < 0.0) {
            throw new IllegalArgumentException("Одно из значений не может быть отрицательным");
        }
        this.radius = radius;
        this.height = height;
        recalculateGeometry();
    }

    public Cylinder(double radius) {
        if (radius < 0.0) {
            throw new IllegalArgumentException("Радиус не может быть отрицательным");
        }
        this.radius = radius;
    }

    @Override
    protected void recalculateGeometry() {
        if (this.height != 0 && this.radius != 0) {
            this.volume = PI * Math.pow(radius, 2) * height;
            this.surfaceArea = 2 * PI * radius * (radius + height);
        } else {
            System.out.println("Одно из значений равно нулю");
        }
    }

    public void setRadius(double radius) {
        if (radius < 0.0) {
            throw new IllegalArgumentException("Радиус не может быть отрицательным");
        }
        this.radius = radius;
        recalculateGeometry();
    }

    public void setHeight(double height) {
        if (height < 0.0) {
            throw new IllegalArgumentException("Высота не может быть отрицательной");
        }
        this.height = height;
        recalculateGeometry();
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }
}
