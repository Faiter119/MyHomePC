package Testing;

import Fundementals.Angle;
import Fundementals.Point;
import Shapes.Line;
import Shapes.Triangle;

public class PointTesting {

    public static void main(String[] args) {

        Point p0 = new Point(0,0);
        Point p1 = new Point(3,0);
        Point p2 = new Point(3,3);
        Point p4 = new Point(0,3);

        Line line = new Line(p0, p2);
        System.out.println("---Line---\n"+line+"\n"+line.length()+"\n"+line.split()[0]+"\n"+line.split()[1]);

        System.out.println(Math.round(Angle.of(p0, p1, p2).degrees())+"\n");

        Triangle t = new Triangle(p0, p1, p2);
        System.out.println(t);





    }

}
