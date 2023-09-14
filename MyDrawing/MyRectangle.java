import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


//class that represents A Rectangle shape

public class MyRectangle extends MyBoundedShape {



	//A constructor that receives the shape data and initializes it accordingly.
	public MyRectangle(double x1, double y1, double x2, double y2, Color color,boolean isFilled) {
		super(x1, y1, x2, y2, color,isFilled);
		// TODO Auto-generated constructor stub
	}
	
	//return true when width and height are equal, regardless of their position.

	public boolean equals(Object obj)
	{
		if (obj == null || !(obj instanceof MyRectangle))
		{
			return false;
		}

		return (this.width() == ((MyRectangle) obj).width() && this.height() == ((MyRectangle) obj).height());
	}

	//Method for drawing the Rectangle
	@Override
	public void draw(GraphicsContext gc)
	{
		gc.setStroke(getColor());
		gc.setFill(getColor());
		if (isFilled())
		{
			gc.fillRect(getX1(), getY1(), getX2(), getY2());
		}
		else
		{
			gc.strokeRect(getX1(), getY1(), getX2(), getY2());
		}
	}
	
	//clone the Rectangle
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		return new MyRectangle(getX1(), getY1(), getX2(), getY2(), getColor(), isFilled());
	}

}
