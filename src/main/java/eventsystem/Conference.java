
package eventsystem;

import java.time.LocalDateTime;
import java.util.List;

public class Conference extends Evenement {
    private String theme;
    private List<String> intervenants;

    public Conference(String id, String nom, LocalDateTime date, String lieu, int capaciteMax,
                      String theme, List<String> intervenants) {
        super(id, nom, date, lieu, capaciteMax);
        this.theme = theme;
        this.intervenants = intervenants;
    }

    @Override
    public void annuler() {
        System.out.println("Conférence annulée : " + nom);
    }
}
