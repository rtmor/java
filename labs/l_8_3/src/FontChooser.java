import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import static java.util.stream.Collectors.toList;
import static javafx.collections.FXCollections.observableList;
import static java.util.stream.IntStream.rangeClosed;

public class FontChooser extends Application {

    @FXML
    private Pane fontDisplay;

    @FXML
    private ComboBox<String> fontFace;

    @FXML
    private ComboBox<Double> fontSize;

    @FXML
    private ComboBox<String> fontStyle;

    @FXML
    private HBox fontBox;

    private Label fontText = new Label("Hello World!");
    private ObservableList<Double> sizes = FXCollections.observableArrayList();

    @FXML
    void initialize() {

        // add system fonts to fontFace menu
        ObservableList<String> fonts = FXCollections.observableArrayList(Font.getFamilies());
        fontFace.setItems(fonts);

        // obtain double range and append to fontSize menu
        sizes.addAll(observableList(rangeClosed(28, 70).asDoubleStream().boxed().collect(toList())));
        fontSize.getItems().addAll(sizes);

        fontStyle.getItems().addAll("Normal", "Bold", "Italic", "Underline");

        // set default menu values
        fontFace.setPromptText("Font Face");
        fontFace.setValue("Arial");
        fontSize.setPromptText("Font Size");
        fontSize.setValue(32.0);
        fontStyle.setPromptText("Font Style");
        fontStyle.setValue("Normal");

        // build menus to hbox
        fontBox.getChildren().clear();
        fontBox.getChildren().addAll(fontFace, fontSize, fontStyle);

        // stand-up listeners
        fontFace.valueProperty().addListener((ov, oldValue, newValue) -> {
            changeLabel(fontFace.getValue(), fontSize.getValue(), fontStyle.getValue());
        });

        fontSize.valueProperty().addListener((ov, oldValue, newValue) -> {
            changeLabel(fontFace.getValue(), fontSize.getValue(), fontStyle.getValue());
        });

        fontStyle.valueProperty().addListener((ov, oldValue, newValue) -> {
            changeLabel(fontFace.getValue(), fontSize.getValue(), fontStyle.getValue());
        });

        // set label center - relative to frame
        fontText.layoutXProperty().bind(fontDisplay.widthProperty().subtract(fontText.widthProperty()).divide(2));
        fontText.layoutYProperty().bind(fontDisplay.heightProperty().subtract(fontText.heightProperty()).divide(2));
        fontText.setFont(Font.font(fontFace.getValue(), FontWeight.valueOf(fontStyle.getValue().toUpperCase()),
                fontSize.getValue()));
        
        // set label text color
        fontText.setTextFill(Color.web("#b48ead"));
        
        // set pane backround and attach text label
        fontDisplay.setBackground(new Background(new BackgroundFill(Color.web("#3b4252"), null, null)));
        fontDisplay.getChildren().add(fontText);

    }

    public void changeLabel(String fontFace, Double fontSize, String fontStyle) {

        fontText.setUnderline(fontStyle.equals("Underline") ? true : false);

        switch (fontStyle) {
        case "Bold":
        case "Normal":
            fontText.setFont(Font.font(fontFace, FontWeight.valueOf(fontStyle.toUpperCase()), fontSize));
            break;
        case "Italic":
            fontText.setFont(Font.font(fontFace, FontWeight.NORMAL,FontPosture.ITALIC, fontSize));
            break;
        case "Underline":
            fontText.setFont(Font.font(fontFace, FontWeight.NORMAL, fontSize));
            break;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Fonts.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setTitle("Font Chooser");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
