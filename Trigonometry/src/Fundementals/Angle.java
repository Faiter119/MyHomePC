package Fundementals;

/**
 * Immutable class to represent an radians in degrees
 */

public class Angle {

    private double radians;

    public Angle(double radians){
        this.radians = radians;
    }

    public double rad(){    return radians;}
    public double degrees(){return Math.toDegrees(radians);}

    public double cos(){    return Math.cos(radians);}
    public double sin(){    return Math.sin(radians);}
    public double tan(){    return Math.tan(radians);}
    public double arcCos(){ return Math.acos(radians);}
    public double arcSin(){ return Math.asin(radians);}
    public double arcTan(){ return Math.atan(radians);}

    /**
     * Angle between 3 3D points, using p1 as the vertex
     */
    public static Angle of(Point p0, Point p1, Point p2){

        // Cosine-rule: C^2 = A^2 + B^2 - 2AB*CosAngle
        // - CosAngle = (C^2 - A^2 - B^2)2AB
        // - - angle = arcCos(A^2+B^2+C^2 / 2AB)
        // Pythagoras only for 90 degree triangles: C^2 = A^2 + B^2

        double a = Point.distanceBetween(p1,p2);            //      p2|\   } a
        double b = Point.distanceBetween(p2,p0);            //        | \  }
        double c = Point.distanceBetween(p0,p1);            //      p0|__\p1     a = Opposite side of p0 and so on

        double angle = Math.acos(((a*a) + (c*c) - (b*b))/(2*a*c));

        // System.out.println(angle);

        return new Angle(angle);
    }

    public String toString() {
        return Double.toString(degrees());
    }

    public static void main(String[] args) {

        Point p0 = new Point(0,0,0);
        Point p1 = new Point(1,0,0);
        Point p2 = new Point(1,1,0);

        System.out.println(Angle.of(p0,p1,p2).degrees());

    }
}
