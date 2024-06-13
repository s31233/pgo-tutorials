import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Task 1
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", 2015));
        cars.add(new Car("Ford", 2014));
        cars.add(new Car("Kia", 2050));
        cars.add(new Car("BMW", 2018));
        cars.add(new Car("Audi", 2016));
        cars.add(new Car("Mercedes", 2017));
        cars.add(new Car("Honda", 2013));
        cars.add(new Car("Hyundai", 2012));
        cars.add(new Car("Mazda", 2019));
        cars.add(new Car("Chevrolet", 2011));

        Collections.sort(cars);

        for (Car car : cars){
            System.out.println(car);
        }

        //Task 2
        //Add 3 more items and implement "Item" class
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(1,"Pen"));
        items.add(new Item(2,"Eraser"));
        items.add(new Item(3, "Notebook"));
        items.add(new Item(4, "Pencil"));
        items.add(new Item(5, "Ruler"));

        for (Item item : items) {
            item.show();
        }
        //HashMap
        HashMap<Integer, String> itemMap = new HashMap<>();
        for (Item item : items){
            itemMap.put(item.getId(), item.getName());
        }

        for (Map.Entry<Integer,String> entry : itemMap.entrySet()){
            System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
        }

        //Task 3
        ArrayList<Item> itemsTask3 = new ArrayList<>();
        for (int i = 6; i <=15; i++){
            items.add(new Item(i,"Item" + i));
        }
        List<Item> sublist = items.subList(0,5);
        HashSet<Item> itemSet = new HashSet<>(sublist);

        for (Item item : itemSet){
            System.out.println(item);
        }
        //Task 4
        Task4 task4 = new Task4();
        System.out.println("Enter 10 numbers");
        task4.fillArray();

        System.out.println("Contents of array: ");
        for (int number : task4.numbers){
            System.out.println(number);
        }
    }
}