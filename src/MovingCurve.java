import java.util.ArrayList;

import processing.core.PApplet;

public class MovingCurve extends PApplet {

    ArrayList<Point> points = new ArrayList<Point>();
    Point one = new Point(this, 200, 200);
    Point two = new Point(this, 200, 500);
    Point three = new Point(this, 100, 400);
    Point four = new Point(this, 100, 600);

    public static PApplet p;

    Point test = new Point(this, 400, 360);
    private static final int GRAY = 88;

    public static void main(String[] args) {
        PApplet.main(new String[] { "--present", "MovingCurve" });
    }

    public void setup() {
        size(800, 800);
        frameRate(30);
        points.add(one);
        points.add(two);
        points.add(three);
        points.add(four);
        points.add(new Point(this, 600, 400));
        smooth();
        p = this;
    }

    public void draw() {
        background(GRAY);

        for(int i=0; i < points.size(); i++){
            points.get(i).display();
        }

        new Neville(points.toArray(new Point[] {})).draw(this);

    }

    public void mousePressed() {
        //TODO find closest point and move it
    }

}
