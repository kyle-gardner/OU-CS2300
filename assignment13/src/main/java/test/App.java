package test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import test.Converter.Operation;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
	private Label convertedLabel;
	private ChoiceBox<String> unitBox;
	private TextField textField;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(createRoot(), 640, 300);
        stage.setScene(scene);
        stage.show();
    }
	public VBox createRoot() {
		VBox root = new VBox();

		root.setPadding(new Insets(40));
		root.setAlignment(Pos.TOP_CENTER);
		root.setSpacing(10);


		HBox topRow = createTopRow();
		HBox bottomRow = createBottomRow();

		root.getChildren().addAll(topRow, bottomRow);
		return root;
	}
	public HBox createTopRow() {
		Label x = new Label("Number you want to convert");
		textField = new TextField();

		unitBox = new ChoiceBox<String>();
		unitBox.getItems().add("KG -> LBS");
		unitBox.getItems().add("MI -> KM");
		unitBox.getItems().add("G -> OZ");
		unitBox.getItems().add("MM -> IN");

		Button enterButton = new Button("Enter");
		enterButton.setOnAction(event -> {
			handleEnter();
		});

		HBox topRow = new HBox(x, textField, unitBox, enterButton);
		HBox.setHgrow(topRow, Priority.NEVER);
		topRow.setSpacing(15);
		topRow.setAlignment(Pos.CENTER);

		return topRow;
	}
	private void handleEnter() {
		String input = textField.getText();
		String x = unitBox.getValue();
		Operation op; 
		String unit = new String();

		if (x == "KG -> LBS") {
			op = Operation.KG_LBS;
			unit = " lbs";
		} else if (x == "MI -> KM") {
			op = Operation.MI_KM;
			unit = " km";
		} else if (x == "G -> OZ") {
			op = Operation.G_OZ;
			unit = " oz";
		} else if (x == "MM -> IN") {
			op = Operation.MM_IN;
			unit = " in";
		} else {
			op = Operation.INVALID;
			unit = "";
		}

		convertedLabel.setText(Converter.convert(input, op) + unit);
	}
	public HBox createBottomRow() {
		convertedLabel = new Label();
		convertedLabel.setFont(new Font(30));
		HBox z = new HBox(convertedLabel);
		z.setPadding(new Insets(20));
		return z;
	}

    public static void main(String[] args) {
        launch();
    }

}