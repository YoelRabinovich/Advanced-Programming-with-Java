
//This class represents an arithmetic expression.
public abstract class Expression {

	//Returns the result of the arithmetic expression
	public abstract double calculate();

	//Returns the result of the arithmetic expression
	public  boolean equals (Object other) {
		if ((other==null) || !(other instanceof Expression))
		{
			return false;
		}

		return this.calculate()== ((Expression) other).calculate();
	}


}
