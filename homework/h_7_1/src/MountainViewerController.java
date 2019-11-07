import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Callback;

public class MountainViewerController {

	@FXML
	private ListView<Employee> employeeListView;

	@FXML
	private Button btnAdd;

	@FXML
	private TextField employeeIDField;

	@FXML
	private TextField emplyeeFirstField;

	@FXML
	private TextField emplyeeLastField;

	@FXML
	private TextField emplyeePhoneField;

	@FXML
	private TextArea employeeView;

	@FXML
	private MenuItem addMenu;

	@FXML
	private MenuItem removeMenu;

	@FXML
	private ContextMenu contextMenu;

	private final ObservableList<Employee> employees = FXCollections.observableArrayList();

	@FXML
	void addEmployee(ActionEvent event) throws UnsupportedEncodingException, NoSuchAlgorithmException {

		Employee e = new Employee(employeeIDField.getText(), emplyeeFirstField.getText(), emplyeeLastField.getText(),
				emplyeePhoneField.getText());
		e.write(e);
		employees.add(e);

		employeeListView.setItems(employees);

		ArrayList<TextField> empProperties = new ArrayList<>();
		Collections.addAll(empProperties, employeeIDField, emplyeeFirstField, emplyeeLastField, emplyeePhoneField);

		for (TextField prop : empProperties) {
			prop.clear();
		}

	}

	@FXML
	void removeEmployee(ActionEvent event) throws NoSuchAlgorithmException {

		int index = employeeListView.getSelectionModel().getSelectedIndex();

		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] bytesOfMessage = md.digest(employees.get(index).getIdNumber().getBytes());
		BigInteger no = new BigInteger(1, bytesOfMessage);
		String filename = no.toString(16);

		while (filename.length() < 32) {
			filename = "0" + filename;
		}
		File file = new File("C:/Users/rtmor/java/homework/h_7_1/src/employees/" + filename);

		try {
			file.delete();
		} catch (Exception ex) {
		}

		employees.remove(employeeListView.getSelectionModel().getSelectedIndex());
		employeeListView.setItems(employees);
	}

	public void initialize() throws ClassNotFoundException {

		FileInputStream fis = null;
		ObjectInputStream in = null;
		File file = new File("C:/Users/rtmor/java/homework/h_7_1/src/employees/");
		File[] files = file.listFiles();
		if (file.isDirectory()) {
			try {
				for (File f : files) {
					fis = new FileInputStream(f);
					in = new ObjectInputStream(fis);
					employees.add((Employee) in.readObject());
				}
			} catch (IOException e) {

			}
		}

		employeeListView.setItems(employees);

		employeeListView.getSelectionModel().selectedItemProperty().addListener(

				new ChangeListener<Employee>() {

					@Override
					public void changed(ObservableValue<? extends Employee> ov, Employee oldValue, Employee newValue) {
						// TODO Auto-generated method stub
						int index = employeeListView.getSelectionModel().getSelectedIndex();
						String id = employees.get(index).getIdNumber();
						String first = employees.get(index).getFirstName();
						String last = employees.get(index).getLastName();
						String phone = employees.get(index).getPhoneNumber();

						employeeView.setText("Employee Record\n\n" + "ID: " + id + "\nFirst Name: " + first
								+ "\nLast Name: " + last + "\nPhone Number: " + phone);
					}

				});

		employeeListView.setCellFactory(new Callback<ListView<Employee>, ListCell<Employee>>() {

			@Override
			public ListCell<Employee> call(ListView<Employee> listView) {
				return new ImageTextCell();
			}

		});

	}

}
