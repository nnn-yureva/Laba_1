public class Elem {
    private Elem next = null;
    private int num;

    //получить ссылку на след элемент
    public Elem getNext(){
        return next;
    }

    //получить значение элемента
    public int getNum()
    {
        return num;
    }

    //установить ссылку на след элемент списка
    public void setNext(Elem obj)
    {
        next = obj;
    }

    //установить значение элемента
    public void setNum(int number)
    {
        num = number;
    }

}