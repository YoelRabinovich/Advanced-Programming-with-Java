
//The class represents an addition expression 
public class AdditionExpression extends CompoundExpression  {

	//gets two parameters of type Expression and initializes the attributes.
	public AdditionExpression(Expression x , Expression y ) {
		super(x,y);
	}

	//Returns the result of the arithmetic expression
	public double calculate() {
		return FirstNum.calculate() + SecondNum.calculate();

	}

	//Returns the expression as a string
	public String toString() {
		return FirstNum.toString() + " + " + SecondNum.toString();
	}
}


