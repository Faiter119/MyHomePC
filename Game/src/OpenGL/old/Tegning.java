package OpenGL.old;

import static com.jogamp.opengl.GL.GL_COLOR_BUFFER_BIT;
import static com.jogamp.opengl.GL.GL_DEPTH_BUFFER_BIT;
import static com.jogamp.opengl.GL2.*;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GL3;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.awt.GLCanvas;
import static com.jogamp.opengl.fixedfunc.GLMatrixFunc.GL_MODELVIEW;
import static com.jogamp.opengl.fixedfunc.GLMatrixFunc.GL_PROJECTION;

import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;

import java.awt.*;
import java.lang.Math;
import java.util.Arrays;
import javax.swing.JOptionPane; 		// Import Swing JOptionPane
import java.util.Random;

public class Tegning extends GLCanvas implements GLEventListener{

    public GLCanvas canvas;
    public GLU glu = new GLU();    // Meta-stuff etc
    public GLUT glut = new GLUT(); // Premade shapes

    double vinkel;

    public float[][] p =
            {
                    {-1f, -1f,  1f},//0
                    { 1f ,-1f,  1f},//1
                    { 1f , 1f,  1f},//2
                    {-1f,  1f,  1f},//3

                    {-1f, -1f, -1f},//4
                    { 1f, -1f, -1f},//5
                    { 1f,  1f, -1f},//6
                    {-1f,  1f, -1f} //7
            };

    public float[][] farger =  {{1f,1f,0f},{1f,1f,1f},{1f,0f,0f},{0f,1f,0f},{0f,0f,1f},{0f,1f,1f}};

    public float[][][] sider = {
            {p[0], p[1], p[2], p[3]},
            {p[4], p[5], p[6], p[7]},
            {p[0], p[3], p[7], p[4]},
            {p[1], p[2], p[6], p[5]},
            {p[3], p[2], p[6], p[7]},
            {p[0], p[1], p[5], p[4]}};


    public Tegning(){
        this.addGLEventListener(this);
        FPSAnimator a  = new FPSAnimator(this, 60);
        a.start();
    }
    public void init(GLAutoDrawable glDrawable){

        GL2 gl = glDrawable.getGL().getGL2();
        gl.glClearColor(0f,0f,0f,1f);

        gl.glEnable(GL_DEPTH_TEST);                	//Enables Depth Testing
        gl.glEnableClientState(GL_COLOR_ARRAY);  	// Enables color arrays
        gl.glEnableClientState(GL_VERTEX_ARRAY);  	// Enables vertex arrays
		/*gl.glEnable( GL_POINT_SMOOTH );
		 gl.glEnable( GL_LINE_SMOOTH );
		 gl.glEnable(GL_BLEND);
		 gl.glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		 gl.glHint(GL_POLYGON_SMOOTH_HINT,GL_NICEST);*/


        gl.glMatrixMode(GL_PROJECTION);
        glu.gluPerspective(90, 1.25, 1, 100);
        glu.gluLookAt(0,4,8, 0f,0f,0f, 0f,1f,0f);

        gl.glMatrixMode(GL_MODELVIEW);
    }
    public void reshape(GLAutoDrawable glDrawable, int i, int i1, int i2, int i3){}
    public void dispose(GLAutoDrawable glDrawable){}

    public void tegnRutenett(GLAutoDrawable glDrawable, float størrelse){

        GL2 gl = glDrawable.getGL().getGL2();
        GL3 gl3 = glDrawable.getGL().getGL3();

        float startX= -100;
        float startZ = startX/2;
        float start0 = startX;
        float start1 = 0f;
        float start2 = -10f;

        int farge=0;

        gl.glColor3f(0f,0f,0f);

        for(int j=0; j<-startX;j++){
            start0=startX+(størrelse*j);
            start2=startZ;
            if(farge==1){
                gl.glColor3f(0f,0f,0f);
                farge=0;
            }
            else{
                gl.glColor3f(1f,1f,1f);
                farge=1;
            }
            for(int i=0; i<-startZ; i++){

                float[][] side =
                        {{start0            ,   start1,   start2          },
                        {start0+størrelse   ,   start1,   start2          },
                        {start0+størrelse   ,   start1,   start2+størrelse},
                        {start0             ,   start1,   start2+størrelse}};

                start0+=størrelse;
                start2+=størrelse;

                tegnPolygon(glDrawable,side);
            }
        }
    }
    public void tegnKoordinatsystem(GLAutoDrawable glDrawable){

        GL2 gl = glDrawable.getGL().getGL2();

        gl.glColor3f(1f,1f,1f);
        gl.glBegin(GL_LINES);

        gl.glVertex3f(0f,0f,0f);
        gl.glVertex3f(2f,0f,0f);
        gl.glVertex3f(0f,0f,0f);
        gl.glVertex3f(0f,2f,0f);
        gl.glVertex3f(0f,0f,0f);
        gl.glVertex3f(0f,0f,2f);
        gl.glVertex3f(1f,-0.5f,0f);
        gl.glVertex3f(1f,0.5f,0f);
        gl.glVertex3f(2f,-0.5f,0f);
        gl.glVertex3f(2f,0.5f,0f);

        gl.glEnd();
    }
    public void tegnPolygon(GLAutoDrawable glDrawable, float[][]sider){

        GL2 gl = glDrawable.getGL().getGL2();

        gl.glBegin(GL_POLYGON);

        gl.glVertex3fv(sider[0], 0);
        gl.glVertex3fv(sider[1], 0);
        gl.glVertex3fv(sider[2], 0);
        gl.glVertex3fv(sider[3], 0);

        gl.glEnd();
    }
    public void tegnKube(GLAutoDrawable glDrawable, float[][][]sider, float[][]farger){

        float[][] side;

        GL2 gl = glDrawable.getGL().getGL2();

        for(int i=0; i < 6; i++){
            side = sider[i];
            gl.glColor3fv(farger[i],0);
            tegnPolygon(glDrawable, side);
        }
    }
    public void tegnSirkel(GLAutoDrawable glDrawable){

        GL2 gl = glDrawable.getGL().getGL2();

        int punkterS = 100;

        gl.glScalef(0.5f,0.5f,0.5f);
        gl.glBegin(GL_LINE_STRIP);

        double vinkel = 0.0;

        for(int i = 0; i < punkterS; i++){
            vinkel = Math.PI+(2 * Math.PI * i/punkterS);
            gl.glVertex2d(1.5*Math.cos(vinkel),Math.sin(vinkel));
        }
        gl.glEnd();
        gl.glScalef(2f,2f,2f);
    }
    public void tegnKule(GLAutoDrawable glDrawable, int ant){

        GL2 gl = glDrawable.getGL().getGL2();

        Random random = new Random();

        float r = 0.5f;//random.nextFloat();
        float g = 0.5f;//random.nextFloat();
        float b = 1;//random.nextFloat();

        int sirkler = ant;

        gl.glColor3f(r,g,b);

        for(float i = 0; i<sirkler; i++){

            gl.glRotatef(360/sirkler, 0f,1f,0f);
            tegnSirkel(glDrawable);
        }
    }

    /*****************************************************************************************************/
    float roter = 0f;
    public void drawGLScene(GLAutoDrawable glDrawable){

        GL2 gl = glDrawable.getGL().getGL2();

        gl.glClear(GL_COLOR_BUFFER_BIT); //Clear the Color buffer
        gl.glClear(GL_DEPTH_BUFFER_BIT); //Clear the Depth Buffer

        gl.glLoadIdentity();

        tegnRutenett(glDrawable, 2f);


        //tegnKoordinatsystem(glDrawable);

        gl.glTranslatef(-2f,2f,-2f);
        gl.glColor3f(0f,1f,1f);
        gl.glRotatef(roter/5, 0f,1f,0f);
        tegnKule(glDrawable,10);

        gl.glLoadIdentity();

        gl.glRotatef(5*roter, 0f,1f,0f);

        tegnKube(glDrawable, sider, farger);

        gl.glRotatef(-5*roter, 0f,1f,0f);

        gl.glTranslatef(0f,2.5f,0f);

        gl.glRotatef(roter, 1f,0f,0f);
        tegnKube(glDrawable, sider, farger);

        gl.glLoadIdentity();

        gl.glTranslatef(7f,1f,1f);
        gl.glTranslatef((float)Math.sin(roter/10)+1,(float)Math.cos(roter/10)+1,(float)Math.cos(roter/10));
        gl.glColor3f(0f,0f,1f);
        glut.glutWireSphere(1,5,5);
        //tegnKule(glDrawable,1);
        gl.glLoadIdentity();

        gl.glTranslatef(3f,2f,-3f);
        gl.glTranslatef((float)Math.cos(roter/10)+1,0f,0f);
        gl.glRotatef(45, 0f,0f,1f);
        tegnKube(glDrawable, sider, farger);
        gl.glRotatef(-45, 0f,0f,1f);
        gl.glTranslatef(0f,4f,0f);
        gl.glTranslatef((float)Math.cos(roter/10)+1,-1f,0f);
        gl.glTranslatef(0f,-((float)Math.cos(roter/10)+1),0f);
        tegnKube(glDrawable, sider, farger);

        if(roter>1000)
            roter=0;
        else
            roter ++;

    }
    /*****************************************************************************************************/

    public void display(GLAutoDrawable glDrawable){
        GL2 gl = glDrawable.getGL().getGL2();
        drawGLScene(glDrawable);
        gl.glFlush();
    }
}
