package Fundementals;

import Shapes.Line;

public class Vector {

    public enum Basis{

        e1(new Vector(new Line(new Point(0,0,0),new Point(1,0,0)))),
        e2(new Vector(new Line(new Point(0,0,0),new Point(0,1,0)))),
        e3(new Vector(new Line(new Point(0,0,0),new Point(0,0,1))));

        Basis(Vector v){

        }
    }

    public static Vector e1 = new Vector(new Line(new Point(0,0,0),new Point(1,0,0)));
    public static Vector e2 = new Vector(new Line(new Point(0,0,0),new Point(0,1,0)));
    public static Vector e3 = new Vector(new Line(new Point(0,0,0),new Point(0,0,1)));

    private Line line;

    public Vector(Line line){
        this.line = line;
    }

    public Line line(){return line;}

    public double length(){
        return line.length();
    }
    public Vector add(Vector v){

        Line firstLine = line;
        Line secondLine = v.line;
        return new Vector(new Line(Point.combine(firstLine.p0(),secondLine.p0()),Point.combine(firstLine.p1(),secondLine.p1())));
    }
    public Vector unitVector(){

        Point p0 = line.p0();
        Point p1 = line.p1();

        return null;



    }
    private double addAllCoordinates(Point p){
        return p.x()+p.y()+p.z();
    }
    public double scalarProduct(Vector v){
        return -1;

    }

    public Vector scale(double scale){
        return new Vector(new Line(line.p0().scale(scale),line.p1().scale(scale)));
    }
    public String toString(){
        return line.toString();
    }

}
