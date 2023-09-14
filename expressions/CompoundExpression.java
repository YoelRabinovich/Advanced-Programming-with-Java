
//This class represents a complex arithmetic expression
public abstract class CompoundExpression extends Expression {

	protected Expression FirstNum;
	protected Expression SecondNum;

	//gets two parameters of type Expression and initializes the attributes.
	public CompoundExpression (Expression x , Expression y ) {
		FirstNum=x;
		SecondNum = y;
	}
}



