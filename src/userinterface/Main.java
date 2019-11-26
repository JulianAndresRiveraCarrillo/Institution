package userinterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
		Scene scene = new Scene(root);
		arg0.setTitle("Institution");
		arg0.setScene(scene);
		arg0.setMaximized(true);
		arg0.show();
	}

}
