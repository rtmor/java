import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorChooserController {

	@FXML
	private Slider sldRed;

	@FXML
	private Slider sldGreen;

	@FXML
	private Slider sldBlue;

	@FXML
	private Slider sldAlpha;

	@FXML
	private TextField txtRed;

	@FXML
	private TextField txtGreen;

	@FXML
	private TextField txtBlue;

	@FXML
	private TextField txtAlpha;

	@FXML
	private Rectangle colorRectangle;

	@FXML
	private TextField hexValue;

	private int red = 0;
	private int green = 0;
	private int blue = 0;
	private double alpha = 1.0;
	private ArrayList<Slider> sliders = new ArrayList<>();

	public void initialize() {

		txtRed.textProperty().bind(sldRed.valueProperty().asString("%.0f"));
		txtGreen.textProperty().bind(sldGreen.valueProperty().asString("%.0f"));
		txtBlue.textProperty().bind(sldBlue.valueProperty().asString("%.0f"));
		txtAlpha.textProperty().bind(sldAlpha.valueProperty().asString("%.2f"));

		Collections.addAll(sliders, sldRed, sldGreen, sldBlue, sldAlpha);

		for (Slider slider : sliders) {
			slider.valueProperty().addListener(new ChangeListener<Number>() {
				public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
					switch (slider.getId()) {
					case "sldRed":
						red = newValue.intValue();
						break;
					case "sldGreen":
						green = newValue.intValue();
						break;
					case "sldBlue":
						blue = newValue.intValue();
						break;
					case "sldAlpha":
						alpha = newValue.doubleValue();
						break;
					}
					colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
					hexValue.setText(retrieveHex());
				}
			});
		}
	}

	public String retrieveHex() {

		String redValue = Integer.toHexString(0x100 | red).substring(1);
		String greenValue = Integer.toHexString(0x100 | green).substring(1);
		String blueValue = Integer.toHexString(0x100 | blue).substring(1);

		/**
		 * determine alpha value
		 * hex alpha value x00-xFF (0-255) is proportional to (base 10) 1-100
		 * (int n * 2.55 + 0.167) linear regression slope that approximates this value
		 */
		String alphaValue = Integer.toHexString(0x100 | (int) (alpha * 100 * 2.55 + 0.167)).substring(1);

		return ("#" + redValue + greenValue + blueValue + alphaValue);

	}
}
