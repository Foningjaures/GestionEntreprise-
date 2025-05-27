
package eventsystem;

public class ParticipantNotif extends Participant implements ParticipantObserver {

    public ParticipantNotif(String id, String nom, String email) {
        super(id, nom, email);
    }

    @Override
    public void recevoirNotification(String message) {
        System.out.println("Notification reçue par " + nom + " : " + message);
    }
}
