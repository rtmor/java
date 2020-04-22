import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
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
    private RadioButton radBlack;

    @FXML
    private ToggleGroup colorToggleGroup;

    @FXML
    private RadioButton radRed;

    @FXML
    private RadioButton radGreen;

    @FXML
    private RadioButton radBlue;

    @FXML
    private RadioButton radOrange;

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

    public void initialize() {

        radBlack.setUserData(Color.BLACK);
        radRed.setUserData(Color.RED);
        radGreen.setUserData(Color.GREEN);
        radBlue.setUserData(Color.BLUE);
        radOrange.setUserData(Color.ORANGE);

        radSmall.setUserData(PenSize.SMALL);
        radMedium.setUserData(PenSize.MEDIUM);
        radLarge.setUserData(PenSize.LARGE);

    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void colorRadioButtonSelected(ActionEvent event) {
        brushColor = (Color) colorToggleGroup.getSelectedToggle().getUserData();
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
        fileDialog.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("PNG File", "*.png"),
            new FileChooser.ExtensionFilter("JPEG File", "*.jpeg"),
            new FileChooser.ExtensionFilter("JPG File", "*.jpg")
        );
        fileDialog.setInitialDirectory(new File(System.getProperty("user.home") + "/Pictures"));
        fileDialog.setTitle("Load Image to Paint");
        File selectedFile = fileDialog.showOpenDialog(this.stage);
        if (selectedFile == null) {
            return;
        }
        try {
            String filename = selectedFile.getCanonicalPath();
            BackgroundImage paneBackground = new BackgroundImage(new Image ("file:///" + filename, drawingAreaPane.getWidth(),drawingAreaPane.getHeight(), false, true),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
          BackgroundSize.DEFAULT);
            drawingAreaPane.setBackground(new Background(paneBackground));
        } catch (Exception e){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR, "The requested file is not an image!" + selectedFile + e.getMessage());
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

    @FXML
    public void closeApplication(ActionEvent event) {

        Platform.exit();

    }
}
