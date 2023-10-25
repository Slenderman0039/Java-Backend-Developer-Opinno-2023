package patterns.mailinglistuniversitarie;

public interface Observer<T> {
    public void update(T message);
}
