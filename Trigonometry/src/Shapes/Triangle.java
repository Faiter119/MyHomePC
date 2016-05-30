package Shapes;

import Fundementals.Angle;
import Fundementals.Axis;
import Fundementals.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Triangle implements TwoDimentionalShape{

    private Point p0;
    private Point p1;
    private Point p2;

    private List<Point> points = new ArrayList<>();

    /**
     * The points with their angles
     */
    private Map<Point, Angle> angles = new HashMap<>();


    public Triangle(Point p0, Point p1, Point p2){

        this.p0 = p0;
        this.p1 = p1;
        this.p2 = p2;

        points.add(p0);
        points.add(p1);
        points.add(p2);

        angles.put(p0,Angle.of(p2,p0,p1));
        angles.put(p1,Angle.of(p0,p1,p2));
        angles.put(p1,Angle.of(p1,p2,p0));

    }
    public double height(){

        double ground = Point.distanceBetween(p0,p1);

        return 0;

    }

    public double area(){

        return 0;

    }

    public Triangle translate(Axis axis, double distance){
        return null;
    }
    public Triangle scale(double scale){
        return null;
    }

    public String toString() {

        return "["+p0+" -> "+p1+" -> "+p2+"]+\n"+Math.round(Angle.of(p2,p0,p1).degrees())+" - "+Math.round(Angle.of(p0,p1,p2).degrees())+" - "+Math.round(Angle.of(p1,p2,p0).degrees());
    }
}
