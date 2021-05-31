package sample.components;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import sample.observer.Observer;

import java.io.InputStream;

public class ShowImageComponent implements Observer<Double> {
    private final double activationTime = 5;
    private Pane imagePane;
    private boolean isActivated = false;

    public ShowImageComponent(Pane imagePane) {

        this.imagePane = imagePane;
    }

    public double getActivationTime() {
        return activationTime;
    }

    public void onNotify(Double value) {
        if (value >= activationTime && !isActivated) {
            Platform.runLater(() -> {
                InputStream stream = ShowImageComponent.class.getResourceAsStream("/res/Слайд1.png");
                Image image = new Image(stream);
                imagePane.getChildren().add(new ImageView(image));
                isActivated = true;
            });
        }
    }
}
