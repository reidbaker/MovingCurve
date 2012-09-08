import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class MovingCurve extends PApplet {

    ArrayList<Point> start = new ArrayList<Point>();
    Point one = new Point('a', 200, 200);
    Point two = new Point('b', 200, 500);
    Point three = new Point('c', 100, 400);
    Point four = new Point('d', 100, 600);
    ArrayList<Point> stop = new ArrayList<Point>();

    float t = 0.0f;
    float t_step = .05f;
    private static final int GRAY = 88;

    Neville[] curves = new Neville[2];
    Neville begin;
    Neville currentNeville;
    Neville end;


    public static void main(String[] args) {
        PApplet.main(new String[] { "--present", "MovingCurve" });
    }

    public void setup() {
        size(800, 800);
        frameRate(30);
        start.add(one);
        start.add(two);
        start.add(three);
        start.add(four);

        stop.add(new Point('1', 100, 300));
        stop.add(new Point('2', 200, 350));
        stop.add(new Point('3', 700, 200));
        stop.add(new Point('4', 500, 600));
        smooth();

        begin = new Neville(start.toArray(new Point[] {}));
        end = new Neville(stop.toArray(new Point[] {}));
        curves[0] = begin;
        curves[1] = end;
    }

    public void draw() {
        background(GRAY);

        for(int i=0; i < start.size(); i++){
            start.get(i).display(this);
        }

        begin.draw_trace(this);
        end.draw_trace(this);

        PVector A = MathMagic.neville(t, curves[0].getCtrl_pnts());
        PVector B = MathMagic.neville(t, curves[1].getCtrl_pnts());
        PVector[] live = new PVector[]{A, B};
        draw_solid_curve(live);
        if (t < 3){
            t += t_step;
        }
        else{
            t = 0;
        }
    }

    public void draw_solid_curve(PVector[] ctrl_pnts){
        beginShape();
        stroke(0xFF4499bb);
        strokeWeight(4);
        noFill();
        for (float i = 0; i <= (ctrl_pnts.length - 1); i += .06) {
            PVector pt = MathMagic.neville(i, ctrl_pnts);
            curveVertex(pt.x, pt.y);
        }
        endShape();
    }

    private Point grabbedPoint;

    public void mouseDragged() {
        if (grabbedPoint == null) {
            float maxDistance = 400000;
            for (Point p: start) {
                float distance = p.distance(mouseX, mouseY);
                if (distance < maxDistance) {
                    maxDistance = distance;
                    grabbedPoint = p;
                }
            }
        }

        grabbedPoint.move(mouseX, mouseY);

    }

    @Override
    public void mouseReleased() {
        grabbedPoint = null;

    }

}
