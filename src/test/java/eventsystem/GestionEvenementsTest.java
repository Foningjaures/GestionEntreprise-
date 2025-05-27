package eventsystem;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class GestionEvenementsTest {

    @Test
    public void testAjoutEtRechercheEvenement() {
        // Création de l'interface graphique
        JFrame frame = new JFrame("Test Gestion Événements");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        frame.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        // Exécution du test
        try {
            GestionEvenements gestion = GestionEvenements.getInstance();
            Conference conf = new Conference("1", "JavaConf", LocalDateTime.now(), "ENSPY", 100, "Java", Collections.emptyList());
            gestion.ajouterEvenement(conf);
            Evenement e = gestion.rechercherEvenement("1");

            // Affichage des résultats
            resultArea.append("Test d'ajout et recherche d'événement:\n");
            resultArea.append("------------------------------------\n");
            resultArea.append("Événement ajouté: " + conf + "\n");
            resultArea.append("Événement trouvé: " + e + "\n\n");

            assertNotNull(e);
            assertEquals("JavaConf", e.nom);

            resultArea.append("Résultat du test: SUCCÈS\n");
            resultArea.append("- Événement trouvé n'est pas null\n");
            resultArea.append("- Nom de l'événement correspond: 'JavaConf'\n");

            frame.setTitle("Test Gestion Événements - SUCCÈS");
        } catch (AssertionError | Exception e) {
            resultArea.append("Résultat du test: ÉCHEC\n");
            resultArea.append("Erreur: " + e.getMessage() + "\n");
            frame.setTitle("Test Gestion Événements - ÉCHEC");
        }

        // Afficher la fenêtre
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Garder la fenêtre ouverte pendant un moment pour voir les résultats
        try {
            Thread.sleep(5000); // 5 secondes
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}