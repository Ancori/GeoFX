package dad.geofx.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class App extends Application {
	private ViewController controller;
	private static Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		App.primaryStage = primaryStage;
		controller = new ViewController();
		Scene scene = new Scene(controller.getView());
		primaryStage.setOnCloseRequest(e -> {
			if (App.confirm("Salir", "Vas a salir de la aplicación", "¿Estas segur@?")) {
				System.exit(0);
			}
			e.consume();
		});
		primaryStage.setTitle("GEOFX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
	

	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	

	public static boolean confirm(String titulo,String cabezero,String Contenido) {
		Alert alert=new Alert(AlertType.CONFIRMATION);
		alert.initOwner(primaryStage);
		alert.setTitle(titulo);
		alert.setHeaderText(cabezero);
		alert.setContentText(Contenido);
		return alert.showAndWait().get().equals(ButtonType.OK);
	}
	public static void error(String cabezero,String Contenido) {
		Alert alert=new Alert(AlertType.ERROR);
		alert.initOwner(primaryStage);
		alert.setTitle("Error");
		alert.setHeaderText(cabezero);
		alert.setContentText(Contenido);
		alert.showAndWait();
	}
	public static void info(String titulo,String cabezero,String Contenido) {
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.initOwner(primaryStage);
		alert.setTitle(titulo);
		alert.setHeaderText(cabezero);
		alert.setContentText(Contenido);
		alert.showAndWait();
	}

}
