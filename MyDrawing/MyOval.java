import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

//class that represents A Oval shape

public class MyOval extends MyBoundedShape
{

	//A constructor that receives the shape data and initializes it accordingly.
	public MyOval(double x1, double y1, double x2, double y2, Color color, boolean isFilled)
	{
		super(x1, y1, x2, y2, color, isFilled);
	}

	//return true when width and height are equal, regardless of their position.
	public boolean equals(Object obj)
	{
		if (obj == null || !(obj instanceof MyOval))
		{
			return false;
		}

		return (this.width() == ((MyOval) obj).width() && this.height() == ((MyOval) obj).height());
	}
	
	//Method for drawing the Oval
	@Override
	public void draw(GraphicsContext gc)
	{
		gc.setStroke(getColor());
		gc.setFill(getColor());
		if (isFilled())
		{
			gc.fillOval(getX1(), getY1(), getX2(), getY2());
		}
		else
		{
			gc.strokeOval(getX1(), getY1(), getX2(), getY2());
		}
	}
	
	//clone the Oval
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		return new MyOval(getX1(), getY1(), getX2(), getY2(), getColor(), isFilled());
	}

}
