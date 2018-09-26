package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));

		Scene scene = new Scene(root);

		stage.setTitle("Országos Múzeumi Adatbázis");
		stage.setWidth(985);
		stage.setHeight(676);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}


	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
