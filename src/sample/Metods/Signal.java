package sample.Metods;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Signal extends Observer {
    int count;
    int start;
    String file;
    Media sound;
    MediaPlayer mediaPlayer;
    Boolean state;

    public Signal(Subject subject){
        this.count = 0;
        this.state = false;
        this.start = subject.getState();
        this.file = "ben.mp3";
        this.sound = new Media(new File(file).toURI().toString());
        this.mediaPlayer = new MediaPlayer(sound);
        this.subject = subject;
        this.subject.attach(this);
    }
    /**
     * Этот метод запускает звук.
     * @param count Значение, которое требуется
     * для обозначения старта воспроизведения.
     */
    public void onComp(int count){
        this.count = count;
        this.start = subject.getState();
        this.state = true;
    }

    /**
     * Этот метод останавливает звук и удаляет его из скиска наблюдателя.
     */
    public void delComo(Subject st){
        mediaPlayer.stop();
        st.detach(this);
    }
    /**
     * Этот метод необходим для воспроизведения звука.
     * @param st Значение, которое требуется
     * для получения доступа к Subject.
     * @return Работающая анимацияПользователь слышит звук.
     */
    @Override
    public void update(Subject st) {
        if (state) {
            if (st.getState() == start + count) {
                mediaPlayer.play();
                start += count;
            }
        }
    }
}


