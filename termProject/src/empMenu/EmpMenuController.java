package empMenu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import menu.empData;
import sample.DBConnect;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmpMenuController implements Initializable {
    @FXML
    private TableView<empData> empDataTableView;
    @FXML
    private TableColumn<empData,Integer> columnID;
    @FXML
    private TableColumn<empData,String> columnName;
    @FXML
    private TableColumn<empData,String> columnSurname;
    @FXML
    private TableColumn<empData,String> columnEmail;
    @FXML
    private TableColumn<empData,Integer> columnSalary;
    @FXML
    private TableColumn<empData,String> columnCountry;
    @FXML
    private TableColumn<empData,String> columnCity;
    @FXML
    private TableColumn<empData,String> columnNationality;
    @FXML
    private TableColumn<empData,Integer> columnHired;
    @FXML
    private TableColumn<empData,Integer> columnOffdays;
    @FXML
    private TableColumn<empData,String> columnDomain;
    @FXML
    private TableColumn<empData,String> columnUsername;
    @FXML
    private TableColumn<empData,String> columnPrivilage;

    private DBConnect db;
    private PreparedStatement ps;
    private ResultSet rs;
    private ObservableList<empData> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.db = new DBConnect();
    }

    @FXML
    private void loadData(ActionEvent event) throws SQLException {
        try {

            ps = db.getCon().prepareStatement("SELECT * FROM sys.info");
            this.data = FXCollections.observableArrayList();
            rs = ps.executeQuery();

            while(rs.next()){
                this.data.add(new empData(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13)));
            }
        } catch(SQLException e){
            e.getCause().printStackTrace();
        }

        this.columnID.setCellValueFactory(new PropertyValueFactory<empData,Integer>("empID"));
        this.columnName.setCellValueFactory(new PropertyValueFactory<empData,String>("name"));
        this.columnSurname.setCellValueFactory(new PropertyValueFactory<empData,String>("surname"));
        this.columnEmail.setCellValueFactory(new PropertyValueFactory<empData,String>("email"));
        this.columnSalary.setCellValueFactory(new PropertyValueFactory<empData,Integer>("salary"));
        this.columnCountry.setCellValueFactory(new PropertyValueFactory<empData,String>("country"));
        this.columnCity.setCellValueFactory(new PropertyValueFactory<empData,String>("city"));
        this.columnNationality.setCellValueFactory(new PropertyValueFactory<empData,String>("nationality"));
        this.columnHired.setCellValueFactory(new PropertyValueFactory<empData,Integer>("yearOnWork"));
        this.columnOffdays.setCellValueFactory(new PropertyValueFactory<empData,Integer>("remainingOffDays"));
        this.columnDomain.setCellValueFactory(new PropertyValueFactory<empData,String>("domain"));
        this.columnUsername.setCellValueFactory(new PropertyValueFactory<empData,String>("username"));
        this.columnPrivilage.setCellValueFactory(new PropertyValueFactory<empData,String>("privilage"));

        this.empDataTableView.setItems(null);
        this.empDataTableView.setItems(this.data);
    }
}
