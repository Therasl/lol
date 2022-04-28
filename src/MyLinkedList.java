public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private static class MyNode<T>{
        T data;
        MyNode<T> next, prev;
        MyNode(T data) {
            this.data = data;
        }
    }
    private int length = 0;
    private MyNode<T> head, tail;
    /** Создать список по умолчанию */
    public MyLinkedList() {}
    /** Создать список из массива объектов */
    public MyLinkedList(T data) {
        MyNode mynode = new MyNode(data);
    }

    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item); // Создаем новый узел
        if (head == null) { // Новый узел — единственный узел в списке
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode; // Связываем новый с последним узлом
            tail = newNode; // Теперь указывает на последний узел
        }
        length++;
    }
    /** Добавляем новый элемент по указанному индексу
     * в этом списке. Индекс головного элемента равен 0 */
    @Override
    public void add(T item, int index) {
        MyNode<T> current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        MyNode<T> temp = current.next;
        current.next = new MyNode<T>(item);
        (current.next).next = temp;
        length++;
    }

    @Override
    public boolean remove(T item) {
        return false;
    }
    /** Удаляем головной узел и
     * возвразаем объект, в удаленном узле. */
    @Override
    public T remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        } else {
            MyNode<T> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            MyNode<T> current = previous.next;
            previous.next = current.next;
            length--;
            return current.data;
        }
    }

    @Override
    public void clear() {
        length = 0;
        head = tail = null;
    }
    /** Возвращаем элемент по указанному индексу */
    public T get(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");
        MyNode<T> temp = head;
        while (index != 0) {
            temp = temp.next;
            index--;
        }
        return temp.data;
    }
    /** Возвращаем индекс соответствующего элемента заголовка в
     * этот список.*/
    @Override
    public int indexOf(Object o) {
        MyNode<T> current = head;
        for (int i = 0; i < length; i++) {
            if (current.data.equals(o))
                return i;
            current = current.next;
        }
        return 0;
    }
    /** Возвращаем индекс последнего совпадающего элемента в
     * этот список. */
    @Override
    public int lastIndexOf(Object o) {
        MyNode<T> current = head;
        int lastIndex = -1;
        for (int i = 0; i < length; i++) {
            if (current.data.equals(o))
                lastIndex = i;
            current = current.next;
        }
        return lastIndex;
    }

    @Override
    public void sort() {
        MyNode<T> current = head, index = null;
        T temp;
        if (head == null) {
            return;
        } else {
            while (current != null) {
                index = current.next;
                while (index != null) {
                    if (current.data.equals(index.data)){
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public int size() {
        return length;
    }

    @Override /** Возвращаем true, если этот список содержит элемент о */
    public boolean contains(Object o) {
        MyNode<T> current = head;
        if (current.data.equals(o))
            return true;
        current = current.next;
    }
        return false;
}

}

