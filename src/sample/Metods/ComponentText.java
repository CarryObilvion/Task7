package sample.Metods;

import javafx.scene.control.TextField;
/**
 * Класс, для отрисовки надписи, о прошедшем времени.
 * @author Кожевников А.Ю. pPi-171
 * @version 1.3
 */
public class ComponentText extends Observer {
    String txt;
    public TextField dindon;
    Boolean state;

    public ComponentText(Subject subject, TextField dindon){
        this.txt = "Прошло _ с";
        this.state = false;
        this.dindon = dindon;
        this.subject = subject;
        this.subject.attach(this);
    }
    /**
     * Этот метод влючает начало отстчета.
     */

    public void onComp(){
        this.state = true;
    }
    /**
     * Этот метод возвращает надпись к первоночальному виду.
     * @param st Значение, которое требуется
     * для получения доступа к Subject.
     */
    public void delComo(Subject st){
        st.detach(this);
        dindon.setText("Прошло _ с");
    }
    /**
     * Этот метод необходим для изменения надписи.
     * @param st Значение, которое требуется
     * для получения доступа к Subject.
     * @return Видимый пользователю отсчет.
     */

    @Override
    public void update(Subject st) {
        if(state) {
            txt = "Прошло " + st.getState() + " с";
            dindon.setText(txt);
        }
    }
}
