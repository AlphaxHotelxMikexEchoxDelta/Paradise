module com.example.paradise {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.paradise to javafx.fxml;
    exports com.example.paradise;
}