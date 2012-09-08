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
    
    ArrayList<Point> points = new ArrayList<Point>();

    float t = .5f;
    private static final int GRAY = 88;
    
    Neville begin;
    Neville currentNeville;
    Neville end;

    Neville[] curves;

    public static void main(String[] args) {
        PApplet.main(new String[] { "--present", "MovingCurve" });
    }

    public void setup() {
        size(800, 800);
        frameRate(30);
        
        
        int numCurves = 4;
        int ctrlPoints = 4;
        
        curves = new Neville[numCurves];
        for (int i = 0; i < numCurves; i++	) {
        	Point[] pts = new Point[ctrlPoints];
        	for (int j = 0; j < ctrlPoints; j++) {
        		Point p = pts[j] = new Point('x', 30 + 100*i, 30 + 100*j);
        		points.add(p);
        	}
        	curves[i] = new Neville(pts);
        }
       
//        points.add(one);
//        points.add(two);
//        points.add(three);
//        points.add(four);
//
//        stop.add(new Point('1', 100, 300));
//        stop.add(new Point('2', 200, 350));
//        stop.add(new Point('3', 700, 200));
//        stop.add(new Point('4', 500, 600));
        
        smooth();
        
        begin = new Neville(new Point[] {one, two, three, four});
        end = new Neville(stop.toArray(new Point[] {}));
    }

    public void draw() {
        background(GRAY);

        for (Point p: points) {
        	p.display(this);
        }
        
        for (Neville n: curves) {
        	n.draw(this);
        }

//        begin.draw_trace(this);
//        end.draw_trace(this);
//
//        PVector A = MathMagic.neville(t, begin.getCtrl_pnts());
//        PVector B = MathMagic.neville(t, end.getCtrl_pnts());
//        PVector live = MathMagic.neville(t, A, B);
//        ellipse(live.x, live.y, 30, 30);
    }

    private Point grabbedPoint;

    public void mouseDragged() {
        if (grabbedPoint == null) {
            float maxDistance = 400000;
            for (Point p: points) {
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
