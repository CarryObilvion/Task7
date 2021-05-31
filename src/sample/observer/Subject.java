package sample.observer;

public interface Subject<ValueType> {
    void notifyAllObservers(ValueType value);

    void attach(Observer<ValueType> observer);
    void detach(Observer<ValueType> observer);
}

