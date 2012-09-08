import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class Point {
	private PVector pos;
	private char label;
	//    private float xLoc;
	//    private float yLoc;
	private int size = 20;

	private int pointColor = 0xFFFFFFFF;
	private int labelColor = 0xFF000000;

	public Point(char label, float x, float y) {
		this(label, new PVector(x,y));
	}

	public Point(char label, PVector pos) {
		this.label = label;
		this.pos = pos;
	}

	public void display(PApplet canvas){
		canvas.pushMatrix();
		canvas.translate(pos.x, pos.y);

		canvas.noStroke();
		canvas.fill(pointColor);
		canvas.ellipse(0, 0, size, size);

		canvas.fill(labelColor);
		canvas.textAlign(canvas.CENTER, canvas.CENTER);
		canvas.text(label, 0, -2); // hacky!

		canvas.popMatrix();
	}

	public float distance(float x, float y){
		//TODO return distance from here to B
		float xDistance = x - getXLoc();
		float yDistance = y - getYLoc();
		float distance = (float) Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
		return distance;
	}

	public float midpoint(Point B){
		//TODO find midpoint between here and B
		System.out.println("Not Yet Implimented");
		return 0;
	}

	/**
	 *
	 * @param A, Point to measure from
	 * @param points
	 * @return index in Arraylist of closest point
	 */
	public int closestPoint(ArrayList<Point> points){
		Point currentPoint = null;
		float closestDistance = 4000000.0f; //shame on me
		int closestPoint = 0;

		for(int i=0; i < points.size(); i++){
			currentPoint = points.get(i);
			float currentDistance = this.distance(currentPoint.pos.x, currentPoint.pos.y);
			if (currentDistance < closestDistance){
				closestDistance= currentDistance;
				closestPoint = i;
				//                System.out.println("current: " + currentDistance + " closest: " + closestDistance);
			}
		}
		return closestPoint;
	}

	public float getYLoc() {
		return this.pos.y;
	}
	public void setYLoc(float y) {
		this.pos.y = y;
	}
	public float getXLoc() {
		return this.pos.x;
	}

	public void setXLoc(float x) {
		this.pos.x = x;
	}

	public void setXY(float x, float y){
		this.pos.x = x;
		this.pos.y = y;
	}

	public PVector getPos() {
		return pos;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void move(int x, int y) {
		pos.x = x;
	    pos.y = y;
	}



}
