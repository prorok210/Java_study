package lab2;

public abstract class GeoBasicClass {
    private static int counter = 0;
    public static final double PI = 3.14;
    protected double volume;
    protected double surfaceArea;

    protected GeoBasicClass() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public double getVolume() {
        return volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    protected abstract void recalculateGeometry();
}
