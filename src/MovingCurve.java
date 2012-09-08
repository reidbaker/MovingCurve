import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class MovingCurve extends PApplet {

    ArrayList<Point> points = new ArrayList<Point>();

    float t = 0.0f;
    float t_step = .05f;
    private static final int GRAY = 88;

    Neville[] curves;

    public static void main(String[] args) {
        PApplet.main(new String[] { "--present", "MovingCurve" });
    }

    public void setup() {
        size(800, 500);
        frameRate(30);


        initCurves();

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


    }

	protected void initCurves() {
		int numCurves = 4;
        int ctrlPoints = 4;

        points.clear();
        
        curves = new Neville[numCurves];
        for (int i = 0; i < numCurves; i++	) {
        	Point[] pts = new Point[ctrlPoints];
        	for (int j = 0; j < ctrlPoints; j++) {
        		Point p = pts[j] = new Point('x', 30 + 100*i, 30 + 100*j);
        		points.add(p);
        	}
        	curves[i] = new Neville(pts);
        }
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
        curves[0].draw_trace(this);
        curves[1].draw_trace(this);

        PVector[] live = new PVector[curves.length];
        for(int i = 0; i < curves.length; i++){
            live[i] = MathMagic.neville(t, curves[i].getCtrl_pnts());
        }
        draw_solid_curve(live);
        if (t < curves.length-1){
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
        PVector pt = MathMagic.neville(0, ctrl_pnts);
        curveVertex(pt.x, pt.y);
        for (float i = 0; i <= (ctrl_pnts.length - 1); i += .01) {
            pt = MathMagic.neville(i, ctrl_pnts);
            curveVertex(pt.x, pt.y);
        }
        pt = MathMagic.neville(ctrl_pnts.length-1, ctrl_pnts);
        curveVertex(pt.x, pt.y);
        endShape();
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

    @Override
    public void keyPressed() {
    	if (key == 'c') {
    		initCurves();
    	}
    }
}
