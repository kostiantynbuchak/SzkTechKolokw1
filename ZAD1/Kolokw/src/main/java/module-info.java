module com.example.kolokw {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kolokw to javafx.fxml;
    exports com.example.kolokw;
}