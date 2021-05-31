package sample.observer;

public interface Observer<ValueType> {
    void onNotify(ValueType value);
}
