import java.util.ArrayList;

import processing.core.PApplet;

public class MovingCurve extends PApplet {

    ArrayList<Point> start = new ArrayList<Point>();
    Point one = new Point(this, 200, 200);
    Point two = new Point(this, 200, 500);
    Point three = new Point(this, 100, 400);
    Point four = new Point(this, 100, 600);

    private static final int GRAY = 88;
    
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

        ArrayList<Point> stop = new ArrayList<Point>();
        stop.add(new Point(this, 100, 300));
        stop.add(new Point(this, 200, 350));
        stop.add(new Point(this, 500, 600));
        stop.add(new Point(this, 700, 200));
        smooth();
        
        begin = new Neville(start.toArray(new Point[] {}));
        end = new Neville(stop.toArray(new Point[] {}));
        currentNeville = new Neville(start.toArray(new Point[] {}));
    }

    public void draw() {
        background(GRAY);

        for(int i=0; i < start.size(); i++){
            start.get(i).display();
        }

        begin.draw_trace(this);
        end.draw_trace(this);

    }

    public void mousePressed() {
        //TODO find closest point and move it
    }

}
