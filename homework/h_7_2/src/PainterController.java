import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PainterController {

    private enum PenSize {
        SMALL(2), MEDIUM(4), LARGE(6);

        private final int radius;

        PenSize(int radius) {
            this.radius = radius;
        }

        public int getRadius() {
            return radius;
        }
    };

    @FXML
    private Slider sldRed;

    @FXML
    private Slider sldGreen;

    @FXML
    private Slider sldBlue;

    @FXML
    private Slider sldAlpha;

    @FXML
    private TextField hexValue;

    @FXML
    private ToggleGroup colorToggleGroup;

    @FXML
    private RadioButton radSmall;

    @FXML
    private ToggleGroup sizeToggleGroup;

    @FXML
    private RadioButton radMedium;

    @FXML
    private RadioButton radLarge;

    @FXML
    private Button btnUndo;

    @FXML
    private Button btnClear;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private MenuItem menuSave;

    @FXML
    private MenuItem menuClose;

    private PenSize radius = PenSize.MEDIUM;
    private Paint brushColor = Color.BLACK;
    private Stage stage;

    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private double alpha = 1.0;
    private ArrayList<Slider> sliders = new ArrayList<>();

    public void initialize() {

        radSmall.setUserData(PenSize.SMALL);
        radMedium.setUserData(PenSize.MEDIUM);
        radLarge.setUserData(PenSize.LARGE);

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
                    brushColor = Color.rgb(red, green, blue, alpha);
                    hexValue.setText(retrieveHex());
                }
            });
        }

    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), radius.getRadius(), brushColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void sizeRadioButtonSelected(ActionEvent event) {
        radius = (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    void undoButtonPressed(ActionEvent event) {
        int count = drawingAreaPane.getChildren().size();

        if (count > 0) {
            drawingAreaPane.getChildren().remove(count - 1);
        }
    }

    @FXML
    private void loadImage(ActionEvent event) {
        FileChooser fileDialog = new FileChooser();
        fileDialog.setInitialFileName("*.png");
        fileDialog.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG File", "*.png"),
                new FileChooser.ExtensionFilter("JPEG File", "*.jpeg"),
                new FileChooser.ExtensionFilter("JPG File", "*.jpg"));
        fileDialog.setInitialDirectory(new File(System.getProperty("user.home") + "/Pictures"));
        fileDialog.setTitle("Load Image to Paint");
        File selectedFile = fileDialog.showOpenDialog(this.stage);
        if (selectedFile == null) {
            return;
        }
        try {
            String filename = selectedFile.getCanonicalPath();
            BackgroundImage paneBackground = new BackgroundImage(
                    new Image("file:///" + filename, drawingAreaPane.getWidth(), drawingAreaPane.getHeight(), false,
                            true),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);
            drawingAreaPane.setBackground(new Background(paneBackground));
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR,
                    "The requested file is not an image!" + selectedFile + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    @FXML
    private void saveImage(ActionEvent event) {
        FileChooser fileDialog = new FileChooser();
        fileDialog.setInitialFileName("imagefile.png");
        fileDialog.setInitialDirectory(new File(System.getProperty("user.home") + "/Pictures"));
        fileDialog.setTitle("Select File to Save. Name MUST end with .png!");
        File selectedFile = fileDialog.showSaveDialog(this.stage);
        if (selectedFile == null)
            return; // User did not select a file.
        try {
            Image canvasImage = drawingAreaPane.snapshot(null, null);
            BufferedImage image = SwingFXUtils.fromFXImage(canvasImage, null);
            String filename = selectedFile.getName().toLowerCase();
            if (!filename.endsWith(".png")) {
                throw new Exception("The file name must end with \".png\".");
            }
            boolean hasFormat = ImageIO.write(image, "PNG", selectedFile);
            if (!hasFormat) { // (this should never happen)
                throw new Exception("PNG format not available.");
            }
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR,
                    "Sorry, an error occurred while\ntrying to save the image:\n" + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    public String retrieveHex() {

        String redValue = Integer.toHexString(0x100 | red).substring(1);
        String greenValue = Integer.toHexString(0x100 | green).substring(1);
        String blueValue = Integer.toHexString(0x100 | blue).substring(1);

        /**
         * determine alpha value hex alpha value x00-xFF (0-255) is proportional to
         * (base 10) 1-100 (int n * 2.55 + 0.167) linear regression slope that
         * approximates this value
         */
        String alphaValue = Integer.toHexString(0x100 | (int) (alpha * 100 * 2.55 + 0.167)).substring(1);

        return ("#" + redValue + greenValue + blueValue + alphaValue);

    }

    @FXML
    public void closeApplication(ActionEvent event) {

        Platform.exit();

    }
}
