package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Classroom;
import model.UserAccount;

public class ClassroomGUI {
	Classroom classroom;
	ObservableList <UserAccount> observableList;
	
	
	private Stage mainStage;
	
	public ClassroomGUI() {
		classroom  = new Classroom();
		
	}
	
	//Ventana 1 "main-pane"
	
    public Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}

	@FXML
    private TextField txtUserName;

    @FXML
    private PasswordField txtPassword;

    @FXML
    public void logIn(ActionEvent event) throws IOException {
    	String user = txtUserName.getText();
    	String password = txtPassword.getText();
    	
    	if(classroom.checkAccount(user, password)) {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-list.fxml"));
        	fxmlLoader.setController(this);
        	Parent root = fxmlLoader.load();
        	Scene scene = new Scene(root);
        	
        	mainStage.setScene(scene);
        	mainStage.show();
        	initializeTableView();
        	
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("Classroom");
        	alert.setHeaderText("Error");
        	alert.setContentText("The username and password given are incorrect");
        	alert.show();
    	}
    	
    }

    @FXML
    public void signUp(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
    	fxmlLoader.setController(this);
    	Parent root = fxmlLoader.load();
    	Scene scene = new Scene (root);
    	
    	mainStage.setScene(scene);
    	mainStage.show();
    	initializeComboBox(); 
    }
    
    //Ventana 2 "register"
    

    @FXML
    private TextField txtCreateUsername;

    @FXML
    private PasswordField txtCreatePassword;

    @FXML
    private TextField txtCreateProfilePhoto;

    @FXML
    private ToggleGroup tgglGender;

    @FXML
    private CheckBox chbxSoftwareE;

    @FXML
    private CheckBox chbxTelematicE;

    @FXML
    private CheckBox chbxIndustrialE;

    @FXML
    private DatePicker dpBirthday;

    @FXML
    private ComboBox<String> cmbxChooseBrowser;
    
    public void initializeComboBox() {
    	List<String> browsers = new ArrayList<String>();
    	
    	String browser1 = "Google Chrome";
    	String browser2 = "Microsoft Edge";
    	String browser3 = "Mozilla Firefox";
    	String browser4 = "Internet Explorer";
    	String browser5 = "Safari";
    	String browser6 = "QQ Browser";
    	String browser7 = "Sogou Explorer";
    	String browser8 = "Opera";
    	String browser9 = "Other";
    	
    	browsers.add(browser1);
    	browsers.add(browser2);
    	browsers.add(browser3);
    	browsers.add(browser4);
    	browsers.add(browser5);
    	browsers.add(browser6);
    	browsers.add(browser7);
    	browsers.add(browser8);
    	browsers.add(browser9);
    	
    	ObservableList<String> observableList = FXCollections.observableArrayList(browsers);
    	cmbxChooseBrowser.setItems(observableList);
    }
    

    @FXML
    public void searchPhoto(ActionEvent event) throws IOException {
    	FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Imagen");
		File imgFile = fileChooser.showOpenDialog(null);
		if (imgFile != null) {
			String url = imgFile.getAbsolutePath();
			txtCreateProfilePhoto.setText(url);
		}

    }

    @FXML
    public void createAccount(ActionEvent event) throws FileNotFoundException, IOException, ClassNotFoundException {
    	String userName = txtCreateUsername.getText();
    	String password = txtCreatePassword.getText();
    	String profilePhoto = txtCreateProfilePhoto.getText();
    	String gender = ((RadioButton)tgglGender.getSelectedToggle()).getText();
    	String birthday = dpBirthday.getValue().toString();
    	String browser = cmbxChooseBrowser.getSelectionModel().getSelectedItem();
    	
    	ArrayList<String> careers = new ArrayList<String>(); 
    	if(chbxSoftwareE.isSelected()) {
    		careers.add(chbxSoftwareE.getText());
    	}
    	if(chbxTelematicE.isSelected()) {
    		careers.add(chbxTelematicE.getText());
    	}
    	if(chbxIndustrialE.isSelected()) {
    		careers.add(chbxIndustrialE.getText());
    	}
    	if((!chbxSoftwareE.isSelected())&&(!chbxTelematicE.isSelected())&&(!chbxIndustrialE.isSelected())) {
    		Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("Classroom");
        	alert.setHeaderText("Error");
        	alert.setContentText("You have to select a career");
        	alert.show();
    	}
    	
    	
    	
    	classroom.addUserAccount(userName, password, profilePhoto, gender, careers, birthday, browser);
    	classroom.saveUserAccount();
    	classroom.loadUserAccount();
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-list.fxml"));
    	fxmlLoader.setController(this);
    	Parent root = fxmlLoader.load();
    	Scene scene = new Scene(root);
    	
    	mainStage.setScene(scene);
    	mainStage.show();
    	initializeTableView();//<----------
    }
    

    @FXML
    public void signIn(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
    	fxmlLoader.setController(this);
    	Parent root = fxmlLoader.load();
    	Scene scene = new Scene(root);
    	
    	mainStage.setScene(scene);
    	mainStage.show();

    }
    
    // Ventana 3 "account-list"
    
    @FXML
    private Label lblUserName;

    @FXML
    private TableView<UserAccount> tvUserAccountList;

    @FXML
    private TableColumn<UserAccount, String> tcId;

    @FXML
    private TableColumn<UserAccount, String> tcUserName;

    @FXML
    private TableColumn<UserAccount, String> tcGender;

    @FXML
    private TableColumn<UserAccount, ArrayList<String>> tcCareer;

    @FXML
    private TableColumn<UserAccount, String> tcBirthday;

    @FXML
    private TableColumn<UserAccount, String> tcBrowser;

    @FXML
    private ImageView ivProfilePhoto;

    @FXML
    void logOut(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
    	fxmlLoader.setController(this);
    	Parent root = fxmlLoader.load();
    	Scene scene = new Scene(root);
    	
    	mainStage.setScene(scene);
    	mainStage.show();

    }
    
    @SuppressWarnings("unused")
	private void initializeTableView() {
    	observableList = FXCollections.observableArrayList(classroom.getUserAccounts());
    	tvUserAccountList.setItems(observableList);
    	tcId.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("id"));
    	tcUserName.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("userName"));
    	tcGender.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("gender"));
    	tcCareer.setCellValueFactory(new PropertyValueFactory<UserAccount, ArrayList<String>>("careers"));
    	tcBirthday.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("birthday"));
    	tcBrowser.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("browser"));
    }

}
