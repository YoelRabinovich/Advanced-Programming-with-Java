import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

//class that represents A line shape
public class MyLine extends MyShape {

	//A constructor that receives the shape data and initializes it accordingly.
	public MyLine(double x1, double y1, double x2, double y2, Color color) {
		super(x1, y1, x2, y2, color);
	}

	//Method for drawing the line
	public void draw(GraphicsContext gc)
	{
		gc.setStroke(getColor());
		gc.setFill(getColor());
		gc.strokeLine(getX1(), getY1(), getX2(), getY2());
	}

	//returns true for Lines that are the same length, regardless of their position.
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null || !(obj instanceof MyLine))
		{
			return false;
		}

		return this.length() == ((MyLine) obj).length();
	}

	//Calculate the length of the line
	private double length()
	{
		return Math.sqrt(Math.pow(getX1() - getX2(), 2) + Math.pow(getY1() - getY2(), 2));
	}

	//clone the line 
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		return new MyLine(getX1(), getY1(), getX2(), getY2(), getColor());
	}
}



