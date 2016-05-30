package Shapes;

import Fundementals.Axis;

public interface ThreeDimentionalShape {

    double area();
    double volume();

    ThreeDimentionalShape translate(Axis axis, double distance);

    ThreeDimentionalShape scale(double scale);

}
