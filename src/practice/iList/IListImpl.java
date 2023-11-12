package practice.iList;

import java.util.Arrays;
import java.util.Iterator;

public class IListImpl<E> implements IList<E>{
    //fields
    private Object[] elements; //массив для списков Объектов
    private int size; // его размер
    //consrt
    public IListImpl(int initialCapacity){
        //. Если переданное значение меньше нуля, то выбрасывается исключение
        // типа IllegalArgumentException с сообщением "Illegal capacity " + initialCapacity.
        if(initialCapacity <0){
            throw new IllegalArgumentException("Illegal capacity " + initialCapacity); //выбросили исключение
        }
        elements = new Object[initialCapacity];
    }
    public IListImpl(){
        this(10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clean() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean add(E element) {
        ensureCapacity();
        elements[size++] = element;
        //size++;
        return true;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            if (size == Integer.MAX_VALUE) {
                throw new OutOfMemoryError(); //большего по размеру массива создать не можем!
            }
            int newCapacity = elements.length + elements.length / 2;   //вырастили длину в 1,5 раза
            if (newCapacity < 0) {
                newCapacity = Integer.MAX_VALUE;
            }
            elements = Arrays.copyOf(elements, newCapacity); //скопировали в новый массив
        }
    }
    @Override
    public boolean add(int index, E element) { //метод разбит на 2 части
        if(index == size) { // добавление в конец списка
            add(element);
            return true;
        }
        //добавление в середину списка по индексу.
        checkIndex(index);
        ensureCapacity();
        System.arraycopy(elements,index,elements, index + 1,size++ -index);
        elements[index] = element;

        return false;
    }

    private void checkIndex(int index) { //смотрим, что здесь нужно проверить
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
    }
    @Override
    public E remove(int index) {
        checkIndex(index);
        E el = (E) elements[index];
        System.arraycopy(elements, index+1,elements, index, --size - index);
        elements[size] = null;//последний эл обнуляем...(не понятно зачем затираем?)
        return el;
    }
    /*После выполнения System.arraycopy, когда элементы сдвигаются на одну позицию назад,
    последний элемент становится дублированным на предпоследней позиции. Затирание последнего элемента
     elements[size] = null; выполняется для очистки этой дублированной позиции,
     */
    //иначе в списке может остаться ссылка на ненужный объект, что может вызвать утечку памяти.*/


    @Override
    public E get(int index) {
        checkIndex(index);
        return(E) elements[index]; //(E) - кастинг к типу
    }



    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E victim = (E) elements[index]; //нашли элемент по индексу
        elements[index] = element;
        return victim;
    }

    @Override
    public int indexOf(Object o) {
        if(o != null){//когда в листе есть объект не null
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])){
                    return i;
                }
            }
        }else {    //когда в листе есть объект null
            for (int i = 0; i < size; i++) {
                if (null == (elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
//Реализовать самостоятельно метод lastIndexOf
    @Override
    public int lastIndexOf(Object o) {
        //Изначально проверяем, что искомый объект null или нет.
        //Итерируем с последнего индекса size-1, бежим в обратном направлении до i[0]
        if (o != null) {
            for (int i= size-1; i >= 0; i--) {
                if (o.equals(elements[i])) {  //если искомый "о" равен текущему elements[i], то возвращаем
                    return i;
                }
            }
            }else {
                    for (int i= size-1; i >= 0; i--) {
                        if (null == (elements[i])){ //является ли текущий элемент null
                            return i;   // возвращаем индекс текущего элемента
                        }
                    }

                }
        // если искомый элемент не найден:
        return -1;
        }




        @Override
        public Iterator<E> iterator () {
            return new Iterator<E>() {
                int i = 0; // с какого элемента начинается перебор

                @Override
                public boolean hasNext() {
                    return i < size;
                }

                @Override
                public E next() {
                    return (E) elements[i++];
                }
            };
        }

    }