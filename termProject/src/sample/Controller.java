package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField textField1;

    @FXML
    private PasswordField passwordField1;

    @FXML
    private Button button1;

    private DBConnect db;

    @FXML
    void login(ActionEvent event) throws SQLException {
        DBConnect lg = new DBConnect();
        lg.checkUser(textField1.getText(),passwordField1.getText());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.db = new DBConnect();
    }
}
