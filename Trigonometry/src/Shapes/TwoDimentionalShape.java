package Shapes;

import Fundementals.Axis;

public interface TwoDimentionalShape {

    double area();

    TwoDimentionalShape translate(Axis axis, double distance);

    TwoDimentionalShape scale(double scale);


}
