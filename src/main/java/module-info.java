module hust.uiux.year.apartment {
    requires javafx.controls;
    requires javafx.fxml;

    opens hust.uiux.year20231.apartment to javafx.fxml;
    exports hust.uiux.year20231.apartment;

    // Controllers
//    opens hust.uiux.year20231.apartment.controllers to javafx.fxml;
    exports hust.uiux.year20231.apartment.controllers;
}