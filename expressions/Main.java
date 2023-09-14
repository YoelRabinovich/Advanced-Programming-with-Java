
import java.util.ArrayList;
import java.util.Random;

//The main program demonstrates the use of classes 
//We fill ArrayList with random expressions and at the end we check if there are equal expressions 
public class Main {

	final static int MAX_VAL = 10; 
	final static int  NUM_OF_EXPRESSIONS = 20;
	final static int MAX_AGRUMENT = 10;

	public static void main(String[] args) {

		ArrayList<Expression> list = new ArrayList<Expression>();
		Random rand = new Random();
		int num;
		Expression exp ; 

		//ArrayList filled with random expressions
		for (int i = 0; i < NUM_OF_EXPRESSIONS ; i++) {
			num = rand.nextInt(MAX_VAL)+1;
			exp = new AtomicExpression(num);
			int argument = rand.nextInt(MAX_AGRUMENT)+1;
			for(int j = 0 ;j < argument ;j++ ) {
				num = rand.nextInt(MAX_VAL)+1;
				Expression temp = new AtomicExpression(num);
				if( rand.nextBoolean()) {
					exp = new AdditionExpression(exp, temp);
				}
				else {
					exp = new SubtractionExpression(exp, temp);
				}
			}
			list.add(exp);
		}

		// print all the expressions created randomly in the ArrayList 
		for (int i = 0; i <NUM_OF_EXPRESSIONS; i++) {
			System.out.println("exp is :" + list.get(i));
			System.out.println("value of the exp is :" + list.get(i).calculate());
			System.out.println();

		}
		// check if 2 different expressions with the same value 
		for (int i = 0; i <NUM_OF_EXPRESSIONS; i++) {
			for (int j = i+1; j <NUM_OF_EXPRESSIONS; j++) {
				if(list.get(i).equals(list.get(j))&&(i!=j)) {
					System.out.println("The following expressions are equal : ");
					System.out.println(list.get(i));
					System.out.println(list.get(j));
					System.out.println("The value is : " + list.get(i).calculate());
				}
			}
		}
	}

}
