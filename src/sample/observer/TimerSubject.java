package sample.observer;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class TimerSubject implements Subject<Double> {
    private final ArrayList<Observer<Double>> observers;

    private final Timer timer;

    private double elapsedSeconds;

    public TimerSubject() {
        observers = new ArrayList<>();
        timer = new Timer();

        TimerTask task = new TimerTask() {
            public void run() {
                tick();
            }
        };

        timer.schedule(task, 100, 100);
    }

    public double getElapsedSeconds() {
        return elapsedSeconds;
    }

    public double reset(){
        double temp = elapsedSeconds;
        elapsedSeconds = 0d;
        return temp;
    }

    public void notifyAllObservers(Double value) {
        observers.forEach(doubleObserver -> doubleObserver.onNotify(value));
    }

    public void attach(Observer<Double> observer) {
        observers.add(observer);
    }

    private void tick() {
        elapsedSeconds += 0.1d;
        notifyAllObservers(elapsedSeconds);
    }

    public void detach(Observer<Double> observer) {
        observers.remove(observer);
    }
}
