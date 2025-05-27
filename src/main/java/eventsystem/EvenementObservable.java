
package eventsystem;

import java.util.ArrayList;
import java.util.List;

public abstract class EvenementObservable extends Evenement {
    protected List<ParticipantObserver> observateurs = new ArrayList<>();

    public EvenementObservable(String id, String nom, java.time.LocalDateTime date, String lieu, int capaciteMax) {
        super(id, nom, date, lieu, capaciteMax);
    }

    public void ajouterObservateur(ParticipantObserver observer) {
        observateurs.add(observer);
    }

    public void notifierObservateurs(String message) {
        for (ParticipantObserver obs : observateurs) {
            obs.recevoirNotification(message);
        }
    }
}
