import java.util.ArrayList;

import processing.core.PApplet;

public class MovingCurve extends PApplet {

    ArrayList<Point> points = new ArrayList<Point>();
    Point one = new Point(this, 200, 200);
    Point two = new Point(this, 200, 300);
    Point three = new Point(this, 200, 400);
    Point four = new Point(this, 200, 500);

    private static final int GRAY = 88;

    public static void main(String[] args) {
        PApplet.main(new String[] { "--present", "MovingCurve" });
    }

    public void setup() {
        size(800, 600);
        points.add(one);
        points.add(two);
        points.add(three);
        points.add(four);
    }

    public void draw() {
        background(GRAY);
        for(int i=0; i < points.size(); i++){
            points.get(i).display();
        }
    }

}
