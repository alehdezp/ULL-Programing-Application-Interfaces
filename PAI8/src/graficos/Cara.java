package graficos;

public class Cara {
	private int x;
	private int y;
	private int radius;
	//private Cara cara;
	Cara(int x, int y, int radius){
		setX(x);
		setY(y);
		setRadius(radius);
		//cara = new Cara(x, y, radius);
	}
	
	
	public int getCaraX(){
		return getX() - getRadius()/2;
	}
	
	public int getCaraY(){
		return getY() - getRadius()/2;
	}
	
	public int getBocaX(){
		return getX() - getRadius()/5;
	}
	
	public int getBocaY(){
		return getY() + getRadius()/5;
	}
	
	public int getBocaX2(){
		return getX() + getRadius()/5;
	}
	
	public int getBocaY2(){
		return getY() +getRadius()/5;
	}
	
	public int getOjo1X(){
		return getX() - getRadius()/4;
	}
	
	public int getOjo1Y(){
		return getX() - getRadius()/5;
	}
	
	public int getOjo2X(){
		return getX() + getRadius()/4 - getRadius()/6;
	}
	
	public int getOjo2Y(){
		return getX() - getRadius()/5;
	}
	
	public int getOjoAncho(){
		return getRadius()/6;
	}
	public int getOjoAlto(){
		return getRadius()/6;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}
	/**
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}
}
