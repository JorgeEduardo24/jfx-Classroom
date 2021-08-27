package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ClassroomGUI {
	
	//Ventana 1 "main-pane"
	
    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtPassword;

    @FXML
    void logIn(ActionEvent event) {

    }

    @FXML
    void signUp(ActionEvent event) {

    }
    
    //Ventana 2 "register"
    

    @FXML
    private TextField txtCreateUsername;

    @FXML
    private PasswordField txtCreatePassword;

    @FXML
    private TextField txtCreateProfilePhoto;

    @FXML
    private RadioButton rbMale;

    @FXML
    private RadioButton rbFemale;

    @FXML
    private RadioButton rbOther;

    @FXML
    private CheckBox chbxSoftwareE;

    @FXML
    private CheckBox chbxTelematicE;

    @FXML
    private CheckBox chbxIndustrialE;

    @FXML
    private DatePicker dpBirthday;

    @FXML
    private ComboBox<?> cmbxChooseBrowser;

    @FXML
    void createAccount(ActionEvent event) {

    }

    @FXML
    void searchPhoto(ActionEvent event) {

    }

    @FXML
    void signIn(ActionEvent event) {

    }
    
    // Ventana 3 "account-list"
    
    @FXML
    private Label lblUserName;

    @FXML
    private TableView<?> tvUserAccountList;

    @FXML
    private TableColumn<?, ?> tcUserName;

    @FXML
    private TableColumn<?, ?> tcGender;

    @FXML
    private TableColumn<?, ?> tcCareer;

    @FXML
    private TableColumn<?, ?> tcBirthday;

    @FXML
    private TableColumn<?, ?> tcBrowser;

    @FXML
    private ImageView ivProfilePhoto;

    @FXML
    void logOut(ActionEvent event) {

    }
    
}
