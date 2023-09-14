import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.ArcType;

public class HangManController
{
	@FXML
	private Label LivesLeft;
	@FXML
	private HBox hboxLetters;
	@FXML
	private Canvas cnv;
	@FXML
	private HBox hboxUsedLetters;
	@FXML
	private Label labelWordStatus;
	private Game game;
	private GraphicsContext gc;
	private final int MAX_TRYS=9;

	@FXML
	public void initialize()
	{
		for (char c = 'A'; c <= 'Z'; c++)
		{
			Button button = new Button("" + c);
			button.setMinSize(10, 10);
			button.setStyle("-fx-background-color: white; -fx-text-fill: blue;");
			hboxLetters.getChildren().add(button);
			button.setOnAction(this::handleButtonAction);
		}

		game = new Game();
		gc = cnv.getGraphicsContext2D();
		restartGame();
	}

	private void handleButtonAction(ActionEvent event)
	{
		Button button = (Button) event.getSource();
		handleLetter(button.getText().charAt(0));
		button.setDisable(true);
	}


	@FXML
	private void restartGame()
	{
		game.newGame();
		LivesLeft.setText(String.valueOf(MAX_TRYS));
		labelWordStatus.setText(game.wordStatus());
		hboxUsedLetters.getChildren().clear();
		gc.clearRect(0, 0, cnv.getWidth(), cnv.getHeight());
		updateLetters(false);
	}




	protected void handleLetter(char letter)
	{
		hboxUsedLetters.getChildren().add(new Label("" + letter));
		if (game.checkLetter(letter))
		{
			labelWordStatus.setText(game.wordStatus());
		}
		else
		{
			drawHangMan();
		}

		if (game.isGameOver())
		{
			endGame();
			showGameOverAlert();
		}
	}

	private void showGameOverAlert()
	{
		Alert alert;
		if (game.hasWon())
		{
			alert = new Alert(AlertType.INFORMATION, "Congratulations");
		}
		else
		{
			alert = new Alert(AlertType.ERROR, "Better luck next time");
		}
		alert.showAndWait();
	}



	private void endGame()
	{
		updateLetters(true);
	}

	private void updateLetters(boolean disable)
	{
		for (Node node : hboxLetters.getChildren())
		{
			node.setDisable(disable);
		}
	}


	private void drawHangMan()
	{
		LinearGradient gradient = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE,
				new Stop(0, Color.BLUE), new Stop(1, Color.VIOLET));
		gc.setStroke(gradient);

		gc.setLineWidth(10);

		int mistakes = game.mistakesCount();
		LivesLeft.setText(String.valueOf(MAX_TRYS - mistakes));

		switch (mistakes)
		{
		case 1:
			drawBase();
			break;
		case 2:
			drawPole();
			break;
		case 3:
			drawBar();
			break;
		case 4:
			drawHead();
			break;
		case 5:
			drawBody();
			break;
		case 6:
			drawLeftHand();
			break;
		case 7:
			drawRightHand();
			break;
		case 8:
			drawLeftLeg();
			break;
		case 9:
			drawRightLeg();
			break;
		}
	}


	private void drawRightLeg()
	{	
		gc.strokeLine(185, 300, 220, 350);

	}

	private void drawLeftLeg()
	{
		gc.strokeLine(185, 300, 150, 350);

	}

	private void drawRightHand()
	{
		gc.strokeLine(185, 210, 220, 230);

	}

	private void drawLeftHand()
	{
		gc.strokeLine(185, 210, 150, 230);

	}

	private void drawBody()
	{
		gc.strokeLine(185, 200, 185, 300);

	}

	private void drawHead()
	{
		gc.strokeOval(160, 120, 50, 80);
		gc.strokeOval(165, 150, 10, 10); // left eye
		gc.strokeOval(190, 150, 10, 10); // right eye
		gc.strokeArc(175, 175, 20, 20, 0, 180, ArcType.OPEN); // smile

	}

	private void drawBar()
	{
		gc.strokeLine(110, 100, 200, 100);

	}

	private void drawPole()
	{
		gc.strokeLine(110, 400, 110, 100);

	}

	private void drawBase()
	{
		gc.strokeLine(20, 400, 200, 400);


	}




}