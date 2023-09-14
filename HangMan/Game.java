import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Game
{
	private static final String FILE_NAME = "./words.txt";

	private static final int MAX_TRYS = 9;

	private ArrayList<String> words;

	private String currentSelection;

	private HashSet<Character> guesses;

	private int Mistakes;

	public Game()
	{
		words = new ArrayList<>();
		guesses = new HashSet<>();
		readFile(FILE_NAME);
	}


	private void readFile(String fileName) {
		// Use a try-with-resources statement to automatically close the Scanner
		try (Scanner input = new Scanner(new File(fileName))) {
			while (input.hasNext()) {
				String word = input.next();
				words.add(word);
			}
			// Check if there were any words in the file
			if (words.isEmpty()) {
				System.out.println("Error: no words found in the file");
				System.exit(1); //  termination
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}



	public boolean checkLetter(char letter)
	{
		if (!guesses.contains(letter))
		{
			guesses.add(letter);

			if (currentSelection.indexOf(letter) >= 0)
			{
				return true;
			}
			else
			{
				Mistakes++;
				return false;
			}
		}
		else
		{
			return false;
		}
	}


	public void newGame() {
		// Check if there are any words in the file
		if (!words.isEmpty()) {
			currentSelection = words.get((int) (Math.random() * words.size())).toUpperCase();
			guesses.clear();
			Mistakes = 0;
		} else {
			System.out.println("Error: no words found in the file");
		}
	}


	public String wordStatus() {
		StringBuilder sb = new StringBuilder();

		// Check if there are any words in the file
		if (currentSelection != null) {
			for (char ch : currentSelection.toCharArray()) {
				if (guesses.contains(ch)) {
					sb.append(ch);
				} else {
					sb.append('_');
				}
			}
		}

		return sb.toString();
	}



	public boolean isGameOver()
	{
		return hasWon() || hasLost();
	}

	private boolean hasLost()
	{
		return Mistakes == MAX_TRYS;
	}

	protected boolean hasWon()
	{
		for (char ch : currentSelection.toCharArray())
		{
			if (!guesses.contains(ch))
			{
				return false;
			}
		}

		return true;
	}


	public int mistakesCount()
	{
		return Mistakes;
	}

}