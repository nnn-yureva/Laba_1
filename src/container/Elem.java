package container;

public class Elem {
    /** Свойство - ссылка на след элемент */
    private Elem next = null;
    /** Свойство - значение элемента */
    private int num;

    /**
     *
     * @return ссылка на след. элемент
     */
    public Elem getNext(){
        return next;
    }

    /**
     *
     * @return значение элемента
     */
    public int getNum()
    {
        return num;
    }

    /**
     *
     * @param obj элемент, на который будет установлена ссылка
     */
    public void setNext(Elem obj)
    {
        next = obj;
    }

    /**
     *
     * @param number значение элемента
     */
    public void setNum(int number)
    {
        num = number;
    }

}