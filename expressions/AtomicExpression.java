
//This class represents an atomic arithmetic expression
public class AtomicExpression extends Expression{

	private double atomic;

	//initialization of the expression
	public AtomicExpression(double val) {
		atomic = val;
	}
	
	//getter for the atomic expression
	public double getNum() {
		return atomic;
	}

	//Returns the result of the arithmetic expression
	public double calculate() {
		return atomic;
	}

	//Returns the expression as a string
	public String toString() {
		return ""+ atomic ;
	}
}

