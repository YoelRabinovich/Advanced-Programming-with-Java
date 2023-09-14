
public class Game
{
	private QuestionBank questionsBank;
	private int score;
	private Question current;
	private static final String FILE  = "./trivia.txt";
	private static final int CORRECT_SCORE  = 10;
	private static final int WRONG_SCORE  = 5;

	public Game()
	{
		questionsBank = new QuestionBank(FILE );
	}

	public void reset()
	{
		questionsBank.restart();
		score = 0;
	}

	public Question getNextQuestion() {
		try {
			return current = questionsBank.nextQuestiion();
		} catch (IndexOutOfBoundsException e) {
			// return null to indicate that there are no more questions
			return null;
		}
	}


	public int getScore()
	{
		return score;
	}

	public boolean checkAnswer(String selectedAnswer)
	{
		if (current.getCorrectAnswer().equals(selectedAnswer))
		{
			score += CORRECT_SCORE ;
			return true;
		}

		score -= WRONG_SCORE ;
		return false;
	}



	public String getCorrectAnswer()
	{
		return current.getCorrectAnswer();
	}

}