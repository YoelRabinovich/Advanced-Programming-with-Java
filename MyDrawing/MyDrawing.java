import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//the main class loads the FXML file (which made by using SceneBuilder)
public class MyDrawing extends Application{
	public void start(Stage stage) throws Exception{
		Parent root = (Parent)

				FXMLLoader.load(getClass().getResource("MyDrawing.fxml"));

		Scene scene = new Scene(root);
		stage.setTitle("MyDrawing");
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
		System.out.println();
	}
}                       