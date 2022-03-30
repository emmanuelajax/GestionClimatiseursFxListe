package sio.d3;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListeClimsController implements Initializable
{
    @FXML
    public void ajoutClimatiseur(MouseEvent mouseEvent) throws IOException {
        GestionDesClimatiseurs.setRoot("ajout_climatiseur");
    }

    @FXML
    private TableView listeGClims;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //association du tableView avec la liste observable tout élément ajouter dans la
        // liste observable sera automatiquement ajouté au tableView tout élément
        // supprimer de la liste observable sera automatiquement supprimé du tableView
        listeGClims.setItems(Model.getClimatiseurs());

        //lors d'un double clic sur un item (ligne) du tableView,
        //on récupère le climatiseur sélectionne et on le supprime du modèle
        listeGClims.setOnMouseClicked(new EventHandler<MouseEvent>()
        {

            @Override
            public void handle(MouseEvent event)
            {
                //si on a pas effectué qu'un seul clic
                if (event.getClickCount() > 1)
                {
                    //récupération du climatiseur sélectionné
                    Climatiseur selectedItem;
                    selectedItem = (Climatiseur)
                            listeGClims.getSelectionModel().getSelectedItem();

                    System.out.println("Suppression de l'item … ");
                    //mise à jour du modèle
                    Model.getClimatiseurs().remove(selectedItem);
                }
            }
        });
    }
}


