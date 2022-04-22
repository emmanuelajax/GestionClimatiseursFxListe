package sio.d3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Model {
    private static ObservableList<Climatiseur> climatiseurs = FXCollections.observableArrayList();

    public static ObservableList<Climatiseur> getClimatiseurs() {
        return climatiseurs;
    }

    private static Connection connexion;
    private static Statement stmt;

    public static void connect_to_database() {
        try {
            String url1 = "jdbc:mysql://localhost:3307/" + "GestionClims?&useJDBCCompliantTimezoneShift=true" + "&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "climauser";
            String password = "climapass";

            connexion = (Connection) DriverManager.getConnection(url1, user, password);

            if (connexion != null) {
                System.out.println("La connexion est effective. Il faut faire des requêtes !");
            }
        } catch (SQLException ex) {
            System.out.println("Erreur de connexion à la bdd. Identifiant ou mot de passe invalide.");
            ex.printStackTrace();
        }
    }

    public static void selectClimatiseurs() {
        //on définit un bloc de code à tester pour les erreurs lors de son exécution
        try {
            System.out.println("Chargement des climatiseurs...");
            //création d'un objet "Statement" qui permettra d'exécuter la requête
            stmt = connexion.createStatement();

            //définition de la requête
            String sql = "SELECT * from climatiseurs";
            System.out.println("requête :" + sql);
            //exécution de la requête
            ResultSet rs = stmt.executeQuery(sql);

            //parcours des enregistrements résultats,

            while (rs.next()) {
                String mar = rs.getString("marque");
                String mod = rs.getString("modele");
                int pui = rs.getInt("puissance");
                int smi = rs.getInt("surfaceMin");
                int sma = rs.getInt("surfaceMax");

                // création de nouveaux objets "climatiseurs"
                Climatiseur c = new Climatiseur(mar, mod, pui, smi, sma);
                // ajout de cet objet dans la liste
                climatiseurs.add(c);
            }
            rs.close();
        } catch (SQLException se) {
            //exécuté si la requête ne s'est pas bien exécutée
            se.printStackTrace();
            System.err.println("La requête c'est mal déroulée.");
        }
        //L’instruction vous permet d’exécuter du code,quel que soit le résultat
        finally
        {
            if (stmt != null)
            {
                try
                {
                    stmt.close();
                }
                catch (SQLException ex)
                {
                }
            }
        }
    }

    public static void insertClimatiseur(Climatiseur c)
    {
        try
        {
            System.out.println("Chargement des climatiseurs...");
            //création d'un objet "Statement" qui permettra d'exécuter la requête
            stmt = connexion.createStatement();

            //définition de la requête
            String sql = "INSERT INTO climatiseurs VALUES (null, \""+c.getMarque()+"\",\""+c.getModele()+"\","
                    + c.getPuissance()+","+c.getSurfaceMinCouverte()+","+c.getSurfaceMaxCouverte()+")";
            System.out.println("requête :" + sql);
            //exécution de la requête
            stmt.execute(sql);


        } catch (SQLException se) {
            //exécuté si la requête ne s'est pas bien exécutée
            se.printStackTrace();
            System.err.println("La requête c'est mal déroulée.");
        }
        //L’instruction vous permet d’exécuter du code,quel que soit le résultat
        finally
        {
            if (stmt != null)
            {
                try
                {
                    stmt.close();
                }
                catch (SQLException ex)
                {
                }
            }
        }

    }

    public static void deleteClimatiseur(Climatiseur c)
    {
        try
        {
            System.out.println("Chargement des climatiseurs...");
            //création d'un objet "Statement" qui permettra d'exécuter la requête
            stmt = connexion.createStatement();

            //définition de la requête
            String sql = "DELETE FROM climatiseurs where marque='"+c.getMarque()+"' ";
            System.out.println("requête :" + sql);
            //exécution de la requête
            stmt.execute(sql);


        } catch (SQLException se) {
            //exécuté si la requête ne s'est pas bien exécutée
            se.printStackTrace();
            System.err.println("La requête c'est mal déroulée.");
        }
        //L’instruction vous permet d’exécuter du code,quel que soit le résultat
        finally
        {
            if (stmt != null)
            {
                try
                {
                    stmt.close();
                }
                catch (SQLException ex)
                {
                }
            }
        }

    }

    public static void updateClimatiseur(int id, String val)
    {

    }
}


