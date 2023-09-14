import javafx.scene.paint.Color;

//Class that Defines what is common to shapes with area

public abstract class MyBoundedShape extends MyShape
{
	private boolean isFilled;

	//A constructor that receives the shape data and initializes it accordingly.
	public MyBoundedShape(double x1, double y1, double x2, double y2, Color color, boolean isFilled)
	{
		super(x1, y1, x2, y2, color);
		this.isFilled = isFilled;
	}

	//check if the shape filled or empty?
	public boolean isFilled()
	{
		return isFilled;
	}

	//set the shape  to filled or empty
	public void setFilled(boolean isFilled)
	{
		this.isFilled = isFilled;
	}

	//Calculate the width of the shape
	protected double width ()
	{
		return (getX2() - getX1());
	}

	//Calculate the height of the shape
	protected double height  ()
	{
		return (getY2() - getY1());
	}


}

