package mrd.util;

public class Point {
	/**
	 * @uml.property  name="x"
	 */
	private double x;
	/**
	 * @uml.property  name="y"
	 */
	private double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @return
	 * @uml.property  name="x"
	 */
	public double getX() { return x; }
	
	/**
	 * @return
	 * @uml.property  name="y"
	 */
	public double getY() { return y; }
}
