package hw.cosmeticBag;

import practice.iList.IList;
import practice.iList.IListImpl;

//Задача 2. Создать список на основе типа String (города, имена и т.д) Проверить работу всех методов.
//
//Распечатать содержимое списка циклом foreach.
public class CosmeticBagAppl {
    public static void main(String[] args) {
        IList<String> listOfCosmeticBag = new IListImpl<>();
        System.out.println(listOfCosmeticBag.size());
        System.out.println(listOfCosmeticBag.isEmpty());

        listOfCosmeticBag.add("face cream");
        listOfCosmeticBag.add("eye cream");
        listOfCosmeticBag.add("hand cream");
        listOfCosmeticBag.add("body lotion");
        System.out.println("Original content:");
        for (String item : listOfCosmeticBag) {
            System.out.println(item);
        }


        System.out.println("Size after adding elements: " + listOfCosmeticBag.size());
        System.out.println("Is Empty after adding elements: " + listOfCosmeticBag.isEmpty());

        // Распечатать содержимое списка циклом foreach
        System.out.println("Contents of the list:");
        for (String item : listOfCosmeticBag) {
            System.out.println(item);
        }
        System.out.println("_____________________________________");

        // Добавление новой позиции
        listOfCosmeticBag.add("face mask");
        listOfCosmeticBag.add("face cream");

        System.out.println("Size after adding new item: " + listOfCosmeticBag.size());
        System.out.println("Contents of the list after adding new item:");
        for (String item : listOfCosmeticBag) {
            System.out.println(item);
        }
        System.out.println("_____________________________________");
        //удалить позицию
        listOfCosmeticBag.remove("face mask");
        System.out.println("Size after deleting item: " + listOfCosmeticBag.size());
        System.out.println("Contents of the list after adding new item:");
        for (String item : listOfCosmeticBag) {
            System.out.println(item);
        }
        System.out.println("_____________________________________");
        int lastIndexOf = listOfCosmeticBag.lastIndexOf("face cream");
        if (lastIndexOf != -1) { //если позиция в списке есть, то:
            System.out.println("Last index of 'face cream': " + lastIndexOf);
        }else {
            System.out.println("'face cream' not found in the list");
        }

        System.out.println("_____________________________________");

        //меняем элемент в списке на новый (длина массива не меняется)
        listOfCosmeticBag.set(2,"toothpaste");
        System.out.println("\nUpdated content:");
        for (String item : listOfCosmeticBag) {
            System.out.println(item);
        }




       /* System.out.println("Size after adding new item: " + listOfCosmeticBag.size());
        System.out.println("Contents of the list after adding new item:");
        for (String item : listOfCosmeticBag) {
            System.out.println(item);
        }
        System.out.println("_____________________________________");*/


    }

}

