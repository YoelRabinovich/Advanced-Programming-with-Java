import javax.swing.JOptionPane;


// The main class manage the game - gets guesses from the user and uses the gamelogic class  
public class Main {
	public static void main(String[] args) {
		GameLogic game = new GameLogic();
		boolean play = true;
		String prev_guesses = "";
		String msg = "";

		String num=game.getNum();
		System.out.println(num);

		// game loop
		while(play == true) {	
			//			String num1=game.getNum();
			//			System.out.println(num1);
			String guess = JOptionPane.showInputDialog( "Guess 4 digits number:" );
			JOptionPane.showMessageDialog(null, (msg = game.HowManyHits(guess)) +"\nPrevious guesses: "+ prev_guesses);
			if(msg.startsWith("Try"))                                        //save previous guesses only if valid
				prev_guesses = prev_guesses +"\n"+ msg;


			//if starts with "WINNER" that means the user won
			if(msg.startsWith("WINNER") == true) {
				int input = JOptionPane.showConfirmDialog(null, 
						"Do you want to play again?", "Select an Option...",JOptionPane.YES_NO_CANCEL_OPTION);
				//if user wants a new game, reset the game - else leave the loop (game ends)
				if (input==0) { 
					game.reset(); 														
					prev_guesses = "";
				}
				else{
					JOptionPane.showMessageDialog(null, "Thanks for playing");
					play = false;                                                        
				}
			}
		}
	}
}