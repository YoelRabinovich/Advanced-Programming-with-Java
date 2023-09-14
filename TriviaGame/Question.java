import java.util.ArrayList;

public class Question
{

	private String question;
	private String correctAnswer;
	private ArrayList<String> wrongAnswers;

	public Question(String quesion)
	{
		this.question = quesion;
		wrongAnswers = new ArrayList<>();
	}

	public void setCorrectAnswer(String string)
	{
		correctAnswer = string;
	}

	public void addWongAnswer(String string)
	{
		wrongAnswers.add(string);
	}

	public String getQuestion()
	{
		return question;
	}

	public String getCorrectAnswer()
	{
		return correctAnswer;
	}

	public ArrayList<String> getWrongAnswers()
	{
		return wrongAnswers;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("TriviaQuestion [question=").append(question)
		.append(", rightAnswer=").append(correctAnswer)
		.append(", wrongAnswers=").append(wrongAnswers)
		.append("]");
		return sb.toString();
	}



}