import processing.core.PApplet;

public class Point {
    PApplet p;
    private float xLoc;
    private float yLoc;

    public Point(PApplet p, float x, float y) {
        this.p = p;
        this.xLoc = x;
        this.yLoc = y;
    }

    public void display(){
        p.ellipse(getXLoc(), getYLoc(), 80, 80);
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



}
