import container.ListElem;
public class Main {

    /**
     * вывод о состоянии выполнения операций
     * @param t true Или false
     */
    public static void printRes(boolean t)
    {
        if(t)System.out.println("Операция прошла успешно.");
        else System.out.println("Операция не выполнена.");

    }
    public static void main(String[] args)
    {
        boolean t;
        ListElem lst = new ListElem();
        lst.printListElem();
        System.out.println("\nПримеры вставки:\n");
        t =  lst.addElem(2);//вставка в начало(т.к. список пуст)
        printRes(t);
        lst.printListElem();
        t = lst.addElem(50);//вставка в конец(т.к. список не пуст и позиция не указана)
        printRes(t);
        lst.printListElem();
        t = lst.addElem(7,1);//вставка в начало, позиция указана
        printRes(t);
        lst.printListElem();
        t = lst.addElem(88,2);//вставка на позицию 2
        printRes(t);
        lst.printListElem();
        t = lst.addElem(90,lst.getSize()); //вставка на позицию size, последний эл. сдвинется, размер списка увелич.
        printRes(t);
        lst.printListElem();
        t = lst.addElem(100,lst.getSize()+1); //вставка на позицию size+1, сдвига нет, размер увелич.
        printRes(t);
        lst.printListElem();
        t = lst.addElem(88, lst.getSize()+3); //ошибка вставки, список не изменится
        printRes(t);
        lst.printListElem();
        System.out.println(lst.getSize());


        System.out.println("\nПример извлечения:\n");
        lst.getElem(1);
        lst.getElem(3);
        lst.getElem(lst.getSize());
        lst.getElem(10);//ошибка извлечения, выход за границу

        System.out.println("\nПримеры удаления:\n");
        t = lst.delElem(2);//удаление из середины
        printRes(t);
        lst.printListElem();
        t = lst.delElem(20);//ошибка удаления, выход за границы
        printRes(t);
        lst.printListElem();
        t = lst.delElem(lst.getSize());//удаление последнего элем.
        printRes(t);
        lst.printListElem();

    }
}
