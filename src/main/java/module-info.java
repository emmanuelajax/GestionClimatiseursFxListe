module sio.d3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens sio.d3 to javafx.fxml;
    exports sio.d3;
}
