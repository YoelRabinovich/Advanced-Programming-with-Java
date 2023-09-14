
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class TriviaController
{
	@FXML
	private Label questionLabel;
	@FXML
	private RadioButton option0RadioButton;
	@FXML
	private RadioButton option1RadioButton;
	@FXML
	private RadioButton option2RadioButton;
	@FXML
	private RadioButton option3RadioButton;
	@FXML
	private ToggleGroup group;
	@FXML
	private Button nextQuestionButton;

	private Game game;

	public void initialize()
	{
		game = new Game();
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
		{

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue)
			{
				nextQuestionButton.setDisable(false);
			}
		});
		restartGame();
	}

	@FXML
	private void restartGame()
	{
		game.reset();
		nextQuestion();
	}


	@FXML
	private void nextQuestion() {
		processSelectedAnswer();
		// Check if there are any more questions
		Question currentQuestion = game.getNextQuestion();
		if (currentQuestion != null) {
			questionLabel.setText(currentQuestion.getQuestion());
			ArrayList<String> allAnswers = new ArrayList<>();
			allAnswers.add(currentQuestion.getCorrectAnswer());
			allAnswers.addAll(currentQuestion.getWrongAnswers());
			Collections.shuffle(allAnswers);
			option0RadioButton.setText(allAnswers.get(0));
			option1RadioButton.setText(allAnswers.get(1));
			option2RadioButton.setText(allAnswers.get(2));
			option3RadioButton.setText(allAnswers.get(3));
			nextQuestionButton.setDisable(true);
		} else {
			finishGame();

		}
	}


	private void processSelectedAnswer()
	{
		RadioButton rb = (RadioButton) group.getSelectedToggle();
		if (rb == null)
		{
			return;
		}
		String selectedAnswer = rb.getText();
		if (game.checkAnswer(selectedAnswer))
		{
			new Alert(AlertType.CONFIRMATION, "You got it right!", ButtonType.OK).showAndWait();
		}
		else
		{
			new Alert(AlertType.WARNING, "Sorry, that's incorrect.\nThe right answer is: " + game.getCorrectAnswer()).showAndWait();
		}
		rb.setSelected(false);
	}



	@FXML
	private void finishGame()
	{
		int points = game.getScore();
		Alert alert1 = new Alert(AlertType.INFORMATION, "You scored " + points + " points");
		alert1.showAndWait();

		Alert alert2 = new Alert(AlertType.CONFIRMATION, "Do you want to play again?", ButtonType.YES, ButtonType.NO);
		Optional<ButtonType> optional = alert2.showAndWait();
		if (optional.get() == ButtonType.YES)
		{
			restartGame();
		}
		else
		{
			closeWindow();
		}
	}

	private void closeWindow()
	{
		Stage stage = (Stage) this.questionLabel.getScene().getWindow();
		stage.close();
	}
}