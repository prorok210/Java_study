package lab2;

public class Sphere extends GeoBasicClass {
    private double radius;

    public Sphere() {
        this.radius = 0;
        this.volume = 0;
        this.surfaceArea = 0;
    }

    public Sphere(double radius) {
        if (radius < 0.0) {
            throw new IllegalArgumentException("Радиус не может быть отрицательным");
        }
        this.radius = radius;
        recalculateGeometry();
    }

    @Override
    protected void recalculateGeometry() {
        this.volume = (4.0 / 3.0) * PI * Math.pow(radius, 3);
        this.surfaceArea = 4 * PI * Math.pow(radius, 2);
    }

    public void setRadius(double radius) {
        if (radius < 0.0) {
            throw new IllegalArgumentException("Радиус не может быть отрицательным");
        }
        this.radius = radius;
        recalculateGeometry();
    }

    public double getRadius() {
        return radius;
    }
}