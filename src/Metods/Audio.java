package Metods;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Audio {

    private String track; // адрес трека(файла)
    private Clip clip = null;// ссылка на объект
    private FloatControl volumeC = null;// кклассаонтролер громкости
    private double wt; //уровень громкости
    private boolean pl_audio;// воспроизведение звука

    private long timer_p = 0;// начальное время для таймера звучания
    private long timer_f = 0;// конечное время звучания
    private long timer_d;// (количество миллисекунд) длительность трека

    public Audio( String track, double wt){
        this.track = track;
        this.wt =wt;
        this.pl_audio = false;
    }
    public Audio( String track, double wt,long timer_d){
        this.timer_d = timer_d;
        this.track = track;
        this.pl_audio = false;
        this.wt =wt;
    }



    public void sound() {
        File f = new File(this.track);
        //поток для записи и
        AudioInputStream tr = null;
        try {
            tr = AudioSystem.getAudioInputStream(f);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            clip = AudioSystem.getClip();
            clip.open(tr);
            volumeC = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            clip.setFramePosition(0);
            clip.start();

        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //стоп
    public void stop() {

        clip.stop();
        clip.close(); //Закрываем
        this.pl_audio = false;
    }


}