package sample.Metods;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * Класс, запускающий анимацию
 * песочных часов.
 * @author Kozhevnikov Alexander pPi-171
 * @version 1.2
 */

public class ConImage extends Observer {
    GraphicsContext gr;
    int x1, x2, y1, y2, y3;
    int count;
    int start;
    Paint p;
    Boolean state;
    Stone stone;

    public ConImage(Subject subject, GraphicsContext gr){
        this.stone = new Stone();
        this.state = false;
        this.gr = gr;
        this.x1 = 105;
        this.x2 = 275;
        this.y1 = 45;
        this.y2 = 45;
        this.y3 = 155;
        this.count = 0;
        this.start = subject.getState();
        this.p = Color.KHAKI;
        this.subject = subject;
        this.subject.attach(this);
    }

    /**
     * Этот метод запускает анимацию.
     * @param count Значение, которое требуется
     * для обозначения старта анимации.
     * @return Готовая анимация.
     */

    public void onComp(int count){
        this.count = count;
        this.start = subject.getState();
        this.state = true;
    }
    /**
     * Этот метод возвращает анимацию к первоночальному виду.
     * @param st Значение, которое требуется
     * для получения доступа к Subject.
     * @return Анимация в первоночальном виде.
     */
    public void delComo(Subject st){
        p = Color.KHAKI;
        this.x1 = 105;
        this.x2 = 275;
        this.y1 = 45;
        this.y2 = 45;
        this.y3 = 155;
        gr.clearRect(0, 0, 380, 248);
        stone.draw(gr,p,x1,x2,y1,y2,y3);
        st.detach(this);
    }

    /**
     * Этот метод необходим для воспроизведения анимации.
     * @param st Значение, которое требуется
     * для получения доступа к Subject.
     * @return Работающая анимация.
     */

    @Override
    public void update(Subject st) {
        if(state) {
            gr.clearRect(0, 0, 380, 248);

            if (st.getState() == start + count) {
                p = Color.CORAL;
                start += count;
            }

            if (st.getState() == start + 1) {
                p = Color.KHAKI;
            }

            stone.draw(gr, p, x1, x2, y1, y2, y3);

            if (y3 != 105) {
                x1 += 10;
                x2 -= 10;
                y1 += 5;
                y2 += 5;
                y3 -= 5;
            } else {
                x1 = 105;
                x2 = 275;
                y1 = 45;
                y2 = 45;
                y3 = 155;
            }
        }
    }
}
