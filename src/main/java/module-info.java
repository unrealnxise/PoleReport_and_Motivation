module com.pole.poletable {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.pole.poletable to javafx.fxml;
    exports com.pole.poletable;
}