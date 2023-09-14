
//The class represents an subtraction expression
public class SubtractionExpression extends CompoundExpression {

	//gets two parameters of type Expression and initializes the attributes.
	public SubtractionExpression(Expression x , Expression y ) {
		super(x,y);
	}

	//Returns the result of the arithmetic expression
	public double calculate() {
		return FirstNum.calculate() - SecondNum.calculate();
	}

	//Returns the expression as a string
	public String toString() {
		return FirstNum.toString() + " - " + SecondNum.toString();
	}
}
