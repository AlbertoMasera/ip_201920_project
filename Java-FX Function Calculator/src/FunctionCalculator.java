import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FunctionCalculator extends Application {
	
	static Scene scene1;
	static Stage stage1;
	
	public void start(Stage primaryStage) {
		
		stage1=primaryStage;
		
		FunctionCalculatorMain main = new FunctionCalculatorMain();
		main.setAlignment(Pos.CENTER);
		main.setStyle("-fx-background-color: lightblue");
		
		scene1 = new Scene(main, 700, 500);
		
		primaryStage.setTitle("Function Calculator");
		primaryStage.setScene(scene1);
		primaryStage.show();
		primaryStage.setResizable(false);
		
	}
	
	public static void main(String[] args) {
			launch(args);
		}
	
}