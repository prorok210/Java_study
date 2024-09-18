package lab2;

public class Main {
    public static void main(String[] args) {
        // Сфера
        {
            Sphere sphere = new Sphere(5);
            System.out.printf("Volume: %f\n", sphere.getVolume());
            System.out.printf("Surface area: %f\n", sphere.getSurfaceArea());
            System.out.printf("Counter: %d\n", GeoBasicClass.getCounter());

            sphere.setRadius(10);
            System.out.printf("Volume: %f\n", sphere.getVolume());
            System.out.printf("Surface area: %f\n", sphere.getSurfaceArea());
            try {
                sphere.setRadius(-10);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.printf("Volume: %f\n", sphere.getVolume());
            System.out.printf("Surface area: %f\n", sphere.getSurfaceArea());
            System.out.print("\n\n\n\n");
        }
        // Цилиндр
        {
            System.out.print("Cylinder\n\n\n\n");
            Cylinder cylinder = new Cylinder(5, 10);
            System.out.printf("Volume: %f\n", cylinder.getVolume());
            System.out.printf("Surface area: %f\n", cylinder.getSurfaceArea());
            System.out.printf("Counter: %d\n", GeoBasicClass.getCounter());

            cylinder.setRadius(10);
            System.out.printf("Volume: %f\n", cylinder.getVolume());
            System.out.printf("Surface area: %f\n", cylinder.getSurfaceArea());
            System.out.printf("Counter: %d\n", GeoBasicClass.getCounter());

            try {
                cylinder.setHeight(-10);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            Cylinder cylinder1 = new Cylinder(5);
            System.out.printf("Volume: %f\n", cylinder1.getVolume());
            System.out.printf("Surface area: %f\n", cylinder1.getSurfaceArea());
            cylinder1.setHeight(5);
            System.out.printf("Volume: %f\n", cylinder1.getVolume());
            System.out.printf("Surface area: %f\n", cylinder1.getSurfaceArea());
            System.out.printf("Counter: %d\n", GeoBasicClass.getCounter());
            System.out.print("\n\n\n\n");
        }
        // Пfраллелепипед
        {
            System.out.print("Parallelepiped\n\n\n\n");
            Parallelepiped parallelepiped = new Parallelepiped(5, 10, 15);
            System.out.printf("Volume: %f\n", parallelepiped.getVolume());
            System.out.printf("Surface area: %f\n", parallelepiped.getSurfaceArea());
            System.out.printf("Counter: %d\n", GeoBasicClass.getCounter());

            parallelepiped.setHeight(10);
            System.out.printf("Volume: %f\n", parallelepiped.getVolume());
            System.out.printf("Surface area: %f\n", parallelepiped.getSurfaceArea());
            System.out.printf("Counter: %d\n", GeoBasicClass.getCounter());

            try {
                parallelepiped.setHeight(-10);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            Parallelepiped parallelepiped1 = new Parallelepiped(5, 10);
            System.out.printf("Volume: %f\n", parallelepiped1.getVolume());
            System.out.printf("Surface area: %f\n", parallelepiped1.getSurfaceArea());
            parallelepiped1.setWidth(5);
            System.out.printf("Volume: %f\n", parallelepiped1.getVolume());
            System.out.printf("Surface area: %f\n", parallelepiped1.getSurfaceArea());
            System.out.printf("Counter: %d\n", GeoBasicClass.getCounter());

            Parallelepiped parallelepiped2 = new Parallelepiped(5);
            System.out.printf("Volume: %f\n", parallelepiped2.getVolume());
            System.out.printf("Surface area: %f\n", parallelepiped2.getSurfaceArea());
            parallelepiped2.setSide(5);
            System.out.printf("Volume: %f\n", parallelepiped2.getVolume());
            System.out.printf("Surface area: %f\n", parallelepiped2.getSurfaceArea());
            System.out.printf("Counter: %d\n", GeoBasicClass.getCounter());
            parallelepiped2.setWidth(10);
            System.out.printf("Volume: %f\n", parallelepiped2.getVolume());
            System.out.printf("Surface area: %f\n", parallelepiped2.getSurfaceArea());
            System.out.printf("Counter: %d\n", GeoBasicClass.getCounter());
        }
    }
}
