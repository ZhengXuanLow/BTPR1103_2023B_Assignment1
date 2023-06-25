module com.example.gamemenu {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gamemenu to javafx.fxml;
    exports com.example.gamemenu;
}