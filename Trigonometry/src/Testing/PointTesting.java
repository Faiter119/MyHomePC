package Testing;

import Fundementals.Angle;
import Fundementals.Point;
import Fundementals.Vector;
import Shapes.Line;
import Shapes.Triangle;

import java.util.ArrayList;

public class PointTesting {

    public static void main(String[] args) {

        /*Point p0 = new Point(0,0);
        Point p1 = new Point(3,0);
        Point p2 = new Point(3,3);
        Point p4 = new Point(0,3);

        Line line = new Line(p0, p2);
        System.out.println("---Line---\n"+line+"\n"+line.length()+"\n"+line.split()[0]+"\n"+line.split()[1]);

        System.out.println(Math.round(Angle.of(p0, p1, p2).degrees())+"\n");

        Triangle t = new Triangle(p0, p1, p2);
        System.out.println(t);*/

        Vector v0 = new Vector(new Line(new Point(0,0,0),new Point(2,3,4)));
        Vector v1 = new Vector(new Line(new Point(2,2,2),new Point(0,5,5)));

        System.out.println(v0+"\n"+v0.length());
        System.out.println("\n"+v1+"\n"+v1.length());

        System.out.println(v0.add(v1));






    }

}
