package cf.prj1point.app;

import cf.prj1point.model.PointXYZ;

public class PointXYZApp {
    public static void main(String[] args) {
        PointXYZ p1 = new PointXYZ(10, 2, 20);
        PointXYZ p2 = new PointXYZ(50, 0, 75);

        PointXYZ p3 = PointXYZ.probableZero();

        System.out.println(p1.convertToString());
        System.out.println(p2.convertToString());
        System.out.println(p3.convertToString());
    }
}
