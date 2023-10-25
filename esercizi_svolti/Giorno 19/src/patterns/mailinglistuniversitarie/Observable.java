package patterns.mailinglistuniversitarie;

public interface Observable<T> {
    public boolean addObserver(T o);
    public boolean deleteObserver(T o);
    public void notifyObservers(String message);
}
