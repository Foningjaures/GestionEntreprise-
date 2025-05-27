
package eventsystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Evenement {
    protected String id;
    protected String nom;
    protected LocalDateTime date;
    protected String lieu;
    protected int capaciteMax;
    protected List<Participant> participants = new ArrayList<>();

    public Evenement(String id, String nom, LocalDateTime date, String lieu, int capaciteMax) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.lieu = lieu;
        this.capaciteMax = capaciteMax;
    }

    public boolean ajouterParticipant(Participant p) {
        if (participants.size() >= capaciteMax) {
            return false;
        }
        participants.add(p);
        return true;
    }

    public void afficherDetails() {
        System.out.println("Événement : " + nom + " à " + lieu + " le " + date);
    }

    public abstract void annuler();
}
