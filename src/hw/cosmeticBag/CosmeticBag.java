package hw.cosmeticBag;

public interface CosmeticBag <E> extends Iterable<E>{

    //зададим абстрактные методы для работы со структурой данных "лист"(список чeго-то)
//для любых типов данных:  Integer, String, StringBuilder,Employee, Car, Pet, Photo, Book...

    int size();           //узнать размер списка(size)

    default boolean isEmpty()   //есть список пустой, то true
    {
        return size() == 0;//да пустой
    }

    void clean();       //удалить все из списка

    boolean add(E element);   //добавить элемент в списке// используем дженерик

    default boolean contains(Object o)  //есть ли элемент в списке
    {
        return indexOf(o) >= 0; //if(indexOf(o) >= 0) return true{ else return f}
    }

    default boolean remove(Object o)  //удалить элемент в списке по его индексу, если он есть
    {
        int index = indexOf(o);
        if (index < 0) { //когда объекта нет в списке
            return false;
        }
        remove(index); //удалили индекс и объект пропал из индекса
        return false;
    }
    boolean add(int index, E element);  //добавить (вставить) элемент по индексу

    E remove(int index);  //удалить элемент из списка по индексу

    E get(int index);   //получить элемент по его индексу

    E set(int index, E element);  //обновить элемент в списке по его индексу

    int indexOf(Object o);   //зная элемент, найти его индекс

    int lastIndexOf(Object o);//ищем индекс элемент с конца списка

    }

