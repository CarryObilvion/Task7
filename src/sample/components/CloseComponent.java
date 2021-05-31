package sample.components;

import sample.observer.Observer;

public class CloseComponent implements Observer<Double> {
    private final double activationTime = 15;
    private boolean isActivated = false;

    public CloseComponent() {

    }

    public double getActivationTime() {
        return activationTime;
    }

    public void onNotify(Double value) {
        if (value >= activationTime && !isActivated) {
            isActivated = true;
            System.exit(0);
        }
    }
}
