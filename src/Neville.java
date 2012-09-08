import processing.core.PApplet;
import processing.core.PVector;

public class Neville {

	int trace_color = 0xFFFFFFFF, path_color = 0xFF00FFFF, leg_color = 0xFFFFFFF;
	PVector[] ctrl_pnts;
	float[] t_range = {
			0, 1
	};

	float trace_step = .05f;
	float t = 0;
	float t_step = .005f;
	int seconds = 5; // how long in seconds the curve should take to complete

	Neville(Point ... pts) {
		this.ctrl_pnts = new PVector[pts.length];
		for (int i = 0; i < pts.length; i++) {
			this.ctrl_pnts[i] = pts[i].getPos();
		}
	}

	void draw(PApplet canvas) {

		draw_trace(canvas);

		for (float i = t_range[0]; i <= t*(ctrl_pnts.length - 1); i += t_step) {
			PVector pt = MathMagic.neville(i, ctrl_pnts);

			canvas.pushMatrix();
			canvas.translate(pt.x, pt.y);

			canvas.fill(path_color);
			canvas.noStroke();
			canvas.ellipse(0, 0, 2, 2);

			canvas.popMatrix();
		} 


		t += t_range[1]/canvas.frameRate/seconds;
		if (t > t_range[1]) {
			t = t_range[0];
		}
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
	}
}
