package OpenGL;

import javafx.scene.shape.CubicCurve;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Rectangle2D;

public class Drawing extends JComponent{

    int scale = 1;

    public Drawing(){


    }
    public void re(){

        long start = System.currentTimeMillis();

        for(int i=0; i<144; i++){

            repaint();

            scale = i;

            try {Thread.sleep(7);}catch (InterruptedException e) {}
        }
        System.out.println(System.currentTimeMillis()-start);
    }

    public void paint(Graphics g){

        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        Shape rect = new Rectangle(scale*1,scale*1,scale*2,scale*2);

        CubicCurve2D circle = new CubicCurve2D.Double(Math.sqrt(scale)*2d,Math.PI*2d,2d,2d,2d,2d,scale*2d,scale*2d);

        g2D.draw(rect);
        g2D.draw(circle);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        Drawing drawing = new Drawing();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(drawing);

        frame.setVisible(true);

        drawing.re();


    }
}
