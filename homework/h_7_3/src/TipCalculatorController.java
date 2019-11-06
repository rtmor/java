import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class TipCalculatorController {

	private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
	private static final NumberFormat percent = NumberFormat.getPercentInstance();

	private double tipPercentage = 0.15;

	private double partySize = 1;

	@FXML
	private Label lblTipPercentage;

	@FXML
	private TextField txtAmount;

	@FXML
	private Label lblPartySize;

	@FXML
	private TextField txtTip;

	@FXML
	private TextField txtTotal;

	@FXML
	private Slider sldTipPercentage;

	@FXML
	private Slider sldPartySize;

	@FXML
	private Button btnCalculate;

	@FXML
	void calculateButtonPressed(ActionEvent event) {
		try {
			double amount = Double.parseDouble(txtAmount.getText()) / partySize;
			double tip = amount * tipPercentage;
			double total = amount + tip;

			txtTip.setText(currency.format(tip));
			txtTotal.setText(currency.format(total));
		} catch (NumberFormatException ex) {
			txtAmount.setText("Enter amount");
			txtAmount.selectAll();
			txtAmount.requestFocus();
		}
	}

	public void initialize() {

		currency.setRoundingMode(RoundingMode.HALF_UP);

		sldTipPercentage.valueProperty().addListener((observable, oldValue, newValue) -> {

			tipPercentage = newValue.intValue() / 100.0;
			lblTipPercentage.setText(percent.format(tipPercentage));
			calculateButtonPressed(null);

		});

		sldPartySize.valueProperty().addListener((observable, oldValue, newValue) -> {

			partySize = newValue.intValue();
			lblPartySize.setText("Party Size : " + (int) partySize);
			calculateButtonPressed(null);

		});

		txtAmount.textProperty().addListener((observable, oldValue, newValue) -> {

			if (newValue.isEmpty() || !(newValue.matches("[0-9.]+"))) {
				txtTip.clear();
				txtTotal.clear();
			} else {
				calculateButtonPressed(null);
			}

		});
	}

}
