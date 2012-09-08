import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class Point {
    private PApplet p;
    private PVector pos;
//    private float xLoc;
//    private float yLoc;
    private int size = 30;

    public Point(PApplet p, float x, float y) {
        this(p, new PVector(x,y));
    }

    public Point(PApplet p, PVector pos) {
		this.p = p;
		this.pos = pos;
	}

	public void display(){
        p.ellipse(getXLoc(), getYLoc(), size, size);
    }

    public float distance(Point B){
        //TODO return distance from here to B
        float xDistance = B.getXLoc() - getXLoc();
        float yDistance = B.getYLoc() - getYLoc();
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
            float currentDistance = this.distance(currentPoint);
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



}
