import processing.core.PVector;


public class MathMagic {

	public static PVector neville(float t, PVector ... points) {
		if (points.length == 1) return points[0];
		if (points.length == 2) return tScale(points[0], points[1], t);

		int len = points.length - 1;
		PVector[] v1 = new PVector[len], v2 = new PVector[len];
		System.arraycopy(points,0,v1,0,len);
		System.arraycopy(points,1,v2,0,len);
		return neville(t/(len),neville(t, v1), neville(t-1,v2));
	}

	public static PVector tScale(PVector a, PVector b, float t) {
		PVector d = PVector.sub(b, a);
		return PVector.add(a, PVector.mult(d, t));
		// or PVector.add(PVector.mult(a, 1-t), PVector.mult(b,t));
	}
	
}
