package sio.d3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;

public class AjoutClimController
{

    @FXML
    private TextArea valMarque;
    @FXML
    private TextArea valPuissance;
    @FXML
    private Label marque;
    @FXML
    private Label puissance;
    @FXML
    private TextArea valModele;
    @FXML
    private TableColumn surfaceMin;



    @FXML
    public void initialize() {
        marque.setText("Saisir la marque : ");
        marque.getText();

        puissance.setText("Saisir la puissance");
        puissance.getText();
    }

    @FXML
    private void valider() throws IOException {
        GestionDesClimatiseurs.setRoot("accueil_liste");
        int p;

        //getText renvoi un élément de type String
        //ça marche ici car m est une chaîne
        String m = valMarque.getText();

        //getText renvoi un élément de type String
        //ca ne marche pas ici car p est un entier
        //il faut donc convertir la chaîne en entier
        //Integer.valueOf renvoi un integer or p est un "int"
        //intValue renvoie l'entier correspondant à l'integer
        p = Integer.valueOf(valPuissance.getText()).intValue();


    }

    @FXML
    private void handleButtonAction (ActionEvent event) throws IOException {
        System.out.println("Enregistrement du climatiseur .... ");
        int puiss = Integer.valueOf(valPuissance.getText()).intValue();
        String marque = valMarque.getText();
        String model = valModele.getText();
        System.out.print("Avant la création de l'objet : nouvelle clim " + marque+" "+model+" "+puiss);

        //création d'un nouvel objet
        Climatiseur c = new Climatiseur(marque,model,puiss);
        int surfaceMin = c.getSurfaceMinCouverte();
        System.out.print("nouvelle clim " + marque+" "+model+" "+puiss+" "+surfaceMin);

        //ajout du climatiseur dans la liste du climatiseur du modèle
        Model.getClimatiseurs().add(c);

        //on revient à la fenêtre d'affichage de la liste de climatiseurs.
        GestionDesClimatiseurs.setRoot("accueil_liste"); }
}

