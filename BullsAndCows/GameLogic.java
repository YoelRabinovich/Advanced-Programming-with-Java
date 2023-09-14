import java.util.Random;

// class for the logic of the game . 
// the class contain an instance var that represents the number that needs to be guessed and a method that representing the guess and returns an answer to the user

public class GameLogic {


	private int NumOfGuess; 
	private String TheNumber;
	final int LENGTH=4;


	//new game
	public GameLogic() {
		TheNumber=TheNumberIs();
		NumOfGuess=0;
	}



	//getter for the number we have to guess
	public String getNum() {
		return TheNumber;
	}


	// checks how many hits and exist user made and prints appropriate message
	public String HowManyHits(String guess) {
		int hit=0;
		int exists=0;
		String msg="";
		if (isValid(guess)!="") 
			return isValid(guess);

		for (int i=0;i<LENGTH;i++) {
			if (TheNumber.charAt(i)==guess.charAt(i))
				hit++;
			for (int j=0;j<LENGTH;j++) {
				if (TheNumber.charAt(i)==guess.charAt(j)&&(j!=i))
					exists++;
			}

		}
		NumOfGuess++;  

		if (hit == LENGTH)
			msg="WINNER. After "+ NumOfGuess +" guesses you managed to guess the number "+guess+" in its entirety ";
		else
			msg="Try again,you got currectly "+hit+" hits and "+exists+" exists this time in your guess "+guess;
		return msg;
	}


	//checks if valid user input
	private String isValid (String guess) {
		String msg="";
		int count=0;
		if (guess.length()!=LENGTH) 
			return msg="Invalid input,must be 4 digits length";
		for (int i=0;i<guess.length();i++) {
			if (Character.isDigit(guess.charAt(i)))
				count++;
		}    
		if (count!=LENGTH)
			return msg="Invalid input,must be numbers only";
		if(guess.charAt(0)==guess.charAt(1)||(guess.charAt(0)==guess.charAt(2))||(guess.charAt(0)==guess.charAt(3))||(guess.charAt(1)==guess.charAt(2)||(guess.charAt(2)==guess.charAt(3))))
			return msg="Invalid input,must be 4 diffrent digits";
		return msg;


	}


	// generate 4 (different) digits number as a string
	private String TheNumberIs() {
		String num="";
		int a = 0, b = 0, c = 0, d = 0;
		int x = 0;
		Random r = new Random();
		while (true) {
			x = r.nextInt(9000) + 1000;
			a = x % 10;
			b = (x / 10) % 10;
			c = (x / 100) % 10;
			d = x / 1000;
			if (a == b || a == c || a == d || b == c || b == d || c == d)
				continue;
			else
				break;
		}
		num=String.valueOf(x); 

		return num;

	}


	//reset the game
	public void reset() {
		TheNumber=TheNumberIs();
		NumOfGuess=0;
	}





}

