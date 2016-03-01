package maths;

public class Circle extends Vector2{
	
	@SuppressWarnings("unused")
	private float radius;
	
	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}
	
	public Circle(Vector2 p, int radius){
		super(p);
		this.radius = radius;
	}

	
	

}
