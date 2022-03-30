package sio.d3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
    private static ObservableList<Climatiseur> climatiseurs = FXCollections.observableArrayList();

    public static ObservableList<Climatiseur> getClimatiseurs() {
        return climatiseurs;
    }
}
