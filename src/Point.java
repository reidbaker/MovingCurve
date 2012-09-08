import processing.core.PApplet;

public class Point {
    private PApplet p;
    private float xLoc;
    private float yLoc;
    private int size = 30;

    public Point(PApplet p, float x, float y) {
        this.p = p;
        this.xLoc = x;
        this.yLoc = y;
    }

    public void display(){
        p.ellipse(getXLoc(), getYLoc(), size, size);
    }

    public float distance(Point B){
        //TODO return distance from here to B
        System.out.println("Not Yet Implimented");
        return 0;
    }

    public float midpoint(Point B){
        //TODO find midpoint between here and B
        System.out.println("Not Yet Implimented");
        return 0;
    }

    public float getYLoc() {
        return yLoc;
    }
    public void setYLoc(float y) {
        this.yLoc = y;
    }
    public float getXLoc() {
        return xLoc;
    }
    public void setXLoc(float x) {
        this.xLoc = x;
    }
    public void setXY(float x, float y){
        this.xLoc = x;
        this.yLoc = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }



}
