module com.example.sep3forsoeg5 {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.desktop;

  opens com.example.sep3forsoeg5 to javafx.fxml;
  exports com.example.sep3forsoeg5;
}