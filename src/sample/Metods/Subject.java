package sample.Metods;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Класс, отвечающий за рассылку оповещений
 * наблюдателям и запуск всех компонентов программы.
 * @author Кожевников А.Ю. pPi-171
 * @version 1.3
 */

public class Subject {
    Timer timer;
    private List<Observer> observers = new ArrayList<Observer>();
    int state;
    int d, p;

    public Subject() {
        this.state = 0;
        this.d = 0;
        this.p = 0;
    }

    /**
     * Этот метод запускает таймер.
     * @param d,p  Значение, которое требуется
     * для обозначения периода в миллисекундах,
     * через d и периодичность - каждые p миллисекунд.
     * @return Включенный таймер.
     */

    public void go(int d,int p){
        this.d = d;
        this.p = p;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tick();
            }
        }, d*1000, p*1000);
    }

    /**
     * Этот метод останавливает таймер.
     * @return Выключеный таймер.
     */

    public void stp(){
        timer.cancel();
    }
    /**
     * Этот метод очищает таймер.
     * @return  state = 0.
     */

    public void cln(){
        state = 0;
        stp();
    }

    /**
     * Этот метод считает тики.
     * @return state+=d иначе state+=p и
     * происходит обращение к наблюдателю.
     */

    private void tick(){
        if(state==0)
            this.state+=d;
        else this.state+=p;
        notifyAllObservers();
    }
    /**
     * Этот метод возвращает значение state.
     * @return  state.
     */
    public int getState() {
        return this.state;
    }
    /**
     * Этот метод возвращает задает значение state.
     * @param state Необходимое значение.
     * @return  state.
     */
    public void setState(int state) {
        this.state = state;
    }
    /**
     * Этот метод нужен для добавления в список рассылки.
     */
    public void attach(Observer observer){
        observers.add(observer);
    }

    /**
     * Этот метод нужен для удаления из списка рассылки.
     */
    public void detach(Observer observer){
        observers.remove(observer);
    }

    /**
     * Этот метод нужен для рассылки.
     */
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}


