package ui;

import java.io.IOException;

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
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import model.Career;
import model.Classroom;
import model.FavoriteBrowser;
import model.Gender;
import model.UserAccount;

public class ClassroomGUI {
	
	private Classroom classroom;
	
    @FXML
    private BorderPane mainPanel;
    
    @FXML
    private TextField txtName;

    @FXML
    private PasswordField txtPassword;
    
    @FXML
    private TextField txtNewUsername;

    @FXML
    private TextField txtUrlPhoto;

    @FXML
    private RadioButton rbMale;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton rbFemale;

    @FXML
    private RadioButton rbOther;

    @FXML
    private CheckBox cbSIS;

    @FXML
    private CheckBox cbTEL;

    @FXML
    private CheckBox cbIND;

    @FXML
    private DatePicker dpBirth;

    @FXML
    private ComboBox<FavoriteBrowser> cmbxBrowser;

    @FXML
    private PasswordField txtNewUserPassword;
    
    @FXML
    private TableView<UserAccount> tvUserAccountList;

    @FXML
    private TableColumn<UserAccount, String> tcUserName;

    @FXML
    private TableColumn<UserAccount, Gender> tcGender;

    @FXML
    private TableColumn<UserAccount, Career> tcCareer;

    @FXML
    private TableColumn<UserAccount, String> tcBirthday;

    @FXML
    private TableColumn<UserAccount, FavoriteBrowser> tcBrowser;

    @FXML
    private Label labUsername;

    @FXML
    private Label labIconProfile;
    
    public ClassroomGUI(Classroom cr) {
		classroom = cr;
	}

    @FXML
    public void loadUserAccountList(ActionEvent event) throws IOException {

    }

    @FXML
    public void registerNewUser(ActionEvent event) throws IOException {

    }

    @FXML
    public void chooseProfilePhoto(ActionEvent event) throws IOException {

    }

    @FXML
    public void createAccountButtonAction(ActionEvent event) throws IOException {

    }

    @FXML
    public void signIn2ButtonAction(ActionEvent event) throws IOException {

    }
    
    @FXML
    public void logOutButtonAction(ActionEvent event) throws IOException {

    }
}
