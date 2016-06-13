package Shapes;

import Fundementals.Angle;
import Fundementals.Axis;
import Fundementals.Point;

public class Line {

    private Point p0;
    private Point p1;

    public Line(Point p0, Point p1){

        this.p0 = p0;
        this.p1 = p1;

    }
    public Point p0(){return p0;}
    public Point p1(){return p1;}
    public Point[] points(){ return new Point[]{p0,p1};} // new table, ie immutable

    public double length(){
        return Point.distanceBetween(p0, p1);
    }

    /**
     * Translates the line in a given direction
     */
    public Line translate(Axis axis, double distance){

        return new Line(p0.add(axis, distance),p1.add(axis, distance));

    }


    /**
     * Splits the line into 2 equal length lines.
     */
    public Line[] split(){

        // p0 -> ?, ? -> p1

        Point middle = new Point((p1.x()+p0.x())/2, (p1.y()+p0.y())/2, (p1.z()-p0.z())/2); // end+start / 2

        return new Line[]{new Line(p0,middle),new Line(middle,p1)};

    }
    public boolean intersecs(Line line){
        return false;
    }

    public Angle angleBetween(){
        return null;
    }

    public String toString() {
        return "["+p0+" -> "+p1+"]";
    }

    public static void main(String[] args) {

        Line line = new Line(new Point(0,1),new Point(0,5));
/*
        System.out.println(line+"\n"+line.length());

        System.out.println(line.split()[0]);
        System.out.println(line.split()[1]);*/

        System.out.println(line.translate(Axis.Z,5));
    }
}
