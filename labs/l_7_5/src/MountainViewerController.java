import java.io.File;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MountainViewerController {

    @FXML
    private ListView<Mountain> mountainsListView;

    @FXML
	private ImageView mountainsImageView;
	
	@FXML
	private MenuItem addMenu;

	@FXML
	private MenuItem removeMenu;

	@FXML
	private ContextMenu contextMenu;
    
	private final ObservableList<Mountain> mountains = FXCollections.observableArrayList();
	private Stage stage;
	
    @FXML
    void addImage(ActionEvent event) {

		FileChooser fc = new FileChooser();
		fc.setInitialFileName("*.png");
		fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Pictures"));
		fc.setTitle("Load Image");
		File selectedFile = fc.showOpenDialog(this.stage);
		if (selectedFile == null) {
			return;
		}
		try {
			String filePath = selectedFile.getCanonicalPath();
			String fileName = selectedFile.getName();
			mountains.add(new Mountain(fileName, "file:///" + filePath, "file:///" + filePath));
			mountainsListView.setItems(mountains);
		} catch (Exception e) {
			Alert error = new Alert(Alert.AlertType.ERROR,
					"Can not import the requested file!" + selectedFile + e.getMessage());
			error.showAndWait();
		}
	}

    @FXML
    void removeImage(ActionEvent event) {

		mountains.remove(mountainsListView.getSelectionModel().getSelectedIndex());
		mountainsListView.setItems(mountains);
	}
    
    public void initialize() {
    	
    	mountains.add(new Mountain("Abraham - Maine", "/images/small/abraham.jpg", "/images/large/abraham.jpg"));
    	mountains.add(new Mountain("Greylock - Massachusetts", "/images/small/greylock.jpg", "/images/large/greylock.jpg"));
    	mountains.add(new Mountain("Jacques Cartier - Quebec", "/images/small/jacquescartier.jpg", "/images/large/jacquescartier.jpg"));
    	mountains.add(new Mountain("Mansfield - Vermont", "/images/small/mansfield.jpg", "/images/large/mansfield.jpg"));
    	mountains.add(new Mountain("Marcy - New York", "/images/small/marcy.jpg", "/images/large/marcy.jpg"));
    	mountains.add(new Mountain("Slide - New York", "/images/small/slide.jpg", "/images/large/slide.jpg"));
    	mountains.add(new Mountain("Washington - New Hampshire", "/images/small/washington.jpg", "/images/large/washington.jpg"));
    	
    	mountainsListView.setItems(mountains);
    	
    	mountainsListView.getSelectionModel().selectedItemProperty().addListener(
    			
    			new ChangeListener<Mountain>() {

					@Override
					public void changed(ObservableValue<? extends Mountain> ov, Mountain oldValue, Mountain newValue) {
						// TODO Auto-generated method stub
						mountainsImageView.setImage(new Image(newValue.getLargeImage()));
					}
    				
    			}
    	);
    	
    	mountainsListView.setCellFactory(
    			new Callback<ListView<Mountain>, ListCell<Mountain>>() {

					@Override
					public ListCell<Mountain> call(ListView<Mountain> listView) {
						return new ImageTextCell();
					}
    				
    			}
    		);
    	
    }

}
