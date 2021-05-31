package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.components.CloseComponent;
import sample.components.PlaySoundComponent;
import sample.components.ShowImageComponent;
import sample.observer.Observer;
import sample.observer.TimerSubject;

public class Controller implements Observer<Double> {
    @FXML
    private Label closeTimer, soundTimer, imageTimer;
    @FXML
    private Pane imagePane;

    private PlaySoundComponent playSoundComponent;
    private ShowImageComponent showImageComponent;
    private CloseComponent closeComponent;

    @FXML
    public void initialize() {
        playSoundComponent = new PlaySoundComponent();
        showImageComponent = new ShowImageComponent(imagePane);
        closeComponent = new CloseComponent();
        TimerSubject timerSubject = new TimerSubject();
        timerSubject.attach(this);
        timerSubject.attach(playSoundComponent);
        timerSubject.attach(showImageComponent);
        timerSubject.attach(closeComponent);
    }

    public void onNotify(Double value) {
        Platform.runLater(() -> {
            closeTimer.setText(String.format("%.1f", Math.max(0, closeComponent.getActivationTime() - value)));
            soundTimer.setText(String.format("%.1f", Math.max(0, playSoundComponent.getActivationTime() - value)));
            imageTimer.setText(String.format("%.1f", Math.max(0, showImageComponent.getActivationTime() - value)));
        });
    }
}
