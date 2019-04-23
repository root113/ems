package menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import sample.DBConnect;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class menuController implements Initializable {

    @FXML
    private Button deleteButton;

    @FXML
    private Button insertButton;

    @FXML
    private Button updateButton;

    private DBConnect db;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.db = new DBConnect();
    }

    @FXML
    void insertData(ActionEvent event) throws SQLException{

    }

    @FXML
    void updateData(ActionEvent event) throws SQLException{

    }

    @FXML
    void deleteData(ActionEvent event) throws SQLException{

    }
}
