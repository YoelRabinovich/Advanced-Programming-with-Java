import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuestionBank
{
	private static final int TEXT_QUESTION = 0;
	private static final int TEXT_RIGHT_ANSWER = 1;

	private int currQuestionIndex;
	private ArrayList<Question> questions;

	public QuestionBank(String fileName)
	{
		questions = new ArrayList<>();
		readQuestionsFromFile(fileName);
	}

	
	private void readQuestionsFromFile(String fileName) {
	    // Use a try-with-resources statement to ensure that the Scanner is closed properly
	    try (Scanner input = new Scanner(new File(fileName))) {
	        Question question = null;
	        int count = 0;
	        while (input.hasNext()) {
	            String st = input.nextLine();

	            // Use a switch statement to handle the different lines of the file
	            switch (count++ % 5) {
	                case TEXT_QUESTION:
	                    if (question != null) {
	                        questions.add(question);
	                    }
	                    question = new Question(st);
	                    break;
	                case TEXT_RIGHT_ANSWER:
	                    question.setCorrectAnswer(st);
	                    break;
	                default:
	                    question.addWongAnswer(st);
	                    break;
	            }
	        }
	        // Check if there were any questions in the file
	        if (question == null) {
	            System.out.println("Error: no questions found in the file");
	            System.exit(1);
	        }
	    } catch (FileNotFoundException e) {
	        // Print the error message and exit the program with a non-zero value to indicate failure
	        System.out.println("Error: file not found");
	        System.exit(1);
	    }
	}


	public Question nextQuestiion()
	{
		return questions.get(currQuestionIndex++);
	}

	public void restart()
	{
		currQuestionIndex = 0;
		Collections.shuffle(questions);
	}

}