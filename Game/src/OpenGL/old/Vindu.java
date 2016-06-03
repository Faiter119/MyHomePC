package OpenGL.old;

import javax.swing.*;

import com.jogamp.opengl.GLAutoDrawable;

class Vindu extends JFrame {
    int rotasjon = 45;

    public Vindu(String tittel) {
        setTitle(tittel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Tegning tegning = new Tegning();
        tegning.setSize(1000, 1000);
        add(tegning);
        pack();


    }
}