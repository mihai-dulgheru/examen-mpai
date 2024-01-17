package sub1.main.dp.observer;

public interface ISubiect {
    void addObserver(IObserver observer);

    void removeObserver(IObserver observer);

    void notifyAll(String mesaj);
}
