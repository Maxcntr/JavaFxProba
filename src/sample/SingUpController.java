package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SingUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button singUpButton;

    @FXML
    private TextField singUpLastName;

    @FXML
    private PasswordField singUpNamePassword;

    @FXML
    private TextField singUpName;

    @FXML
    private TextField singUpNameLoginField2;

    @FXML
    private TextField singUpContry;

    @FXML
    private CheckBox singUpCheckBoxMan;

    @FXML
    private CheckBox singUpCheckBoxWoman;

    @FXML
    void initialize() {
        singUpButton.setOnAction(event -> {
            singUpNewUser();
        });
    }

    private void singUpNewUser() {

        DatabaseHandler dbHandler = new  DatabaseHandler();

        String firsName = singUpName.getText();
        String lastName = singUpLastName.getText();
        String userName = singUpNameLoginField2.getText();
        String password = singUpNamePassword.getText();
        String location = singUpContry.getText();
        String gander = "";

        if (singUpCheckBoxMan.isSelected())
            gander = "Мужской";
        else gander = "Женский";

        User user = new User(firsName,lastName,userName,password,location,gander);

        dbHandler.singUpUser(user);
    }
}
