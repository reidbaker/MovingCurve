import processing.core.PApplet;

public class MovingCurve extends PApplet {

    public static void main(String[] args) {
        PApplet.main(new String[] { "--present", "MovingCurve" });
    }

    public void setup() {
        size(480, 120);
    }

    public void draw() {
        if (mousePressed) {
            fill(0);
        } else {
            fill(255);
        }
        ellipse(mouseX, mouseY, 80, 80);
    }

}
