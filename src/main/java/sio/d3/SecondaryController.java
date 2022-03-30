package sio.d3;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        GestionDesClimatiseurs.setRoot("primary");
    }
}