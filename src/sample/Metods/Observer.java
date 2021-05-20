package sample.Metods;
/**
 * Класс, Наблюдатель
 * @author Кожевников А.Ю. pPi-171
 * @version 1.2
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update(Subject st);
}
