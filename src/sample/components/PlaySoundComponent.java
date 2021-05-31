package sample.components;

import sample.observer.Observer;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class PlaySoundComponent implements Observer<Double> {
    private final double activationTime = 10;
    private boolean isActivated = false;

    public double getActivationTime() {
        return activationTime;
    }

    public void onNotify(Double value) {
        if (value >= activationTime && !isActivated) {
            try {
                InputStream stream = PlaySoundComponent.class.getResourceAsStream("/res/mus.wav");
                AudioInputStream soundStream = AudioSystem.getAudioInputStream(stream);
                AudioFormat format = soundStream.getFormat();
                DataLine.Info info = new DataLine.Info(Clip.class, format);
                Clip clip = (Clip) AudioSystem.getLine(info);
                clip.open(soundStream);
                clip.start();
                isActivated = true;
            } catch (Exception exception) {
            }
        }
    }
}
