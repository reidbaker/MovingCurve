import processing.core.PApplet;
import processing.core.PVector;

public class Neville {

	int trace_color = 0xFFFFFFFF, path_color = 0xFF00FFFF, leg_color = 0xFFFFFFF;
	PVector[] ctrl_pnts;
	float[] t_range = {
			0, 1
	};

	float trace_step = .05f; // gap between white dots in time
	float t = 0;
	float t_step = .005f; // gap between moving dots in time
	float curve_step = .1f; // resolution of curve

	int seconds = 5; // how long in seconds the curve should take to complete

	Neville(Point ... pts) {
		this.ctrl_pnts = new PVector[pts.length];
		for (int i = 0; i < pts.length; i++) {
			this.ctrl_pnts[i] = pts[i].getPos();
		}
	}

    Neville(PVector ... pts) {
        this.ctrl_pnts = pts;
    }

    public PVector[] getCtrl_pnts() {
        return ctrl_pnts;
    }

	void draw(PApplet canvas) {
		draw_trace(canvas);
        draw_animated_curve(canvas);
	}

	public void draw_solid_curve(PApplet canvas){
	    canvas.beginShape();
        canvas.stroke(path_color);
        canvas.strokeWeight(4);
        canvas.noFill();
	    for (float i = t_range[0]; i <= (ctrl_pnts.length - 1); i += curve_step) {
            PVector pt = MathMagic.neville(i, ctrl_pnts);
            canvas.curveVertex(pt.x, pt.y);
        }
	    canvas.endShape();
	}

    private void updateT(PApplet canvas) {
        t += t_range[1]/canvas.frameRate/seconds;
        if (t > t_range[1]) {
            t = t_range[0];
        }
    }

    public void draw_animated_curve(PApplet canvas) {
        canvas.strokeWeight(2);
        for (float i = t_range[0]; i <= t*(ctrl_pnts.length - 1); i += t_step) {
			PVector pt = MathMagic.neville(i, ctrl_pnts);

			canvas.pushMatrix();

			canvas.translate(pt.x, pt.y);
			canvas.fill(path_color);
			canvas.noStroke();
			canvas.ellipse(0, 0, 2, 2);

			canvas.popMatrix();
		}
        updateT(canvas);
    }

	void draw_trace(PApplet canvas) {
		for (float i = t_range[0]; i <= t_range[1]*(ctrl_pnts.length - 1); i += trace_step) {
			PVector p = MathMagic.neville(i, ctrl_pnts);
			canvas.pushMatrix();
			canvas.translate(p.x, p.y);

			canvas.fill(trace_color);
			canvas.ellipse(0, 0, 2, 2);

			canvas.popMatrix();
		}
		updateT(canvas);
	}
}
