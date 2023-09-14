
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

//An abstract class called MyShape that defines what is common to all the shapes.

public abstract class MyShape implements Cloneable {

	//Coordinates of the shapes
	private double x1;
	private double x2;
	private double y1;
	private double y2;
	private Color color;


	//constructor that receives the shape data and initializes it accordingly.
	public MyShape(double x1,double y1, double x2 , double y2 ,Color color) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.color = color;

	}

	// clone method applied individually in the shapes classes 
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	//drawing method applied individually in the shapes classes 
	public abstract  void draw(GraphicsContext gc);


	//getters and setters to all the coordinates 
	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}


	//color getter and setter  
	public Color getColor() {
		return color;
	}

	public void setColor(Color color)
	{
		this.color = color;
	}


}

