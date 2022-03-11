import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class FunctionCalculatorReport extends GridPane {

	private static Button report, clear;
	private static TextArea output;
	private static Label tittle;

	public FunctionCalculatorReport() {

		Font font = new Font(40);

		tittle = new Label("History");
		tittle.setFont(font);

		output = new TextArea("No data");
		output.setEditable(false);
		output.setWrapText(true);

		report = new Button("Exit");
		report.setOnAction(this::processExit);
		report.setAlignment(Pos.CENTER_LEFT);

		clear = new Button("Clear Report");
		clear.setOnAction(this::processClearHistory);
		clear.setAlignment(Pos.CENTER_RIGHT);

		HBox hbox2 = new HBox(report, clear);
		hbox2.setSpacing(450);

		VBox vbox = new VBox(tittle, output, hbox2);
		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(10);

		getChildren().addAll(vbox);
	}

	public void processClearHistory(ActionEvent event) {

		output.setText("No data");
		FunctionCalculatorMain.clearHistory();

	}

	public void processExit(ActionEvent event) {
		FunctionCalculatorMain.exitReport();
	}

	public static void getReport(String result) {
		output.setText(result);
	}

}