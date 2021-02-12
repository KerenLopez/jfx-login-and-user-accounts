package ui;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
import javafx.scene.control.cell.PropertyValueFactory;
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
    private ComboBox<String> cmbxBrowser;

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

    public void loadLoginForm() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		fxmlLoader.setController(this);
		Parent loginPane = fxmlLoader.load();
		mainPanel.getChildren().clear();
		mainPanel.setTop(loginPane);
    }
    
    @FXML
    public void loadUserAccountList(ActionEvent event) throws IOException {
    	if(!txtName.getText().equals("") && !txtPassword.getText().equals("")) {
    		String strUsername =  txtName.getText();
        	String strPassword =  txtPassword.getText();
    		boolean find = classroom.findUserAccount(strUsername, strPassword);
    		txtName.setText("");
    		txtPassword.setText("");
        	if(find==true) {
        		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-list.fxml"));
            	fxmlLoader.setController(this);
            	Parent userListPane = fxmlLoader.load();
            	mainPanel.getChildren().clear();
            	mainPanel.setCenter(userListPane);
            	initializeTableView();
            	labUsername.setText(strUsername);
        	}else {
        		Alert alert = new Alert(AlertType.ERROR);
        		alert.setTitle("Log in incorrect");
        		alert.setHeaderText(null);
        		alert.setContentText("The username and password given are incorrect");
        		alert.showAndWait();
        	}
    	}else {
    		showValidationErrorAlert();
    	}
    }

    private void initializeTableView() {
    	ObservableList<UserAccount> observableList;
    	observableList = FXCollections.observableArrayList(classroom.getAccounts());
    	tvUserAccountList.setItems(observableList);
    	tcUserName.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("Username")); 
		tcGender.setCellValueFactory(new PropertyValueFactory<UserAccount,Gender>("Gender")); 
		tcCareer.setCellValueFactory(new PropertyValueFactory<UserAccount,Career>("Career"));
		tcBirthday.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("Birthday"));
		tcBrowser.setCellValueFactory(new PropertyValueFactory<UserAccount,FavoriteBrowser>("Browser")); 
	}

	@FXML
    public void loadRegistrationForm(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
		fxmlLoader.setController(this);
		Parent registerPane = fxmlLoader.load();
		mainPanel.getChildren().clear();
		mainPanel.setTop(registerPane);
		txtNewUserPassword.setPromptText("**********");
		ObservableList<String> browsersList = FXCollections.observableArrayList("Chrome","Opera","Firefox","Edge","Safari");
    	cmbxBrowser.setValue("Chrome");
    	cmbxBrowser.setItems(browsersList);
	}

    @FXML
    public void chooseProfilePhoto(ActionEvent event) throws IOException {

    }

    @FXML
    public void createAccountButtonAction(ActionEvent event) throws IOException {
    	String strGender = getRadioButtonGenre();
    	String strBirthday = dpBirth.getValue().toString();
    	String strBrowser = cmbxBrowser.getValue().toString();
    	ArrayList<String> careers = getCheckBoxCareer();
    	boolean find = false;
		for(int k=0;k<careers.size() && !find;k++){
			if(careers.get(k).equals("no")){
				find = true;
				careers.remove(k);
			}
		} 
    	if(!txtNewUsername.getText().equals("") && !txtNewUserPassword.getText().equals("") && !txtUrlPhoto.getText().equals("") && strGender!="no" && !strBirthday.equals("") && !strBrowser.equals("") && !find) {
    		String strNewUsername = txtNewUsername.getText();
    		String strNewUserPassword = txtNewUserPassword.getText();
        	String strUrlPhoto = txtUrlPhoto.getText();
        	classroom.addNewUserAccount(strNewUsername, strNewUserPassword, strUrlPhoto, strGender, careers, strBirthday, strBrowser);
        	Alert alert = new Alert(AlertType.INFORMATION);
    	    alert.setTitle(null);
    	    alert.setHeaderText(null);
    	    alert.setContentText("The user has been created successfully");
    	    alert.showAndWait();
    	}else {
    		showValidationErrorAlert();
    	}
    }
    
    public String getRadioButtonGenre() {
    	String gender = "";
    	if(rbMale.isSelected()) {
    		gender = "male";
    	} else if (rbFemale.isSelected()) {
    		gender = "female";
    	}else if (rbOther.isSelected()) {
    		gender = "other";
    	} else {
    		gender = "no";
    	}
    	return gender;
    }
    
    public ArrayList<String> getCheckBoxCareer() {
    	ArrayList<String> careers = new ArrayList<>();
    	if(cbSIS.isSelected()) {
    		careers.add("SIS");
    	}else if(cbTEL.isSelected()) {
    		careers.add("TEL");
    	}else if(cbIND.isSelected()){
    		careers.add("IND");
    	} else {
    		careers.add("no");
    	}
    	return careers;
    }
    
    @FXML
    public void signInButtonAction(ActionEvent event) throws IOException {
    	loadLoginForm();
    }
    
    @FXML
    public void logOutButtonAction(ActionEvent event) throws IOException {
    	loadLoginForm();
    }
    
    @FXML
    public void showAbout(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Classroom");
	    alert.setHeaderText("Credits");
	    alert.setContentText("Keren López\nAlgorithms II");
	    alert.showAndWait();
    }
    
    public void showValidationErrorAlert() {
    	Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Validation Error");
		alert.setHeaderText(null);
		alert.setContentText("You must fill each field in the form");
		alert.showAndWait();
    }
}
