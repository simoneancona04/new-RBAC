module com.rbac {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

    opens com.rbac to javafx.fxml;
    exports com.rbac;
}
