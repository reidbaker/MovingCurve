import processing.core.PApplet;

public class MovingCurve extends PApplet {


    public static void main(String[] args) {
        PApplet.main(new String[] { "--present", "MovingCurve" });
    }

    public void setup() {
        size(800, 600);
    }

    public void draw() {
        background(100);
        Point one = new Point(this, 200, 200);
        one.display();
        ellipse(mouseX, mouseY, 80, 80);
    }

}
