public class ListElem {
    private Elem head = null;
    private static int size = 0;

    //добавление в список самого первого элемента
    private void addFirst(int obj) {
        Elem node = new Elem();
        node.setNum(obj);
        node.setNext(head);
        head = node;
        size++;
    }

    //добавление элемента в конец списка
    private void addEnd(int obj) {
        Elem node1 = new Elem();//основной
        node1.setNum(obj);
        Elem node2 = new Elem();//вспомогательный
        node2 = positionSearch(size + 1);
        node2.setNext(node1);
        size++;
        node2 = null;
    }

    //удаление первого элемента
    private void delFirst() {
        Elem node = new Elem();
        node = head;
        head = head.getNext();
        node = null;
        size--;
        if(size == 0) head = null;
    }

    //получить размер списка
    public int getSize() {
        return size;
    }

    //проверка пустой список или нет
    public boolean isEmpty() {
        return (head == null);
    }

    // поиск позиции, возвращает элемент, после которого следует искомая позиция
    private Elem positionSearch(int num) {
        Elem obj = new Elem();
        obj = head;//становимся в начало списка и пошли искать элемент который будет стоять перед num-1 (учит-ся нумерац. с нуля)
        for (int i = 0; i < num - 2; i++) {
            obj = obj.getNext();
        }
        return obj;
    }

    //вывод списка на консоль
    public void printListElem() {
        Elem node = new Elem();
        node = head;
        if (isEmpty()) {
            System.out.println("Список пуст.");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.print(node.getNum() + "  ");
                node = node.getNext();
            }
            System.out.println();
        }
        node = null;
    }

    //добавление элемента в список
    // параметры: что вставляем и куда
    // возвращает true если вставка прошла успешно, иначе false
    // если позиция не указана(добавление происходит в конец списка)
    public boolean addElem(int obj) {
        Elem node1 = new Elem();//основной
        Elem node2 = new Elem();//вспомогательный

        if (isEmpty()) addFirst(obj);//если массив пуст, ставим элемент на первое место
        else addEnd(obj);//иначе в конец
        return true;
    }

    // если позиция указана
    // параметры: что вставляем и куда
    // возвращает true если вставка прошла успешно, иначе false
    public boolean addElem(int obj, int n) {
        Elem node1 = new Elem();//основной
        Elem node2 = new Elem();//вспомогательный

        if (isEmpty()) return false;//список пуст, вставлять новый эл. некуда
        else if (n == 1) { //список не пуст, вставка на первую позицию
            addFirst(obj);
            return true;
        } else if (n >= 2 && n <= size) {    //вставка в любую часть списка(предполог. сдвиг вправо остальных элементов)
            node2 = positionSearch(n);
            node1.setNext(node2.getNext());
            node2.setNext(node1);
            node1.setNum(obj);
            size++;
            return true;
        } else if (n == size + 1) { //вставка в конец(предполог. без сдвига)
            addEnd(obj);
            return true;
        } else return false;
    }

    //извлечение элемента(поиск)
    //параметр: позиция искомого элемента
    public Elem getElem(int n)
    {

        if (n < 1 || n > size) {
            System.out.println("Выход за границы списка.");
            return null;
        }
        else if(n == 1){
            System.out.println("На позиции " + n + " находится элемент: " + head.getNum());
            return head;
        }
        else {
            Elem node = new Elem();
            node = head;
            node = positionSearch(n+1);
            System.out.println("На позиции " + n + " находится элемент: " + node.getNum());
            return node;
        }
    }

    //удаление элемента из любой позиции
    //параметр: номер элемента, кот. нужно удалить
    public boolean delElem(int n) {
        Elem node1 = new Elem();
        Elem node2 = new Elem();

        if (isEmpty()) { //удаление невозможно, т.к. список пуст
            System.out.println("Список пуст.");
            return false;
        }
        else if (n == 1) { //удаление 1 элем.
            delFirst();
            return true;
        }
        else if (n == size) //удаление последнего
        {
            node1 = positionSearch(n);
            node1.setNext(null);
            node1 = null;
            size--;
            return true;
        }
        else if (n >= 2 && n < size) { //удаление элем. из середины

            node2 = positionSearch(n);
            node1 = node2.getNext().getNext();
            node2.setNext(node1);
            node1 = null;
            node2 = null;
            size--;
            return true;
        }
        else return false;
    }
}