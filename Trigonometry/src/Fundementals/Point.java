package Fundementals;

/**
 * Immutable point representing a 3D point
 */
public class Point {

    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z){ // 3D
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Point(double x, double y){ // 2D (in 3D space)
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    public double x(){return x;}
    public double y(){return y;}
    public double z(){return z;}

    public Point move(double x, double y, double z){
        return new Point(x,y,z);
    }
    public Point add(Axis axis, double distance){

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
    public Point add(double dx, double dy, double dz){
        return new Point(x+dx,y+dy,z+dz);
    }
    public Point add(Point p){ return new Point(x+p.x(),y+p.y(),z+p.z()); }

    public static Point combine(Point p0, Point p1){
        return new Point(p0.x()+p1.x(),p0.y()+p1.y(),p0.z()+p1.z());
    }

    public Point scale(double scale){ return new Point(x*scale, y*scale, z*scale); }

    public static double distanceBetween(Point p0, Point p1){

        double deltaX = p0.x() - p1.x();
        double deltaY = p0.y() - p1.y();
        double deltaZ = p0.z() - p1.z();

        return Math.sqrt(deltaX*deltaX + deltaY*deltaY + deltaZ*deltaZ);

    }

    public String toString() {
        return "(X:"+x+" Y:"+y+" Z:"+z+")";
    }
}
