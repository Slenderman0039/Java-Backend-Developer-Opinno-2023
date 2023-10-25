package patterns.mailinglistuniversitarie;

import java.util.ArrayList;
import java.util.List;

public class MailingList  implements Observable<Studente> {
    List<Studente> subscribers;

    public MailingList(){
        subscribers = new ArrayList<>();
    }

    @Override
    public boolean addObserver(Studente s) {
        return subscribers.add(s);
    }

    @Override
    public boolean deleteObserver(Studente s) {
        return subscribers.add(s);
    }

    @Override
    public void notifyObservers(String message) {
        for(Studente studente : subscribers){
            studente.update(message);
        }
    }
}
