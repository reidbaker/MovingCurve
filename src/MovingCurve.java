import java.util.ArrayList;

import processing.core.PApplet;

public class MovingCurve extends PApplet {

	ArrayList<Point> points = new ArrayList<Point>();
	Point one = new Point('a', 200, 200);
	Point two = new Point('b', 200, 500);
	Point three = new Point('c', 100, 400);
	Point four = new Point('d', 100, 600);

	Point test = new Point('t', 400, 360);
	private static final int GRAY = 88;

	Neville neville;

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
		points.add(new Point('e', 600, 400));
		smooth();

		neville = new Neville(points.toArray(new Point[] {}));
	}

	public void draw() {
		background(GRAY);

		for(int i=0; i < points.size(); i++){
			points.get(i).display(this);
		}

		neville.display(this);

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
