/**
 * Immutable point representing a 3D point
 */
public class Point {

    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z){

        this.x = x;
        this.y = y;
        this.z = z;

    }
    public double x(){return x;}
    public double y(){return y;}
    public double z(){return z;}

    public Point translate(Axis axis, double distance){

        switch(axis){
            case X:
                return new Point(x+distance,y,z);
            case Y:
                return new Point(x,y+distance,z);
            case Z:
                return new Point(x,y,z+distance);
            default:
                return this;
        }
    }
    public static double distanceBetween(Point p0, Point p1){

        double deltaX = p0.x() - p1.x();
        double deltaY = p0.y() - p1.y();
        double deltaZ = p0.z() - p1.z();

        return Math.sqrt(deltaX*deltaX + deltaY*deltaY + deltaZ*deltaZ);

    }

    public String toString() {
        return "X:"+x+" Y:"+y+" Z:"+z;
    }
}
