module termProject {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.sql;
    requires java.desktop;
    opens sample;
    opens register;
    opens operations;
    opens menu;
    opens empMenu;
}